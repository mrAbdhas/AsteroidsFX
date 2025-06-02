package dk.sdu.cbse.bullet;

import dk.sdu.cbse.common.bullet.Bullet;
import dk.sdu.cbse.common.bullet.BulletSPI;
import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IEntityProcessingService;

public class BulletControlSystem implements IEntityProcessingService, BulletSPI {

    @Override
    public void process(GameData gameData, World world) {
        for (Entity bullet : world.getEntities()) {
            if (!(bullet instanceof Bullet)) continue;

            float x = bullet.getX();
            float y = bullet.getY();
            float dx = bullet.getDx();
            float dy = bullet.getDy();

            x += dx;
            y += dy;

            if (x < 0 || x > 800 || y < 0 || y > 600) {
                bullet.setRadius(-1); // Mark for removal
            }

            bullet.setX(x);
            bullet.setY(y);
        }

        // Remove expired bullets
        world.getEntities().removeIf(e -> e instanceof Bullet && e.getRadius() < 0);
    }

    @Override
    public Entity createBullet(Entity shooter, GameData gameData, World world) {
        Bullet bullet = new Bullet();

        float x = shooter.getX();
        float y = shooter.getY();
        float angle = shooter.getRotation();

        float speed = 5;
        float dx = (float) Math.cos(Math.toRadians(angle)) * speed;
        float dy = (float) Math.sin(Math.toRadians(angle)) * speed;

        bullet.setX(x);
        bullet.setY(y);
        bullet.setDx(dx);
        bullet.setDy(dy);
        bullet.setRadius(4);
        bullet.setShooterID(shooter.getID());


        return bullet;
    }
}
