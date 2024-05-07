package bubble.test.ex10;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleFrame extends JFrame {

	// 컨텍스트를 생성하는 방법 (셀프 참조)
	BubbleFrame mContext = this;

	private JLabel backgroundMap;
	// 포함관계 - 콤포지션
	private Player player;
	private Enemy enemy1;

	public BubbleFrame() {

		initData();
		setInitLayout();
		addEventListener();

	}

	private void initData() {
		// todo 이미지 변경
		backgroundMap = new JLabel(new ImageIcon("img/backgroundMap.png"));
		// backgroundMap = new JLabel(new ImageIcon("img/test.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Frame --> root Panel
		setContentPane(backgroundMap); // add 처리
		setSize(1000, 640);

		// mContext --> 참조 타입( ) --> 주소값에 크기는 기본 4byte 이다.
		player = new Player(mContext);

		enemy1 = new Enemy(mContext);

	}

	private void setInitLayout() {
		// 좌표 값으로 배치
		setLayout(null);
		setResizable(false); // 프레임 조절 불가
		setLocationRelativeTo(null); // JFrame 여러분 모니터 가운데 자동 배치
		setVisible(true);

		add(player);
		add(enemy1);
	}

	private void addEventListener() {

		this.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("key code : " + e.getKeyCode());

				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					// 왼쪽으로 방향키 누르고 있다면
					// key 이벤트가 계속 <- <- <- <- <- <-
					// 왼쪽 상태가 아니라면
					// 왼쪽 벽에 충돌 한게 아니라면
					if (!player.isLeft() && !player.isLeftWallCrash()) {
						player.left();
					}
					break;
				case KeyEvent.VK_RIGHT:
					if (!player.isRight() && !player.isRightWallCrash()) {
						player.right();
					}

					break;
				case KeyEvent.VK_UP:
					if (!player.isUp()) {
						player.up();
					}
					break;
				case KeyEvent.VK_SPACE:
					// add(new Bubble(player));
					player.attack();
					// 프레임에 컴포넌트를 add 동작은 누구? JFrame --> add() 메서드 이다.
					// 버블 실행시에 끊김 현상이 발생하는 이유는 왜 일까??
					break;
				default:
					break;
				}
			} // end of KeyPressed

			@Override
			public void keyReleased(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					// 왼쪽으로 가능 상태 멈춤
					player.setLeft(false);
					break;
				case KeyEvent.VK_RIGHT:
					// 오른쪽으로 가능 상태 멈춤
					player.setRight(false);
					break;
				default:
					break;
				}
			} // end of KeyReleased

		});
	}

	// getter
	public Player getPlayer() {
		return player;
	}

	public Enemy getEnemy() {
		return enemy1;
	}

	// 코드 테스트
	public static void main(String[] args) {
		new BubbleFrame();
	} // end of main

}
