package day10hw;

public class Square extends BasicFigure{
	Square(){
	}
	
	Square(float width, float height){
		this.setWidth(width);
		this.setHeight(height);
	}
	
	public float getCalArea() {
		return this.getWidth()*this.getHeight();
		//superµµ µÇ³×?
	}
}
