package day10;

import day09.Marin;

public class TestMain1001 {
	public static void main(String[] args) {
		
		Parent p1 = new Parent();
		Child c1 = new Child();
		
		p1.jwanSori();
		p1.singing();
		p1.eating();
		
		c1.jwanSori();
		c1.singing();
		c1.goClub();
		
		Marin m1;		//day09.Marin a1 = new Marin();
		Parent p2 = new Parent();
		 
		p2 = p1;
		//辞稽 陥献 適掘什 晦軒澗 凧繕葵聖 匝 呪 蒸陥.
		//旭精 適掘什 晦軒澗 匝 呪 赤製 しせしせ
		// 切戟莫戚 陥献蕉級 晦軒澗 凧繕葵聖 匝 呪 蒸製
		// 唖 適掘什亜 唖 切戟莫戚艦猿
		
		p2.singing();
/////////////////////////////////////////////////////////////////////
		// 嬢憩陥姥 買宿 (? さ?)
		// 採乞 凧繕痕呪拭 切縦税 凧繕痕呪 企脊精 亜管.
		
		// 森須旋生稽 採乞 切縦 淫域拭辞澗 喫
		// p1 § c1 淫域艦猿, p1戚 左奄拭澗 c1拭 赤澗 依級聖 硝壱赤製
		// c1 凧繕葵聖 亜走壱 達焼亜辞(琵拭 赤澗 切縦 Object拭 亜辞)
		// p1戚 乞牽澗 c1税 痕呪蟹 五辞球澗 叔楳鞠走 省製. (走亜 焼澗暗幻 しせ)
		System.out.println("**************");
		p1 = c1;
		p1.singing();
		
		/* 拭君 蟹澗暗 溌昔背砂.
		c1= p1;
		c1.singing();
		c1.goClub();
		*/
		
		Child c2;
		c2= c1;
		c2.goClub();	// しせ 
		
		//c2 = p1;	// 陳督析君 : 戚惟 鞠? , 雇短廃 陳督析君..
		
		c2 = (Child)p1;	//梓端亀 悪薦 莫痕発 喫.
		c2.goClub();
		
		// 梓端 莫痕発 弦戚 彰韓壱 敗.
		
		
		// 持失 社瑚 淫域亜 嬢胸惟 赤聖猿? 
		// p1精 琵拭 持失鞠醸走幻 戚薦 硲窒鞠走 省製.
		// 切郊澗 社瑚切亜 蒸嬢! (free.. 蒸錠.. 陪..)
		// GC(亜搾走 鎮刑斗)亜 硝焼辞 社瑚獣佃捜.
		// 凧繕鞠走 省壱 赤澗 琵慎蝕拭 拝雁吉 Object級...
		// GC澗 什追糟戚 舛背閃赤嬢辞 嬢追 娃七拝 呪 蒸製. 汝社 切据 社乞亜 岨 赤製.
		
		
		/*
		 * 
stack     | heap
p1(@a)      @a
            (String name, String job, int age)
            (singing(), eating(), breathing(), jwanSori(), Parent())
            
            
c1(@b)      @b
            (String name, String job, int age, String facebookID)
            (singing(), eating(), breathing(), jwanSori(), Child())
            
>>execute


Parent p1 = new Parent();
p1戚虞澗 凧繕痕呪 爽社因娃 五乞軒拭 
                                     梓端 拝雁(new)板 爽社葵聖 p1拭 企脊   (JVM戚 硝限精 是帖研 走舛)  
Parent虞澗 適掘什 姥繕研(奄沙 持失切稽)

Child c1 = new Child();
p1戚虞澗 凧繕痕呪 爽社 拝雁閤澗陥(JVM戚 硝限精 是帖研 走舛背辞).
p1戚虞澗 凧繕痕呪拭 企脊
五乞軒 拝雁(new) Child虞澗 適掘什 姥繕研 奄沙 持失切稽 幻糾 
戚 奄沙 持失切澗 採乞痕呪研 凧繕馬壱 赤生糠稽
1. child税 奄沙 持失切 硲窒喫
2. 益 奄沙 持失切 照拭 赤澗 採乞税 奄沙持失切(super)研 硲窒
 2-1. super精 凧繕痕呪 戚糠稽 採乞税 爽社葵 @a稽 羨悦
 2-2. 採乞税 持失切研 硲窒 

		 */
		
	}

}
