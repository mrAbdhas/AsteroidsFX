package dk.sdu.cbse.collision;

import dk.sdu.cbse.common.asteroids.AsteroidSplitterSPI;
import dk.sdu.cbse.common.bullet.Bullet;
import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IPostEntityProcessingService;

import java.util.Collection;
import java.util.ServiceLoader;

public class CollisionDetector implements IPostEntityProcessingService {

    private final ServiceLoader<AsteroidSplitterSPI> splitterLoader =
            ServiceLoader.load(AsteroidSplitterSPI.class);

    @Override
    public void process(GameData gameData, World world) {
        for (Entity bullet : world.getEntities()) {
            if (!(bullet instanceof Bullet)) continue;

            for (Entity target : world.getEntities()) {
                if (bullet == target || (target instanceof Bullet)) continue;

                float dx = bullet.getX() - target.getX();
                float dy = bullet.getY() - target.getY();
                float dist = (float) Math.sqrt(dx * dx + dy * dy);

                if (dist < bullet.getRadius() + target.getRadius()) {
                    handleCollision(world, target);
                    bullet.setRadius(-1); // Mark bullet for removal
                    break;
                }
            }
        }

        // Remove bullets marked for deletion
        world.getEntities().removeIf(e -> e instanceof Bullet && e.getRadius() < 0);
    }

    private void handleCollision(World world, Entity target) {
        if (isAsteroid(target)) {
            for (AsteroidSplitterSPI splitter : splitterLoader) {
                Collection<Entity> split = splitter.createSplitAsteroids(target, null, world);
                world.getEntities().addAll(split);
            }
        }

        // Remove the hit target
        world.removeEntity(target);
    }

    private boolean isAsteroid(Entity e) {
        try {
            return Class.forName("dk.sdu.cbse.common.asteroids.Asteroid").isAssignableFrom(e.getClass());
        } catch (ClassNotFoundException ex) {
            return false;
        }
    }
}
