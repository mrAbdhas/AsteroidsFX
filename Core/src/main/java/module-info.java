module Core {
    requires javafx.controls;
    requires Common;
    exports dk.sdu.cbse.core;

    uses dk.sdu.cbse.common.services.IGamePluginService;
    uses dk.sdu.cbse.common.services.IEntityProcessingService;
    uses dk.sdu.cbse.common.services.IPostEntityProcessingService;
}