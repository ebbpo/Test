package sk.tuke.magsa.tools.metamodel;

import sk.tuke.magsa.tools.metamodel.constraints.Constraint;

public class Property implements Named {

    private final String name;
    private final Type type;
    private Constraint[] constraints;

    public Property(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public Property(String name, Type type, Constraint[] constraints) {
        this.name = name;
        this.type = type;
        this.constraints = constraints;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    /**
     * @return the type
     */
    public Type getType() {
        return type;
    }

//Do triedy Property pridajte metódu na získanie obmedzenia vlastnosti podľa typu public <T extends Constraint> T getConstraint(Class<T> clazz).
//V prípade, že vlastnosť neobsahuje obmedzenie daného typu, je návratová hodnota null. V prípade, že existuje viacero obmedzení toho istého typu, je návratová hodnota ľubovoľné z týchto obmedzení.
//Príklad použitia:
//
//Range range = property.getConstraint(Range.class);
    public <T extends Constraint> T getConstraint(Class<T> clazz) {
        for (Constraint constraint : getConstraints()) {
            if (clazz.isAssignableFrom(constraint.getClass())) {
                return (T) constraint;
            }
        }
        return null;
    }

//    Úloha: Do triedy Property pridajte metódu na overenie, či množina obmedzení danej vlastnosti obsahuje obmedzenie daného typu public boolean hasConstraint(Class<? extends Constraint> clazz). 
//    boolean b = property.hasConstraint(Required.class);
    public boolean hasConstraint(Class<? extends Constraint> clazz) {
        if (getConstraint(clazz) != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        final Property object = (Property) obj;
        if ((this.name == null) ? object.name != null : !this.name.equals(object.name)) {
            return false;
        }
        return true;

    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }

    /**
     * @return the constraints
     */
    public Constraint[] getConstraints() {
        return constraints;
    }



    /**
     * @param constraints the constraints to set
     */
    public void setConstraints(Constraint[] constraints) {
        this.constraints = constraints;
    }
}
