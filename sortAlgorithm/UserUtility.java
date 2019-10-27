package sortAlgorithm;

public class UserUtility {
	private static int width;		// 출력열 고정 상수 30000
	
	UserUtility(){
	}
	UserUtility(int width){
		this.width = width;
	}
	
	public int randGen(int n) {					// num := (0 ≤ num < n)
		int num = (int)(Math.random()*n);
		return num;
	}
	
	public int randGen(int a, int b) {			// num := ( a ≤ num < b)
		int num = (int)(Math.random()*(b-a) + a);		// 0~b / 0~(b-a) / 0~(b-a) +a / 0
		return num;
	}
	
	public int[] randGenArr(int len, int n) {	// 0 ~ n-1 사이의 랜덤한 수 배열 arr[] 생성
		int[] arr = new int[len];
		for(int i = 0; i < len; i++)		
			arr[i] = randGen(n);
		return arr;
	}
	
	public int[] randGenArr(int len, int a, int b) {	// a ~ b-1 사이의 랜덤한 수 배열 arr[] 생성
		int[] arr = new int[len];
		for(int i = 0; i < len; i++)		
			arr[i] = randGen(a, b);
		return arr;
	}
	
	public static int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
}
