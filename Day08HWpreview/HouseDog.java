package day08HWpreview;

public class HouseDog extends Dog {
	public void sleep() {				// �޼ҵ��� �������̵��� �����ϴ�.(��ӹ޾� �������Ͽ� (�������� ����ä) ��� �����ϴٴ� �̾߱��ε�)
		System.out.println(this.name+" zzz in house");
	}
	public void sleep(int hour) {		// �޼ҵ� �����ε� ��
		System.out.println(this.name+" zzz in house for "+hour+"hours");
	}
	public static void main(String[] args) {
		HouseDog hd = new HouseDog();
		hd.setName("house happy");
		hd.sleep();
	}
}


// ���� ���� ������ ���� �� �ڹ� ���/�������̽�/������/�߻�Ŭ������ �����Ͽ���
// ���� ���� ����� �� �����Ƽ� �����ؼ� �����ϰ� ������ ���� �ƴ�(��� ����)

////// �޼ҵ� �������̵�(method overriding)
// ���� Dog Ŭ������ �̹� sleep()�� ���ǵǾ� �ִ�.
// Dog Ŭ������ ��ӹ��� HouseDog Ŭ�������� sleep()�޼��带 ��ӹ޾� 
// �ڱⰡ �������Ͽ� (������ϵ���) �ٸ��� ����� �� �ִ�.
// �̷��� �θ� Ŭ������ �޼ҵ带 �ڽ� Ŭ������ ������ ���·� �� �ٽ� �����ϴ� ������ �޼ҵ� �������̵� �̶�� ��.��
// (== �޼ҵ� �����)

////// �޼ҵ� �����ε�(method overloading)
// 
