package dk.sdu.cbse.asteroids;

import dk.sdu.cbse.common.asteroids.Asteroid;
import dk.sdu.cbse.common.asteroids.AsteroidSplitterSPI;
import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;

import java.util.ArrayList;
import java.util.Collection;

public class AsteroidSplitterImpl implements AsteroidSplitterSPI {

    @Override
    public Collection<Entity> createSplitAsteroids(Entity original, GameData gameData, World world) {
        Collection<Entity> result = new ArrayList<>();

        if (!(original instanceof Asteroid)) return result;
        if (original.getRadius() < 10) return result;

        for (int i = 0; i < 2; i++) {
            Asteroid child = new Asteroid();
            child.setX(original.getX());
            child.setY(original.getY());
            child.setRadius(original.getRadius() / 2);
            child.setDx((float) (Math.random() * 2 - 1));
            child.setDy((float) (Math.random() * 2 - 1));
            result.add(child);
        }

        return result;
    }
}
