package day08HW;

public class HwMain {

	public static void main(String[] args) {
		//hw1
		Man Hong = new Man("ȫ�浿", 2, "��", 2, 20, "����", "��ƿ");
		Hong.steal();
		Hong.run();
		Hong.fastrun();
		Hong.chookJiBubb();
		
		//hw2
		MulTable MulAtoB = new MulTable(1, 9);	//1�ܺ��� 9��
		System.out.println();
		MulTable MulN = new MulTable(5);		//5�ܸ�
		//���� �� ���� ���� ���� �ٽ� �а� �ٽ� Ǯ��. ;;��;;...
		System.out.println();
		
		MulTable g1 = new MulTable();	//��� �������� ���� ��
		g1.dan = 5;
		g1.mulPrint();
		System.out.println();
		
		/*
		hw3
		 class�� ��üȭ ���� ���� �������� �� �� �ְ� (���赵)
		 object�� ��üȭ ��(�ν��Ͻ�ȭ ��, �޸𸮿� ������ �Ҵ��� ��) 
		                    ������ �� �� �ִ�.(���赵�� ���� ��)
		
		hw4 
		 class�� �����ϴ� 3 ��Ҵ� 
		 ���(�������ų� �ڽĳ��ܿ��� ��� �������� ����� ���� �����ϵ�)
		 member Field(member variable + ...)
		 constructor(�ּ�1, ������ �ڵ� gen)
		 member method
		
		
		hw5
		Method Overloading�̶�?
		�ڹٿ����� ���α׷��� �����ϸ鼭 �޼ҵ带 ȣ���ؾ��� �� � �޼ҵ带 ȣ���� ���� ���ؾ��Ѵ�.
		�� �� ���� �޼ҵ��(��������)�� ��������ν� ���� �޼ҵ���Ͻ� �����ϴ� �ñ״��ķδ�
		�ñ״���(���� �޼ҵ���϶� �Ű�����(parameter)�� ����, ����, ��(type))�� �Ǵ��Ѵ�.
		
		hw6
		call by name (�Ķ��Ÿ ���� ȣ��)
		call by value (���� �־� ȣ��)
		call by reference (�������� �޾Ƽ� ȣ��)
		
		*/
		
		//hw7
		int a = 20;
		int[] b = {10, 20, 50, 30};
		float f = 240.3f;
		
		FormatData fd = new FormatData();
		fd.print(a);
		fd.print(b);
		fd.print(f);
		
		//hw8
		//marin - atk -> ghost
		//medic - heal -> ghost
		//ghost -> ����,�޵�,��Ʈ
		//nuclear
		
		//hw9
		//siegeMode()
		
	}
	
	public static class MulTable{
		int dan;
		MulTable(){				//�̰��� �������� ���� �����̾���
		}
		MulTable(int a, int b){	// �׳� a�ܺ��� b�ܱ���
			for(int j = 1; j <= 9; j++) {
				for(int i = a; i <= b; i++)
					System.out.printf("[%1d]*[%1d]=[%2d] ", i, j, i*j);
				System.out.println();
			}
		}
		MulTable(int c){		// c�� ���
			for(int j = 1; j <= 9; j++)
				System.out.printf("[%1d]*[%1d]=[%2d]\n", c, j, c*j);
		}		
		void mulPrint() {
			for(int i = 1; i <= 9; i++)
				System.out.printf("[%1d]*[%1d]=[%2d]\n", dan, i, this.dan*i);
		}
	}
}
