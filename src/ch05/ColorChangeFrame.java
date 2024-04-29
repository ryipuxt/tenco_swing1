package ch05;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
// 이벤트 리스너를 사용하는 방법
// 1. implements ActionListener 사용 하는 방법
// ActionListener > 운영 체제가 제어하는 이벤트 등록 가능
public class ColorChangeFrame extends JFrame implements ActionListener {

	private JButton button1;

	public ColorChangeFrame() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button1 = new JButton("button1");
	}

	private void setInitLayout() {
		setLayout(new FlowLayout());
		add(button1);
		setVisible(true);
	}

	private void addEventListener() {
		button1.addActionListener(this);
	}

	public static void main(String[] args) {
		new ColorChangeFrame();

	}
	// 이벤트가 발생하면 이 메서드를 수행하라고 약속되어있음.
	// 단, 어떤 컴포넌트가 이벤트가 할당 되었는지 등록을 먼저 해주어야 한다.
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("actionPerformed 메서드 호출()");
		System.out.println(e.toString());
		setBackground(Color.black);
	}
}
