package day19_repeat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
	public static void main(String[] args) {
		
		// Create Server Socket
		try {
			ServerSocket svrSo = new ServerSocket(5000);
			while(true) {		//detection
				System.out.println("Ŭ���̾�Ʈ ���� ��� ��");
				Socket clientSo = svrSo.accept(); 	// �갡 listen���ش�.
				// listen�� �Ǵ� Ʈ���ŷδ� Ŭ���̾�Ʈ������ pw.flush()�� �����ȴ�.
				System.out.println("IP : "+clientSo.getInetAddress().getHostAddress());//Ŭ���̾�Ʈ�������ּ�
				
				// �� Ŭ���̾�Ʈ(�����)���� ���������� ���� ó���� �������
				// ��Ƽ������� ó��
				// ��� ������ ����ϴ� ��ü MTServer
				
//				MTServer ms = new MTServer(clientSo);
//				ms.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

/*
��� ���� ���ΰ�?
 ��Ƽ������� GUI�� �̿��Ͽ� ������ �������� ������ ä�� ����-Ŭ���̾�Ʈ ����


�������� Ŭ���̾�Ʈ ���� ó�� �κ��� ��Ƽ ������� �����Ǿ����.
	������ ��ű��
	���� - listen
	Ŭ���̾�Ʈ - send
	���� - accept

������ �������� �ٸ� �����带 �����Ͽ����Ѵ�.
�������� accept�� ������ ������ ����(��ü)�� ������ ������ �� ����.
accept�ؼ� ����Ǿ��ٸ� �� ���ķδ� ��� ��Ż��°� �Ǿ����.

���� �����ؼ� ����

Ŭ���̾�Ʈ���� �ؽ�Ʈ�ʵ忡 ���� �Ἥ ���� ������ ���� �ؽ�Ʈ���� �ø���( ���� �� ����� �����ϰ��� �ϴ� ���� �ƴ�  )
Ŭ���̾�Ʈ���� �ؽ�Ʈ�ʵ忡 ���� �� ���� ������ ������
�� ���� Ŭ���̾�Ʈ���� outputstream�� ��Ƽ� output


ī�巹�̾ƿ����� ����� ����
1��ȭ��
tf1 ������ ��Ƽ�
tf2 ��Ʈ ��Ƽ�


�̰� ���� ä�� Ŭ���̾�Ʈ���� ���� ������
�� tf1, tf2 ������ ������ ���ϰ�ü�� �����Ͽ�
Ŭ���̾�Ʈ ��ü���� ���̴� �޼������� (�� ȭ�鿡 ����ϴ� ���������� ������ �����ϰ�)
������ ������ ���� (���͸� �����ų� ������ �����ų�)
�޼���(���ڿ�) �� ������ �Ѵ�. ����� 

br ( s.getInputStream���� Ŭ���̾�Ʈ ���Ͽ� ���� ��ǲ��Ʈ�� �����͸� �б� ���� ���� )
pw (                                    �ƿ�ǲ                                      )
���ͼ� �׿��ִ� �ֵ�
�������� �׿��ִ� �ֵ�

�������� �޼��� ��Ƽ� -> target������ ��Ī�ϴ� outputstream�� ��Ƽ� 

s.getInputStream	//�� ���Ͽ��� �޴� input stream  .read
s.getOutputStream	//���� ���Ͽ� ���� output stream .write

����( Ŭ���̾�Ʈ �޼��� �޾Ƽ� ���, �ٽ� Ŭ���̾�Ʈ�� ���� )
 
 */