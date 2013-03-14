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
public class Range extends sk.tuke.magsa.tools.metamodel.constraints.Constraint {
    
    private long maxValue;
    private long minValue;

    public Range(long minValue, long maxValue) {
        this.maxValue = maxValue;
        this.minValue = minValue;
    }

    public long getMaxValue() {
        return maxValue;
    }

    public long getMinValue() {
        return minValue;
    }

    @Override
    public boolean supportsType(Type type) {
          if (type==Type.INTEGER){
            return true;
        }
        return false;
    }
    
    
    
}
