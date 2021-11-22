package id.alexandrov.firstgame;

import com.badlogic.gdx.graphics.g2d.Batch;

public class Laser extends PlaceableObject<Laser> {

    private Laser() { }

    public static Laser newRed() {
        return new Laser().body("laserRed06");
    }

    public static Laser newBlue() {
        return new Laser().body("laserBlue06");
    }

    public void draw(Batch batch) {
        batch.draw(body, x - width / 2f, y, width, height);
    }
}
