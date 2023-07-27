package blocks;

import java.awt.image.BufferedImage;

import cookierun.gfx.Assets;

public class Sky extends Block {

	public Sky(int id) {
		super(Assets.sky, id, 60, 60);
	}

	public boolean isSolid() {
		return true;
	}
}
