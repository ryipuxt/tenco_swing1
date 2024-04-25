package ch01;

import java.awt.BorderLayout;
import java.awt.Button;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutEx2 extends JFrame {
	
	final int WIDTH = 600;
	final int HEIGHT = 600;

	JButton[] buttons = {};
	String[] directions = { BorderLayout.EAST, BorderLayout.WEST, BorderLayout.SOUTH, BorderLayout.NORTH,
			BorderLayout.CENTER };

	// 생성자
	public BorderLayoutEx2() {

		initData();
		setInitData();
	}

	public void initData() {
		setTitle("borderLayout 연습");
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		buttons = new JButton[directions.length];
	}

	public void setInitData() {
		// 배치 관리자 선정 (컨테이너)
		// BorderLayout -- 컴포넌트들을 동서남북가운데로 배치 시켜주는 레이아웃이다.
		setLayout(new BorderLayout());

		// 반복문을 활용해 코드를 완성 for (int i = 0; i < buttons.length; i++) {

		for (int i = 0; i < directions.length; i++) {
			add(new JButton(directions[i]), directions[i]);
		}

	}

	public static void main(String[] args) {
		new BorderLayoutEx2();
	}

}
