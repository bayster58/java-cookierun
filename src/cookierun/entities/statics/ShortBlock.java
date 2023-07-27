package cookierun.entities.statics;

import java.awt.Graphics;

import cookierun.Handler;
import cookierun.gfx.Assets;

public class ShortBlock extends StaticEntity {

	public ShortBlock(Handler handler, float x, float y) {
		super(handler, x, y, 60, 60);
	}

	@Override
	public void tick() {

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.shortblock, (int) (x - handler.getGameCamera().getxOffset()), (int) y, width, height, null);

	}

}
