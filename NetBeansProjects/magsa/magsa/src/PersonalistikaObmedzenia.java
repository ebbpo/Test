
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
      entity_ref("zamestnanec", 
              property_ref("meno", required(),max_length(15)),
              property_ref("priezvisko", max_length(20),regex("^([A-Z]([a-z]*))$")));
        
    }
}