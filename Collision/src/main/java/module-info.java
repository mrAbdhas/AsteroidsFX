module Collision {
    requires Common;
    requires CommonAsteroids;
    requires CommonBullet;

    uses dk.sdu.cbse.common.asteroids.AsteroidSplitterSPI;
    provides dk.sdu.cbse.common.services.IPostEntityProcessingService
            with dk.sdu.cbse.collision.CollisionDetector;


}