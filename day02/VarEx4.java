package day02;

public class VarEx4 {

    public static void main(String[] args){
        args = new String[2];
        args[0] = "hello\n";
        args[1] = "\tworld";
        
        // \n, \t, \b(�齺���̽�), \\, \', \"

        System.out.println("������ \n ���� \t �ְ�� ���� ");
        System.out.println(args[1]+"!");
        
        // c���� 1�� 0���� ǥ�� ���� java������ boolean b = 1 (�ȵ�) b = true (��)
        // ��, ���� : ������ ������ �� �ִ� �ڷ��� �Ґl��
        
        boolean bl1 = true;
        boolean bl2 = false;
        
        System.out.println("bl1: "+bl1);
        System.out.println("bl2: "+bl2);
   
    }
}
