package cookierun.entities.creatures;

import blocks.Block;
import cookierun.Game;
import cookierun.Handler;
import cookierun.entities.Entity;

public abstract class Creature extends Entity {

	public static final int DEFAULT_HEALTH = 90;
	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_CREATURE_WIDTH = 60, DEFAULT_CREATURE_HEIGHT = 90;

	protected int health;
	protected float speed;
	protected float xMove, yMove;

	public Creature(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}

	public void jump() {
		if (checkEntityCollisions(xMove, 0f)) {
			try {
				Thread.sleep(10000000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		x += xMove;
		y += yMove;
	}

	protected boolean collisionWithBlock(int x, int y) {
		return handler.getWorld().getBlock(x, y).isSolid();
	}

	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

}
