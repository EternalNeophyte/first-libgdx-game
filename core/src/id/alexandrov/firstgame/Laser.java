package id.alexandrov.firstgame;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Affine2;

public class Laser extends PlaceableObject<Laser> {

    private Laser() { }

    public static Laser newRed() {
        return new Laser()
                .body("laserRed06")
                .height(6f)
                .width(2f)
                .speed(-0.8f).angle(90);
    }

    public static Laser newBlue() {
        return new Laser()
                .body("laserBlue06")
                .height(6f)
                .width(2f)
                .speed(0.8f).angle(90);
    }

    public void update(float delta) {
        x += speed;
    }

    public boolean isOut(int worldWidth) {
        return x + width >= worldWidth || x + width < 0;
    }

    public void draw(Batch batch) {
        batch.draw(body, x - width / 2f, y, 0f, 0f, width, height, 1f, 1f, 90f);
    }
}
