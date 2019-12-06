package sortAlgorithm;

public class QuickSortEndPivot extends UtilitesForSort {
	private static long cnt = 0;	// ��Ͷ�.. �����Ǵ� �κп� cnt�� �־�� ����� ī��Ʈ ��
	private static long exeTime = 0;
	private static long rCnt = 0;
	
	public static int[] sort(int arr[], int l, int r) {
		//relaxing(arr, r);					// ��ó���� ���ָ� �� �������� ������? on/off
		
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
		if(rCnt == 0 && arr.length > 9) {	// �ѹ��� ����ǰ� �ƿ� ���ֹ��� �� ����? GCȸ�� �ȵ�..
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
 * ��ó���� �ϸ� ���?
�߰� ��
1011798 times 0.375s
1024318 times 0.374s
1062239 times 0.304s
1066301 times 0.338s
1004657 times 0.329s
�߰� ��
1192503 times 0.203s
988241  times 0.210s
928486  times 0.244s
1172476 times 0.315s
1073220 times 0.253s
 */





/*

�� ���� �����ϱⰡ �� �׷���
��..

n���� ������ ��Ƽ� ��հ��� ����� ���� ���� �迭�� ������ �迭(ó�� �Ǻ�����)�� ��ü�ϸ�
�־��� ��Ȳ�� �� �� ���� ����� �� ������������

0. �Ǻ��� ������� ����. ( �ֿ��� element�� �������� pivot )

1. ������ ������.
ó������ 0���� �ֿ���(1st pivot idx)����

1. a[j]�� ��� left���� right���� �˻�
a[j] �� 



i ������ ���������� ��ȯ�� ���� ������ �����ϱ� i+1 ������ pivot index�� ��������.
�׷��� i+1�� �Ǻ����� ���� ������ ��ü�Ͽ� i+1������ ���� �Ǻ� �������� ����. 

index i �� �Ǻ��� ���� ���� ������ ã�Ƽ� �ְ� 
i �տ��� �׷� ���鸸 �ִٴ� ���� �ǹ���

�۾��� ������

*/
