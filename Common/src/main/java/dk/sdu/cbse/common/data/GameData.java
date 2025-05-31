package dk.sdu.cbse.common.data;

public class GameData {
    private GameKeys keys = new GameKeys();
    private double deltaTime;

    public GameKeys getKeys() {
        return keys;
    }

    public double getDeltaTime() {
        return deltaTime;
    }

    public void setDeltaTime(double deltaTime) {
        this.deltaTime = deltaTime;
    }
}
