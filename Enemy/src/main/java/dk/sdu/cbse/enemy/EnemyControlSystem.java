package dk.sdu.cbse.enemy;

import dk.sdu.cbse.common.bullet.BulletSPI;
import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IEntityProcessingService;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

public class EnemyControlSystem implements IEntityProcessingService {

    private final ServiceLoader<BulletSPI> bulletSPILoader = ServiceLoader.load(BulletSPI.class);
    private long lastFired = 0;

    @Override
    public void process(GameData gameData, World world) {
        List<Entity> bulletsToAdd = new ArrayList<>();

        for (Entity entity : new ArrayList<>(world.getEntities())) {
            if (!(entity instanceof Enemy)) continue;

            float x = entity.getX();
            float y = entity.getY();
            float dx = entity.getDx();
            float dy = entity.getDy();

            // Move (basic bounce)
            x += dx;
            y += dy;

            if (x < 0 || x > 800) dx *= -1;
            if (y < 0 || y > 600) dy *= -1;

            entity.setX(x);
            entity.setY(y);
            entity.setDx(dx);
            entity.setDy(dy);

            // Fire bullet every 1500ms
            if (canFire()) {
                for (BulletSPI bulletSPI : bulletSPILoader) {
                    Entity bullet = bulletSPI.createBullet(entity, gameData, world);
                    bulletsToAdd.add(bullet);
                }
                lastFired = System.currentTimeMillis();
            }
        }

        world.getEntities().addAll(bulletsToAdd);
    }

    private boolean canFire() {
        return (System.currentTimeMillis() - lastFired) > 1500;
    }
}
