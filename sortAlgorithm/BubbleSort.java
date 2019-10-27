package sortAlgorithm;

public class BubbleSort extends UtilitesForSort {
	// 생각 0-1 1-2 2-3 3-4 4-5 5-6 ... last-1 last   <<<<< 작은거 미는중
	//         1-2 2-3 3-4 4-5 5-6 ... last-1 last   <<<<< 한개는 고정됨 다시 밈
	// ...                             last-1 last   <<<<< 반복
	public static int[] sort(int[] arr) {
		long cnt = 0;
		System.out.println("[ Bubble Sort ]");
		printInit();
		printInitArr(arr);	
		long start = getTimeStart();
		// # 오름차순
		for(int i = arr.length-2; i>=0; i--) {
			for(int j = i; j <=arr.length-2; j++) {
				if(arr[j] > arr[j+1]) {
					swap(arr, j, j+1);
					printSort(arr, j, j+1);
					cnt++;
				}
			}
		}
		long end = getTimeEnd();
		//System.out.println("-------------------------");

		/*
		// # 내림차순
		for(int i = arr.length-2; i >= 0; i--) {		
			for(int j = 0; j <= i; j++) {	
				if(arr[j] < arr[j+1]) {	   
					swap(arr, j+1, j);		
					printSort(arr, j+1, j);
					cnt++;
				}
			}
		}*/
		System.out.printf("swaped  %8d times |\n",cnt);
		System.out.printf("Execution time : %.3f |\n\n", ( end - start )/1000.0);
		return arr;
	}
}
