package day10hw;

public abstract class BasicFigure {
	private float width, height, radius;
	// protected로 접근자 지정하면 하위 도형 클래스에서 get/set으로 접근하지 않아도 됨.
	// 일단은 private로 만들어서 게터 세터를 사용하는 것을 연습하기로 함.
	public abstract float getCalArea();
	public float getWidth() {
		return width;
	}
	public void setWidth(float width) {
		this.width = width;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public float getRadius() {
		return radius;
	}
	public void setRadius(float raidus) {
		this.radius = raidus;
	}
}