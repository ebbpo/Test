
import java.io.File;
import java.io.FileReader;
import sk.tuke.magsa.framework.ConnectionPool;
import sk.tuke.magsa.tools.builder.ConstraintBuilder;
import sk.tuke.magsa.tools.generator.CollectionTemplateGenerator;
import sk.tuke.magsa.tools.generator.DatabaseScriptGenerator;

import sk.tuke.magsa.tools.metamodel.*;
import sk.tuke.magsa.tools.parser.*;

public class Make {

    public static void main(String[] args) throws Exception {
        /* Model - object representation of input sentences */
        Model model;


        /* External language - single line parser parses the content of model directory in the project */
        File dir = new File("model");
        LineParser parser = new LineParser();
        model = parser.parseDir(dir);

        ConstraintBuilder builder = new PersonalistikaObmedzenia();
        builder.compose(model);


        /* External language - single line parser */
        new DatabaseScriptGenerator(model).generate();

        /* Generators -  entity, dao interface, dao implementation */
        new CollectionTemplateGenerator<Entity>(model, "entity_class", model.getEntities()).generate();
        new CollectionTemplateGenerator<Entity>(model, "dao_interface", model.getEntities()).generate();
        new CollectionTemplateGenerator<Entity>(model, "dao_impl", model.getEntities()).generate();
        /* Print the model */
        System.out.println(model);


    }
}
