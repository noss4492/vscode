package sortAlgorithm;

public class __hold__QuickSortMedianPivot extends UtilitesForSort {
	// ��͹���� Median pivot ����Ʈ
	// �Լ� ���������ٰ� �ٽ� ���ƿͼ� �ٽ� ����Ǵ� ���� ������ ���Ƽ� �ؼ� �򰥸�
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
