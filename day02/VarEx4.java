package day02;

public class VarEx4 {

    public static void main(String[] args){
        args = new String[2];
        args[0] = "hello\n";
        args[1] = "\tworld";
        
        // \n, \t, \b(백스페이스), \\, \', \"

        System.out.println("월요일 \n 좋아 \t 최고로 좋아 ");
        System.out.println(args[1]+"!");
        
        // c언어는 1과 0으로 표현 가능 java에서는 boolean b = 1 (안됨) b = true (됨)
        // 참, 거짓 : 논리값을 저장할 수 있는 자료형 불릐언
        
        boolean bl1 = true;
        boolean bl2 = false;
        
        System.out.println("bl1: "+bl1);
        System.out.println("bl2: "+bl2);
   
    }
}
