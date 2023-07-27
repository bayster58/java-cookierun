package cookierun.gfx;

import java.awt.image.BufferedImage;

public class Assets {

	public static BufferedImage longblock, shortblock, back, hole, sky, Ground;
	public static BufferedImage[] player, jump, jump2;

	public static void init() {
		SpriteSheet sheet1 = new SpriteSheet(ImageLoader.loadImage("/textures/cookie.png"));
		SpriteSheet sheet2 = new SpriteSheet(ImageLoader.loadImage("/textures/block1.png"));
		SpriteSheet sheet3 = new SpriteSheet(ImageLoader.loadImage("/textures/back.png"));

		player = new BufferedImage[3];
		jump = new BufferedImage[3];
		jump2 = new BufferedImage[3];

		player[0] = sheet1.crop(0, 0, 123, 134);
		player[1] = sheet1.crop(123, 0, 123, 134);
		player[2] = sheet1.crop(246, 0, 123, 134);
		jump[0] = sheet1.crop(0, 134, 123, 113);
		jump[1] = sheet1.crop(123, 134, 123, 113);
		jump[2] = sheet1.crop(246, 134, 123, 113);
		jump2[0] = sheet1.crop(0, 247, 123, 117);
		jump2[1] = sheet1.crop(123, 247, 123, 117);
		jump2[2] = sheet1.crop(246, 247, 123, 117);
		shortblock = sheet2.crop(0, 0, 100, 100);
		longblock = sheet2.crop(100, 0, 100, 100);
		hole = sheet3.crop(100, 0, 100, 100);
		sky = sheet3.crop(200, 0, 100, 100);
		Ground = sheet3.crop(300, 0, 100, 100);
	}
}
