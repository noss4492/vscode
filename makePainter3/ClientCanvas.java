package makePainter3;

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
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

// 아마 한 패널에 채팅창과 이 페인터를 붙여서 쓴다고 생각해보면 얘도 쓰레드로 구성되어야 할 것이다.
// 근데 일단 패널을 주고 받는 기능을 구현한다면
// 이 패널을 주고 받는 애를 쓰레드로 만들면 될 것이다.

public class ClientCanvas extends JFrame implements MouseMotionListener, MouseListener, Serializable { // runnable
	DrawCanvas drawCanvas; // 내부 중첩 클래스로 할 필요는 없지만
	JPanel mirrorPane;	// 삭제됨
	Socket server;
	String ip = "192.168.0.49";
	int port = 5000;
	JFrame frame;
//	Container c;
//	BufferedWriter bw;
	int cnt = 0;
	ArrayList<Integer> strokePointArrX, strokePointArrY;
	

	public ClientCanvas() {
		strokePointArrX = new ArrayList<Integer>();
		strokePointArrY = new ArrayList<Integer>();
		setLayout(null);
		setResizable (false);
		drawCanvas = new DrawCanvas();
		
		drawCanvas.setBounds(0, 0, 500, 500); // 그림판 크기
		drawCanvas.setBackground(Color.GRAY); // 일단 배경색 이걸로 해둠(구분을 위해)
		add(drawCanvas);
//		mirrorPane.add(drawCanvas); 					  // 그림판 캔버스 생성함
		
		drawCanvas.addMouseMotionListener(this); // mouse dragged시 위치 감지를 위해
		drawCanvas.addMouseListener(this);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		setSize(500, 500);	// this frame size
		setVisible(true);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
		drawCanvas.x = e.getX();
		drawCanvas.y = e.getY();
		strokePointArrX.add(e.getX());
		strokePointArrY.add(e.getY());
		System.out.println("X, Y"+e.getX()+"|"+e.getY());
		System.out.println("x추가중 "+strokePointArrX);
		System.out.println("y추가중 "+strokePointArrY);
		drawCanvas.repaint();
		
		
		// 가속도로 예측점 찍는 기능...추가? (그냥 가속도로 하면 내가 원하지 않는 부분에 찍힐 수 있음.)
		// 이전 단계의 가속도로 이전 선이 연속되지 않았는지를 판별하는 알고리즘이 필요함
		// 가속도가 너무 크면 선이 연속되지 않았다고 보고 이전에 움직인 지점들을 연결해주는 방법이 필요함.
		// 크기 100개정도 되는 큐에 가속도를 구하는 방식으로 만들어야할 듯. 시간 많이 걸릴 듯 하니 나중에 함
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		drawCanvas.x = e.getX();
		drawCanvas.y = e.getY();
		strokePointArrX.add(e.getX());
		strokePointArrY.add(e.getY());
		System.out.println("X, Y"+e.getX()+"|"+e.getY());
		System.out.println("x추가중 "+strokePointArrX);
		System.out.println("y추가중 "+strokePointArrY);
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
		try {
			server = new Socket(ip, port);
			System.out.println("try streamout. 지금 갑니다~");
			System.out.println("연결대상:"+server.getInetAddress().getHostAddress()+"|포트:"+server.getPort());
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
//		System.out.println("---------------------");
//		for(int i = 0; i<strokePointArrX.size(); i++)
//			System.out.println(strokePointArrX.get(i));
//		System.out.println("---------------------");
		
		BufferedOutputStream bos;
		ObjectOutputStream oos;
		OutputStream os;
		try {
			os = server.getOutputStream();
			bos = new BufferedOutputStream(os);
			oos = new ObjectOutputStream(bos);
			BoxedStrokePoint pp = new BoxedStrokePoint(strokePointArrX, strokePointArrX);
			oos.writeObject(pp);
			oos.flush();
			System.out.println("PP"+pp);
			System.out.println("ppppppppppppppppppppppppppp");
			strokePointArrX.clear();
			strokePointArrY.clear();
			
			
			
			
//			ArrayList<INTEGER>
//			mirrorPane.add(drawCanvas);
//			PaintPacket pp = new PaintPacket(mirrorPane);
//			oos.writeObject(pp);
//			oos.writeObject((Frame)this);
//			oos.flush();
			
			// 시도 로그.
			// ObjectOutputStream Obj, Pane, JPanel, Frame ...
			// JPanel을 랩핑해서 만든 PaintPacket 클래스로도 직렬화 안됨
			// ByteArrayStream으로 byte단위로 보내는 것 -> 역직렬화시 곤란함
			// FileOutputStream 안됨
			// DataOutputStream 안됨
			// serialversionUID 
			// Image로 전송은 많이 불안전함
			// Pane으로 보낼 수 있나 했는데 안됨

//			os.close();
//			oos.close();
//			bos.close();
//			oos.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}
	public static void main(String[] args) { // 메인
		ClientCanvas s1 = new ClientCanvas();
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
//결론. awt클래스의 직렬화 문제 애시당초 이것을 시도하는 것이 옳지 않았다.
// 구조적 또는 내부 변경이 자주 일어날 경우 직렬화를 추천하지 않음.
/*
 * 1. Graphics 클래스는 직렬화 할 수 없다. 그리고 stackoverflow의 많은 사람들이 GUI 구성요소를 직렬화 및 역직렬화
 * 하지 않는 것을 권장한다.
 * 
 * 그렇다면 해결 방법은? 2. graphics 로 현재 화면의 image를 그려서 이 image를 전송하는 방법 (graphics에 없을듯)
 * 3. toolkit api로 캡쳐 (간지가 안난다) 4. 퀴즈 출제자에서 mouse dragged 이벤트 발생시 x, y 좌표를 서버에
 * 보내서 서버에서 다시 퀴즈 solver에게 x, y좌표를 보내 클라이언트에서 그리게 하는 방법. (성능면에서 이점이 많음)
 */
/*
 * 
직렬-역직렬화시 SerialversionUID는 자동으로 생성되고 매칭되기도 하지만 수동으로 설정하는 것을 추천함.
1. 직렬화가 불가능한 경우
   1) 직렬화가 불가능한 객체를 포함한 경우
   2) 하위 클래스는 직렬화를 구현했지만 상위 클래스에서는 직렬화가 구현되지 않은 상태에서 
       상위 클래스의 생성자에 매개변수가 있는 경우

2. 대표적으로 직렬화 불가능한 클래스들
   1) 이벤트 어댑터
   2) 이미지 필터
   3) AWT 클래스
   4) beans
   5) Socket
   6) URLConnection

3. 상속구조에서 직렬화할 수 없는 상황
    (엄밀하게 말하면 직렬화는 가능하지만 역직렬화가 불가능한 상태)
   1) 상위 클래스의 생성자에 매개변수가 있는 생성자만 존재
   2) 상위 클래스는 Serializable을 구현하지 않은 상태
   3) 하위 클래스는 상위 클래스를 상속받은 뒤 Serializable을 구현한 상태

 */
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
