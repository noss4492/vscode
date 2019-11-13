package HomeCatchMind;

import java.applet.Applet;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JPanel;

// �Ƹ� �� �гο� ä��â�� �� �����͸� �ٿ��� ���ٰ� �����غ��� �굵 ������� �����Ǿ�� �� ���̴�.
// �ٵ� �ϴ� �г��� �ְ� �޴� ����� �����Ѵٸ�
// �� �г��� �ְ� �޴� �ָ� ������� ����� �� ���̴�.

public class CreateDrawCanvas extends JFrame implements MouseMotionListener, MouseListener, Serializable { // runnable
	DrawCanvas drawCanvas; // ���� ��ø Ŭ������ �� �ʿ�� ������
	JPanel mirrorPane;
	Socket server;
	String ip = "192.168.0.2";
	int port = 5000;
	JFrame frame;
	Container c;
	BufferedWriter bw;

	public CreateDrawCanvas() {
		setLayout(null);
		setResizable (false);
		drawCanvas = new DrawCanvas();
		mirrorPane = new JPanel();
		mirrorPane.setLayout(null);
		
		mirrorPane.setBackground(Color.red);
		mirrorPane.setBounds(0, 0, 500, 500);	
		mirrorPane.setVisible(false);
		
		drawCanvas.setBounds(0, 0, 500, 500); // �׸��� ũ��
		drawCanvas.setBackground(Color.GRAY); // �ϴ� ���� �̰ɷ� �ص�(������ ����)
		add(drawCanvas);
//		mirrorPane.add(drawCanvas); 					  // �׸��� ĵ���� ������
		
		drawCanvas.addMouseMotionListener(this); // mouse dragged�� ��ġ ������ ����
		drawCanvas.addMouseListener(this);
		mirrorPane.addMouseMotionListener(this); // mouse dragged�� ��ġ ������ ����
		mirrorPane.addMouseListener(this);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		setSize(500, 500);
		setVisible(true);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		drawCanvas.x = e.getX();
		drawCanvas.y = e.getY();
		drawCanvas.repaint();
//		mirrorPane.add(drawCanvas);
		// ���ӵ��� ������ ��� ���...�߰�? (�׳� ���ӵ��� �ϸ� ���� ������ �ʴ� �κп� ���� �� ����.)
		// ���� �ܰ��� ���ӵ��� ���� ���� ���ӵ��� �ʾҴ����� �Ǻ��ϴ� �˰������� �ʿ���
		// ���ӵ��� �ʹ� ũ�� ���� ���ӵ��� �ʾҴٰ� ���� ������ ������ �������� �������ִ� ����� �ʿ���.
		// ũ�� 100������ �Ǵ� ť�� ���ӵ��� ���ϴ� ������� �������� ��. �ð� ���� �ɸ� �� �ϴ� ���߿� ��
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		drawCanvas.x = e.getX();
		drawCanvas.y = e.getY();
		drawCanvas.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// ����� �巡�׽� üũ �ȵǴ� ������.
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
	@Override
	public void mousePressed(MouseEvent e) {
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// mirrorPane.add(drawCanvas); �̰� �������� �� ��?
		// �ƴϸ� drawCanvas�� ��������ɵ�?
		// oos.writer

//		Container conn = drawCanvas;	// �긦 �������� �ǳ�? �Ƴ� 
		// �׷� �̰ɷ� �Űܺ��� drawCanvas
		try {
			System.out.println("try streamout. ���� ������~");
			server = new Socket(ip, port);
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

//		ByteArrayOutputStream baos;
//				bos = new BufferedOutputStream(server.getOutputStream());
//				oos = new ObjectOutputStream(bos);
//			baos = new ByteArrayOutputStream();
		BufferedOutputStream bos;
		ObjectOutputStream oos;
		OutputStream os;
		try {
			os = server.getOutputStream();
			bos = new BufferedOutputStream(os);
			oos = new ObjectOutputStream(bos);
			mirrorPane.add(drawCanvas);
			PaintPacket pp = new PaintPacket(mirrorPane);
//			oos.writeObject(pp);
			oos.writeObject((Frame)this);
			
			// �õ� �α�.
			// ObjectOutputStream Obj, Pane, JPanel, Frame ...
			// JPanel�� �����ؼ� ���� PaintPacket Ŭ�����ε� ����ȭ �ȵ�
			// ByteArrayStream���� byte������ ������ �� -> ������ȭ�� �����
			// FileOutputStream �ȵ�
			// DataOutputStream �ȵ�
			// serial UID ? �� ������ �ִٰ� �ϰ�...
			// Image�� ������ ���� �Ҿ�����
			// Pane���� ���� �� �ֳ� �ߴµ� �ȵ�

			os.close();
			oos.close();
			bos.close();
			oos.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}
	public static void main(String[] args) { // ����
		CreateDrawCanvas s1 = new CreateDrawCanvas();
	}
	
	public DrawCanvas getDrawCanvas() {
		return drawCanvas;
	}
	
	public void setDrawCanvas(DrawCanvas drawCanvas) {
		this.drawCanvas = drawCanvas;
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	class DrawCanvas extends Canvas implements Serializable{ // Serialized Form
		int x, y; // x, y���� ������ �����ؼ� ����ϴ� ����� ��������.

		Graphics g;
		
		// Graphics ���ڸ� �ܺο��� ���� ����� �����ϱ� ������ �޼��带 �̿��Ѵ�.
		// repaint�� ���� ȣ���.
		// repaint�� update�� ȣ���� �� �� ĵ������ paint��
		public void update(Graphics g) {
			myPaint(g);
		}

		// ���� �������� ǥ����. �̸� ������ �մ� �˰������� ���Ŀ�
		public void myPaint(Graphics g) {
			changeColorR(g);
			g.fillOval(x - 5, y - 5, 10, 10);
		}

		public void changeColorR(Graphics g) {
			g.setColor(Color.red);
		}

		public void changeColorG(Graphics g) {
			g.setColor(Color.green);
		}

		public void changeColorB(Graphics g) {
			g.setColor(Color.blue);
		}

		public void changeColorY(Graphics g) {
			g.setColor(Color.yellow);
		}

		public void changeColorBK(Graphics g) {
			g.setColor(Color.black);
		}
	}
}
//			oos = new ObjectOutputStream(os);
//			bos = new BufferedOutputStream(oos);
	
//			oos.writeObject(this.getFrame());
//			oos.writeObject(this.getGlassPane());

//			oos.writeObject(baos);
//			byte[] data = baos.toByteArray();

//			System.out.println("pw:" + );

//			solver = new Socket(ip, port);
//			ObjectOutputStream oos = new ObjectOutputStream(bos);
//			oos.writeObject(this);

//				System.out.println(bos+"|"+oos);
//			mirrorPane = drawCanvas;
//				System.out.println("hash : "+drawCanvas);
//			os.writeObject(drawCanvas);
//			DrawCanvas a = drawCanvas;
//			Object mip = drawCanvas;
//			Object b = new PaintPacket(drawCanvas);
//			os.writeObject(b);
//			os.flush();
//			os.reset();
//			os.close(); // �̰� ���� ����÷� ����.

	// DrawCanvas Ŭ������ ����ȭ ����. �ֽô��� �̰��� �õ��ϴ� ���� ���� �ʾҴ�.
	/*
	 * 1. Graphics Ŭ������ ����ȭ �� �� ����. �׸��� stackoverflow�� ���� ������� GUI ������Ҹ� ����ȭ �� ������ȭ
	 * ���� �ʴ� ���� �����Ѵ�.
	 * 
	 * �׷��ٸ� �ذ� �����? 2. graphics �� ���� ȭ���� image�� �׷��� �� image�� �����ϴ� ��� (graphics�� ������)
	 * 3. toolkit api�� ĸ�� (������ �ȳ���) 4. ���� �����ڿ��� mouse dragged �̺�Ʈ �߻��� x, y ��ǥ�� ������
	 * ������ �������� �ٽ� ���� solver���� x, y��ǥ�� ���� Ŭ���̾�Ʈ���� �׸��� �ϴ� ���. (���ɸ鿡�� ������ ����)
	 */
//			BufferedImage capImg;
//			ImageOutputStream baos;
//				Point lo = this.getLocation();
//				int x = (int) this.getLocation().getX();
//				int y = (int) this.getLocation().getY();

//				Toolkit toolkit = Toolkit.getDefaultToolkit();
//				Dimension scrSize = toolkit.getScreenSize();
//				Rectangle rect = new Rectangle(0, 0, scrSize.width, scrSize.height);

//				Rectangle rect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
//				Rectangle rect = new Rectangle(500, 500);
// ------------------------------------------------------------------------------------
// - ���� ȭ���� ĸ�� �� (����Ʈ��Ʈ������ ����) -
//			Robot robot;
//			OutputStream os;
//			BufferedOutputStream bos;
//			try {
//				robot = new Robot();
//				Rectangle rect = new Rectangle(this.getX(), this.getY(), 500, 500);
//				BufferedImage capImg = robot.createScreenCapture(rect);
//				os = server.getOutputStream();
//				bos = new BufferedOutputStream(os);
//				ImageIO.write(capImg, "jpg", bos);
//				os.close();
//				System.out.println("�̹��� ���� �Ϸ�");
//			} catch (AWTException e1) {
//				e1.printStackTrace();
//			} catch (IOException e1) {
//				e1.printStackTrace();
//			}
//	}
// ------------------------------------------------------------------------------------

	// ĸ�� �� �̸� ����Ʈ ��Ʈ������ ����.

//			long size = Instrumentation.getObjectSize(capImage);
//			ObjectSizeFetcher.getObjectSize(capImage);

//			long size = iis.length();
//			byte[] imageBytes = new byte[(int)size];
//			int imgByteSize = imgBytes.length

	// new Rectangle(int width, int height)�� ����ϸ� ��.
//				Rectangle rect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
//				Dimension area = Toolkit.getDefaultToolkit().getScreenSize();
//				Rectangle rect = new Rectangle(area);

	// ����Ʈ��Ʈ������ Outputstream�� �ױ�

// ------------------ ����ȭ ���  --------------------------------------------------			
//			BufferedOutputStream bos = new BufferedOutputStream(server.getOutputStream());
//			ObjectOutputStream oos = new ObjectOutputStream(bos);
//			System.out.println(bos+"|"+oos);
//			mirrorPane = drawCanvas;
//			System.out.println(drawCanvas);
//			oos.writeObject(drawCanvas);
//			DrawCanvas a = drawCanvas;
//			Object mip = drawCanvas;
//			Object b = new PaintPacket(drawCanvas);
//			oos.writeObject();
//			oos.flush();
//			oos.reset();
//			oos.close();	// �̰� ���� ����÷� ����. 
//		} catch (UnknownHostException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//	}
// ------------------------------------------------------------------------------
//		System.out.println("�̶� ������!!");
//		try {
//			server = new Socket(ip, port);	// ���� ���� ��� -> ���� ==> ����1,2,3
//		} catch (UnknownHostException e1) {
//			e1.printStackTrace();
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}						
//		jp1 = new JPanel();

//		Container conn = this.get
//		OutputStream os = solver.getOutputStream()
//		ObjectOutputStream oos = new ObjectOutputStream();
//		BufferedWriter bw = new BufferedWriter(oos);

//		Socket solver;
//		try {
//			solver = new Socket(ip, port);
//			BufferedOutputStream bos = new BufferedOutputStream(solver.getOutputStream());
//			ObjectOutputStream oos = new ObjectOutputStream(bos);
//			oos.writeObject(this);
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
//	}
//	
//	public CreateDrawCanvas CopyDraw() {
//		CreateDrawCanvas copy1 = null;
//		try {
//			copy1 = (CreateDrawCanvas) super.clone();
//		} catch (CloneNotSupportedException e) {
//			e.printStackTrace();
//		}
//		return copy1;
//	}
//	public void VClient() {	// �׳� Ŭ���̾�Ʈ ������ ������� ��� //����
//		Thread th = new Thread(this);
//		th.start();
//	}
//	

//	@Override
//	public void run() {	//���������� ���� ���Ͽ� ������Ʈ�� �ѷ������ // �Ƴ� ������ �ʿ� ������
//		try {
//			server = new Socket(ip, port);	// �������� �޾Ƽ� �ٽ� ������(solver)���� �ѷ��� ������
//			
//			// ���Ͽ� ��� output stream�� �װ� ����. (�ְ����� �ǰ�)
//			BufferedOutputStream bos = new BufferedOutputStream(server.getOutputStream());
//			ObjectOutputStream oos = new ObjectOutputStream(bos);
//			
//			//�������� br = new 
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}