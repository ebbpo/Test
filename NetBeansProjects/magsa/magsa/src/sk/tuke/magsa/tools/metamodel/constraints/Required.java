package sk.tuke.magsa.tools.metamodel.constraints;

import sk.tuke.magsa.tools.metamodel.Type;

public class Required extends Constraint {

    public Required() {
    }

    @Override
    public String toString() {
        return "required";
    }

    @Override
    public boolean supportsType(Type type) {
        return true;
    }
}
