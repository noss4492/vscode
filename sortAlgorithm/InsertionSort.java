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
		for(int i = 0; i < arr.length; i++) {	// 대상 빼놓고 기억했다가 이전 인덱스 배열들과 비교해보고 밀어서 빈자리에 넣기.
			j = i;
			tmp = arr[i];	// insert할 배열 한개 추출. 잠시 기억한다.

			while(j > 0 && tmp<arr[j-1]) {	//arr[j-1] > tmp (앞행이 기준행보다 크면 바꿔서 오름차순으로)
				arr[i] = arr[j]; // arr[j] = arr[j-1] same
				j--;	
				cnt++;
			}
			arr[j] = tmp;	// 빈자리(실제로 비어있진 않음, 개념적으로만)에 넣는다. 

			if(!(i==0 && j==0))
				printSort(arr, i, j);

		}
		long end = getTimeEnd();
		System.out.printf("swaped  %8d times |\n",cnt);
		System.out.printf("Execution time : %.3f |\n\n", ( end - start )/1000.0);
		return arr;
	}
}

//for(; j > 0 && tmp < arr[j-1]; j--)   // 가독성 안좋아서 삭제
	// for(; j>0; j--)             			 // 가독성 안좋아서 삭제
	//   if(tmp<arr[j-1])   
	// while문으로 쓰는게 오히려 더 나을듯
