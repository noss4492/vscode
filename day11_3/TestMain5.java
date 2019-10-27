package day11_3;


// �ν��Ͻ��� ������� method area�� ���� �Ҵ�Ǵ� ����

// �׳� �߰��� ���� ����
// ��� ��������� ���� �޼��� ���� �����ϰ��ִ�.

// �������� ���� �ּ���.
// Ŭ���� �޸� �ε��߿� �Ҵ�Ǵ� ����, method
// new �����ڷ� ��ü�� �����Ǳ� ���� ����Ҽ��ִ�Ư���Ѻ���
// ���� ���������� �����Ƿ� ���������� ��� Ŭ���������� ����ؼ� ���ٰ���



// Per-Thread (�����帶�� ' 3'...;; �̷��� recursive�� �޼��� ������ ����� �κ��� ��������)
// Program Counter Register
// JVM Stacks
// Native Method Stacks

// Common Area
// Heap( MethodArea( Run-time Constant Pool) )

// JVM
// ������ �÷��� // Excution Engine // Class Loader(<-.class<-Compiler<-.java)
//        ��           ��                ��
//        ��           ��                ��
//               runtime data area
//  method area/heap area/stack area/PC register/NativeMethodStack

// Heap
// Eden survivor1 survivor2 Old Permanent(Metaspace)

// �� ���� : �޼ҵ� �����̶� �� ������ ��� �����尡 ������
// ���ÿ���/PC��������/NativeMethodStack�� ������ �����帶�� �����ǰ� �������� ����



public class TestMain5 {
	public static void main(String[] args) {
		SmartPhone.pCompany = "oneApple";
		System.out.println(SmartPhone.pCompany);
		// new ���ߴµ��� ȣ���� ����.
		
		SmartPhone sp1 = new SmartPhone(
				"redriceNote", "���̳���", "01012345678", "�ڷ");
		SmartPhone sp2 = new SmartPhone(
				"redNote", "���̳�", "01012345678", "�");
		SmartPhone sp3 = new SmartPhone(
				"rNote", "����", "01012345678", "�");
		
		SmartPhone.pCompany = "oneApple";
		System.out.println(sp1.pCompany);
		System.out.println(sp2.pCompany);
		System.out.println(sp3.pCompany);
	}
}
