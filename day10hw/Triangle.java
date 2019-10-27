package day10hw;

public class Triangle extends BasicFigure{	//기본도형(추상클래스) 상속받아옴
	
	Triangle(){
	}
	
	Triangle(float width, float height){
		this.setWidth(width);
		this.setHeight(height);
	}
	@Override
	public float getCalArea() {
		return this.getWidth()*this.getHeight()/2;
	}
}
