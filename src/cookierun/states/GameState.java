package cookierun.states;

import java.awt.Graphics;

import blocks.Block;
import cookierun.Game;
import cookierun.Handler;
import cookierun.entities.creatures.Player;
import cookierun.entities.statics.ShortBlock;
import worlds.World;

public class GameState extends State {

	private World world;

	public GameState(Handler handler) {
		super(handler);
		world = new World(handler, "res/worlds/world1.txt");
		handler.setWorld(world);
	}

	@Override
	public void tick() {
		world.tick();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
	}

}
