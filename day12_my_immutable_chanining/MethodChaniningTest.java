package day12_my_immutable_chanining;



public class MethodChaniningTest {
	
	
	public static void main(String[] args) {
		PetForChanining p1 = new PetForChanining();
		p1.setName("PoPPi");
		p1.setEyeColor("blue");

		
		p1.setName("totti")
		  .setEyeColor("black");
	}
	
}
