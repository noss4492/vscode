package day11_3;

import day10_2.Marine;

public class TestMain4 {
	public static void main(String[] args) {
		SmartPhone sp1 = new SmartPhone(
				"redriceNote", "Â÷ÀÌ³ª¿ä", "01012345678", "á³Ú·");
		SmartPhone sp2 = new SmartPhone(
				"zarcX", "Â÷ÀÌ³ª¿ä", "01098765432", "Hwaway");

		System.out.println(sp1.pCompany);
		System.out.println(sp2.pCompany);
		
		
		Marine m = new Marine();
		System.out.println(sp1 instanceof SmartPhone);
		System.out.println(m instanceof Marine);
		
		
		sp1.pCompany = "LG";
		
		System.out.println(sp1.pCompany);
		System.out.println(sp2.pCompany);
		
	}
}
