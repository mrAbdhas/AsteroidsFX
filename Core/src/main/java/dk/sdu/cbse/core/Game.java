package dk.sdu.cbse.core;

import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IEntityProcessingService;
import dk.sdu.cbse.common.services.IPostEntityProcessingService;

import java.util.ServiceLoader;

public class Game {
    private final ServiceLoader<IEntityProcessingService> entityProcessors =
            ServiceLoader.load(IEntityProcessingService.class);
    private final ServiceLoader<IPostEntityProcessingService> postProcessors =
            ServiceLoader.load(IPostEntityProcessingService.class);

    public void update(GameData gameData, World world) {
        for (IEntityProcessingService processor : entityProcessors) {
            processor.process(gameData, world);
        }

        for (IPostEntityProcessingService processor : postProcessors) {
            processor.process(gameData, world);
        }
    }
}
