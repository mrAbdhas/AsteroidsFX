module Player {
    requires Common;
    requires CommonBullet;
    provides dk.sdu.cbse.common.services.IGamePluginService
            with dk.sdu.cbse.player.PlayerPlugin;

    provides dk.sdu.cbse.common.services.IEntityProcessingService
            with dk.sdu.cbse.player.PlayerControlSystem;

    uses dk.sdu.cbse.common.bullet.BulletSPI;

}