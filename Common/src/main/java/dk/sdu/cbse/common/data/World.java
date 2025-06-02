package dk.sdu.cbse.common.data;

import java.util.ArrayList;
import java.util.Collection;

public class World {
    private final Collection<Entity> entities = new ArrayList<>();

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    public void removeEntity(Entity entity) {
        entities.remove(entity);
    }

    public Collection<Entity> getEntities() {
        return entities;
    }


}
