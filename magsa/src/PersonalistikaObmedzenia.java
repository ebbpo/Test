
import sk.tuke.magsa.tools.builder.ConstraintBuilder;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Adam
 */
public class PersonalistikaObmedzenia extends ConstraintBuilder {

    @Override
    protected void define() {
        entity_ref("Zamestnanec",
                property_ref("priezvisko",
                required(),
                max_length(16),
                regex("[A-Z]([a-z]*)")),
                property_ref("vek", range(18, 40)));
                
    }
}