package id.alexandrov.firstgame;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;

public abstract class Ship<T extends Ship<T>> extends PlaceableObject<T> {

    ReentrantLock lock;
    LinkedList<Laser> lasers;
    TextureRegion shield;

    int shieldHp;
    float shotInterval, shotCountDown;

    Ship() {
        lock = new ReentrantLock(true);
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



    public void update(float delta, int worldWidth) {
        shotCountDown += delta;
        if(canFire()) {
            fire();
            shotCountDown = 0;
        }
        for(int i = 0; i < lasers.size(); i++) {
            Laser laser = lasers.get(i);
            laser.update(delta);
            if (laser.isOut(worldWidth)) {
                lock.lock();
                try {
                    lasers.remove(i);
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public boolean canFire() {
        return shotCountDown >= shotInterval;
    }

    public abstract void fire();

    public void draw(Batch batch) {
        batch.draw(body, x, y, 0f, 0f, width, height, 1f, 1f, angle);
        if(shieldHp > 0) {
            batch.draw(shield, x, y, 0f, 0f, width, height, 1f, 1f, angle);
        }
        lasers.forEach(laser -> laser.draw(batch));
    }

    public LinkedList<Laser> getLasers() {
        return lasers;
    }
}
