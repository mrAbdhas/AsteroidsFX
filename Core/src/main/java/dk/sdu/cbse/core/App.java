package dk.sdu.cbse.core;

import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IGamePluginService;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ServiceLoader;


public class App extends Application {

    private final Game game = new Game();
    private final GameData gameData = new GameData();
    private final World world = new World();

    private final ServiceLoader<IGamePluginService> pluginLoader =
            ServiceLoader.load(IGamePluginService.class);

    @Override
    public void start(Stage stage) {
        Canvas canvas = new Canvas(800, 600);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Pane root = new Pane(canvas);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("AsteroidsFX");
        stage.show();

        // Input handling
        scene.setOnKeyPressed(event -> {
            KeyCode code = event.getCode();
            gameData.getKeys().setKey(code.toString(), true);
        });

        scene.setOnKeyReleased(event -> {
            KeyCode code = event.getCode();
            gameData.getKeys().setKey(code.toString(), false);
        });

        startPlugins();

        // Game loop
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                gameData.setDeltaTime(0.016); // Approx 60 FPS
                game.update(gameData, world);

                gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                drawEntities(gc, world);



            }
        }.start();
    }

    private void drawEntities(GraphicsContext gc, World world) {
        for (var entity : world.getEntities()) {
            float x = entity.getX();
            float y = entity.getY();
            float r = entity.getRadius();

            gc.strokeOval(x - r, y - r, r * 2, r * 2);
        }
    }


    private void startPlugins() {
        for (IGamePluginService plugin : pluginLoader) {
            plugin.start(gameData, world);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
