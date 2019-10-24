package day06holi;

public class mySort {
	
	final static int width = 10;		// ��¿� ���� ��� 30000
	private static long start;
	private static long end;
	static int globalCnt = 0;
	
	/* ----------  simple method start ---------- */
	public static int[] randGen(int arr[]) {	// 0~100 ������ ������ �� �迭 arr[15] ����
		for(int i = 0; i < arr.length; i++)		
			arr[i] = (int)(Math.random()*100);
		return arr;
	}
	
	public static int randGen(int n) {	// hw1�� ����
		int num = (int)(Math.random()*n);	//0~100
		return num;
	}
	
	// ��ü �迭 ���� ��ȿ����, ���� ��� -> �ΰ��̻� ���� -> ��� -> ���� Ÿ�� : Ŭ����/�迭/�ؽ���..
	public static int[] swap(int[] arr, int i, int j){	// ���� ���� �迭 element swap ����� �޼ҵ�� ����
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
	// i ���� �� j�� ���ذ��� �� ū ���� ���� j�� ��ȯ, �� ����� ���� ���� ���ö���. (�۽��..)
	public static int[] selectionSortCustom(int[] arr){	
		int cnt = 0;
		System.out.println("[ Selection Sort(Custom), �� ÷�� ������ ��]");
		printInit();							// �⺻ ���� Ȯ�� (index, �ʱⰪ)
		printInitArr(arr);	
		timeStart();							// ����ð� üũ
		for(int i = 0; i < arr.length; i++) {	// ������ O(n^2)
			for(int j = i+1; j < arr.length; j++) {
				if(arr[i]>arr[j]) {				// �տ������� ���ݾ� ���ƸԾ�鼭 ���ĵ�
					arr = swap(arr, i, j);		// ��ȯ
					printSort(arr, i, j);		// ��ȯ�� �� Ȯ��
					cnt++;						// ��ȯȽ�� üũ
				}
			}
		}
		timeEnd();
		System.out.printf("    swaped [%04d]times |\n",cnt);
		System.out.printf("Execution time : %.3f |\n", ( end - start )/1000.0);
		return arr;
	}
	
	public static int[] selectionSortOrigin(int[] arr){	// ÷�� �̷��� ������ �ϰ� �־��µ� index��ȯ�̶�� ���� ���� �򰥷Ⱦ���.
		int cnt = 0;									// ���� ���ͳݿ� �ִ� ���� ������� �ɷ��� ����...
		System.out.println("[ Selection Sort(Original) ]");
		printInit();
		printInitArr(arr);	
		//i���� ��� ���� �� j(i+1����) ������ ���ؼ� ��Һ��� �ּҰ��� ���� �迭�� �����Ͽ� �ű��.
		timeStart();
		for(int i = 0; i < arr.length-1; i++) {	// �������� �ڵ����� ���ĵ�(�׽�Ʈ �� ����ȭ �� ��)
			int min = i;	// i select
			for(int j = i+1; j < arr.length; j++) {	// �ƱͰ� �� ���´����� �𸣰ڴ�. ����ȭ �� �غ� ��.
				if(arr[j]<arr[min]) {	//min���� �� ���� j �߰ߵǸ� min�� ����					
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
		for(int i = 0; i < arr.length; i++) {	// ��� ������ ����ߴٰ� ���� �ε��� �迭��� ���غ��� �о ���ڸ��� �ֱ�.
			j = i;
			tmp = arr[i];	// insert�� �迭 �Ѱ� ����. ��� ����Ѵ�.
			
			while(j > 0 && tmp<arr[j-1]) {	//arr[j-1] > tmp (������ �����ຸ�� ũ�� �ٲ㼭 ������������)
				arr[i] = arr[j]; // arr[j] = arr[j-1] same
				j--;	
			}
			arr[j] = tmp;	// ���ڸ�(������ ������� ����, ���������θ�)�� �ִ´�. 
			
			if(!(i==0 && j==0))
				printSort(arr, i, j);

			cnt++;
		}
		timeEnd();
		System.out.printf("    swaped [%04d]times |\n",cnt);
		System.out.printf("Execution time : %.3f |\n", ( end - start )/1000.0);
		return arr;
	}
	// for(; j > 0 && tmp < arr[j-1]; j--)   // ������ �����Ƽ� ����
	// for(; j>0; j--)             			 // ������ �����Ƽ� ����
	//   if(tmp<arr[j-1])   
	// while������ ���°� ������ �� ������
	
	
	
	// ���� 0-1 1-2 2-3 3-4 4-5 5-6 ... last-1 last   <<<<< ������ �̴���
	//         1-2 2-3 3-4 4-5 5-6 ... last-1 last   <<<<< �Ѱ��� ������ �ٽ� ��
	// ...                             last-1 last   <<<<< �ݺ�
	public static int[] bubbleSort(int[] arr) {
		int cnt = 0;
		System.out.println("[ Bubble Sort ]");
		printInit();
		printInitArr(arr);	
		timeStart();
		// # ��������
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
		// # ��������
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
	public static int[] mergeSort(int[] arr) {	//ŷ��Ȳ ���̸�
		int cnt = 0;
		System.out.println("[ Merge Sort ]");
		printInit();
		printInitArr(arr);	
		
		timeStart();
		timeEnd();
		System.out.printf("    swaped [%04d]times |\n",cnt);

		return arr;
	}
	
	// ��͹���� ����Ʈ, �۵� ��� ���� �� �ؼ��� �����... ��.��	
	public static class QuickSort{		//�ʹ� �� Ŭ������ �������, ��ƿ��Ƽ�� static, ŷ��ţ
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
			int pl = front;	// �� �� ��������.. ������� front->left, rear->right
			int pr = rear;
			int pivot = arr[(pl+pr)/2];	//�߰�(or�߰�-1)ĭ�� ��� �� (�ƱͰ� ��������?)			
			
			// ��͵� �� ���� ����Ͽ� �˻� ���� Ȯ��
			System.out.printf(" <pl:=%2d>  ~  <pr:=%2d> |{", front, rear);
			for(int i = front; i < rear; i++)
				System.out.printf("%3d ", arr[i]);
			System.out.printf("%3d }\n", arr[rear]);
			
			do {
				while(arr[pl] < pivot)	// pl ������ �̵� a[pl] < x �� pl�� �������� �̵�, a[pl]�� pivot���� ���� ���� ã�´�.
					pl++;
				// arr[pl]�� pivot�������� ���� ���� ã���� Ż��! pl�� �� �������� �����ִ�.
				while(arr[pr] > pivot)	// pr ������ �̵� a[pr] > x�� pr�� �������� �̵�, a[pr]�� pivot���� ���� ���� ã�´�.
					pr--;
				// arr[pr]�� pivot�������� ���� ���� ã���� Ż��! pr�� �� �������� �����ִ�.
	
				if(pl <= pr) {		// pl pr�� ���� �����Ǿ�߸� Ż��, pl==pr�� ��쿡�� Ż�� x�ϰ� ++ --�� �������� �ѱ�
					swap(arr, pl++, pr--);		// pl pr�� �ٸ� ���, pr���� pl�� (ex index 2(x���� ū ��),3(������) -> 3(��),2(ū) 
					printSort(arr, pl-1, pr+1);	// ��ȯ�� ��û ���� �Ͼ�±���
					globalCnt++;				// .. ���߿� �ٽ� �ٲ���
					}
				
				}while(pl <= pr);
			
			if(front < pr)
				qSortExecutor(arr, front, pr);
			if(pl < rear)
				qSortExecutor(arr, pl, rear);
		}
	}
	
	// ����͹������ ������ ����Ʈ , �ؼ��ϱ⿡ �����ϴ�. �ϴ��� �̰ɷ� �˾Ƶ���.
	public static class QSortPrac{	// ���� �Ǻ����� ��� �����ϴ� qSort
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
	
	public static int[] heapSort(int[] arr) {	// ���̿��� ���־�..
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
	
	public static void printInitArr(int[] arr) {		// �ʱ� ������ arr[15] ���
		int cnt = 0;
		System.out.print("  Initialized Rand Arr | ");
		for(int x : arr) {						
			System.out.printf("%3d ", x);
			cnt++;
			if(cnt%width == 0)
				System.out.println();
		}
	}
	
	public static void printSortedArr(int[] arr) {		// ���ĵ� �迭 arr[15] ���
		
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
		int[] arr = new int[width];	// ��¿� ����
		arr = randGen(arr);			// ������ �� �迭 arr[width]
		
		int[][] arrCopy = new int[7][width];
		for(int i = 0; i < 7; i++)
			arrCopy[i] = arr.clone();	//�׳� arrCopy[i] = arr ���� ���� ���簡 �ǹ����� ���� �������
		
		
		//arr = selectionSortCustom(arr);	// arr�迭 ���� ����
		//printSortedArr(arr);					// ���ĵ� �迭 ���
		
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
		System.out.println("�����س��� TEST, Ž���������� ���");
		arrTest = QuickSort.quickSort(arrTest);
		printSortedArr(arrTest);
		*/
		
//		arrCopy[4] = QSortPrac.qSort(arrCopy[4], 0, arrCopy[4].length);
//		printSortedArr(arrCopy[4]);	
		
		
		
	}
}




/* ���. �����ֿ� �������� �ۼ��� ��Ʈ
 * 
 * ���۹�� 
 * i�� ������ ���鼭 / j�� 0���� i������ ���Ͽ� 
 * ���� �ڿ� �ִ� i�� �տ��� �˻��� j���� �۴ٸ� i�� ���� Ŀ�� �� �ֵ��� ��� ��ȯ
 * �ڿ��� �� ū ���� ������ ��ȯ�Ǵ� ���
 * 
 * for( i = a.length-1; i>=0; i--){
 * 	for(int j = 0; j < i; j++){
 * 	 if(a[i]<a[j]){
 *    tmp = a[i];
 *    a[i] = a[j];
 *    a[j] = tmp;
 *    printSort(a);
 */   

/* �������� �ۼ��� ��Ʈ, �������� �����鼭 ���� ������ ��
 * for(int i = 0; i < arr.length; i++) 
 *   { for(int j = i+1; j < arr.length; j++) {
 *     if(arr[i]>arr[j]) { // �̷����̸� �Ҵ��� �ʹ� ���� �Ͼ. ��û�� �ð� ���� �߻��� 
 *     arr = swap(arr, i, j); // ��ȯ
 *     printSort(arr, i, j); // ��ȯ�� �� Ȯ�� 
 *     cnt++; // ��ȯȽ�� üũ } } }
 */

//class forReturnTwoArr{			// ���Ͻ� ������ ���ڰ��� �ű�� ���� Ŭ����(�̻��)