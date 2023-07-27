package cookierun.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import cookierun.Game;
import cookierun.Handler;
import cookierun.gfx.Animation;
import cookierun.gfx.Assets;
import cookierun.input.KeyManager;

public class Player extends Creature {

	private Animation anim, animJump, animJump2;
	public float jump1_hei = 0, jump2_hei = 0;

	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

		bounds.x = 20;
		bounds.y = 20;
		bounds.width = 20;
		bounds.height = 50;

		anim = new Animation(100, Assets.player);
		animJump = new Animation(100, Assets.jump);
		animJump2 = new Animation(100, Assets.jump2);
	}

	@Override
	public void tick() {
		anim.tick();
		animJump.tick();
		animJump2.tick();
		getInput();
		jump();
		handler.getGameCamera().centerOnEntity(this);
	}

	private void getInput() {
		xMove = 3;
		yMove = 0;

		if (handler.getKeyManager().jump1_chk) {
			if (handler.getKeyManager().jump2_chk) {
				if (handler.getKeyManager().jump2_max == false) {
					yMove = -speed;
					jump2_hei += speed;
					if (jump2_hei == 90)
						handler.getKeyManager().jump2_max = true;
				} else if (handler.getKeyManager().jump2_max == true) {
					yMove = speed;
					jump2_hei -= speed;
					if (jump2_hei == 0) {
						handler.getKeyManager().jump2_chk = false;
						handler.getKeyManager().jump2_max = false;
					}
				}
			} else if (handler.getKeyManager().jump1_max == false) {
				yMove = -speed;
				jump1_hei += speed;
				if (jump1_hei == 108) {
					handler.getKeyManager().jump1_max = true;
				}
			} else if (handler.getKeyManager().jump1_max == true) {
				yMove = speed;
				jump1_hei -= speed;
				if (jump1_hei == 0) {
					handler.getKeyManager().jump1_chk = false;
					handler.getKeyManager().jump1_max = false;
				}
			}
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) y, width,
				height, null);
	}

	private BufferedImage getCurrentAnimationFrame() {
		if (handler.getKeyManager().jump1_chk) {
			if (handler.getKeyManager().jump2_chk)
				return animJump2.getCurrentFrame();
			else
				return animJump.getCurrentFrame();
		} else
			return anim.getCurrentFrame();
	}
}
