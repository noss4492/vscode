package day01;


//?��길동?? 20?��?���? ?���? 182.3?��?��?��.
public class VarEx2 {
	public static void main(String[] args) {
		int i = 20;
		float h = 182.3f;
		
		System.out.println("?��길동?�� "+i+"?��?���? ?��?��"+h+"?��?��?��.");
		System.out.printf("?��길동?��?�� %d?��?���? ?���? %.1f?��?��?��.", i, h);
		
		float f1 = 3.14159251f;
		float f2 = 1.193948241f;
		System.out.printf("%.22f",f1*f2);
		System.out.println("?��차는 0.00000001321006191?? "); // float?�� ?��?��?�� 6~7 ?���? 까�??�� 보장?��.
	}


}
