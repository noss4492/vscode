package __PlayGround__2;
import java.util.LinkedList;



public class HashTable1{
	public static void main(String[] args) {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	class HashTable{
		// 각각 열마다 linkedlist로 연결될 것이므로
	    private LinkedList<Node>[] data;	// 사이즈 미정
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
		
		// 키 값으로 간단하게 구현해본 해쉬함수
		public int makeHashCode(String key){
			int hashcode = 0;
			char[] strToHash = key.toCharArray();
			for(int i = 0 ; i < strToHash.length; i++) {
				hashcode += strToHash[i];	// 문자열 아스키코드 총합
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
//					31(소수이며 연산 최적화 가능)
//					hashcode = (hashcode<<5)-hashcode + val[i];
				}
			}
			return hashcode;
		}
		
		
		
	}
}
