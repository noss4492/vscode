package day10hw;

public class Circle extends BasicFigure{
	// width, height���� ������ ������ ��ӹ����� ���� ���� ���� ��.��.
	// ��� ���Ⱑ �ȵ�. ġ����.
	Circle(){
	}
	
	Circle(float radius){
		this.setRadius(radius);
	}
	
	public float getCalArea() {
		return (float) ((float)Math.PI * (float)Math.pow(this.getRadius(), 2.0f));
	}
}
