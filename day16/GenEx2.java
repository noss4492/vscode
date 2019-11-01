package day16;

public class GenEx2 {
	String[] array;

	public String[] getArray() {
		return array;
	}

	public void setArray(String[] array) {
		this.array = array;
	}
	
	public void print() {
		for(String x : array)
			System.out.println(x);
	}
	
	public static void main(String[] args) {
		GenEx2 ge2 = new GenEx2();
		String[] str = {"¹ÙµÏÀÌ", "¾Æ·ÕÀÌ", "È«¾¾", "Àç·ÕÀÌ"};
		ge2.setArray(str);
		ge2.print();
		
	}
}
