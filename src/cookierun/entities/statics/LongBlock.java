package cookierun.entities.statics;

import java.awt.Graphics;

import cookierun.Handler;
import cookierun.gfx.Assets;

public class LongBlock extends StaticEntity {

	public LongBlock(Handler handler, float x, float y) {
		super(handler, x, y - 90, 60, 150);
	}

	@Override
	public void tick() {

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.longblock, (int) (x - handler.getGameCamera().getxOffset()), (int) y, width, height, null);

	}

}
