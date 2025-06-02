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



public class App extends Application {

    private final GameData gameData = new GameData();
    private final World world = new World();

    private final ModuleConfig moduleConfig = new ModuleConfig();

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

                for (var processor : moduleConfig.getEntityProcessingServices()) {
                    processor.process(gameData, world);
                }

                for (var postProcessor : moduleConfig.getPostEntityProcessingServices()) {
                    postProcessor.process(gameData, world);
                }

                gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                drawEntities(gc, world);



            }
        }.start();
    }

    private void drawEntities(GraphicsContext gc, World world) {
        for (var entity : world.getEntities()) {
            float[] sx = entity.getShapeX();
            float[] sy = entity.getShapeY();

            boolean hasValidShape = sx != null && sy != null &&
                    sx.length > 1 && sy.length > 1 &&
                    !(sx[0] == 0 && sy[0] == 0 && sx[1] == 0 && sy[1] == 0);

            if (hasValidShape) {
                double[] dx = new double[sx.length];
                double[] dy = new double[sy.length];
                for (int i = 0; i < sx.length; i++) {
                    dx[i] = sx[i];
                    dy[i] = sy[i];
                }
                gc.strokePolygon(dx, dy, dx.length);
            } else {
                gc.strokeOval(
                        entity.getX() - entity.getRadius(),
                        entity.getY() - entity.getRadius(),
                        entity.getRadius() * 2,
                        entity.getRadius() * 2
                );
            }
        }
    }


    private void startPlugins() {
        for (IGamePluginService plugin : moduleConfig.getGamePluginServices()) {
            plugin.start(gameData, world);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
