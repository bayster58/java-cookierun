package worlds;

import java.awt.Graphics;

import blocks.Block;
import cookierun.Game;
import cookierun.Handler;
import cookierun.entities.EntityManager;
import cookierun.entities.creatures.Player;
import cookierun.entities.statics.LongBlock;
import cookierun.entities.statics.ShortBlock;
import cookierun.utils.Utils;

public class World {

	private Handler handler;
	private int width, height;
	private int spawnX, spawnY;
	private int[][] blocks;

	private EntityManager entityManager;

	public World(Handler handler, String path) {
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 60, 150));
		entityManager.addEntity(new ShortBlock(handler, 420 * 1 + 120, 180));
		entityManager.addEntity(new LongBlock(handler, 420 * 2 + 120, 180));
		entityManager.addEntity(new LongBlock(handler, 420 * 3 + 120, 180));
		entityManager.addEntity(new ShortBlock(handler, 420 * 4 + 120, 180));
		entityManager.addEntity(new ShortBlock(handler, 420 * 5 + 120, 180));
		entityManager.addEntity(new LongBlock(handler, 420 * 6 + 120, 180));
		entityManager.addEntity(new ShortBlock(handler, 420 * 7 + 120, 180));
		entityManager.addEntity(new LongBlock(handler, 420 * 8 + 120, 180));
		entityManager.addEntity(new ShortBlock(handler, 420 * 9 + 120, 180));
		entityManager.addEntity(new LongBlock(handler, 420 * 10 + 120, 180));
		entityManager.addEntity(new ShortBlock(handler, 420 * 11 + 120, 180));
		entityManager.addEntity(new ShortBlock(handler, 420 * 12 + 120, 180));
		entityManager.addEntity(new LongBlock(handler, 420 * 13 + 120, 180));
		entityManager.addEntity(new ShortBlock(handler, 420 * 14 + 120, 180));
		entityManager.addEntity(new LongBlock(handler, 420 * 15 + 120, 180));
		entityManager.addEntity(new LongBlock(handler, 420 * 16 + 120, 180));
		entityManager.addEntity(new ShortBlock(handler, 420 * 17 + 120, 180));
		entityManager.addEntity(new LongBlock(handler, 420 * 18 + 120, 180));
		entityManager.addEntity(new ShortBlock(handler, 420 * 19, 180));
		entityManager.addEntity(new LongBlock(handler, 420 * 20 + 120, 180));
		entityManager.addEntity(new ShortBlock(handler, 420 * 21 + 120, 180));
		

		loadWorld(path);

		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
	}

	public void tick() {
		entityManager.tick();
	}

	public void render(Graphics g) {
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / 60);
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / 60 + 1);
		for (int y = 0; y < height; y++) {
			for (int x = xStart; x < xEnd; x++) {
				getBlock(x, y).render(g, (int) (x * 60 - handler.getGameCamera().getxOffset()), y * 30);
			}
		}
		entityManager.render(g);
	}

	public Block getBlock(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height)
			return Block.ground;

		Block b = Block.blocks[blocks[x][y]];
		if (b == null)
			return Block.sky;
		return b;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	private void loadWorld(String path) {
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);

		blocks = new int[width][height];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				if (blocks[x][y] == 3)
					blocks[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
				else
					blocks[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}
	}
}
