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
public class Length extends sk.tuke.magsa.tools.metamodel.constraints.Constraint {
    
    private long maxLength;
    private long minLength;

    public Length(long minLength, long maxLength) {
        this.maxLength = maxLength;
        this.minLength = minLength;
    }

    public long getMaxLength() {
        return maxLength;
    }

    public long getMinLength() {
        return minLength;
    }

    
    @Override
    public boolean supportsType(Type type) {
        if (type==Type.STRING){
            return true;
        }
        return false;
    }
    
    
            
}
