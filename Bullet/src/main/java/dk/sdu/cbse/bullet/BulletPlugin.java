package dk.sdu.cbse.bullet;

import dk.sdu.cbse.common.bullet.Bullet;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IGamePluginService;

public class BulletPlugin implements IGamePluginService {

    @Override
    public void start(GameData gameData, World world) {
        System.out.println("BulletPlugin started");
    }

    @Override
    public void stop(GameData gameData, World world) {
        world.getEntities().removeIf(e -> e instanceof Bullet);    }
}
