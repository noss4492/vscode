package day09hw;
/*
 * Hw05. Computer 객체를 생성할수 있는 클래스를 작성하세요 
	기능 : 켜기(), 끄기()
	
Hw06. Computer 객체를 상속받는 PDA 클래스를 작성하세요 

	PDA p = PDA();

	p.전화하기();
	p.연결하기();
	
 */
public class Computer extends Object{	// 그냥 써봤음
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
		this.cpuName="기입해주세요";
		this.gpuName="기입해주세요";
		this.motherboardName = "기입해주세요";
		this.FirmwareVersion = "기입해주세요";
		this.powerFlag = false;
	}
	
	
	
	public void comOn() {
		if(this.powerFlag == false) {
			this.powerFlag = !(this.powerFlag);	//flag switch 
			System.out.println(" 켜졌습니다.");
		}
		else
			System.out.println(" 이미 전원이 커져 있어요");
	}
	public void comOff() {
		if(this.powerFlag == true) {
			System.out.println("꺼졌습니다.");
			this.powerFlag = !(this.powerFlag);
		}
		else
			System.out.println(" 이미 전원이 꺼져 있어요");
	}
	public void internetAccessOn() {
		if(this.internetAccessFlag == false) {
			this.internetAccessFlag = !(this.internetAccessFlag);
			System.out.println(" 인터넷이 연결되었습니다.");
		}
		else
			System.out.println(" 이미 인터넷이 연결되어 있습니다.");
	}
	public void internetAccessOff() {
		if(this.internetAccessFlag == true) {
			this.internetAccessFlag = !(this.internetAccessFlag);
			System.out.println(" 인터넷이 연결을 해제하였습니다.");
		}
		else
			System.out.println(" 이미 인터넷이 끊어져 있습니다.");
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
	 * 너무 귀찮아...
	 * 특이점 발견 : private boolean type의 경우 getter의 작명법이 다르다.
	 *                public datatype isParameterName(){return this.parameterName;} 이런식으로 쓰임
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
