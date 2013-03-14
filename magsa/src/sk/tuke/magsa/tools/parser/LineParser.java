package sk.tuke.magsa.tools.parser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import sk.tuke.magsa.tools.metamodel.Entity;
import sk.tuke.magsa.tools.metamodel.Model;
import sk.tuke.magsa.tools.metamodel.Property;
import sk.tuke.magsa.tools.metamodel.Type;

public class LineParser {

    private static final char SEPARATOR = ':';
    private static final String COMMENT = "^#(.*)$";
    private static final String PROPERTY = "^([a-zA-Z_$][a-zA-Z\\d_$]*)(\\s*" + SEPARATOR + "\\s*([a-zA-Z_$][a-zA-Z\\d_$]*))?$";

    public Model parseDir(File dir) throws ParserException {
        if (!dir.isDirectory()) {
            throw new ParserException(dir + " is not a directory");
        }

        List<Entity> entities = new ArrayList<Entity>();
        for (File file : dir.listFiles()) {
            entities.add(parse(file));
        }
        return new Model(entities.toArray(new Entity[]{}));
    }

    public Entity parse(File file) throws ParserException {
        try {
            Reader reader = new FileReader(file);
            String name = file.getName();
            name = name.substring(0, name.lastIndexOf('.'));
            return parse(name, reader);
        } catch (IOException e) {
            throw new ParserException("Cannot open file " + file, e);
        }
    }

    private Entity parse(String name, Reader reader) throws ParserException {
        LineNumberReader lnr = new LineNumberReader(reader);
        String line;
        List<Property> propertyList = new ArrayList<Property>();
        try {
            while ((line = lnr.readLine()) != null) {
                Property property = parseLine(line.trim(), lnr.getLineNumber());
                if (property != null) {
                    if (propertyList.contains(property)) {
                        throw new ParserException("Property names must be unique. Duplicate at line number " + lnr.getLineNumber());
                    } else {
                        propertyList.add(property);
                    }
                }
            }
        } catch (IOException ex) {
//            Logger.getLogger(LineParser.class.getName()).log(Level.SEVERE, null, ex);
             System.out.println(ex.getMessage());
        }
        
        return new Entity(name, propertyList.toArray(new Property[propertyList.size()]));
    }

    private Property parseLine(String line, int lineNumber) throws ParserException {
        if (line.isEmpty()) {
            return null;
        }

        Pattern commentPattern = Pattern.compile(COMMENT);
        Pattern propertyPattern = Pattern.compile(PROPERTY);

        Matcher commentMatcher = commentPattern.matcher(line);
        Matcher propertyMatcher = propertyPattern.matcher(line);

        if (propertyMatcher.find()) {
            String name = propertyMatcher.group(1);
            String typeName = propertyMatcher.group(3);
            Type type = Type.STRING;
            if (typeName != null) {
                type = Type.valueOf(typeName.toUpperCase());
            }
            return new Property(name, type);
        } else if (!commentMatcher.find()) {
            throw new ParserException("Parse exception at line number: " + lineNumber);
        }
        return null;
    }
}
