package id.alexandrov.firstgame;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameScreen implements Screen {

    //screen
    private Camera camera;
    private Viewport viewport;

    //graphics
    private SpriteBatch spriteBatch;
    private TextureAtlas atlas;
    //private Texture background;
    private TextureRegion[] backgrounds;
    private float bgWidth;

    //timing;
    //private int backgroundOffset;
    private float[] offsets = { 1, 1};
    private float maxScrollingRate;

    private Ship player;
    private Ship enemy;

    //world
    private static final int WORLD_WIDTH = 128;
    private static final int WORLD_HEIGHT = 72;

    public GameScreen() {
        camera = new OrthographicCamera();
        viewport = new FillViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);
        bgWidth = WORLD_WIDTH;
        maxScrollingRate = WORLD_WIDTH / 4f;

        atlas = new TextureAtlas("images.atlas");
        spriteBatch = new SpriteBatch();

        backgrounds = new TextureRegion[] {
                new TextureRegion(new Texture("space_dark.jpg")),
                new TextureRegion(new Texture("clouds.png"))
        };

        player = Ships.newPlayable()
                     .shieldHp(4)
                     .speed(2)
                     .x(WORLD_WIDTH / 4f)
                     .y(WORLD_HEIGHT / 2f)
                     .height(10)
                     .width(10);

        enemy =  Ships.newEnemy()
                     .shieldHp(2)
                     .speed(2)
                     .x(WORLD_WIDTH / 4f * 3f)
                     .y(WORLD_HEIGHT / 2f)
                     .height(10)
                     .width(10);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        spriteBatch.begin();
        renderBackground(delta);
        player.draw(spriteBatch);
        enemy.draw(spriteBatch);
        spriteBatch.end();
    }

    private void renderBackground(float delta) {
        for(int layer = 0; layer < backgrounds.length; layer++) {
            float offset = offsets[layer];
            offsets[layer] = offset <= WORLD_WIDTH
                    ? offset + (delta * maxScrollingRate / (8 >> layer))
                    : 0;
            spriteBatch.draw(backgrounds[layer], -offset, 0, WORLD_WIDTH, WORLD_HEIGHT);
            spriteBatch.draw(backgrounds[layer], WORLD_WIDTH-offset, 0, WORLD_WIDTH, WORLD_HEIGHT);
        }
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
        spriteBatch.setProjectionMatrix(camera.combined);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
