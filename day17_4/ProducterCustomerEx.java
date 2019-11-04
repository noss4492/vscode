package day17_4;

public class ProducterCustomerEx {
	public static void main(String[] args) {
		Car car = new Car();
		
		//자동차 회사
		Producter p = new Producter(car);
		
		//고객
		Customer c = new Customer(car);
		
		// 고객님아 좀 기다려요 기능 추가
		p.start();
		c.start();
		
	}
}
