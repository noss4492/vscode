package sortAlgorithm;

public class QuickSortEndPivot extends UtilitesForSort {
	private static long cnt = 0;	// 재귀라서.. 공유되는 부분에 cnt가 있어야 제대로 카운트 됨
	private static long exeTime = 0;
	private static long rCnt = 0;
	
	public static int[] sort(int arr[], int l, int r) {
		//relaxing(arr, r);					// 전처리를 해주면 좀 좋아지지 않을까? on/off
		
		long start = getTimeStart();
		if(l<r) {
			int p = partition(arr, l, r);	// pivot index
			
			arr = sort(arr, l, p-1);
			arr = sort(arr, p+1, r);
		}
		long end = getTimeEnd();
		exeTime += (end - start);
		return arr;
	}
	
	static int partition(int arr[], int l, int r) {
		int pivot = arr[r];
		int i = l - 1;
		
		for(int j = l; j <= r-1; j++) {
			if(arr[j] <= pivot) {
				i++;
				arr = swap(arr, i, j);
				printSort(arr, j, j+1);
				setCnt(getCnt() + 1);
			}
		}
		arr = swap(arr, i+1, r);
		return i+1;
	}
	
	static void relaxing(int[] arr, int r) {
		if(rCnt == 0 && arr.length > 9) {	// 한번만 실행되고 아예 없애버릴 순 없나? GC회수 안됨..
			int[] relaxer = new int[10];
			int sum = 0;
			for(int i = 0; i < 10; i++) {
				relaxer[i] = arr[(int)(Math.random()*(arr.length))];	//1~2
				for(int j = 0; j < i; j++)
					if(arr[i] == arr[j])
						i--;
				sum += relaxer[i];
			}
			
			int minGap = relaxer[0];
			int minGapIdx = 0;
			for(int i = 0; i < 10; i++) {
				int gap = Math.abs(relaxer[i]-sum/10);
				if(minGap > gap) {
					minGap = gap;
					minGapIdx = i;
				}
			}
			swap(arr, minGapIdx, r);
		}
		rCnt++;
	}
	
	public static void printTotal(int arr[], int l, int r) {
		System.out.println("[ Quick Sort ]");
		sort(arr, l, r);
		System.out.printf("swaped  %8d times |\n",getCnt());
		System.out.printf("Execution time : %.3f |\n\n", exeTime/1000.0);
	}

	public static long getCnt() {
		return cnt;
	}

	public static void setCnt(long cnt) {
		QuickSortEndPivot.cnt = cnt;
	}
}

/*
 * 전처리를 하면 어떨까?
추가 전
1011798 times 0.375s
1024318 times 0.374s
1062239 times 0.304s
1066301 times 0.338s
1004657 times 0.329s
추가 후
1192503 times 0.203s
988241  times 0.210s
928486  times 0.244s
1172476 times 0.315s
1073220 times 0.253s
 */





/*

몬가 말로 설명하기가 좀 그러네
흠..

n개의 지점을 잡아서 평균값에 가까운 값을 지닌 배열과 마지막 배열(처음 피봇기준)을 교체하면
최악의 상황을 좀 더 많이 모면할 수 있지않을까함

0. 피봇값 선정방식 설정. ( 최우측 element을 기준으로 pivot )

1. 범위를 설정함.
처음에는 0부터 최우측(1st pivot idx)까지

1. a[j]가 모든 left부터 right까지 검사
a[j] 가 



i 지점이 마지막으로 교환된 값을 가지고 있으니까 i+1 지점이 pivot index를 가져야함.
그래서 i+1과 피봇값을 지닌 지점과 교체하여 i+1지점을 다음 피봇 기준으로 선정. 

index i 는 피봇값 보다 작은 값들을 찾아서 넣고 
i 앞에는 그런 값들만 있다는 것을 의미함

작업이 끝나면

*/
