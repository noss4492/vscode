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

// 아마 한 패널에 채팅창과 이 페인터를 붙여서 쓴다고 생각해보면 얘도 쓰레드로 구성되어야 할 것이다.
// 근데 일단 패널을 주고 받는 기능을 구현한다면
// 이 패널을 주고 받는 애를 쓰레드로 만들면 될 것이다.

public class CreateDrawCanvas extends JFrame implements MouseMotionListener, MouseListener, Serializable { // runnable
	DrawCanvas drawCanvas; // 내부 중첩 클래스로 할 필요는 없지만
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
		
		drawCanvas.setBounds(0, 0, 500, 500); // 그림판 크기
		drawCanvas.setBackground(Color.GRAY); // 일단 배경색 이걸로 해둠(구분을 위해)
		add(drawCanvas);
//		mirrorPane.add(drawCanvas); 					  // 그림판 캔버스 생성함
		
		drawCanvas.addMouseMotionListener(this); // mouse dragged시 위치 감지를 위해
		drawCanvas.addMouseListener(this);
		mirrorPane.addMouseMotionListener(this); // mouse dragged시 위치 감지를 위해
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
		// 가속도로 예측점 찍는 기능...추가? (그냥 가속도로 하면 내가 원하지 않는 부분에 찍힐 수 있음.)
		// 이전 단계의 가속도로 이전 선이 연속되지 않았는지를 판별하는 알고리즘이 필요함
		// 가속도가 너무 크면 선이 연속되지 않았다고 보고 이전에 움직인 지점들을 연결해주는 방법이 필요함.
		// 크기 100개정도 되는 큐에 가속도를 구하는 방식으로 만들어야할 듯. 시간 많이 걸릴 듯 하니 나중에 함
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		drawCanvas.x = e.getX();
		drawCanvas.y = e.getY();
		drawCanvas.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// 여기는 드래그시 체크 안되는 상태임.
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
		// mirrorPane.add(drawCanvas); 이걸 가져가면 될 듯?
		// 아니면 drawCanvas를 가져가면될듯?
		// oos.writer

//		Container conn = drawCanvas;	// 얘를 가져가면 되나? 아냐 
		// 그래 이걸로 옮겨보자 drawCanvas
		try {
			System.out.println("try streamout. 지금 보내요~");
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
			
			// 시도 로그.
			// ObjectOutputStream Obj, Pane, JPanel, Frame ...
			// JPanel을 랩핑해서 만든 PaintPacket 클래스로도 직렬화 안됨
			// ByteArrayStream으로 byte단위로 보내는 것 -> 역직렬화시 곤란함
			// FileOutputStream 안됨
			// DataOutputStream 안됨
			// serial UID ? 뭐 문제도 있다고 하고...
			// Image로 전송은 많이 불안전함
			// Pane으로 보낼 수 있나 했는데 안됨

			os.close();
			oos.close();
			bos.close();
			oos.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}
	public static void main(String[] args) { // 메인
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
		int x, y; // x, y값만 서버에 전달해서 사용하는 방법도 괜찮은듯.

		Graphics g;
		
		// Graphics 인자를 외부에서 받을 방법이 없으니까 내부의 메서드를 이용한다.
		// repaint에 의해 호출됨.
		// repaint가 update를 호출할 때 이 캔버스를 paint함
		public void update(Graphics g) {
			myPaint(g);
		}

		// 점의 연속으로 표현함. 이를 선으로 잇는 알고리즘은 추후에
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
//			os.close(); // 이건 완전 종료시로 하자.

	// DrawCanvas 클래스의 직렬화 문제. 애시당초 이것을 시도하는 것이 옳지 않았다.
	/*
	 * 1. Graphics 클래스는 직렬화 할 수 없다. 그리고 stackoverflow의 많은 사람들이 GUI 구성요소를 직렬화 및 역직렬화
	 * 하지 않는 것을 권장한다.
	 * 
	 * 그렇다면 해결 방법은? 2. graphics 로 현재 화면의 image를 그려서 이 image를 전송하는 방법 (graphics에 없을듯)
	 * 3. toolkit api로 캡쳐 (간지가 안난다) 4. 퀴즈 출제자에서 mouse dragged 이벤트 발생시 x, y 좌표를 서버에
	 * 보내서 서버에서 다시 퀴즈 solver에게 x, y좌표를 보내 클라이언트에서 그리게 하는 방법. (성능면에서 이점이 많음)
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
// - 현재 화면을 캡쳐 후 (바이트스트림으로 전송) -
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
//				System.out.println("이미지 전송 완료");
//			} catch (AWTException e1) {
//				e1.printStackTrace();
//			} catch (IOException e1) {
//				e1.printStackTrace();
//			}
//	}
// ------------------------------------------------------------------------------------

	// 캡쳐 후 이를 바이트 스트림으로 전송.

//			long size = Instrumentation.getObjectSize(capImage);
//			ObjectSizeFetcher.getObjectSize(capImage);

//			long size = iis.length();
//			byte[] imageBytes = new byte[(int)size];
//			int imgByteSize = imgBytes.length

	// new Rectangle(int width, int height)로 사용하면 됨.
//				Rectangle rect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
//				Dimension area = Toolkit.getDefaultToolkit().getScreenSize();
//				Rectangle rect = new Rectangle(area);

	// 바이트스트림으로 Outputstream에 쌓기

// ------------------ 직렬화 사용  --------------------------------------------------			
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
//			oos.close();	// 이건 완전 종료시로 하자. 
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
//		System.out.println("이때 전송해!!");
//		try {
//			server = new Socket(ip, port);	// 퀴즈 내는 사람 -> 서버 ==> 유저1,2,3
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
//	public void VClient() {	// 그냥 클라이언트 여러개 만드려고 사용 //엎어
//		Thread th = new Thread(this);
//		th.start();
//	}
//	

//	@Override
//	public void run() {	//지속적으로 서버 소켓에 오브젝트를 뿌려줘야함 // 아냐 쓰레드 필요 없을듯
//		try {
//			server = new Socket(ip, port);	// 서버에서 받아서 다시 유저들(solver)에게 뿌려줄 예정임
//			
//			// 소켓에 계속 output stream을 쌓고 있음. (주관적인 의견)
//			BufferedOutputStream bos = new BufferedOutputStream(server.getOutputStream());
//			ObjectOutputStream oos = new ObjectOutputStream(bos);
//			
//			//받을때는 br = new 
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
