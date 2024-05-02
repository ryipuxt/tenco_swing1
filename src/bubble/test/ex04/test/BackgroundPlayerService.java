package bubble.test.ex04.test;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BackgroundPlayerService implements Runnable {

	private BufferedImage image;
	private Player player;

	public BackgroundPlayerService(Player player) {
		this.player = player;

		try {
			image = ImageIO.read(new File("img/backgroundMapService.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		System.out.println("백그라운드 서비스 동작");
		while (true) {
			// 색상 확인 TODO(보정값 필요)
			Color tColor = new Color(image.getRGB(player.getX(), player.getY()));
			System.out.println(tColor.getRed() + " <<<<< ");
			
			Color leftColor = new Color(image.getRGB(player.getX() + 10, player.getY() + 25));
			Color rightColor = new Color(image.getRGB(player.getX() + 50 + 10, player.getY() + 25));
			
			Color leftBottomColor = new Color(image.getRGB(player.getX() + 10, player.getY() + 25 + 50));
			Color rightBottomColor = new Color(image.getRGB(player.getX() + 50 + 10, player.getY() + 25 + 50));

			// 왼쪽 벽에 충돌함
			if (leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
				System.out.println("왼쪽 벽에 충돌함");
				player.setLeftWallCrash(true);
				player.setLeft(false);
			} else if (rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
				System.out.println("오른쪽 벽에 충돌함");
				player.setRightWallCrash(true);
				player.setRight(false);
			} else if (leftBottomColor.getBlue() == 255 && leftBottomColor.getRed() == 0
					&& leftBottomColor.getGreen() == 0) {
				System.out.println("B");
				player.setLeftBottomCrash(true);
				player.setDown(false);
			} else if (rightBottomColor.getBlue() == 255 && rightBottomColor.getRed() == 0
					&& rightBottomColor.getGreen() == 0) {
				System.out.println("B");
				player.setRightBottomCrash(true);
				player.setDown(false);
			}
			// 위 두 조건이 아니면 player 마음대로 움직일 수 있다.
			player.setLeftWallCrash(false);
			player.setRightWallCrash(false);
			player.setLeftBottomCrash(false);
			player.setRightBottomCrash(false);

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
