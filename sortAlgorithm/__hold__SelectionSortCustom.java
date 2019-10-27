package sortAlgorithm;

public class __hold__SelectionSortCustom extends UtilitesForSort{
	__hold__SelectionSortCustom(){
	}
	// i ���� �� j�� ���ذ��� �� ū ���� ���� j�� ��ȯ, �� ����� ���� ���� ���ö���. (�۽��..)
	public static int[] sort(int[] arr){	
		long cnt = 0;
		System.out.println("[ Selection Sort(Custom), �� ÷�� ������ ��]");
		printInit();							// �⺻ ���� Ȯ�� (index, �ʱⰪ)
		printInitArr(arr);	
		
		long start = getTimeStart();							// ����ð� üũ
		for(int i = 0; i < arr.length; i++) {	// ������ O(n^2)
			for(int j = i+1; j < arr.length; j++) {
				if(arr[i]>arr[j]) {				// �տ������� ���ݾ� ���ƸԾ�鼭 ���ĵ�
					arr = swap(arr, i, j);		// ��ȯ
					printSort(arr, i, j);		// ��ȯ�� �� Ȯ��
					cnt++;						// ��ȯȽ�� üũ
				}
			}
		}
		long end = getTimeEnd();
		
		System.out.printf("    swaped [%04d]times |\n",cnt);
		System.out.printf("Execution time : %.3f |\n", ( end - start )/1000.0);
		printSortedArr(arr);
		return arr;
	}
	
	
	
	
}
