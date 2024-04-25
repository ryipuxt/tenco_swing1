package ch01;

import java.awt.FlowLayout;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;

// Swing > 배치 관리자 : FlowLayout
// 컴포넌트들을 (버튼, 라벨) 등을 수평, 수직으로 배치를 해주는 클래스 이다.
public class FlowLayoutEx2 extends JFrame {

	private JButton[] buttons;

	// 생성자
	public FlowLayoutEx2() {
		super.setTitle("FlowLayout 연습");
		super.setSize(500, 500);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 생성자에서도 메서드 호출이 가능하다.
		initData();
		setInitData();
	}

	// 멤버 변수를 초기화 하는 기능(값 넣기)
	public void initData() {

		buttons = new JButton[6];

		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton("[button" + (i + 1) + "]");
		}

	}

	// 컴포넌트들을 배치하는 기능
	public void setInitData() {
		// 배치 관리자 -> BorderLayout 이라는 배치관리자가 기본으로 활용 된다.
		// FlowLayout flowLayout = new FlowLayout();
		// setLayout(flowLayout); // 배치관리자 -> FlowLayout

		// 배치 관리자 생성 및 JFrame 세팅
		setLayout(new FlowLayout(FlowLayout.LEADING, 50, 50)); // 배치관리자 -> FlowLayout

		// 컴포넌트들을 붙이다.
		for (int i = 0; i < buttons.length; i++) {
			super.add(buttons[i]);
		}

	}

	// 코드 테스트
	public static void main(String[] args) {
		// FlowLayoutEx f1 = new FlowLayoutEx(); // <-- 부를수 있는 이름이 있는 상태
		new FlowLayoutEx2(); // 익명 클래스
		// 다시 접근해 사용할일이 없으면
	} // end of main

}
