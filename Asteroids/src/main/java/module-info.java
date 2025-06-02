module Asteroids {
    requires Common;
    requires CommonAsteroids;

    provides dk.sdu.cbse.common.services.IGamePluginService
            with dk.sdu.cbse.asteroids.AsteroidPlugin;

    provides dk.sdu.cbse.common.services.IEntityProcessingService
            with dk.sdu.cbse.asteroids.AsteroidProcessor;

    provides dk.sdu.cbse.common.asteroids.AsteroidSplitterSPI
            with dk.sdu.cbse.asteroids.AsteroidSplitterImpl;
}