package day10hw;

public class Triangle extends BasicFigure{
	
	Triangle(){
	}
	
	Triangle(float width, float height){
		this.setWidth(width);
		this.setHeight(height);
	}
	
	public float getCalArea() {
		return this.getWidth()*this.getHeight()/2;
	}
}
