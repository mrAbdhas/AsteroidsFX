package dk.sdu.cbse.asteroids;

import dk.sdu.cbse.common.asteroids.Asteroid;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IEntityProcessingService;

public class AsteroidProcessor implements IEntityProcessingService {

    @Override
    public void process(GameData gameData, World world) {
        for (var entity : world.getEntities()) {
            if (!(entity instanceof Asteroid)) continue;

            float x = entity.getX();
            float y = entity.getY();
            float dx = entity.getDx();
            float dy = entity.getDy();

            x += dx;
            y += dy;

            if (x < 0) x = 800;
            if (x > 800) x = 0;
            if (y < 0) y = 600;
            if (y > 600) y = 0;

            entity.setX(x);
            entity.setY(y);
        }
    }
}
