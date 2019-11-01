package day16;

public class GenEx3 {
	float[] height;
	
	GenEx3(){
	}
	
	public float[] getHeight() {
		return height;
	}

	public void setHeight(float[] height) {
		this.height = height;
	}
	
	public void print() {
		for( float x : this.height )
			System.out.println(x);
	}
	
	public static void main(String[] args) {
		GenEx3 ge3 = new GenEx3();
		float[] height = { 187.3f, 172.3f, 162.5f, 199.9f };
		ge3.setHeight(height);
		ge3.print();
	}
}
