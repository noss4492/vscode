package day16;
	
//��� �ڷ����� ���ؼ� ó��
//���� �ڷ����� �������� ���� �̿ϼ� �ڷ������� ����
//���� ���� ���߾� Ÿ�� -> Ŭ���� ���鶧 �������ִµ�


// �߷е�, �߻�ȭ�� ������ Ÿ�� ( �Ϲ�ȭ�� ������ Ÿ�� ), ���뼺 up



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
