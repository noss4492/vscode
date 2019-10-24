package day09hw;
/*
 * Hw05. Computer ��ü�� �����Ҽ� �ִ� Ŭ������ �ۼ��ϼ��� 
	��� : �ѱ�(), ����()
	
Hw06. Computer ��ü�� ��ӹ޴� PDA Ŭ������ �ۼ��ϼ��� 

	PDA p = PDA();

	p.��ȭ�ϱ�();
	p.�����ϱ�();
	
 */
public class Computer extends Object{	// �׳� �����
	private String cpuName;
	private String gpuName;
	private String motherboardName;
	private String FirmwareVersion;
	private int memoryCapacity;
	private int cpuProcessorNum;
	private int cpuThreadNum;
	private int price;
	private float cpuOpeartionVoltage;
	private float cpuConsumePower;
	private float cpuMaxFrequency;
	private float cpuMinFrequency;
	private float cpuLimitVoltage;
	private double cpuOperationTime;
	private boolean powerFlag;
	//boolean ethernetFlag;
	private boolean internetAccessFlag;
	
	
	public Computer() {
		this.cpuName="�������ּ���";
		this.gpuName="�������ּ���";
		this.motherboardName = "�������ּ���";
		this.FirmwareVersion = "�������ּ���";
		this.powerFlag = false;
	}
	
	
	
	public void comOn() {
		if(this.powerFlag == false) {
			this.powerFlag = !(this.powerFlag);	//flag switch 
			System.out.println(" �������ϴ�.");
		}
		else
			System.out.println(" �̹� ������ Ŀ�� �־��");
	}
	public void comOff() {
		if(this.powerFlag == true) {
			System.out.println("�������ϴ�.");
			this.powerFlag = !(this.powerFlag);
		}
		else
			System.out.println(" �̹� ������ ���� �־��");
	}
	public void internetAccessOn() {
		if(this.internetAccessFlag == false) {
			this.internetAccessFlag = !(this.internetAccessFlag);
			System.out.println(" ���ͳ��� ����Ǿ����ϴ�.");
		}
		else
			System.out.println(" �̹� ���ͳ��� ����Ǿ� �ֽ��ϴ�.");
	}
	public void internetAccessOff() {
		if(this.internetAccessFlag == true) {
			this.internetAccessFlag = !(this.internetAccessFlag);
			System.out.println(" ���ͳ��� ������ �����Ͽ����ϴ�.");
		}
		else
			System.out.println(" �̹� ���ͳ��� ������ �ֽ��ϴ�.");
	}
	
	public void printInfo() {
		System.out.println("--- THIS COMPUTER INFO ---");
		System.out.printf("cpuName, gpuName, motherboardName,FirmwareVersion\n");
		System.out.printf("%s,%s,%s,%s\n",cpuName, gpuName, 
											motherboardName, FirmwareVersion);
		System.out.printf("Flag of power|internet\n\t%b|%b\n", powerFlag, internetAccessFlag);
	}

	
	/* 
	 * getter, setter is made by source generator 
	 * �ʹ� ������...
	 * Ư���� �߰� : private boolean type�� ��� getter�� �۸���� �ٸ���.
	 *                public datatype isParameterName(){return this.parameterName;} �̷������� ����
	 * */
	   
	public String getCpuName() {
		return cpuName;
	}



	public void setCpuName(String cpuName) {
		this.cpuName = cpuName;
	}



	public String getGpuName() {
		return gpuName;
	}



	public void setGpuName(String gpuName) {
		this.gpuName = gpuName;
	}



	public String getMotherboardName() {
		return motherboardName;
	}



	public void setMotherboardName(String motherboardName) {
		this.motherboardName = motherboardName;
	}



	public String getFirmwareVersion() {
		return FirmwareVersion;
	}



	public void setFirmwareVersion(String firmwareVersion) {
		FirmwareVersion = firmwareVersion;
	}



	public int getMemoryCapacity() {
		return memoryCapacity;
	}



	public void setMemoryCapacity(int memoryCapacity) {
		this.memoryCapacity = memoryCapacity;
	}



	public int getCpuProcessorNum() {
		return cpuProcessorNum;
	}



	public void setCpuProcessorNum(int cpuProcessorNum) {
		this.cpuProcessorNum = cpuProcessorNum;
	}



	public int getCpuThreadNum() {
		return cpuThreadNum;
	}



	public void setCpuThreadNum(int cpuThreadNum) {
		this.cpuThreadNum = cpuThreadNum;
	}



	public int getGpuCoreNum() {
		return price;
	}



	public void setGpuCoreNum(int gpuCoreNum) {
		this.price = gpuCoreNum;
	}



	public float getCpuOpeartionVoltage() {
		return cpuOpeartionVoltage;
	}



	public void setCpuOpeartionVoltage(float cpuOpeartionVoltage) {
		this.cpuOpeartionVoltage = cpuOpeartionVoltage;
	}



	public float getCpuConsumePower() {
		return cpuConsumePower;
	}



	public void setCpuConsumePower(float cpuConsumePower) {
		this.cpuConsumePower = cpuConsumePower;
	}



	public float getCpuMaxFrequency() {
		return cpuMaxFrequency;
	}



	public void setCpuMaxFrequency(float cpuMaxFrequency) {
		this.cpuMaxFrequency = cpuMaxFrequency;
	}



	public float getCpuMinFrequency() {
		return cpuMinFrequency;
	}



	public void setCpuMinFrequency(float cpuMinFrequency) {
		this.cpuMinFrequency = cpuMinFrequency;
	}



	public float getCpuLimitVoltage() {
		return cpuLimitVoltage;
	}



	public void setCpuLimitVoltage(float cpuLimitVoltage) {
		this.cpuLimitVoltage = cpuLimitVoltage;
	}



	public double getCpuOperationTime() {
		return cpuOperationTime;
	}



	public void setCpuOperationTime(double cpuOperationTime) {
		this.cpuOperationTime = cpuOperationTime;
	}



	public boolean isPowerFlag() {
		return powerFlag;
	}



	public void setPowerFlag(boolean powerFlag) {
		this.powerFlag = powerFlag;
	}



	public boolean isInternetAccessFlag() {
		return internetAccessFlag;
	}



	public void setInternetAccessFlag(boolean internetAccessFlag) {
		this.internetAccessFlag = internetAccessFlag;
	}
	

}
