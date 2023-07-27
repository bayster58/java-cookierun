package cookierun.gfx;

import cookierun.Handler;
import cookierun.entities.Entity;

public class GameCamera {

	private Handler handler;
	private float xOffset, yOffset;

	public GameCamera(Handler handler, float xOffset, float yOffset) {
		this.handler = handler;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}

	public void centerOnEntity(Entity e) {
		xOffset = e.getX() - 120 / 2;
	}

	public void move(float xAmt) {
		xOffset += xAmt;
	}

	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.xOffset = yOffset;
	}
}
