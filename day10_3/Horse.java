package day10_3;

import day11.Flyable;

public class Horse extends Mammal implements Flyable{	//Flyable 상속 받고 싶음 -> 어케? -> 보완책
	int footgoop;
	
	public Horse(){
		super();
	}
	
	@Override
	public void eatting() {
		System.out.println("당근머겅");
	}
	public void running() {
		System.out.println("다구닥 다구닥");
	}

	@Override
	public void flying() {
		System.out.println("날아?");
	}
	
	
}
