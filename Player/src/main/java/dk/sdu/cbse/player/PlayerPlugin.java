package dk.sdu.cbse.player;

import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IGamePluginService;

public class PlayerPlugin implements IGamePluginService {

    private Entity player;

    @Override
    public void start(GameData gameData, World world) {
        player = createPlayer();
        world.addEntity(player);
    }

    private Entity createPlayer() {
        Entity player = new Player();
        player.setX(400);
        player.setY(300);
        player.setRadius(15);
        player.setRotation(270);
        return player;
    }

    @Override
    public void stop(GameData gameData, World world) {
       world.removeEntity(player);
    }
}
