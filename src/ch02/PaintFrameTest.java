package ch02;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PaintFrameTest extends JFrame {

	// 내부 클래스를 외부 클래스에 사용하려면
	// 멤버로 가지고 있어야 한다.
	MyDrawing myDrawing;

	public PaintFrameTest() {
		initData();
		setInitLayout();
	}

	private void initData() {
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		myDrawing = new MyDrawing();
	}

	private void setInitLayout() {
		add(myDrawing);
		setVisible(true);
	}

	class MyDrawing extends JPanel {

		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.drawOval(150, 100, 50, 15);
			g.drawOval(175, 120, 50, 15);
			g.drawOval(125, 80, 50, 15);
			g.drawOval(115, 70, 50, 15);
			g.drawRect(200, 200, 150, 150);
			g.drawRect(300, 230, 30, 30);
			g.drawRect(230, 275, 30, 75);
			g.drawLine(0, 350, 600, 350);
			g.drawLine(300, 245, 330, 245);
			g.drawLine(315, 230, 315, 260);
			g.drawLine(350, 200, 275, 125);
			g.drawLine(200, 200, 275, 125);
			g.drawLine(210, 190, 210, 140);
			g.drawLine(210, 140, 240, 140);
			g.drawLine(240, 140, 240, 160);
			g.drawString("○", 250, 320);
		}
	}
}
