package cookierun.input;

import java.awt.Event;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

	private boolean[] keys;
	public boolean space, down;
	public boolean jump1_chk = false, jump2_chk = false;
	public boolean jump1_max = false, jump2_max = false;

	public KeyManager() {
		keys = new boolean[256];
	}

	public void tick() {
		down = keys[KeyEvent.VK_DOWN];
		space = keys[KeyEvent.VK_SPACE];
	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (jump1_chk == false)
				jump1_chk = true;
			else if (jump2_chk == false) {
				jump2_chk = true;
				jump1_max = true;
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
