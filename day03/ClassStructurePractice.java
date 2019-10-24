package day03;
import java.io.IOException;

//statement Ex7의 확장임.
public class ClassStructurePractice {
	static char stuGrade(int kor, int eng, int mat) {
		float sum = 0.0f;
		sum = kor + eng + mat;
		float avg = sum/3;
		
		if(avg >= 90) 
			return 'A'; 
		else if(avg >= 80) 
			return 'B'; 
		else if(avg >= 70) 
			return 'C'; 
		else if(avg >= 60)
			return 'D'; 
		else 
			return 'F';
	}
	
	static class StuReport{			// report table  
	// 스태틱은 잘 사용되지 않는 클래스가 객체지향적인듯? 흠..
	// 흠.. 이런 포맷은 지양되는 것 같다. 이러한 구조는 향후에 수정하여야 할 듯 하다.
		String name;
		int kor;
		int eng;
		int mat;
		char grade;
		StuReport(String name, int kor, int eng, int mat) {
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.mat = mat;
			this.grade = stuGrade(kor, eng, mat);
		}
	}

	public static void main(String[] args) {
		StuReport[] srt = {							// srt student report table
				new StuReport("Scott", 55, 90, 70),
				new StuReport("Blake", 95, 50,100),
				new StuReport("David", 99, 99, 99),
				new StuReport("Ralph", 30, 20, 40)
				};
		
		for(int i=0; i<srt.length; i++)
			System.out.println(srt[i].name+"의 평균 학점은 "+srt[i].grade+" 입니다.");
	}
}





/*
 * 전체 테이블을 대상으로 하는 메서드의 경우에는 이런 식으로 작성하면 될 것으로 생각된다.
static char stuGrade(StuReport[] dat){
	//float sum[] = {0.0f, 0.0f, 0.0f};
	float sum = 0.0f;
	
	for(int i = 0; i < dat.length; i++) {
		sum = dat[i].kor + dat[i].eng + dat[i].mat;
	}
*/

//static char stuGrade(StuReport[] dat){
//float sum[] = {0.0f, 0.0f, 0.0f};
//for(int i = 0; i < dat.length; i++) {
//	sum = dat[i].kor + dat[i].eng + dat[i].mat;
//}		
//}
