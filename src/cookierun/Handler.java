package cookierun;

import cookierun.gfx.GameCamera;
import cookierun.input.KeyManager;
import worlds.World;

public class Handler {

	private Game game;
	private World world;

	public Handler(Game game) {
		this.game = game;
	}

	public GameCamera getGameCamera() {
		return game.getGameCamera();
	}

	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}

	public int getWidth() {
		return game.getWidth();
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}
}
