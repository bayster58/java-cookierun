package cookierun;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import cookierun.display.Display;
import cookierun.gfx.Assets;
import cookierun.gfx.GameCamera;
import cookierun.gfx.ImageLoader;
import cookierun.gfx.SpriteSheet;
import cookierun.input.KeyManager;
import cookierun.states.GameState;
import cookierun.states.MenuState;
import cookierun.states.State;

public class Game implements Runnable {

	private Display display;
	private int width, height;
	public String title;

	private boolean running = false;
	private Thread thread;

	private BufferStrategy bs;
	private Graphics g;

	private State gameState;
	private State menuState;

	private KeyManager keyManager;

	private GameCamera gameCamera;

	private Handler handler;

	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
	}

	public void init() {
		display = new Display(title, width, height);
		display.getframe().addKeyListener(keyManager);
		Assets.init();

		gameCamera = new GameCamera(handler, 0, 0);
		handler = new Handler(this);

		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		State.setState(gameState);
	}

	public void tick() {
		keyManager.tick();

		if (State.getState() != null)
			State.getState().tick();
	}

	public void render() {
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();

		g.clearRect(0, 0, width, height);

		if (State.getState() != null)
			State.getState().render(g);

		bs.show();
		g.dispose();
	}

	public void run() {

		init();

		int fps = 60;
		double timeperTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;

		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timeperTick;
			timer += now - lastTime;
			lastTime = now;

			if (delta >= 1) {
				tick();
				render();
				ticks++;
				delta--;
			}

			if (timer >= 1000000000) {
				ticks = 0;
				timer = 0;
			}
		}

		stop();

	}

	public KeyManager getKeyManager() {
		return keyManager;
	}

	public GameCamera getGameCamera() {
		return gameCamera;
	}

	public int getWidth() {
		return width;
	}

	public synchronized void start() {
		if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop() {
		if (!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
