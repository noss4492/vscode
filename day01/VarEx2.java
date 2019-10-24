package day01;


//?™ê¸¸ë™?? 20?‚´?´ë©? ?‚¤ê°? 182.3?…?‹ˆ?‹¤.
public class VarEx2 {
	public static void main(String[] args) {
		int i = 20;
		float h = 182.3f;
		
		System.out.println("?™ê¸¸ë™?”¨ "+i+"?‚´?´ë©? ?‚¤?Š”"+h+"?…?‹ˆ?‹¤.");
		System.out.printf("?™ê¸¸ë™?”¨?Š” %d?‚´?´ë©? ?‚¤ê°? %.1f?…?‹ˆ?‹¤.", i, h);
		
		float f1 = 3.14159251f;
		float f2 = 1.193948241f;
		System.out.printf("%.22f",f1*f2);
		System.out.println("?˜¤ì°¨ëŠ” 0.00000001321006191?? "); // float?Š” ?†Œ?ˆ«?  6~7 ?ë¦? ê¹Œì??Š” ë³´ì¥?•¨.
	}


}
