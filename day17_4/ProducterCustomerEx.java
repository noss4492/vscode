package day17_4;

public class ProducterCustomerEx {
	public static void main(String[] args) {
		Car car = new Car();
		
		//�ڵ��� ȸ��
		Producter p = new Producter(car);
		
		//��
		Customer c = new Customer(car);
		
		// ���Ծ� �� ��ٷ��� ��� �߰�
		p.start();
		c.start();
		
	}
}
