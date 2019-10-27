package sortAlgorithm;

public class SelectionSort extends UtilitesForSort {
	public static int[] sort(int[] arr){	// 첨에 이렇게 생각은 하고 있었는데 index교환이라는 말에 조금 헷갈렸었다.
		long cnt = 0;									// 역시 인터넷에 있는 말은 어느정도 걸러서 들어야...
		System.out.println("[ Selection Sort ]");
		printInit();
		printInitArr(arr);	
		//i번재 요소 선택 후 j(i+1부터) 끝까지 비교해서 대소비교후 최소값을 지닌 배열을 선택하여 옮긴다.
		
		long start = getTimeStart();
		for(int i = 0; i < arr.length-1; i++) {	// 마지막은 자동으로 정렬됨(테스트 후 최적화 한 것)
			int min = i;	// i select
			for(int j = i+1; j < arr.length; j++) {	// 아귀가 잘 들어맞는지는 모르겠다. 최적화 더 해볼 것.
				if(arr[j]<arr[min]) {	//min보다 더 작은 j 발견되면 min을 갱신					
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
