package day12_my_immutable_chanining;

public class Hw3 {
}

/*
AWT
(Abstract Wndow Toolkit)

Component
	Container
		Window
			Frame
 */
/*
3. ��� Ŭ������ �ֻ��� Ŭ������?
Object

4. �� Ŭ������ �޼���� ��� ��ִ°�?  11
clone(), equals(Object obj), finalize(), getClass(), hashCode(), notify()
notifyAll(), toString() : Returns a string representation of the object
wait(), wait(long timeout), wait(long timeout, int nanos)

5.  equals(), toString()�� ���� ��� ����غ���
� ������ ����ִ��� �����Ͻÿ�.

equals(Object obj)
The equals method implements an equivalence relation on non-null object references
�� equals �޼ҵ�� ���� ���δ�(������) ������ ���踦 �Ǵ��ϴ� null�� �ƴ� ������Ʈ�� ��������
���������� ����.

toString()
Returns a string representation of the object
��ü�� ��ǥ�ϰ� �ִ� string( getClass().getName() + '@' + Integer.toHexString(hashCode()) )
�� ��ȯ�Ѵ�.

String Class�� ��� ���� �񱳸� equals�� �ؾ� ��ü ������ ������ ���� �� �ִ�.
String Class�� �Ҵ翬����(new)���� �Ϲ� primitive type variableó�� ����ϸ� 
���� ��ü�� ��Ÿ�� ��� �������� �ʰ� ���� ��ü ������ ����Ű�� �ȴ�.

6. String Ŭ������ equals() , toString()��
ObjectŬ������ � ���̰� ������, �� ���̰� ����°�? 

String Class�� equals()�� �������� ������ ���� ���ϴ� ���� �ƴ϶�
���� ���ڸ� ���Ͽ� ������ �������� ���ϰ� ��.

String Class�� toString()�� 

String Class
	toString()
		This object (which is already a string!) is itself returned.
Overrides:
	toString in class Object
 �ڱ� ��ü�� ��ȯ����.



7. String Ŭ������ ���� ���Ǵ� �޼��带 �����ϰ�
�� �޼��尡 � ����� �ִ��� �����Ͻÿ�.
String ������
	String(byte[] bytes)
charAt(int idx)
	�ش� �ε��� ���� �� ��ȯ
concat(String str)
	�̾���̱�
equals(Object anObject)
	���� ��ü�� ���� ���� ������
equalsIgnoreCase(String anotherString)
	���ڿ� ��(�빮�� ����)
indexOf(int ch)
	�ش� ���� ����ִ� ���ڿ��� �ε��� ��ȯ
length()
	���ڿ� ���� ��ȯ
replace(char oldChar, char newChar)
toCharArray()
	char�迭�� �ɰ�
toString()
	�ڱ� ��ü �� ��ȯ

*/