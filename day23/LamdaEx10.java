package day23;

import java.util.function.Consumer;


// Supplier
// Consumer

public class LamdaEx10 {
	public static void main(String[] args) {
		
		Consumer<String> c = s -> System.out.println(s);
		
		c.accept("������");
		c.accept("�������̺�");
	}

}
