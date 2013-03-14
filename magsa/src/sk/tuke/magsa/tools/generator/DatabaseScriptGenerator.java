package sk.tuke.magsa.tools.generator;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import sk.tuke.magsa.tools.metamodel.Entity;
import sk.tuke.magsa.tools.metamodel.Model;
import sk.tuke.magsa.tools.metamodel.Property;
import tuke.magsa.tools.metamodel.constraints.Length;
import tuke.magsa.tools.metamodel.constraints.Required;

//SEE ALSO: Transformer Generation
//http://martinfowler.com/dslwip/TransformerGeneration.html
public class DatabaseScriptGenerator extends Generator {

    public DatabaseScriptGenerator(Model model) {
        super(model);
    }

    @Override
    public void generate() throws GeneratorException {
        PrintWriter out = createWriter(getDestinationDir() + "/database.sql");

        for (Entity entity : getModel().getEntities()) {
//            System.out.println(entity.getName());
            out.printf("CREATE TABLE %s (\n", entity.getName());
            out.printf("\tident_%s INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY", entity.getName());
            List<Property> properties = Arrays.asList(entity.getProperties());
            for (Property property : properties) {
                generateProperty(out, property);
                generateConstraints(out, property);
            }
            out.printf(");\n");
        }
        out.close();
    }

    public void generateProperty(PrintWriter out, Property property) {
        switch (property.getType()) {
            case STRING:
                out.printf(",\n\t%s varchar2", property.getName());
                break;
            case INTEGER:
                out.printf(",\n\t%s int", property.getName());
                break;
            case REAL:
                out.printf(",\n\t%s real", property.getName());
                break;
            case CHAR:
                out.printf(",\n\t%s char", property.getName());
                break;
            case ARRAY:
                out.printf(",\n\t%s blob", property.getName());
                break;
        }

    }

    public void generateConstraints(PrintWriter out, Property property) {
        if (property.getConstraints() != null) {
            if (property.hasConstraint(Length.class)) {
                out.printf("(%s)", property.getConstraint(Length.class).getMaxLength());
            }
            if (property.hasConstraint(Required.class)) {
                out.printf(" NOT NULL");
            }

        }
    }
}
