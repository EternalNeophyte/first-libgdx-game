package id.alexandrov.firstgame;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.LinkedList;
import java.util.function.Consumer;

public class Ship extends PlaceableObject<Ship> {

    LinkedList<Laser> lasers;
    TextureRegion shield;

    int shieldHp;
    float shotInterval, shotCountDown;

    private Ship() {
        lasers = new LinkedList<>();
        shotCountDown = 0;
    }

    public static Ship construct() {
        return new Ship();
    }

    public Ship shield(String regionName) {
        return chaining(() -> shield = ATLAS.findRegion(regionName));
    }

    public Ship shieldHp(int shieldHp) {
        return chaining(() -> this.shieldHp = shieldHp);
    }

    public Ship shotInterval(float shotInterval) {
        return chaining(() -> this.shotInterval = shotInterval);
    }

    public void update(float delta) {
        shotCountDown += delta;
    }

    public boolean canFire() {
        return shotCountDown >= shotInterval;
    }

    public Ship doOnfire(Consumer<Ship> behavior) {
        return chainingIf(canFire(), () -> {
            shotCountDown = 0;
            behavior.accept(this);
        });
    }

    public void draw(Batch batch) {
        batch.draw(body, x, y, width, height);
        if(shieldHp > 0) {
            batch.draw(shield, x, y, width, height);
        }
    }
}
