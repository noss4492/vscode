package sortAlgorithm;

public class SelectionSort extends UtilitesForSort {
	public static int[] sort(int[] arr){	// ÷�� �̷��� ������ �ϰ� �־��µ� index��ȯ�̶�� ���� ���� �򰥷Ⱦ���.
		long cnt = 0;									// ���� ���ͳݿ� �ִ� ���� ������� �ɷ��� ����...
		System.out.println("[ Selection Sort ]");
		printInit();
		printInitArr(arr);	
		//i���� ��� ���� �� j(i+1����) ������ ���ؼ� ��Һ��� �ּҰ��� ���� �迭�� �����Ͽ� �ű��.
		
		long start = getTimeStart();
		for(int i = 0; i < arr.length-1; i++) {	// �������� �ڵ����� ���ĵ�(�׽�Ʈ �� ����ȭ �� ��)
			int min = i;	// i select
			for(int j = i+1; j < arr.length; j++) {	// �ƱͰ� �� ���´����� �𸣰ڴ�. ����ȭ �� �غ� ��.
				if(arr[j]<arr[min]) {	//min���� �� ���� j �߰ߵǸ� min�� ����					
					min = j;		// search min arr[j]
					cnt++;
				}
			}
			arr = swap(arr, i, min);
			printSort(arr, i, min);
		}
		long end = getTimeEnd();
		
		System.out.printf("swaped  %8d times |\n",cnt);
		System.out.printf("Execution time : %.3f |\n\n", ( end - start )/1000.0);
		return arr;
	}
}
