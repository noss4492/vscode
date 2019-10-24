package day09hw;

public class PDA extends Computer{ 
								// extends Computer, Phone 하고 싶지만 다중 상속이 안됨
	String PDAproductName;
	float displaySize; // ex 12.3
	float batteryCapacity;

	PDA(){
		super();	//기본적으로 생성됨, 생략가능 
		PDAproductName = "기입해주세요";	// 나중에 테이블에서 미입력값 검색할때를 위해서 걍 이렇게 초기값을 써둠, 만드는 사람 맴임
	}
	
	public PDA(String PDAproductName, String price) {
		this.PDAproductName = PDAproductName;
		this.setCpuName(price);
	}
	
	//켜기 끄기 인터넷 사용하기는 가져와이씀.
	//전화하기만 가져오면 됨.
	
	public void callPDA() {
		System.out.println("call by PDA");
	}
	
	// 가끔 발견되는 @Override는 왜 써놓는걸까? - 검색하고옴
	// 어노테이션이라고 함. 오타 방지용이라고 함 말 그대로 주석의 일종으로 메타데이터에 해당된다.
	// @Override 해봤는데 안되네 아 지금 매개변수를 넣어서 다른 메서드가 되어있잖아?
	// 오버라이드하는게 아니라 그냥 새로운 메서드가 만들어진거임.
	// 아마도 printInfo라는거 쓰려면 implements로 인터페이스를 같은걸 써서
	// 추상메서드로 printInfo를 사용해야겠지?
	// 추상메서드에서의 시그니쳐도 역시 마찬가지로 인자로 구별될 것인데
	// 오버라이드 할 필요는 딱히 없구나
	// 혼자 북치고 장구치고 있었음 .. 
	public void printInfo() {// 아마도 클래스의 참조값을 전달받아 오겠지?
		System.out.println("--- THIS PDA INFO ---");
		System.out.printf("cpuName, gpuName, motherboardName,FirmwareVersion\n");
		System.out.printf("%s,%s,%s,%s\n",getCpuName(), getGpuName(), 
						getMotherboardName(), getFirmwareVersion());
		System.out.printf("Flag power|internet %b|%b\n", isPowerFlag(), isInternetAccessFlag());
	}
	
	public void comOn() {
		if(this.isPowerFlag() == false) {
			this.setPowerFlag(true);	//flag switch 
		}
		else
			System.out.println(" 이미 전원이 커져 있어요");
	}
	public void comOff() {
		if(this.isPowerFlag() == true) {
			this.setPowerFlag(false);
		}
		else
			System.out.println(" 이미 전원이 꺼져 있어요");
	}
	// 실제 컴퓨터랑 동작이 다른 것 같아서 다시 원버튼으로 제작함.
	public void powerButton() {
		if(this.isPowerFlag()==true) {
			this.comOff();
			System.out.println("\n켜져있는 PDA의 버튼을 눌러서 꺼졌습니다.");
		}
		else {
			this.comOn();
			System.out.println("\n꺼져있는 PDA의 버튼을 눌러서 켜졌습니다.");
		}
	}
	
}
