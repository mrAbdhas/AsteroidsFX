package dk.sdu.cbse.enemy;

import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IGamePluginService;

public class EnemyPlugin implements IGamePluginService {

    private Enemy enemy;

    @Override
    public void start(GameData gameData, World world) {
        enemy = new Enemy();
        enemy.setX(100);
        enemy.setY(100);
        enemy.setRadius(12);
        enemy.setDx(1);
        enemy.setDy(0.5f);
        world.addEntity(enemy);
    }

    @Override
    public void stop(GameData gameData, World world) {
        world.removeEntity(enemy);
    }
}
