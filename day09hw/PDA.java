package day09hw;

public class PDA extends Computer{ 
								// extends Computer, Phone �ϰ� ������ ���� ����� �ȵ�
	String PDAproductName;
	float displaySize; // ex 12.3
	float batteryCapacity;

	PDA(){
		super();	//�⺻������ ������, �������� 
		PDAproductName = "�������ּ���";	// ���߿� ���̺��� ���Է°� �˻��Ҷ��� ���ؼ� �� �̷��� �ʱⰪ�� ���, ����� ��� ����
	}
	
	public PDA(String PDAproductName, String price) {
		this.PDAproductName = PDAproductName;
		this.setCpuName(price);
	}
	
	//�ѱ� ���� ���ͳ� ����ϱ�� �������̾�.
	//��ȭ�ϱ⸸ �������� ��.
	
	public void callPDA() {
		System.out.println("call by PDA");
	}
	
	// ���� �߰ߵǴ� @Override�� �� ����°ɱ�? - �˻��ϰ��
	// ������̼��̶�� ��. ��Ÿ �������̶�� �� �� �״�� �ּ��� �������� ��Ÿ�����Ϳ� �ش�ȴ�.
	// @Override �غôµ� �ȵǳ� �� ���� �Ű������� �־ �ٸ� �޼��尡 �Ǿ����ݾ�?
	// �������̵��ϴ°� �ƴ϶� �׳� ���ο� �޼��尡 �����������.
	// �Ƹ��� printInfo��°� ������ implements�� �������̽��� ������ �Ἥ
	// �߻�޼���� printInfo�� ����ؾ߰���?
	// �߻�޼��忡���� �ñ״��ĵ� ���� ���������� ���ڷ� ������ ���ε�
	// �������̵� �� �ʿ�� ���� ������
	// ȥ�� ��ġ�� �屸ġ�� �־��� .. 
	public void printInfo() {// �Ƹ��� Ŭ������ �������� ���޹޾� ������?
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
			System.out.println(" �̹� ������ Ŀ�� �־��");
	}
	public void comOff() {
		if(this.isPowerFlag() == true) {
			this.setPowerFlag(false);
		}
		else
			System.out.println(" �̹� ������ ���� �־��");
	}
	// ���� ��ǻ�Ͷ� ������ �ٸ� �� ���Ƽ� �ٽ� ����ư���� ������.
	public void powerButton() {
		if(this.isPowerFlag()==true) {
			this.comOff();
			System.out.println("\n�����ִ� PDA�� ��ư�� ������ �������ϴ�.");
		}
		else {
			this.comOn();
			System.out.println("\n�����ִ� PDA�� ��ư�� ������ �������ϴ�.");
		}
	}
	
}
