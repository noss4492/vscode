package makePainter21_backup_load;

public class __CHUThread__X extends Thread {
	boolean inGameFlagPrev;
	boolean inGameFlag;
	boolean swCheckFlag;
	int svrTimerTime;
	int setTimerEndTime;
	boolean resultFlag;
	
	public __CHUThread__X(boolean inGameFlagPrev, boolean inGameFlag, boolean swCheckFlag, int svrTimerTime,
			int setTimerEndTime) {
		super();
		this.inGameFlagPrev = inGameFlagPrev;
		this.inGameFlag = inGameFlag;
		this.swCheckFlag = swCheckFlag;
		this.svrTimerTime = svrTimerTime;
		this.setTimerEndTime = setTimerEndTime;

	}

	@Override
	public void run() {
		while(true) {
		if(swCheckFlag == true && inGameFlag == true) {
			System.out.println("게임이 끝났구나");
			resultFlag = false;
//			th.join();
//			MServerbroadcastUserInfo();
//			broadcastDisplayInfo();
			resultFlag = true;
		} else if(swCheckFlag == true && inGameFlag == false) {
			System.out.println("게임이 시작됐구나");
//		broadcastWantInfo();
		}
		}
	}
}
