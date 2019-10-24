package day10hw;

public class Circle extends BasicFigure{
	// width, height값을 버리고 싶은데 상속받은거 버릴 수가 없엉 ㅠ.ㅠ.
	// 상속 포기가 안됨. 치명적.
	Circle(){
	}
	
	Circle(float radius){
		this.setRadius(radius);
	}
	
	public float getCalArea() {
		return (float) ((float)Math.PI * (float)Math.pow(this.getRadius(), 2.0f));
	}
}
