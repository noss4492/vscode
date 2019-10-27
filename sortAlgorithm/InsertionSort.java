package sortAlgorithm;

public class InsertionSort extends UtilitesForSort {
	public static int[] sort(int[] arr) {
		long cnt = 0;
		int tmp = 0;
		int j = 0;	
		System.out.println("[ Insertion Sort ]");
		printInit();
		printInitArr(arr);	
		
		long start = getTimeStart();
		for(int i = 0; i < arr.length; i++) {	// ��� ������ ����ߴٰ� ���� �ε��� �迭��� ���غ��� �о ���ڸ��� �ֱ�.
			j = i;
			tmp = arr[i];	// insert�� �迭 �Ѱ� ����. ��� ����Ѵ�.

			while(j > 0 && tmp<arr[j-1]) {	//arr[j-1] > tmp (������ �����ຸ�� ũ�� �ٲ㼭 ������������)
				arr[i] = arr[j]; // arr[j] = arr[j-1] same
				j--;	
				cnt++;
			}
			arr[j] = tmp;	// ���ڸ�(������ ������� ����, ���������θ�)�� �ִ´�. 

			if(!(i==0 && j==0))
				printSort(arr, i, j);

		}
		long end = getTimeEnd();
		System.out.printf("swaped  %8d times |\n",cnt);
		System.out.printf("Execution time : %.3f |\n\n", ( end - start )/1000.0);
		return arr;
	}
}

//for(; j > 0 && tmp < arr[j-1]; j--)   // ������ �����Ƽ� ����
	// for(; j>0; j--)             			 // ������ �����Ƽ� ����
	//   if(tmp<arr[j-1])   
	// while������ ���°� ������ �� ������
