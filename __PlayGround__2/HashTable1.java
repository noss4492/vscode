package __PlayGround__2;
import java.util.LinkedList;



public class HashTable1{
	public static void main(String[] args) {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	class HashTable{
		// ���� ������ linkedlist�� ����� ���̹Ƿ�
	    private LinkedList<Node>[] data;	// ������ ����
	    private class Node{
	        String key;
	        String value;
			public Node(String key, String value) {
				this.key = key;
				this.value = value;
			}
			public String getKey() {
				return key;
			}
			public void setKey(String key) {
				this.key = key;
			}
			public String getValue() {
				return value;
			}
			public void setValue(String value) {
				this.value = value;
			}
	    }
	    
		HashTable(int size) {
			this.data = new LinkedList[size];
		}	
		
		// Ű ������ �����ϰ� �����غ� �ؽ��Լ�
		public int makeHashCode(String key){
			int hashcode = 0;
			char[] strToHash = key.toCharArray();
			for(int i = 0 ; i < strToHash.length; i++) {
				hashcode += strToHash[i];	// ���ڿ� �ƽ�Ű�ڵ� ����
			}
			

			return hashcode;
		}
		
		// Horner's Method
		public int makeHashCode2(String value) {
			int hashcode = 0;
			if( hashcode == 0 && value.length()>0) {
				char[] val = value.toCharArray();
				for(int i = 0 ; i < value.length(); i++) {
					hashcode = 31 * hashcode + val[i]; 
//					31(�Ҽ��̸� ���� ����ȭ ����)
//					hashcode = (hashcode<<5)-hashcode + val[i];
				}
			}
			return hashcode;
		}
		
		
		
	}
}
