package blocks;

import java.awt.image.BufferedImage;

import cookierun.gfx.Assets;

public class Ground extends Block {

	public Ground(int id) {
		super(Assets.Ground, id, 60, 60);
	}

	public boolean isSolid() {
		return true;
	}
}
