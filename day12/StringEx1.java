package day12;

public class StringEx1 {
	public static void main(String[] args) {
		// class impl ù���� �빮��
		String s = "java";
		System.out.println(s);
		
		String str1 = new String("java");	//�̰� fm��
		String str2 = new String("java");
		String str3 = new String("java2");
		int[] a = {3};		// immutable ��ü ���� hashcode�� ����. ��..
		int[] b = {3};	
		int[] c = {6};
		System.out.println("str1 "+str1.getClass().getName() + '@' + Integer.toHexString(str1.hashCode()));
		System.out.println("str2 "+str2.getClass().getName() + '@' + Integer.toHexString(str2.hashCode()));
		System.out.println("str3 "+str3.getClass().getName() + '@' + Integer.toHexString(str3.hashCode()));
		System.out.println("a "+a.getClass().getName() + '@' + Integer.toHexString(a.hashCode()));
		System.out.println("b "+b.getClass().getName() + '@' + Integer.toHexString(b.hashCode()));
		System.out.println("c "+c.getClass().getName() + '@' + Integer.toHexString(c.hashCode()));
		// str1�� str2�� �ؽ��ڵ�� ����.
		// new�� ������ ��쿡�� str1 str2 �� ������. primitiveó�� ������ ��쿡�� 
		
		if( str1 == str2) {
			System.out.println("���� ������");
		}else {
			System.out.println("�ٸ� ������");
		}
		if( str1.equals(str2)) {
			System.out.println("���� ����");
		} else {
			System.out.println("�ٷ� ����");
		}
		
		// Object Ŭ���� : equals�� ���ϰ�ü���� �������� ���ϴ� �ֿ���
		// String Ŭ���� : equals�� overrided. ���� ��
		/* Overrides: equals in class Object */
		// ���� �񱳷� �ٲ��ռ�
		
		
		//���� ���ڿ��̸�
		//str1 str2�� ���� ���� ���ڿ� ��ü�� ����Ű�� �ִٰ�
		str2 = "oracle";		// str2�� ���� �����Ǵ� ��ü�� �� �� ������.
								// �������� �� �� ��� �ٲ�
		// Ŭ���������� Primitive typeó��
		// ����� �� �̾� �������� Ŭ���� : String
		// ���ڸ� �����ϰڴٰ� char[] ����� �����ϰ�...
		// �޸𸮴� �Ʊ���...
		
		String str5 = "java";
		String str6 = "java";
		
		if(str6 == str5) {
			System.out.println("str5, 6�� ���� ��ü�� ����Ű�� ����");
		}
		
		
		System.out.println("--------------------------");
		System.out.println("str1 : "+str1);
		System.out.println(str1.getClass().getName() + '@' + Integer.toHexString(str1.hashCode()));
		System.out.println(str2.getClass().getName() + '@' + Integer.toHexString(str2.hashCode()));
		System.out.println("str1 : "+str1.toString());
		// Overrides toString in class Object
	}

}
