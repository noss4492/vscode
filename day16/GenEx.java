package day16;
	
//모든 자료형에 대해서 처리
//아직 자료형을 결정하지 않은 미완성 자료형으로 선언
//아직 결정 못했어 타입 -> 클래스 만들때 지정해주는듯


// 추론된, 추상화된 데이터 타입 ( 일반화된 데이터 타입 ), 재사용성 up



public class GenEx<T> {
	T[] array;
	String name;
	
	
	
	public T[] getArray() {
		return array;
	}
	public void setArray(T[] array) {
		this.array = array;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void print() {
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
