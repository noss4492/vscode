package day10hw;

public abstract class BasicFigure {
	private float width, height, radius;
	// protected�� ������ �����ϸ� ���� ���� Ŭ�������� get/set���� �������� �ʾƵ� ��.
	// �ϴ��� private�� ���� ���� ���͸� ����ϴ� ���� �����ϱ�� ��.
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