package day01;


//?κΈΈλ?? 20?΄?΄λ©? ?€κ°? 182.3???€.
public class VarEx2 {
	public static void main(String[] args) {
		int i = 20;
		float h = 182.3f;
		
		System.out.println("?κΈΈλ?¨ "+i+"?΄?΄λ©? ?€?"+h+"???€.");
		System.out.printf("?κΈΈλ?¨? %d?΄?΄λ©? ?€κ°? %.1f???€.", i, h);
		
		float f1 = 3.14159251f;
		float f2 = 1.193948241f;
		System.out.printf("%.22f",f1*f2);
		System.out.println("?€μ°¨λ 0.00000001321006191?? "); // float? ??«?  6~7 ?λ¦? κΉμ?? λ³΄μ₯?¨.
	}


}
