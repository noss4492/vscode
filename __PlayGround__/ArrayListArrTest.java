package __PlayGround__;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListArrTest{
    public static void main(String[] args) {
        // 어레이리스트 안에 배열을 넣었을 때의 반복자는 어떻게 생성이 되는가?
        ArrayList<String[]> strArrList = new ArrayList<String[]>();
        String[][] testArr = {
            {"안녕하세요1", "어레이리스트1", "반복자", "어떻게 돌아가는지1", "테스트중입니다.1"},
            {"안녕하세요2", "어레이리스트2", "반복자", "어떻게 돌아가는지2", "테스트중입니다.2"},
            {"안녕하세요3", "어레이리스트3", "반복자", "어떻게 돌아가는지3", "테스트중입니다.3"}
        };

        for(int i = 0 ; i < 3; i ++){
            strArrList.add(testArr[i]);
        }
        
        Iterator<String[]> itr = strArrList.iterator();
        String[] tmp = new String[5];
        
        System.out.println("--------------------------------");
        System.out.println("itr : "+itr);
        // System.out.println("itr.next() : "+itr.next());
        // System.out.println("itr.next()[0] : "+itr.next()[0]);
        
        System.out.println("--------------------------------");
        
        for(int i=0; i < 3; i ++){
            tmp = itr.next();   //[Ljava.lang.String;@6d06d69c] arr?
            System.out.println("tmp, "+i+" --> : "+tmp);
            System.out.println("spread, "+i+" --> : "+[...tmp]);
            for(int j = 0 ; j< 5; j ++){
                System.out.println("tmp[j], "+i+" --> : "+tmp[j]);
            }
            // System.out.println("itr.next()["+i+"] : "+itr.next()[i]);
        }
        
        System.out.println("--------------------------------");

        // 아  하  사용법 알겠음 수고링
        

        //여기서의 이터레이터는 리스트에서 상속된 자식들에서만 사용 가능함.
        
    }
}
