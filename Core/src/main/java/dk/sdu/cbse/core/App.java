package dk.sdu.cbse.core;

import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IGamePluginService;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ServiceLoader;

public class App extends Application {

    private final GameData gameData = new GameData();
    private final World world = new World();

    @Override
    public void start(Stage stage) {
        Pane root = new Pane();
        stage.setScene(new Scene(root, 800, 600));
        stage.setTitle("AsteroidsFX");
        stage.show();

        loadPlugins();
    }

    private void loadPlugins() {
        ServiceLoader<IGamePluginService> loader = ServiceLoader.load(IGamePluginService.class);
        for (IGamePluginService plugin : loader) {
            plugin.start(gameData, world);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
