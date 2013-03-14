package sk.tuke.magsa.tools.metamodel;

import java.util.Arrays;

public class Model {

    private final Entity[] entities;

    public Model(Entity[] entities) {
        this.entities = entities;
    }

    public Entity[] getEntities() {
        return entities;
    }

    public Entity findEntity(String name){
        for (Entity entity : getEntities()) {
            if (entity.getName().equals(name)){
                return entity;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "model " + Arrays.toString(entities);
    }
}
