/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tuke.magsa.tools.metamodel.constraints;

import sk.tuke.magsa.tools.metamodel.Type;

/**
 *
 * @author Adam
 */
public class Regex extends sk.tuke.magsa.tools.metamodel.constraints.Constraint {
    
    private String regex;

    public Regex(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }

    @Override
    public boolean supportsType(Type type) {
          if (type==Type.STRING){
            return true;
        }
        return false;
    }

    
            
    
}
