package day06;
import java.util.ArrayList;

public class distinctRemainder {

    // Ǯ�� �� ����. �� �̰� ���� �Ἥ ��� �ϴ°� ������..
    // �迭�� ���ڴ� ���Ḯ��Ʈ�� �ְ� ���Ḯ��Ʈ�� ���ڴ� ����,ť�� �ְ� ����,ť�� ���ڴ� ���� �ְ�... ~ 3~;;
    // �ϴ� �迭�� Ǯ��θ� �ٸ� �ɷε� ������ �� �ְ���.. ��� Ǯ�� ����

    // ���ĵ� ���θ� �� �ؾ� �ϴµ�... ' ';; 8������ n������ �ؾ��ϴµ�

    // �������� ��� �迭 rem[10], �� ���������� ��� �ִ��� [42]

    static int[] userSort(int[] tmp){        // ���� ���� �ȳ��ϱ� �׳� �������� ���� ����. 
        int tmpt = tmp[0];
        for(int i=0; i<10; i++)
            for(int j = 0; j<i; j++){
                if(tmp[i]>tmp[j]){      // ascending
                    tmpt = tmp[i];
                    tmp[i] = tmp[j];
                    tmp[j] = tmpt;
                }
            }
        return tmp;
    }   
    
    // ��� �־�� �ϴ� �ڷḦ ����
    // int[0] = 38; -> count���� ���� �迭�� ������� �ƴϸ� 2���� �迭�� ������(����)

    static int[] distinct(int[] tmp){   //���� ���� ���� ��ġ�Ǹ� ���� ���ش�.  ->  �� ���ڸ��� ī��Ʈ�Ѵ�.
        int[] cnt = new int[49];
        for(int i = 0; i<10; i++){
            cnt[tmp[i]]++;
            for(int j = 0; j<i; j++){		//�ʹ� ���� �������� ����
                if(tmp[i]==tmp[j]){
                    cnt[tmp[i]]++;
                }
            }
        }
		return cnt;
    }

    static int sumOfeach(int[] tmp){
        // ������ �迭�� �˻��ؼ� ���� ��� �ִ� ��� ī��Ʈ�� �ø���.
        int cnt = 0;
        for(int i = 0; i < tmp.length; i++)
            cnt++;
        return cnt;
    }

    // ���� �Ҵ� �ڷᱸ���� ���� ������ �ϴ� �迭�� �ۼ��Ͽ� �迭������ ���� ���� ���������� �Ѵ�.
    // ���� �ٸ� ���� ����� -> ī��Ʈ �迭�� ���� ����ִ� �ֵ� ��

    public static void main(String[] args){
        int[] n = {39, 40, 41, 42, 43, 44, 82, 83, 84, 85}; // do while scanner ���� �Է� ���� �� ������ ��� �Է��ϱ� �����Ƽ� ����
        int tmp = 0; 
        int idxofR = 0;
        int[] rem = new int[n.length];
        int[] cnt = new int[42];
        //int[] rem = new int[n.length];
        //ArrayList<Integer> remainder = new ArrayList<Integer>();

        for(int i = 0; i < n.length; i++)       // ������ ������ ����.
            rem[i] = n[i]%42;
        
        System.out.println("----------------------------");
        for(int x : rem)
        	System.out.print(" "+x+" ");

        rem = userSort(rem);  // sorting�� �迭�� �ٽ� rem �迭�� �־��
                                 // ren[10]
        System.out.println();
        System.out.println("----------------------------");
        for(int x : rem)
        	System.out.print(" "+x+" ");
        cnt = distinct(rem);  // �ߺ��� �迭�� ������ �� �ε����� ī��Ʈ ����
                                 // cnt[42]

        final int result = sumOfeach(cnt);

        System.out.println(result);
    }
}

       // remainder.add(i, n[i]%42); ��̿��� ���߿� ����

//        for(int i = 0; i < remainder.size(); i++)
//            System.out.println(remainder);  //error





    
// ���� �Ҵ� �ڷᱸ���� ���� ������ �ϴ� �迭�� �ۼ��Ͽ� �迭������ ���� ���� ���������� �Ѵ�.
// 

/*
    public static void main(String[] args){
        int[] n = {39, 40, 41, 42, 43, 44, 82, 83, 84, 85}; // do while scanner ���� �Է� ���� �� ������ ��� �Է��ϱ� �����Ƽ� ����
        int tmp = 0; 
        int idxofR = 0;
        //int[] rem = new int[n.length];
        
        ArrayList<Integer> remainder = new ArrayList<Integer>();

        for(int i = 0; i < n.length; i++)       // ������ ������ ����.
            remainder.add(i, n[i]%42);
        
        for(int i = 0; i < remainder.size(); i++)
            System.out.println(remainder);  //error
*/

        //for(int x : remainder)
        //    System.out.println(get.remainder(x));
        // remainder.size();   // maybe 8
 
        //ArrayList �� ����ؼ� �ϸ� �� �� ������ �ϴ��� �迭���� �ۼ�
//        for(int x : n){ //�ͼ������� ������ �� ��������, �׳� temp = a[i] �̷� �� ���� ���Ǵ� �� ������ -> �� �ͼ����� �� ����.
//            if(){                //���� ���ο��� ���� ���� �߰ߵȴٸ� �ش� �ε��� ������ ���� ����
//                remainder[i++]= x%42;
//            }                   //
//            else{               // ���� ���� ���� ���� �������� �ϸ� ���ο� ���� ����� �߰�.
        // ���� �ٸ� ���������� ����
            