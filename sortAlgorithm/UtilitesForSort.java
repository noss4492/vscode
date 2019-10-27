package sortAlgorithm;

public abstract class UtilitesForSort {

	private long start;
	private long end;
	private static int width = UserUtility.getWidth();
	static boolean viewFlag=false;
	
	UtilitesForSort(){
	}
	UtilitesForSort(int width){
		this.width = width;
	}
	UtilitesForSort(int width, boolean viewFlag){
		this.width = width;
		this.viewFlag = viewFlag;
	}
	
	
	// �� �޼������ ������� ���� ���� ��ü���� ������ �ʿ䰡 ���� ������ static���� �����Ͽ���.
	

	
	public static int[] swap(int[] arr, int i, int j){	// �迭 ������ element swap
		int tmp = 0;
		if(arr[i]>arr[j]) {
			tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;		
		}
		return arr;						
	}
	
	public static long getTimeStart() {
		return System.currentTimeMillis();
	}

	public static long getTimeEnd() {
		return System.currentTimeMillis();
	}
	
	
	/* print method start */
	
	public static void printSort(int[] arr, int i, int j) {
		if(viewFlag==true) {	// avoidance, if print flag is off 
			int cnt = 0;
			System.out.printf("swaped a[%02d] <-> a[%02d] | ", i, j);
			for(int x : arr) {
				System.out.printf("%3d ", x);
				cnt++;
				if(cnt%width == 0)
					System.out.println();
			}
		}
	}

	public static void printInit() {
//		System.out.print("             Arr index | ");
//		for(int i = 0; i < width; i++)
//			System.out.printf("%3d ", i);
//		System.out.println();
	}

	public static void printInitArr(int[] arr) {		// �ʱ� ������ arr[] ���
//		int cnt = 0;
//		System.out.print("  Initialized Rand Arr | ");
//		for(int x : arr) {						
//			System.out.printf("%3d ", x);
//			cnt++;
//			if(cnt%width == 0)
//				System.out.println();
//		}
	}

	public static void printSortedArr(int[] arr) {		// ���ĵ� �迭 arr[] ���

		int cnt = 0;
		System.out.print("    finally sorted Arr | ");
		for(int x : arr) {						
			System.out.printf("%3d ", x);
			cnt++;
			if(cnt%width == 0)
				System.out.println();
		}
		System.out.println("\n");
	}
	
	public static boolean isViewFlag() {
		return viewFlag;
	}
	
	public static void setViewFlag(boolean viewFlag) {
		UtilitesForSort.viewFlag = viewFlag;
	}
	
	
	
	
}
