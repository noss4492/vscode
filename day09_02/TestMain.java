package day09_02;

public class TestMain {
	private static void printbarss() {
		System.out.println("-----------------");
	}
	public static void main(String[] args) {
		//Human tmp = new Human();
		//Human h1 = new Human("IU", 26, "여", "010-xxxx-xxxx");
		//h1.eating();
		//h1.breathing();
		//h1.talking();
		//System.out.println("상태 출력");
		//System.out.println("--------------");
		
		Human iu1 = new Human("IU", 26, "여", "010-xxxx-xxxx");
		printbarss(); 
		Human iu2 = new Human("IU", "가수", "여");
		printbarss();
		iu1.status();
		printbarss();
		iu2.status();
		printbarss();
	}

}
