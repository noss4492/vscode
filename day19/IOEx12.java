package day19;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// ȸ�������� �����ϰ� �б�
public class IOEx12 {
	public static void main(String[] args) throws IOException {
		Member m1 = new Member("id1", "1234", "�浿ȫ", "����", "hong@gmail.com", 20);
		
		FileOutputStream fos = new FileOutputStream("z:\\_19_member.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(m1);
		
		
		// NotSerializableException �߻�. 
		// �߰� �ɰ��� �ٽ� �����·� ����� ���� ����ȭ(��� �Ҹ��� �̸����� ����, �¼��콺�� �� ���� ��Ȳ��)
		// ��� ��ü�� serializable ���·� ����� ��.(�ø���������� ���ø���Ʈ)
		
		
	}
}
