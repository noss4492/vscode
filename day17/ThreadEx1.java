package day17;
// �޸𸮸� �Ҵ�޾� �������� ���α׷� ==> ���μ���
// ���α׷������� ����Ǵ� �帧�� ���� ==> Thread
// �ڹٴ� Multi Thread ����

// ���ÿ�... ? ��Ƽ�׽�ũ ó���Ϸ���... ?
// 1. Thread ��ӹ޾Ƽ� 
// 2. Runnable �������̽��� �����ؼ�


public class ThreadEx1 extends Thread {	// �⺻������ Main Thread
	public static void main(String[] args) {
		Thread th = Thread.currentThread();	//Returns a reference to the currently executing thread object.
		System.out.println(th.getName());
	}
}
