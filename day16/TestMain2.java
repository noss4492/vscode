package day16;

public class TestMain2 {
	public static void main(String[] args) {
		Integer[] arr1 = {20, 30, 10, 90, 80};
		GenEx<Integer> ge1 = new GenEx<Integer>();
		ge1.setArray(arr1);
		ge1.print();
		
		System.out.println("----------------------");
		String[] arr2 = {"¹ÙµÏ½º", "¾Æ·Õ½º", "È«½Ã½º", "Àç·Õ½º"};
		GenEx<String> ge2 = new GenEx<String>();
		ge2.setArray(arr2);
		ge2.print();
		
	}
}
