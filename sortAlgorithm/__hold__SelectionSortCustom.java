package sortAlgorithm;

public class __hold__SelectionSortCustom extends UtilitesForSort{
	__hold__SelectionSortCustom(){
	}
	// i 고정 후 j와 비교해가며 더 큰 값을 지닌 j와 교환, 이 방식이 가장 먼저 떠올랐음. (글쎄요..)
	public static int[] sort(int[] arr){	
		long cnt = 0;
		System.out.println("[ Selection Sort(Custom), 맨 첨에 생각난 것]");
		printInit();							// 기본 정보 확인 (index, 초기값)
		printInitArr(arr);	
		
		long start = getTimeStart();							// 수행시간 체크
		for(int i = 0; i < arr.length; i++) {	// 어차피 O(n^2)
			for(int j = i+1; j < arr.length; j++) {
				if(arr[i]>arr[j]) {				// 앞에서부터 조금씩 갉아먹어가면서 정렬됨
					arr = swap(arr, i, j);		// 교환
					printSort(arr, i, j);		// 교환된 것 확인
					cnt++;						// 교환횟수 체크
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
