package dk.sdu.cbse.common.data;

import java.util.UUID;

public class Entity {
    private float[] shapeX = new float[4];
    private float[] shapeY = new float[4];

    private final UUID id = UUID.randomUUID();
    private float x, y, radius;
    private float dx, dy;
    private float rotation;

    public UUID getID() {
        return id;
    }

    public float getX() { return x; }
    public void setX(float x) { this.x = x; }

    public float getY() { return y; }
    public void setY(float y) { this.y = y; }

    public float getDx() { return dx; }
    public void setDx(float dx) { this.dx = dx; }

    public float getDy() { return dy; }
    public void setDy(float dy) { this.dy = dy; }

    public float getRotation() { return rotation; }
    public void setRotation(float rotation) { this.rotation = rotation; }

    public float getRadius() { return radius; }
    public void setRadius(float radius) { this.radius = radius; }

    public float[] getShapeX() {
        return shapeX;
    }

    public void setShapeX(float[] shapeX) {
        this.shapeX = shapeX;
    }

    public float[] getShapeY() {
        return shapeY;
    }

    public void setShapeY(float[] shapeY) {
        this.shapeY = shapeY;
    }

}
