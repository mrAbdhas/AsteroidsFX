package dk.sdu.cbse.enemy;

import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IEntityProcessingService;

public class EnemyControlSystem implements IEntityProcessingService {

    @Override
    public void process(GameData gameData, World world) {
        for (Entity entity : world.getEntities()) {
            if (!(entity instanceof Enemy)) continue;

            float x = entity.getX();
            float y = entity.getY();
            float dx = entity.getDx();
            float dy = entity.getDy();

            x += dx;
            y += dy;

            if (x < 0 || x > 800) dx *= -1;
            if (y < 0 || y > 600) dy *= -1;

            entity.setX(x);
            entity.setY(y);
            entity.setDx(dx);
            entity.setDy(dy);
        }
    }
}
