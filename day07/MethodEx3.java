package day07;

public class MethodEx3 {
	public static void ex1() {
		int[] m = {23, 53, 22, 11, 66, 77, 88, 29};
		int max = getMaxValue(m);
		System.out.println(m[max]);	//�� ���
		
		int maxValue = getMaxValue2(m);
		System.out.println(maxValue); //������
		int maxValuePosition = getMaxValuePosition(m);
		System.out.println(m[maxValuePosition]); //������2
		
		// ���������� �ż��尡 �����Ҷ� ���� �Ҹ�Ǵ� ����������
		// (ȣ���� ������ ������ ��ġ���� ������)
		
		// ��.��.��. (�̹� �޾.. �迭 �����ϸ鼭)
		// �������� �����ϸ�, �������� ���ؼ� ������ ������ ����
		
		setMaxValue(m, -100); //�� �迭�� �ִ��� -100���� �����.
		System.out.println("---------------------");
		maxValue = getMaxValue2(m);
		System.out.println(maxValue);
		
		/*
		 method ȣ�� ��Ŀ� ���� �з�
		 call by name      : getMaxValue();
		 call by Value     : getNumber(4);		=> (���ο�����) ���� ���� �Ұ���
		 call by reference : setMaxValue(m, -100);  => ���� ���� ����
		 */
	}
	
	public static void setMaxValue(int[] x, int num) {
		// int pos = getMaxValuePosition(x);
		// x[pos] = value;
		x[getMaxValuePosition(x)] = num;	// x[pos] = num;
	}
	public static int getMaxValue2(int[] x) {// ���� �� ���(���� ���� �����ε�)
		int maxValue = 0;			
		for(int i = 0; i < x.length; i++) {
			if(maxValue < x[i]) {
				maxValue = x[i];
			}
		}		
		return maxValue;
	}
	public static int getMaxValuePosition(int[] x) {
		//int maxIdx = -1;	//���� : 0�� �迭�� ����ִ� �ִϱ� �ƿ� ������� ���� �����
		int maxValue = 0;
		int pos = -1;
		for(int i = 0; i < x.length; i++) {
			if(maxValue<x[i]) {
				//maxIdx = i; // ���� ��� ��������.. 
				maxValue=x[i];
				pos = i;
			}
		}
		return pos;
	}
	public static int getMaxValue(int[] m) {// ���� ÷�� �������. �ϴ� ����
		int max = 0;	// max is m[max] : maxValue's index, (������ ������ �߰�)
		for(int i = 0; i < m.length; i++ ) {
			if(m[max] < m[i])
				max = i;
		}
		return max;
	}
	public static void main(String[] args) {
		ex1();

	}

}
