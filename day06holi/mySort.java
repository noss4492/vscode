package day06holi;

public class mySort {
	
	final static int width = 10;		// 출력열 고정 상수 30000
	private static long start;
	private static long end;
	static int globalCnt = 0;
	
	/* ----------  simple method start ---------- */
	public static int[] randGen(int arr[]) {	// 0~100 사이의 랜덤한 수 배열 arr[15] 생성
		for(int i = 0; i < arr.length; i++)		
			arr[i] = (int)(Math.random()*100);
		return arr;
	}
	
	public static int randGen(int n) {	// hw1을 위한
		int num = (int)(Math.random()*n);	//0~100
		return num;
	}
	
	// 전체 배열 리턴 비효율적, 개선 방안 -> 두개이상 리턴 -> 방법 -> 리턴 타입 : 클래스/배열/해쉬맵..
	public static int[] swap(int[] arr, int i, int j){	// 자주 사용될 배열 element swap 기능을 메소드로 정의
		int tmp = 0;
		if(arr[i]>arr[j]) {
			tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;		
		}
		return arr;						
	}
	public static void timeStart() {
		start = System.currentTimeMillis();
	}
	
	public static void timeEnd() {
		end = System.currentTimeMillis();
	}
	/* ----------   simple method end  ---------- */

	/* ----------   sort method start  ---------- */
	// i 고정 후 j와 비교해가며 더 큰 값을 지닌 j와 교환, 이 방식이 가장 먼저 떠올랐음. (글쎄요..)
	public static int[] selectionSortCustom(int[] arr){	
		int cnt = 0;
		System.out.println("[ Selection Sort(Custom), 맨 첨에 생각난 것]");
		printInit();							// 기본 정보 확인 (index, 초기값)
		printInitArr(arr);	
		timeStart();							// 수행시간 체크
		for(int i = 0; i < arr.length; i++) {	// 어차피 O(n^2)
			for(int j = i+1; j < arr.length; j++) {
				if(arr[i]>arr[j]) {				// 앞에서부터 조금씩 갉아먹어가면서 정렬됨
					arr = swap(arr, i, j);		// 교환
					printSort(arr, i, j);		// 교환된 것 확인
					cnt++;						// 교환횟수 체크
				}
			}
		}
		timeEnd();
		System.out.printf("    swaped [%04d]times |\n",cnt);
		System.out.printf("Execution time : %.3f |\n", ( end - start )/1000.0);
		return arr;
	}
	
	public static int[] selectionSortOrigin(int[] arr){	// 첨에 이렇게 생각은 하고 있었는데 index교환이라는 말에 조금 헷갈렸었다.
		int cnt = 0;									// 역시 인터넷에 있는 말은 어느정도 걸러서 들어야...
		System.out.println("[ Selection Sort(Original) ]");
		printInit();
		printInitArr(arr);	
		//i번재 요소 선택 후 j(i+1부터) 끝까지 비교해서 대소비교후 최소값을 지닌 배열을 선택하여 옮긴다.
		timeStart();
		for(int i = 0; i < arr.length-1; i++) {	// 마지막은 자동으로 정렬됨(테스트 후 최적화 한 것)
			int min = i;	// i select
			for(int j = i+1; j < arr.length; j++) {	// 아귀가 잘 들어맞는지는 모르겠다. 최적화 더 해볼 것.
				if(arr[j]<arr[min]) {	//min보다 더 작은 j 발견되면 min을 갱신					
					min = j;		// search min arr[j]
				}
			}
			arr = swap(arr, i, min);
			printSort(arr, i, min);
			cnt++;
		}
		timeEnd();
		System.out.printf("    swaped [%04d]times |\n",cnt);
		System.out.printf("Execution time : %.3f |\n", ( end - start )/1000.0);
		return arr;
	}
	
	public static int[] insertionSort(int[] arr) {
		int cnt = 0;
		int tmp = 0;
		int j = 0;	
		//boolean flag_sw = false;
		System.out.println("[ Insertion Sort ]");
		printInit();
		printInitArr(arr);	
		timeStart();
		for(int i = 0; i < arr.length; i++) {	// 대상 빼놓고 기억했다가 이전 인덱스 배열들과 비교해보고 밀어서 빈자리에 넣기.
			j = i;
			tmp = arr[i];	// insert할 배열 한개 추출. 잠시 기억한다.
			
			while(j > 0 && tmp<arr[j-1]) {	//arr[j-1] > tmp (앞행이 기준행보다 크면 바꿔서 오름차순으로)
				arr[i] = arr[j]; // arr[j] = arr[j-1] same
				j--;	
			}
			arr[j] = tmp;	// 빈자리(실제로 비어있진 않음, 개념적으로만)에 넣는다. 
			
			if(!(i==0 && j==0))
				printSort(arr, i, j);

			cnt++;
		}
		timeEnd();
		System.out.printf("    swaped [%04d]times |\n",cnt);
		System.out.printf("Execution time : %.3f |\n", ( end - start )/1000.0);
		return arr;
	}
	// for(; j > 0 && tmp < arr[j-1]; j--)   // 가독성 안좋아서 삭제
	// for(; j>0; j--)             			 // 가독성 안좋아서 삭제
	//   if(tmp<arr[j-1])   
	// while문으로 쓰는게 오히려 더 나을듯
	
	
	
	// 생각 0-1 1-2 2-3 3-4 4-5 5-6 ... last-1 last   <<<<< 작은거 미는중
	//         1-2 2-3 3-4 4-5 5-6 ... last-1 last   <<<<< 한개는 고정됨 다시 밈
	// ...                             last-1 last   <<<<< 반복
	public static int[] bubbleSort(int[] arr) {
		int cnt = 0;
		System.out.println("[ Bubble Sort ]");
		printInit();
		printInitArr(arr);	
		timeStart();
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
		timeEnd();
		System.out.printf("    swaped [%04d]times |\n",cnt);
		System.out.printf("Execution time : %.3f |\n", ( end - start )/1000.0);
		return arr;
	}
	public static int[] mergeSort(int[] arr) {	//킹갓황 노이만
		int cnt = 0;
		System.out.println("[ Merge Sort ]");
		printInit();
		printInitArr(arr);	
		
		timeStart();
		timeEnd();
		System.out.printf("    swaped [%04d]times |\n",cnt);

		return arr;
	}
	
	// 재귀방식의 퀵소트, 작동 방식 추적 및 해석이 힘들당... ㅠ.ㅠ	
	public static class QuickSort{		//너무 길어서 클래스로 묶어놓고, 유틸리티성 static, 킹갓큇
		public static int[] quickSort(int[] arr) {
			globalCnt = 0;
			System.out.println("[ Quick Sort ]");
			printInit();
			printInitArr(arr);	
			timeStart();
			qSortExecutor(arr, 0, arr.length-1);
			timeEnd();
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
	
	// 비재귀방식으로 구현한 퀵소트 , 해석하기에 용이하다. 일단은 이걸로 알아두자.
	public static class QSortPrac{	// 끝을 피봇으로 잡고 시작하는 qSort
		public static int[] qSort(int arr[], int l, int r) {
			if(l<r) {
				System.out.printf("C. l:[%2d],r[%2d]\n",l,r);
				int p = partition(arr, l, r);	// pivot index
				System.out.printf("-------- L : %2d, R : %2d\n", l , r);
				System.out.printf("L ? R : %2d %1c %2d\n",
						l, (l>r)?'>':'<', r);
				
				System.out.printf("L. l:[%2d],r[%2d]\n",l,p-1);
				System.out.printf("R. l:[%2d],r[%2d]\n\n",p+1,r);
			
				arr = qSort(arr, l, p-1);
				arr = qSort(arr, p+1, r);
			}
			return arr;
		}
		static int partition(int arr[], int l, int r) {
			int pivot = arr[r];
			int i = l - 1;
			
			for(int j = l; j <= r-1; j++) {
				if(arr[j] <= pivot) {
					i++;
					arr = swap(arr, i, j);
				}
			}
			arr = swap(arr, i+1, r);
			return i+1;
		}
	}
	
	public class RadixSort{
	}
	
	public static int[] heapSort(int[] arr) {	// 마이웨이 멋있어..
		System.out.println("[ Heap Sort ]");
		return arr;
	}
	
	/* ----------    sort method end   ---------- */
	
	/* ----------  print method start  ---------- */
	public static void printSort(int[] arr, int i, int j) {
		int cnt = 0;
		System.out.printf("swaped a[%02d] <-> a[%02d] | ", i, j);
		for(int x : arr) {
			System.out.printf("%3d ", x);
			cnt++;
			if(cnt%width == 0)
				System.out.println();
		}
	}
	
	public static void printInit() {
		System.out.print("             Arr index | ");
		for(int i = 0; i < width; i++)
			System.out.printf("%3d ", i);
		System.out.println();
	}
	
	public static void printInitArr(int[] arr) {		// 초기 생성된 arr[15] 출력
		int cnt = 0;
		System.out.print("  Initialized Rand Arr | ");
		for(int x : arr) {						
			System.out.printf("%3d ", x);
			cnt++;
			if(cnt%width == 0)
				System.out.println();
		}
	}
	
	public static void printSortedArr(int[] arr) {		// 정렬된 배열 arr[15] 출력
		
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
	/* ----------  print method end  ---------- */
	
	public static void main(String[] args) {
		int[] arr = new int[width];	// 출력열 설정
		arr = randGen(arr);			// 임의의 수 배열 arr[width]
		
		int[][] arrCopy = new int[7][width];
		for(int i = 0; i < 7; i++)
			arrCopy[i] = arr.clone();	//그냥 arrCopy[i] = arr 쓰면 깊은 복사가 되버려서 쓰기 곤란해짐
		
		
		//arr = selectionSortCustom(arr);	// arr배열 정렬 실행
		//printSortedArr(arr);					// 정렬된 배열 출력
		
		/*
		arrCopy[0] = selectionSortOrigin(arrCopy[0]);	
		printSortedArr(arrCopy[0]);		
		arrCopy[1] = insertionSort(arrCopy[1]);	
		printSortedArr(arrCopy[1]);		
		arrCopy[2] = bubbleSort(arrCopy[2]);	
		printSortedArr(arrCopy[2]);	
		arrCopy[6] = selectionSortCustom(arrCopy[6]);	
		printSortedArr(arrCopy[6]);	
		*/	
		arrCopy[3] = QuickSort.quickSort(arrCopy[3]);
		printSortedArr(arrCopy[3]);
		arrCopy[4] = 
				QSortPrac.qSort(arrCopy[4], 0 , arrCopy[4].length-1);
		printSortedArr(arrCopy[4]);
		
		/*
		System.out.println("recursive median pivot quicksort");
		System.out.println("1st pivot index is started end index");
		*/
		
		/*
		int[] arrTest = {36,90,21,10,52,88,26,29,21,43};
		System.out.println("고정해놓고 TEST, 탐색범위까지 출력");
		arrTest = QuickSort.quickSort(arrTest);
		printSortedArr(arrTest);
		*/
		
//		arrCopy[4] = QSortPrac.qSort(arrCopy[4], 0, arrCopy[4].length);
//		printSortedArr(arrCopy[4]);	
		
		
		
	}
}




/* 기록. 저번주에 생각없이 작성한 소트
 * 
 * 동작방식 
 * i가 끝부터 오면서 / j가 0부터 i전까지 비교하여 
 * 만약 뒤에 있는 i가 앞에서 검색된 j보다 작다면 i가 제일 커질 수 있도록 계속 교환
 * 뒤에가 더 큰 값이 남도록 교환되는 방식
 * 
 * for( i = a.length-1; i>=0; i--){
 * 	for(int j = 0; j < i; j++){
 * 	 if(a[i]<a[j]){
 *    tmp = a[i];
 *    a[i] = a[j];
 *    a[j] = tmp;
 *    printSort(a);
 */   

/* 생각없이 작성한 소트, 삽입정렬 같으면서 동작 순서가 ㅂ
 * for(int i = 0; i < arr.length; i++) 
 *   { for(int j = i+1; j < arr.length; j++) {
 *     if(arr[i]>arr[j]) { // 이런식이면 할당이 너무 많이 일어남. 엄청난 시간 손해 발생중 
 *     arr = swap(arr, i, j); // 교환
 *     printSort(arr, i, j); // 교환된 것 확인 
 *     cnt++; // 교환횟수 체크 } } }
 */

//class forReturnTwoArr{			// 리턴시 여러개 인자값을 옮기기 위한 클래스(미사용)