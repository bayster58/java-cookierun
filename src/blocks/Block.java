package blocks;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Block {

	public static Block[] blocks = new Block[256];
	public static Block sky = new Sky(0);
	public static Block ground = new Ground(1);
	public static Block hole = new Hole(2);

	protected final int BLOCKWIDTH, BLOCKHEIGHT;
	protected BufferedImage texture;
	protected final int id;

	public Block(BufferedImage texture, int id, int BLOCKWIDTH, int BLOCKHEIGHT) {
		this.texture = texture;
		this.id = id;
		this.BLOCKWIDTH = BLOCKWIDTH;
		this.BLOCKHEIGHT = BLOCKHEIGHT;

		blocks[id] = this;
	}

	public void tick() {

	}

	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, BLOCKWIDTH, BLOCKHEIGHT, null);
	}

	public boolean isSolid() {
		return false;
	}

	public int getId() {
		return id;
	}
}
