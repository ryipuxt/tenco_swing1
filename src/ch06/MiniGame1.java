package ch06;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiniGame1 extends JFrame {

	private JLabel jPlayer;
	private JLabel backgroundMap;

	private int jPlayerX = 100;
	private int jPlayerY = 100;
	private final int MOVE_DISTANCE = 10;
	private final int FRAME_WIDTH = 500;
	private final int FRAME_HEIGHT = 500;
	private final int PLAYER_WIDTH = 100;
	private final int PLAYER_HEIGHT = 100;

	public MiniGame1() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jPlayer = new JLabel(new ImageIcon("images/image1.png"));
		jPlayer.setSize(PLAYER_WIDTH, PLAYER_HEIGHT);
		Icon icon = new ImageIcon("images/amogusgus.jpg");
		backgroundMap = new JLabel(icon);
		backgroundMap.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		backgroundMap.setLocation(0, 0);
	}

	private void setInitLayout() {
		// 좌표 기반으로 배치관리자 변경
		setLayout(null);
		add(jPlayer);
		add(backgroundMap);
		jPlayer.setLocation(jPlayerX, jPlayerY);
		setVisible(true);
	}

	private void addEventListener() {
		// jPlayer 객체에게서만 keyListener 동작을 시키고자 한다면
		// 익명 구현클래스로 KeyListener 인터페이스를 재정의 할 수 있다.
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					jPlayerX -= MOVE_DISTANCE;
					if (jPlayerX < -30) {
						jPlayerX = -30;
					}
				} else if (e.getKeyCode() == KeyEvent.VK_UP) {
					if (jPlayerY < 0) {
						jPlayerY = 0;
					}
					jPlayerY -= MOVE_DISTANCE;
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					jPlayerX += MOVE_DISTANCE;
					if (jPlayerX > 410) {
						jPlayerX = 410;
					}
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					jPlayerY += MOVE_DISTANCE;
					if (jPlayerY > 370) {
						jPlayerY = 370;
					}
				}
				jPlayer.setLocation(jPlayerX, jPlayerY);
			}
		});
	}

	// 코드 테스트
	public static void main(String[] args) {
		new MiniGame1();
	} // end of main

} // end of class
