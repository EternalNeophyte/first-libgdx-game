package id.alexandrov.firstgame;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public abstract class PlaceableObject<T extends PlaceableObject<T>> implements Chaining<T> {

    static final TextureAtlas ATLAS = new TextureAtlas("images.atlas");
    TextureRegion body;

    float x, y, width, height;
    float speed;

    public PlaceableObject() { }

    public T body(String regionName) {
        return chaining(() -> body = ATLAS.findRegion(regionName));
    }

    public T speed(float speed) {
        return chaining(() -> this.speed = speed);
    }

    public T x(float x) {
        return chaining(() -> this.x = x);
    }

    public T y(float y) {
        return chaining(() -> this.y = y);
    }

    public T height(float height) {
        return chaining(() -> this.height = height);
    }

    public T width(float width) {
        return chaining(() -> this.width = width);
    }
}
