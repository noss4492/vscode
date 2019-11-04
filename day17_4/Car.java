package day17_4;
// ������-�Һ��� ����
// syncro    wait / notify
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class Car {
	// String Ŭ������ ���� �� �ִ� ���� Object�迭
	ArrayList<String> list;
	String[] carNameList = { "�غ�ī", "������", "��Ʈ", "�ڶ���" };

	public Car() {
		list = new ArrayList<String>();
	}

	public String getCarName() {
		Random rnd = new Random();
		return carNameList[rnd.nextInt(4)];
	}

	public synchronized void push(String car) {
		System.out.println("���� ���� ���� : " + list);
		System.out.println("�ڵ����� ����Ǿ����ϴ�. " + car);
		list.add(car);
		// ��ٸ��� �ճ� �Ͼ
//		this.notify();	// ���� ��(��å�� ���̷�?)
		this.notifyAll();	// �� ����, �Ϲ������� ���� ��ٸ��ְ� ������
		// synchronized �޼����� ���� ����
	}

	public synchronized String pop() {
		String carName = null;
		System.out.println("���� ���� ���� : " + list);
		if (list.size() == 0) {
			System.out.println("���� ������ �����. ��ٸ����� �մԾ�");
			// ��ٷ�
			try {
				this.wait();//object�� �޼���
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		}
		carName = list.remove(list.size() - 1);
		System.out.println("�ڵ����� ���Ǿ����ϴ�. ���̸� : " + carName);
		return carName;
	}
}
//		Stack<String> s = new Stack<String>();
//		s.push(getCarName());
//		s.push(getCarName());
//		s.push(getCarName());
//		s.push(getCarName());