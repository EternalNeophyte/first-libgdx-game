package id.alexandrov.firstgame;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.LinkedList;

public abstract class Ship<T extends Ship<T>> extends PlaceableObject<T> {

    LinkedList<Laser> lasers;
    TextureRegion shield;

    int shieldHp;
    float shotInterval, shotCountDown;

    Ship() {
        lasers = new LinkedList<>();
        shotCountDown = 0;
    }

    public T shield(String regionName) {
        return chaining(() -> shield = ATLAS.findRegion(regionName));
    }

    public T shieldHp(int shieldHp) {
        return chaining(() -> this.shieldHp = shieldHp);
    }

    public T shotInterval(float shotInterval) {
        return chaining(() -> this.shotInterval = shotInterval);
    }

    public void update(float delta) {
        shotCountDown += delta;
    }

    public boolean canFire() {
        return shotCountDown >= shotInterval;
    }

    public abstract void fire();

    public void draw(Batch batch) {
        batch.draw(body, x, y, width, height);
        if(shieldHp > 0) {
            batch.draw(shield, x, y, width, height);
        }
    }
}
