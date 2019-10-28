package day12_my_immutable_chanining;


public class PetForChanining {
	private String name;
	private String eyeColor;
	private int hungryLevel;
	
	public PetForChanining setName(String name) {
		this.name = name;
		return this;
	}
	
	public PetForChanining setEyeColor(String eyeColor) {
		this.eyeColor = eyeColor;
		return this;
	}
}
