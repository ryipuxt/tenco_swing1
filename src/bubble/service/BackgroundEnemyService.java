package bubble.service;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import bubble.components.Enemy;

public class BackgroundEnemyService implements Runnable {

	private BufferedImage image;
	private Enemy enemy;

	public BackgroundEnemyService(Enemy enemy) {
		this.enemy = enemy;

		try {
			image = ImageIO.read(new File("img/backgroundMapService.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			// 색상 확인 TODO(보정값 필요)
			Color leftColor = new Color(image.getRGB(enemy.getX() + 10, enemy.getY() + 25));
			Color rightColor = new Color(image.getRGB(enemy.getX() + 50 + 10, enemy.getY() + 25));

			// Color bottomColor = new Color(image.getRGB(enemy.getX(), enemy.getY()));

			// 흰색이면 바닥 RGB 255 255 255
			// 바닥인 경우 > 255 0 0 (바닥이라고 판단 가능)
			// 바닥인 경우 > 0 0 255 (바닥이라고 판단 가능)
			int bottomColorLeft = image.getRGB(enemy.getX() + 20, enemy.getY() + 50 + 5);
			int bottomColorRight = image.getRGB(enemy.getX() + 50 + 10, enemy.getY() + 50 + 5);

			// 하얀색 > int 값이 -1
			if (bottomColorLeft + bottomColorRight != -2) {
				// 멈추기 (빨간바닥 or 파란바닥)
				enemy.setDown(false);
				// 플레이어가 올라가거나 내려가는 상태가 아니라면 호출
			} else if (!enemy.isUp() && !enemy.isDown()) {
				enemy.down();
			}

			// 왼쪽 벽에 충돌함
			if (leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
				System.out.println("왼쪽 벽에 충돌함");
				enemy.setLeftWallCrash(true);
				enemy.setLeft(false);
			} else if (rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
				System.out.println("오른쪽 벽에 충돌함");
				enemy.setRightWallCrash(true);
				enemy.setRight(false);
			} else {
				enemy.setLeftWallCrash(false);
				enemy.setRightWallCrash(false);
			}
			// 위 두 조건이 아니면 enemy 마음대로 움직일 수 있다.

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
