	package day16;

public class GenEx1 {
	int[] array;
	String name;
	
	
	
	public int[] getArray() {
		return array;
	}
	public void setArray(int[] array) {
		this.array = array;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void print() {
		// 배열 안에 모든 요소 출력하기
		for(int i = 0; i < this.array.length; i++) {
			System.out.println(this.array[i]);
		}
	}
//		for(int x : array)
//			System.out.println(x);
//		for(Object	 x : obj)
//			System.out.println(x);
		
	
//	public static void main(String[] args) {
//		GenEx1 ge1 = new GenEx1();
//		int[] m = { 10, 30, 50, 20 };
//		ge1.setArray(m);
//		ge1.print();
//		
//	}
}
