package makePainter24c____orix;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

class DrawCanvas extends Canvas { // Serialized Form X
	int x, y; // x, y값만 서버에 전달해서 사용하는 방법도 괜찮은듯.
	int colorFlag = 3;
	int r1=0, g1=0, b1=0;
	boolean sw=false;
	int cnt=0;

	Graphics g; // 기본적으로 그릴 때 쓰는 그래픽스 객체
	Image dbImage; // 더블 버퍼링 이미지
	Graphics dbg; // 더블버퍼그래픽스

	// Graphics 인자를 외부에서 받을 방법이 없으니까 내부의 메서드를 이용한다.
	// repaint에 의해 호출됨.
	// repaint가 update를 호출할 때 이 캔버스를 paint함
	public void update(Graphics g) {
		// 최초에는 이렇게 더블버퍼링 이미지(메모리에 담겨있을 이미지)를 초기화
		if (dbImage == null) {
			dbImage = createImage(this.getSize().width, this.getSize().height);
			dbg = dbImage.getGraphics(); // Creates a graphics context for drawing to an off-screen image.
			// dbImage : 메모리에서 이미지를 그리기 위해 (화면 밖의)dbImage를 준비
			// dbg : (화면 밖에서)그리기 위해서 필요한 off-screen drawing graphics 객체
			// context라는게 연속적인 것을 나타낸다고 알고 있는데 여기서의 graphics context(?)는 정확하게는 모르겠음
		}
		// 화면 밖에 있으니까 일단 내 위에 올라와있을 캔버스의 백그라운드 색을 가져와서 지정하고 (그냥 배경색은 복사하는 느낌으로)
		dbg.setColor(getForeground());
		myPaint(dbg); // dbg로 그리면 screen-off(그냥 메모리에) 그려질 것이다.
		// 이것을 다시 일반적인 g로 drawImage해서 더블 버퍼링 이미지(메모리에 그려놨던 것)를 다시 캔버스에 보이게 그려준다.
		// 메모리에 미리 그려둠으로써 실제 동작할때 끊겨서 보일 수 있는 부분을 보완한 방식이다.
		g.drawImage(dbImage, 0, 0, this);
	}

	public void myPaint(Graphics g) {
		if (colorFlag == 0) { // R
			g.setColor(Color.red);
		} else if (colorFlag == 1) { // G
			g.setColor(Color.green);
		} else if (colorFlag == 2) { // B
			g.setColor(Color.blue);
		} else if (colorFlag == 3) { // Bk
			g.setColor(Color.black);
		} else if (colorFlag == 4) { // 지우개 -> background color
			g.setColor(this.getBackground());
		} else if (colorFlag == 5) { // Y
			g.setColor(Color.yellow);
		} else if (colorFlag == 6) { // special
			g.setColor(new Color(149,54,255));
//			setSuperBrush();
		}
//		} else if (colorFlag == 7) { // AllClear
//			clearAll(g);
//		}
		for(int i = 0 ; i < 3;  i++)	// 야매이니 나중에 수정해서 사용하세요. -> 알고리즘 적용 하고 시포 ㅠ.ㅠ 시간이 없음
			g.fillOval(x - 5, y - 5, 10, 10);
	}
	// 막간 주저리주저리 생각
	// 0. Paint 메서드는 마우스로 그리면 화면에 그려지는 동작을 수행한다.
	// (mouse dragged or mouse click시) 호출되는 부분.
	// 인자로 Graphics g를 받게 되어있어서 호출 방식이 겉으로 드러나있지 않다.
	// 실제적으로는 repaint -> update-> myPaint 순서로 호출된다.

	// 1. 여기에 적용될 수 있는 보완책은 무궁무진해 보인다.
	// (움직임에 따른 물리적인 법칙들을 모두 적용 가능)
	// (움직임을 판별하여 부가적인 동작 보완이 가능)

	// 1-1. 선을 그렸을 때 이것이 선으로 그려진다고 보장할 수 있는가?
	// 아직 완벽하게 연결된 선이라고는 볼 수 없다.
	// 쓰레드로 잡아서 돌리지만 그래도 우선순위에 밀려 프로세스를 할당받지 못해 paint되는 시점에 그려지지 않을 가능성이 있다.
	// (좌표는 잡히지만 화면에 출력하는 부분에서 문제가 발생할 수도 있다.)
	// (Graphics라는 클래스에 대해서는 자세히 모르겠으나 동작이 그런듯 싶다. 별로 얘를 자세히 알고 싶지는 않다.)

	// 그래서 좌표를 찍을때 서로 어느정도 연속되어 있는지를 체크해보고 (이전시간과 지금시간에서의 좌표 차이값)
	// 연결성이 낮은 지점 사이에서 선이 끊길 가능성이 높다고 판단한다.
	// 이렇게 끊길것이라 예측되는 경우에서는
	// 이전 위치와 지금 위치를 (가속도에 비례하는 n)n등분하여 각각의 좌표 ArrayList에 추가한다.
	// (px + (px-nx)*(i/n), py + (py-ny)*(i/n)), ArrayList.add(끊긴 시점의 index, n등분된
	// 좌표(i)), i+1~n-1
	// 얼추 게임이 완성된다면 이를 적용하여 작성해보자.
	// (조금 이전 시점에서의 가속도만으로도 이 방법을 구현할 수 있을듯)

	// 너무 edge가 sharp한 경우를 판단하고 이를 보완해주게 부드럽게 만들기 (부드럽고 귀엽게 보이게)
	// 심하게 꺾이는 점이 생긴다면.
	// ex) 점 A0-A1-A2이 찍힌 모양이 ㄱ 처럼 그려진다 하면 A0와 A2가 이어져야 하고 A1이 취소(보완)되어야 한다.
	// 그려지고 있는 방향은 두 좌표간의 기울기로 볼 수 있을 것이다.
	// 이것도 위와 마찬가지로 그냥 n등분 해서 \ 모양으로 만들어도 되지만
	// 우리가 고정속도로 떨어지는 모양인 \, 가속도로 떨어지는 모양인 곡선을 생각해 볼 수 있겠다.
	// ㄱ의 A1 지점(edge)에서 멀 수록 점점 변하는 값이 작다면 이쁘고 뭉뚝하게 잡힐 것이다.
	// 시간이 남는다면? 시간이 안 남을듯

	// 화면 전체 지우기 기능(이라고 적어놨지만 canvas에 지정된 background색으로 전체크기 사각형으로 덮어그리기)
	public void clearAll(Graphics g) {
		x = -900; y = -500;
		dbg.setColor(getBackground());
		dbg.fillRect(0, 0, this.getSize().width, this.getSize().height);
		repaint();
	}

	public void callClearAll() {
		x = -900; y = -500;
		System.out.println("전체지우기 호출됨");
		clearAll(g);
	}

	public void callChangeColorR() {
		changeColorR(g);
	}

	public void callChangeColorG() {
		changeColorG(g);
	}

	public void callChangeColorB() {
		changeColorB(g);
	}

	public void callChangeColorY() {
		changeColorY(g);
	}

	public void callChangeColorW() {
		changeColorW(g);
	}

	public void callChangeColorBK() {
		changeColorBK(g);
	}

	public void setSuperBrush() {		// 불안정한 관계로 안씁니다. (정말 이쁘긴 한데 ㅠ.ㅠ)
		sw=false;
		colorFlag = 5;
		cnt = 0;
		g1=255; b1=255; r1=0;
		new Thread(() -> {
			while ( cnt<10000) { 	// max 100s
				cnt++;
				try {
					Thread.sleep(10);
					// Red -> Blue -> Red -> Blue Gradient
					// init r=0; g=0; b=255;
					// RGB(255,0,0) -> RGB(127, 0 127) -> RGB(0, 0, 100)
//					if(sw == false) {	
//						r1++;
//						if(r1==255)
//							sw=true;
//					}else {
//						r1--;
//						if(r1==0)
//							sw=false;
//					}
//					if(sw==false) {
//						b1--;
//						if(b1==255)
//							sw=true;
//					}else {
//						b1++;
//						if(b1==255)
//							sw=false;
//					}
					
					// 보라-파랑-하늘 그라디언트
					// init g1=255; b1=255; r1=0;
					if(sw == false) {	
						r1++;
						if(r1==255)
							sw=true;
					}else {
						r1--;
						if(r1==0)
							sw=false;
					}
					if(sw==false) {
						g1--;
						if(g1==255)
							sw=true;
					}else {
						g1++;
						if(g1==255)
							sw=false;
					}
					// All Random
//					r1 = (int) (Math.random() * 256);
//					g1 = (int) (Math.random() * 256);
//					b1 = (int) (Math.random() * 256);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	public void callChangeColorRGB() { // X
//		new Thread (() -> {
//			while(true) {
//				try {
//					Thread.sleep(100);
//					g.setColor(new Color((int) (Math.random()*256),255,255));
////					Thread.sleep(100);
////					colorFlag=0;	
////					Thread.sleep(100);
////					colorFlag=1;
////					Thread.sleep(100);
////					colorFlag=2;	
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}).start();
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

	public void changeColorW(Graphics g) {
		g.setColor(Color.white);
	}

	public void paintBucket() {
		// Convex Hull(Graham's scan)으로 폐곡선을 체크하여 폐곡선 내부를 칠해주는 기능을 생각
		// 머시써
	}

	public int getColorFlag() {
		return colorFlag;
	}

	public void setColorFlag(int colorFlag) {
		this.colorFlag = colorFlag;
	}
}
// 죽음의 코드 무덤
//		myPaint(g);
//		img_buffer = createImage(900, 500);
//		buffer = img_buffer.getGraphics();
//		buffer.fillOval( x - 5 , y - 5, 10 , 10 );
//		g.fillOval(img_buffer, 0, 0, this);
//		changeColorG(g);
//		g.fillOval(x - 5, y - 5, 10, 10);
//	public void mirrorPaint(ArrayList<Integer> x, ArrayList<Integer> y) { // x, y 리스트 받아서 그리기
//		System.out.println("mirrorPaint : 호출됨");
//		System.out.println("size x :" + x.size() + "size y :" + y.size());
//		for (int i = 0; i < x.size(); i++) {
//			System.out.println("그리는중 x : " + x.get(i) + "|그리는중 y : " + y.get(i));
//		}
//		for (int i = 0; i < x.size(); i++) {
//			g.fillOval(x.get(i) - 5, y.get(i) - 5, 10, 10);
//		}
//	}