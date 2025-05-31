package dk.sdu.cbse.collision;

import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IPostEntityProcessingService;

public class CollisionDetector implements IPostEntityProcessingService {

    @Override
    public void process(GameData gameData, World world) {
        System.out.println("CollisionDetector: processing collisions");
    }
}
