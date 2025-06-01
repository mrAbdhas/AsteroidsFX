package dk.sdu.cbse.common.asteroids;

import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;

import java.util.Collection;

public interface AsteroidSplitterSPI {
    Collection<Entity> createSplitAsteroids(Entity originalAsteroid, GameData gameData, World world);
}
