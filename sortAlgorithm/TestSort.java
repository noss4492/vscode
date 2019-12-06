package sortAlgorithm;

public class TestSort {
	static{	
	}
	// �� �̰� �ƴϾ�.. ������ �̻��ѵ�... ����� �� �غ��� �� �� ����
	TestSort(){
	}
	public static void main(String[] args) {
		
		final int width = 100000;						// �׽�Ʈ �迭 ���� ����.
		UserUtility u = new UserUtility(width);
		UtilitesForSort.setViewFlag(false);			// ������� ���� �ɼ�
		
		int[] arr = u.randGenArr(width, 1, 1000);	// width������ arr�迭, a���� b������ ����
		
		int[][] arrCopy = new int[7][width];
		for(int i = 0; i < 7; i++)
			arrCopy[i] = arr.clone();	//�׳� arrCopy[i] = arr ���� ���� ����(���� �������� ����Ŵ)�� �ǹ����� ���� �����
		
		// ���� �� 4���� �ٵ����. 
		// (���� : args[0]:arr, Args[1]:left, Args[2]:right)
		arrCopy[0] = SelectionSort.sort(arrCopy[0]);		
		arrCopy[1] = InsertionSort.sort(arrCopy[1]);			// �ְ��� ' 3'... ����?
		arrCopy[2] = BubbleSort.sort(arrCopy[2]);			
																// ��͹� ������ ������ ���⼭?
		
		QuickSortEndPivot.printTotal(arrCopy[3], 0, arrCopy[3].length-1);
//		System.out.println("[ Quick Sort ]");
//		arrCopy[3] = QuickSortEndPivot.sort(arrCopy[3], 0, arrCopy[3].length-1);
//		System.out.printf("swaped  %8d times |\n", QuickSortEndPivot.getCnt());
//		System.out.printf("Execution time : %.3f |\n\n", QuickSortEndPivot.getExeTime()/1000.0);
		
	}
}

	// �����ؾ��� ��
	// ���ڰ��� ���� �޼ҵ� ���� ���� -> ��� ��ĥ �����... ��... ÷���� int[]�� �����ϸ� �ȵ����� ���� �������� ������...
	// �̰� ���ڰ� ������ �������� ���·� ���� �� �ִ� Generic�� �ִ��� �̰� �� �� �Ἥ...
	// radix�� ��� ���ٴ�... MSD ������ �;��µ� ������ �� ���� �غ��� ������ �غ��߰���
	
	// ��ü �迭 ���� ��ȿ����, ���� ��� -> �ΰ��̻� ���� -> ��� -> ���� Ÿ�� : Ŭ����/�迭/�ؽ���.. (X)
	// ����Ʈ ����ϸ鼭 ����� �������... �ʹ� �ҿ�����... �������?
