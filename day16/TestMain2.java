package day16;

public class TestMain2 {
	public static void main(String[] args) {
		Integer[] arr1 = {20, 30, 10, 90, 80};
		GenEx<Integer> ge1 = new GenEx<Integer>();
		ge1.setArray(arr1);
		ge1.print();
		
		System.out.println("----------------------");
		String[] arr2 = {"�ٵϽ�", "�Ʒս�", "ȫ�ý�", "��ս�"};
		GenEx<String> ge2 = new GenEx<String>();
		ge2.setArray(arr2);
		ge2.print();
		
	}
}
