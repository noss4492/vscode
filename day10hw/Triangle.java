package day10hw;

public class Triangle extends BasicFigure{	//�⺻����(�߻�Ŭ����) ��ӹ޾ƿ�
	
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
