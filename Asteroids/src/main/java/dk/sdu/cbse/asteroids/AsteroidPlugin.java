package dk.sdu.cbse.asteroids;

import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IGamePluginService;

public class AsteroidPlugin implements IGamePluginService {
    @Override
    public void start(GameData gameData, World world) {
        System.out.println("AsteroidsPlugin started");

    }

    @Override
    public void stop(GameData gameData, World world) {
        System.out.println("AsteroidsPlugin stopped");
    }
}
