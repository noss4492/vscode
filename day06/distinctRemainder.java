package day06;
import java.util.ArrayList;

public class distinctRemainder {

    // 풀기 전 생각. 아 이거 스택 써서 어떻게 하는거 같은데..
    // 배열을 쓰자니 연결리스트가 있고 연결리스트를 쓰자니 스택,큐가 있고 스택,큐를 쓰자니 덱이 있고... ~ 3~;;
    // 일단 배열로 풀어두면 다른 걸로도 변형할 수 있겠지.. 라며 풀이 시작

    // 정렬도 공부를 좀 해야 하는데... ' ';; 8퀸문제 n퀸문제 해야하는데

    // 나머지를 담는 배열 rem[10], 각 나머지들이 몇개나 있는지 [42]

    static int[] userSort(int[] tmp){        // 정렬 생각 안나니까 그냥 삽입정렬 만들어서 쓰자. 
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
    
    // 담고 있어야 하는 자료를 생각
    // int[0] = 38; -> count값은 따로 배열을 만들던지 아니면 2차원 배열로 쓰던지(불편)

    static int[] distinct(int[] tmp){   //만약 같은 값이 서치되면 열을 없앤다.  ->  각 숫자마다 카운트한다.
        int[] cnt = new int[49];
        for(int i = 0; i<10; i++){
            cnt[tmp[i]]++;
            for(int j = 0; j<i; j++){		//너무 많이 더해지고 있음
                if(tmp[i]==tmp[j]){
                    cnt[tmp[i]]++;
                }
            }
        }
		return cnt;
    }

    static int sumOfeach(int[] tmp){
        // 각각의 배열을 검색해서 값이 들어 있는 경우 카운트를 올린다.
        int cnt = 0;
        for(int i = 0; i < tmp.length; i++)
            cnt++;
        return cnt;
    }

    // 동적 할당 자료구조를 쓰면 쉽지만 일단 배열로 작성하여 배열에서의 동작 논리를 따져보도록 한다.
    // 서로 다른 값이 몇개인지 -> 카운트 배열에 뭐라도 들어있는 애들 수

    public static void main(String[] args){
        int[] n = {39, 40, 41, 42, 43, 44, 82, 83, 84, 85}; // do while scanner 쓰면 입력 받을 수 있지만 계속 입력하기 귀찮아서 고정
        int tmp = 0; 
        int idxofR = 0;
        int[] rem = new int[n.length];
        int[] cnt = new int[42];
        //int[] rem = new int[n.length];
        //ArrayList<Integer> remainder = new ArrayList<Integer>();

        for(int i = 0; i < n.length; i++)       // 나머지 값들이 담긴다.
            rem[i] = n[i]%42;
        
        System.out.println("----------------------------");
        for(int x : rem)
        	System.out.print(" "+x+" ");

        rem = userSort(rem);  // sorting된 배열을 다시 rem 배열에 넣어둠
                                 // ren[10]
        System.out.println();
        System.out.println("----------------------------");
        for(int x : rem)
        	System.out.print(" "+x+" ");
        cnt = distinct(rem);  // 중복된 배열이 있으면 그 인덱스에 카운트 증가
                                 // cnt[42]

        final int result = sumOfeach(cnt);

        System.out.println(result);
    }
}

       // remainder.add(i, n[i]%42); 어레이에는 나중에 담자

//        for(int i = 0; i < remainder.size(); i++)
//            System.out.println(remainder);  //error





    
// 동적 할당 자료구조를 쓰면 쉽지만 일단 배열로 작성하여 배열에서의 동작 논리를 따져보도록 한다.
// 

/*
    public static void main(String[] args){
        int[] n = {39, 40, 41, 42, 43, 44, 82, 83, 84, 85}; // do while scanner 쓰면 입력 받을 수 있지만 계속 입력하기 귀찮아서 고정
        int tmp = 0; 
        int idxofR = 0;
        //int[] rem = new int[n.length];
        
        ArrayList<Integer> remainder = new ArrayList<Integer>();

        for(int i = 0; i < n.length; i++)       // 나머지 값들이 담긴다.
            remainder.add(i, n[i]%42);
        
        for(int i = 0; i < remainder.size(); i++)
            System.out.println(remainder);  //error
*/

        //for(int x : remainder)
        //    System.out.println(get.remainder(x));
        // remainder.size();   // maybe 8
 
        //ArrayList 를 사용해서 하면 될 것 같지만 일단은 배열으로 작성
//        for(int x : n){ //익숙해질때 까지는 좀 보류하자, 그냥 temp = a[i] 이런 때 자주 사용되는 것 같은데 -> 좀 익숙해진 것 같다.
//            if(){                //만약 내부에서 같은 값이 발견된다면 해당 인덱스 지점에 값을 대입
//                remainder[i++]= x%42;
//            }                   //
//            else{               // 같은 값이 없는 수가 들어오려고 하면 새로운 열을 만들고 추가.
        // 서로 다른 나머지값을 저장
            