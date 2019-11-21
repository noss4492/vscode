package myP;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimeIntervalService implements Runnable{ // ������ �������� ��Ȯ�� �ð谡 �ʿ��ؼ�...
	static int interval = 1;
	static boolean tSwFlag = false;
	@Override
	public void run() {
		System.out.println("boolean :" + tSwFlag);
		tSwFlag = !(tSwFlag);
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		service.scheduleAtFixedRate(this, 0, 1, TimeUnit.SECONDS);
	}
}
// 1
//		TimerTask tt = new TimerTask() {
//			public void run() {
//				System.out.println("YA");
//			}
//		};
//		Timer timer = new Timer();
//		long delay = 0;
//		long intevalPeriod = 1*100;
//		timer.scheduleAtFixedRate(tt, delay, intevalPeriod);
//2
//	static int interval = 1;
//	static boolean tSwFlag = false;
//	public static void main(String[] args) {
//		Runnable sesTimer = new Runnable() {
//			@Override
//			public void run() {
////				System.out.println("boolean :"+tSwFlag);
////				tSwFlag = !(tSwFlag);
//			}
//		};
//		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
//		service.scheduleAtFixedRate(sesTimer, 0, 1, TimeUnit.SECONDS);
