package sortAlgorithm;

public class TestSort {
	static{	
	}
	// 몬가 이게 아니야.. 구조가 이상한듯... 고민을 좀 해봐야 할 것 같음
	TestSort(){
	}
	public static void main(String[] args) {
		
		final int width = 100000;						// 테스트 배열 길이 설정.
		UserUtility u = new UserUtility(width);
		UtilitesForSort.setViewFlag(false);			// 진행과정 보기 옵션
		
		int[] arr = u.randGenArr(width, 1, 1000);	// width길이의 arr배열, a부터 b까지의 정수
		
		int[][] arrCopy = new int[7][width];
		for(int i = 0; i < 7; i++)
			arrCopy[i] = arr.clone();	//그냥 arrCopy[i] = arr 쓰면 깊은 복사(동일 참조값을 가르킴)가 되버려서 쓰기 곤란함
		
		// 아직 이 4개만 다듬어짐. 
		// (인자 : args[0]:arr, Args[1]:left, Args[2]:right)
		arrCopy[0] = SelectionSort.sort(arrCopy[0]);		
		arrCopy[1] = InsertionSort.sort(arrCopy[1]);			// 최고성능 ' 3'... 왜죠?
		arrCopy[2] = BubbleSort.sort(arrCopy[2]);			
																// 재귀문 쓰레드 약점이 여기서?
		
		QuickSortEndPivot.printTotal(arrCopy[3], 0, arrCopy[3].length-1);
//		System.out.println("[ Quick Sort ]");
//		arrCopy[3] = QuickSortEndPivot.sort(arrCopy[3], 0, arrCopy[3].length-1);
//		System.out.printf("swaped  %8d times |\n", QuickSortEndPivot.getCnt());
//		System.out.printf("Execution time : %.3f |\n\n", QuickSortEndPivot.getExeTime()/1000.0);
		
	}
}

	// 수정해야할 점
	// 인자값이 많은 메소드 보기 싫음 -> 어떻게 고칠 방법이... 흠... 첨부터 int[]로 리턴하면 안됐을거 같은 느낌적인 느낌이...
	// 이거 인자값 받을때 여러가지 형태로 받을 수 있는 Generic이 있던데 이걸 좀 잘 써서...
	// radix는 어림도 없겟다... MSD 만들어보고 싶었는데 머지랑 힙 먼저 해보고 버켓을 해봐야겠음
	
	// 전체 배열 리턴 비효율적, 개선 방안 -> 두개이상 리턴 -> 방법 -> 리턴 타입 : 클래스/배열/해쉬맵.. (X)
	// 퀵소트 재귀하면서 생기는 쓰레드들... 너무 불완전함... 개선방법?
