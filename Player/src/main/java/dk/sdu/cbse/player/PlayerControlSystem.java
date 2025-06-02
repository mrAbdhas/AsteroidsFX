package dk.sdu.cbse.player;

import dk.sdu.cbse.common.bullet.BulletSPI;
import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.GameKeys;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IEntityProcessingService;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

public class PlayerControlSystem implements IEntityProcessingService {

    private final ServiceLoader<BulletSPI> bulletSPILoader = ServiceLoader.load(BulletSPI.class);
    private long lastFired = 0;

    @Override
    public void process(GameData gameData, World world) {
        List<Entity> bulletsToAdd = new ArrayList<>();

        for (Entity entity : new ArrayList<>(world.getEntities())) {
            if (!(entity instanceof Player)) continue;

            float x = entity.getX();
            float y = entity.getY();
            float dx = entity.getDx();
            float dy = entity.getDy();
            float rotation = entity.getRotation();

            if (gameData.getKeys().isDown(GameKeys.LEFT)) {
                rotation -= 5;
            }
            if (gameData.getKeys().isDown(GameKeys.RIGHT)) {
                rotation += 5;
            }
            if (gameData.getKeys().isDown(GameKeys.UP)) {
                dx += (float)(Math.cos(Math.toRadians(rotation)) * 0.5);
                dy += (float)(Math.sin(Math.toRadians(rotation)) * 0.5);

            }

            x += dx;
            y += dy;

            if (x < 0) x = 800;
            if (x > 800) x = 0;
            if (y < 0) y = 600;
            if (y > 600) y = 0;

            entity.setX(x);
            entity.setY(y);
            entity.setDx(dx * 0.99f);
            entity.setDy(dy * 0.99f);
            entity.setRotation(rotation);

            if (gameData.getKeys().isDown(GameKeys.SPACE) && canFire()) {
                for (BulletSPI bulletSPI : bulletSPILoader) {
                    Entity bullet = bulletSPI.createBullet(entity, gameData, world);
                    if (bullet instanceof dk.sdu.cbse.common.bullet.Bullet b) {
                        b.setShooterID(entity.getID());
                    }
                    bulletsToAdd.add(bullet);
                }
                lastFired = System.currentTimeMillis();
            }
        }

        world.getEntities().addAll(bulletsToAdd);
    }

    private boolean canFire() {
        return (System.currentTimeMillis() - lastFired) > 300;
    }
}
