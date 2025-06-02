package dk.sdu.cbse.common.bullet;

import dk.sdu.cbse.common.data.Entity;

import java.util.UUID;

public class Bullet extends Entity {
    private UUID shooterID;

    public UUID getShooterID() {
        return shooterID;
    }

    public void setShooterID(UUID shooterID) {
        this.shooterID = shooterID;
    }

}
