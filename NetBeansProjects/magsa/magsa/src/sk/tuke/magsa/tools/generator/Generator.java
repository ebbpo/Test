package sk.tuke.magsa.tools.generator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import sk.tuke.magsa.tools.ConfigurationException;
import sk.tuke.magsa.tools.metamodel.Model;

public abstract class Generator {
    protected static final String PROPERTIES_FILE = "generator.properties";

    protected static Properties generatorProperties = new Properties();

    private final Model model;

    static {
        try {
            generatorProperties.load(ClassLoader.getSystemClassLoader().getResourceAsStream(PROPERTIES_FILE));
        } catch (Exception e) {
            throw new ConfigurationException("Failed during loading of the configuration file '" + PROPERTIES_FILE + "'", e);
        }
    }

    public Generator(Model model) {
        this.model = model;
    }

    public Model getModel() {
        return model;
    }

    public String getDestinationDir() {
        return generatorProperties.getProperty("destDir");
    }

    protected PrintWriter createWriter(String fileName) throws GeneratorException {
        try {
        File file = new File(fileName);
        file.getParentFile().mkdirs();
        return new PrintWriter(file);
        } catch (IOException e) {
            throw new GeneratorException("Cannot write generated output to file '" + fileName + "'", e);
        }
    }

    public abstract void generate() throws GeneratorException;
}
