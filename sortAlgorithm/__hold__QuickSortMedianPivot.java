package sortAlgorithm;

public class __hold__QuickSortMedianPivot extends UtilitesForSort {
	// 재귀방식의 Median pivot 퀵소트
	// 함수 빠져나갔다가 다시 돌아와서 다시 실행되는 동작 지점이 많아서 해석 헷갈림
	private static long globalCnt = 0;
	
	public static int[] quickSort(int[] arr) {
		System.out.println("[ Quick Sort ]");
		printInit();
		printInitArr(arr);	
		long start = getTimeStart();
		qSortExecutor(arr, 0, arr.length-1);
		long end = getTimeEnd();
		System.out.printf("    swaped [%04d]times |\n",globalCnt);
		System.out.printf("Execution time : %.3f |\n", ( end - start )/1000.0);
		return arr;
	}
	
	public static void qSortExecutor(int[] arr, int front, int rear) {	//should be recursive method
		int pl = front;	// 용어가 안 맞을수도.. 수정요망 front->left, rear->right
		int pr = rear;
		int pivot = arr[(pl+pr)/2];	//중간(or중간-1)칸에 담긴 수 (아귀가 들어맞을까?)			
		
		// 재귀될 때 마다 출력하여 검색 영역 확인
		System.out.printf(" <pl:=%2d>  ~  <pr:=%2d> |{", front, rear);
		for(int i = front; i < rear; i++)
			System.out.printf("%3d ", arr[i]);
		System.out.printf("%3d }\n", arr[rear]);
		
		do {
			while(arr[pl] < pivot)	// pl 포인터 이동 a[pl] < x 면 pl은 우측으로 이동, a[pl]은 pivot보다 높은 값을 찾는다.
				pl++;
			// arr[pl]이 pivot지점보다 높은 값을 찾으면 탈출! pl은 이 지점에서 멈춰있다.
			while(arr[pr] > pivot)	// pr 포인터 이동 a[pr] > x면 pr은 좌측으로 이동, a[pr]은 pivot보다 낮은 값을 찾는다.
				pr--;
			// arr[pr]이 pivot지점보다 낮은 값을 찾으면 탈출! pr은 이 지점에서 멈춰있다.
			
			if(pl <= pr) {		// pl pr이 서로 교차되어야만 탈출, pl==pr의 경우에도 탈출 x하고 ++ --로 다음으로 넘김
				swap(arr, pl++, pr--);		// pl pr이 다른 경우, pr값과 pl값 (ex index 2(x보다 큰 수),3(작은수) -> 3(작),2(큰) 
				printSort(arr, pl-1, pr+1);	// 교환이 엄청 많이 일어나는구나
				globalCnt++;				// .. 나중에 다시 바꾸자
			}
			
		}while(pl <= pr);
		
		if(front < pr)
			qSortExecutor(arr, front, pr);
		if(pl < rear)
			qSortExecutor(arr, pl, rear);
	}
}
