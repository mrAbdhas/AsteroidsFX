package dk.sdu.cbse.asteroids;

import dk.sdu.cbse.common.asteroids.Asteroid;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IGamePluginService;

import java.util.Random;

public class AsteroidPlugin implements IGamePluginService {

    @Override
    public void start(GameData gameData, World world) {
        for (int i = 0; i < 3; i++) {
            Asteroid asteroid = new Asteroid();
            asteroid.setX(new Random().nextInt(800));
            asteroid.setY(new Random().nextInt(600));
            asteroid.setRadius(20);
            asteroid.setDx((float) (Math.random() * 2 - 1));
            asteroid.setDy((float) (Math.random() * 2 - 1));
            world.addEntity(asteroid);
        }
    }

    @Override
    public void stop(GameData gameData, World world) {
        world.getEntities().removeIf(e -> e instanceof Asteroid);
    }
}
