/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tuke.magsa.tools.metamodel.constraints;

import sk.tuke.magsa.tools.metamodel.Type;
import sk.tuke.magsa.tools.metamodel.constraints.Constraint;

/**
 *
 * @author adam
 */
public class Required extends Constraint{

    public Required() {
    }

    
    @Override
    public boolean supportsType(Type type) {
        return true;
    }
    
}
