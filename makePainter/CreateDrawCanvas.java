package makePainter;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Container;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

// �Ƹ� �� �гο� ä��â�� �� �����͸� �ٿ��� ���ٰ� �����غ��� �굵 ������� �����Ǿ�� �� ���̴�.
// �ٵ� �ϴ� �г��� �ְ� �޴� ����� �����Ѵٸ�
// �� �г��� �ְ� �޴� �ָ� ������� ����� �� ���̴�.

public class CreateDrawCanvas extends Frame implements MouseMotionListener, 
															MouseListener {	// runnable
	DrawCanvas drawCanvas; // ���� ��ø Ŭ������ �� �ʿ�� ������
	JPanel mirrorPane;
	Socket server;
	String ip = "192.168.0.49";
	int port = 5000;
	JFrame frame = new JFrame("");
	Container c;
	BufferedWriter bw;

	public CreateDrawCanvas() {
		setLayout(null);
		
		drawCanvas = new DrawCanvas();
//		mirrorPane.setLayout(null);
//		mirrorPane.setBounds(0, 0, 500, 500);	// is 
		

		drawCanvas.setBounds(0, 0, 500, 500);
		drawCanvas.setBackground(Color.GRAY); // �ϴ� ���� �̰ɷ� �ص�(������ ����)
		add(drawCanvas); // �׸��� ĵ���� ������

		drawCanvas.addMouseMotionListener(this); // mouse dragged�� ��ġ ������ ����
		drawCanvas.addMouseListener(this);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		setSize(500,500);
		setVisible(true);
	}
	
	public void createSendPan(DrawCanvas drawCanvas) {
		mirrorPane = new JPanel();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		drawCanvas.x = e.getX();
		drawCanvas.y = e.getY();
		drawCanvas.repaint();
		// ���ӵ��� ������ ��� ���...�߰�? (�׳� ���ӵ��� �ϸ� ���� ������ �ʴ� �κп� ���� �� ����.)
		// ���� �ܰ��� ���ӵ��� ���� ���� ���ӵ��� �ʾҴ����� �Ǻ��ϴ� �˰����� �ʿ���
		// ���ӵ��� �ʹ� ũ�� ���� ���ӵ��� �ʾҴٰ� ���� ������ ������ �������� �������ִ� ����� �ʿ���.
		// ũ�� 100������ �Ǵ� ť�� ���ӵ��� ���ϴ� ������� �������� ��. �ð� ���� �ɸ� �� �ϴ� ���߿� ��
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// ����� �巡�׽� üũ �ȵǴ� ������.
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		drawCanvas.x = e.getX();
		drawCanvas.y = e.getY();
		drawCanvas.repaint();
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
				System.out.println("try streamout. Ŭ���̾�Ʈ���� ���� �������� ��ǥ ����");
				server = new Socket(ip, port);
			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
			// ���� ȭ���� ĸ�� �� (����Ʈ��Ʈ������ ����)
			Robot robot;
//			BufferedImage capImg;
			OutputStream os;
			BufferedOutputStream bos;
//			ImageOutputStream baos;
			try {
				robot = new Robot();
//				Point lo = this.getLocation();
//				int x = (int) this.getLocation().getX();
//				int y = (int) this.getLocation().getY();
				int[] dd = new int[2];
				this.getBaseline(port, port);
				System.out.println(dd[1]+"dd1");
				System.out.println(dd[2]+"dd2");
				
				Rectangle rect = new Rectangle(this.getX(), this.getY(), 500,500);
//				Rectangle rect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
//				Rectangle rect = new Rectangle(500, 500);
				BufferedImage capImg = robot.createScreenCapture(rect);
				
//				this.paintAll(g);
				
				os = server.getOutputStream();
				bos = new BufferedOutputStream(os);
				ImageIO.write(capImg, "jpg", bos);
				os.close();
				System.out.println("�̹��� ���� �Ϸ�");
			} catch (AWTException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
	}
			
			// ĸ�������� �̸� ����Ʈ ��Ʈ������ ����. 
			
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
			
	// DrawCanvas Ŭ������ ����ȭ ����. �ֽô��� �̰��� �õ��ϴ� ���� ���� �ʾҴ�.
	/*
	 * 1. Graphics Ŭ������ ����ȭ �� �� ����.
	 * �׸��� stackoverflow�� ���� ������� GUI ������Ҹ� ����ȭ �� ������ȭ ���� �ʴ� ���� �����Ѵ�.
	 * 
	 * �׷��ٸ� �ذ� �����?
	 * 2. graphics �� ���� ȭ���� image�� �׷��� �� image�� �����ϴ� ��� (graphics�� ������)
	 * 3. toolkit api�� ĸ�� (������ �ȳ���)
	 * 4. ���� �����ڿ��� mouse dragged �̺�Ʈ �߻��� x, y ��ǥ�� ������ ������
	 * �������� �ٽ� ���� solver���� x, y��ǥ�� ���� Ŭ���̾�Ʈ���� �׸��� �ϴ� ���. (���ɸ鿡�� ������ ����)
	 */
// ------------------ ����ȭ ��� X --------------------------------------------------			
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
	public static void main(String[] args) {	//����
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
	
	
	
	
	
	
}
