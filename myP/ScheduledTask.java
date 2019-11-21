//package myP;
//class ScheduledTask extends TimerTask {	
//	private static int count = 0;
//	private long sleepTime;
//	private String taskId;
//	private SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");
//
//	@Override
//	public void run(){
//		Date startTime = new Date();
//		Date SchdulingForRunningTime = new Date(super.scheduledExecutionTime()); 
//		String currentThreadName = Thread.currentThread().getName();
//		System.out.println("#### <" + currentThreadName +"," + taskId 
//				+ " > Scheduled to run at "
//				+ dateFormatter.format(SchdulingForRunningTime) 
//				+ ", Actually started at "
//				+ dateFormatter.format(startTime) 
//				+ "####");
//
//		for(int i = 0; i<5; i++) {
//			try {
//				TimeUnit.MICROSECONDS.sleep(sleepTime);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//
//		System.out.println("#### <" + currentThreadName + "," + taskId  
//				+ " >Finished at "
//				+ dateFormatter.format(new Date()) 
//				+ "####");
//	}
//	
//
//	public ScheduledTask(long sleepTime) {
//		this.sleepTime = sleepTime;
//		this.taskId = "ScheduledTask-" + count++;
//	}
//}