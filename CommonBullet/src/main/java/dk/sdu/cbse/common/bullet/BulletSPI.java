package dk.sdu.cbse.common.bullet;

import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;

public interface BulletSPI {
    Entity createBullet(Entity shooter, GameData gameData, World world);
}
