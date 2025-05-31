module Core {
    requires javafx.controls;
    requires Common;
    exports dk.sdu.cbse.core;

    uses dk.sdu.cbse.common.services.IGamePluginService;
}