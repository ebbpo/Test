/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tuke.magsa.tools.metamodel.constraints;

import sk.tuke.magsa.tools.metamodel.Type;

/**
 *
 * @author adam
 */
public class ForeignKey extends sk.tuke.magsa.tools.metamodel.constraints.Constraint{
    
    private Integer identFK;
    private String entityName;

    public ForeignKey(Integer identFK, String entityName) {
        this.identFK = identFK;
        this.entityName = entityName;
    }

    public String getEntityName() {
        return entityName;
    }

    public Integer getIdentFK() {
        return identFK;
    }
    
    

    @Override
    public boolean supportsType(Type type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
