package sk.tuke.magsa.tools.builder;

import java.util.ArrayList;
import java.util.List;
import sk.tuke.magsa.tools.metamodel.Entity;
import sk.tuke.magsa.tools.metamodel.Model;
import sk.tuke.magsa.tools.metamodel.Property;
import sk.tuke.magsa.tools.metamodel.constraints.Constraint;
import sk.tuke.magsa.tools.metamodel.constraints.EntityRef;
import sk.tuke.magsa.tools.metamodel.constraints.PropertyRef;
import sk.tuke.magsa.tools.metamodel.constraints.Required;
import tuke.magsa.tools.metamodel.constraints.Length;
import tuke.magsa.tools.metamodel.constraints.Range;
import tuke.magsa.tools.metamodel.constraints.Regex;

//SEE ALSO: Nested Function
//http://martinfowler.com/dslwip/NestedFunction.html
public abstract class ConstraintBuilder {
    private List<EntityRef> entities = new ArrayList<EntityRef>();

    private Model model;

    protected abstract void define();

    public void compose(Model model) throws ConstraintProcessingException {
        this.model = model;
        define();
        validate();
    }

    protected void entity_ref(String name, PropertyRef... properties) {
        entities.add(new EntityRef(name, properties));
    }

    protected PropertyRef property_ref(String name, Constraint... constraints) {
        return new PropertyRef(name, constraints);
    }
    
    protected Length length(long minLength, long maxLength){
        return new Length(minLength,maxLength);
    }
    
    protected Length min_length(long minLength){
        return new Length(minLength, Integer.MAX_VALUE);
    }
    
    protected Length max_length(long maxLength){
        return new Length(Integer.MIN_VALUE, maxLength);
    }
    
    protected Range range(long minValue, long maxValue){
        return new Range(minValue, maxValue);
    }
    
    protected Regex regex(String regex){
        return new Regex(regex);
    }

    protected Required required() {
        return new Required();
    }

    private void validate() throws ConstraintProcessingException {
            for (EntityRef entityRef : entities) {
            Entity entity = null;
            if((entity=model.findEntity(entityRef.getName()))==null){
                throw new ConstraintProcessingException(entityRef.getName());
            }
                for (PropertyRef propertyRef : entityRef.getProperties()) {
                    Property property = null;
                    if((property=entity.findProperty(propertyRef.getName()))==null){
                        throw new ConstraintProcessingException(propertyRef.getName());
                    }
                    for (Constraint constraint  : propertyRef.getConstraints()) {
                        if(!constraint.supportsType(property.getType()))
                        throw new ConstraintProcessingException(constraint.toString());
                    }
                    property.setConstraints(propertyRef.getConstraints());
                }
        }
	}
}
