package day22;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyWin extends Frame {
	final static int WIDTH = 800;
	final static int HEIGHT = 600;

	MyWin() {

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setBounds(100, 100, 800, 600);
		setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		System.out.println("ȭ�� �׷����� ��" + System.currentTimeMillis());
		// Graphics : ����

		// draw/fill

		// ���� �׸���
//		g.drawLine(0, 0, 300, 300);
//		g.drawLine(800, 0, 400, 300);

		// �簢�� �׸���
//		g.drawRect(300, 300, 100, 100);

		// Ÿ�� �׸���
//		for(int i = 0; i < 200; i ++) {
//			Color c = new Color((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255));
//			g.setColor(c);
//			for(int j = 0; j < 4; j ++)
//				g.drawArc(0, 0, 5*i, 5*i, 0, 90*j);
//		}

		// �� �׸���
//		g.drawOval(250,  250, 100, 100);

		// �簢�� ä���
//		g.fillRect(400,  400,  500, 50);
//		g.setColor(Color.BLUE);

		// �۾���
//		g.drawString("������", 250, 100);

		// rgb ���� ���� ����
		Color c = new Color(54, 182, 22);
		g.setColor(c);
//		g.drawString("������", 250, 100);

		// �� �׸���

		Color c2 = new Color(0, 0, 0);
		g.setColor(c2);

		int radius = 200;
		int wGap = 40;
		int hGap = 15;
		int eyeSize = 70;
		int eyePu = 20;
		// center is WIDTH/4+radius, HEIGHT/4+radius
		g.drawOval(WIDTH / 4, HEIGHT / 4, radius * 2, radius * 2);
		g.drawOval(WIDTH / 4 + radius - eyeSize - wGap, HEIGHT / 4 + radius - eyeSize - hGap, eyeSize, eyeSize);
		g.drawOval(WIDTH / 4 + radius + wGap, HEIGHT / 4 + radius - eyeSize - hGap, eyeSize, eyeSize);

		// left eye center is WIDTH/4+radius-eyeSize-wGap+eyeSize/2-eyePu/2
		// right eye center is WIDTH/4+radius+wGap+eyeSize/2-eyePu/2
		// eye height center is HEIGHT/4+radius-eyeSize-hGap+eyeSize/2-eyePu/2
		g.fillOval(WIDTH / 4 + radius - eyeSize - wGap + eyeSize / 2 - eyePu / 2,
				HEIGHT / 4 + radius - eyeSize - hGap + eyeSize / 2 - eyePu / 2, eyePu, eyePu);
		g.fillOval(WIDTH / 4 + radius + wGap + eyeSize / 2 - eyePu / 2,
				HEIGHT / 4 + radius - eyeSize - hGap + eyeSize / 2 - eyePu / 2, eyePu, eyePu);

		int mouthLen = 120;
		int mouthHeight = 60;
		g.drawArc(WIDTH / 4 + radius - mouthLen / 2, HEIGHT / 4 + radius + (mouthLen - mouthHeight), mouthLen,
				mouthHeight, 180, 180);

		int hTeeth = 30;
		int wTeeth = 30;
		g.drawLine(WIDTH / 4 + radius - mouthLen / 2 + mouthLen / 2,
				HEIGHT / 4 + radius + (mouthLen - mouthHeight) + mouthHeight,
				WIDTH / 4 + radius - mouthLen / 2 + mouthLen / 2,
				HEIGHT / 4 + radius + (mouthLen - mouthHeight) + mouthHeight + hTeeth);
		// HEIGHT / 4+ radius+(mouthLen-mouthHeight)+mouthHeight+teeth
		g.drawLine(WIDTH / 4 + radius - mouthLen / 2 + mouthLen / 2,
				HEIGHT / 4 + radius + (mouthLen - mouthHeight) + mouthHeight + hTeeth,
				WIDTH / 4 + radius - mouthLen / 2 + mouthLen / 2 + wTeeth,
				HEIGHT / 4 + radius + (mouthLen - mouthHeight) + mouthHeight + hTeeth);
		g.drawLine(WIDTH / 4 + radius - mouthLen / 2 + mouthLen / 2,
				HEIGHT / 4 + radius + (mouthLen - mouthHeight) + mouthHeight + hTeeth,
				WIDTH / 4 + radius - mouthLen / 2 + mouthLen / 2 - wTeeth,
				HEIGHT / 4 + radius + (mouthLen - mouthHeight) + mouthHeight + hTeeth);

		// alpha is not calculated value
		int alpha = 3;
		g.drawLine(WIDTH / 4 + radius - mouthLen / 2 + mouthLen / 2 - wTeeth,
				HEIGHT / 4 + radius + (mouthLen - mouthHeight) + mouthHeight + hTeeth,
				WIDTH / 4 + radius - mouthLen / 2 + mouthLen / 2 - wTeeth,
				HEIGHT / 4 + radius + (mouthLen - mouthHeight) + mouthHeight - alpha);
		g.drawLine(WIDTH / 4 + radius - mouthLen / 2 + mouthLen / 2 + wTeeth,
				HEIGHT / 4 + radius + (mouthLen - mouthHeight) + mouthHeight + hTeeth,
				WIDTH / 4 + radius - mouthLen / 2 + mouthLen / 2 + wTeeth,
				HEIGHT / 4 + radius + (mouthLen - mouthHeight) + mouthHeight - alpha);
		// 90 // 270

		int wEars = 50;
		g.drawArc(WIDTH / 4, HEIGHT / 4 + radius, 50, 50, 90, 180);

	}

	public static void main(String[] args) {
		new MyWin();
	}

}
