package id.alexandrov.firstgame;

import com.badlogic.gdx.Game;

public class FirstGdxGame extends Game {

	GameScreen screen;

	@Override
	public void create() {
		screen = new GameScreen();
		setScreen(screen);
	}

	@Override
	public void dispose() {
		screen.dispose();
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void resize(int width, int height) {
		screen.resize(width, height);
	}
}
