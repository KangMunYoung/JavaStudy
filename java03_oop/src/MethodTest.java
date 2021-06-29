
public class MethodTest {
	//public - 접근제한자
	//멤버영역
	int num = 12;
	String name="홍길동";
	String tel;	//	null
	
	//생성자 메소드 :	생략시 자동 추가(JVM)
	//				상송관계가 아닐때만 추가 해준다.
	//	매개변수는 데이터형이 다르거나 데이터의 변수의 갯수가 달라야한다.
	MethodTest(){};//필요하든 안하든 무조건 추가해준다
	MethodTest(String tel){
		System.out.println("연락처"+tel);
	}
	//MethodTest(String name){	
	//}
	MethodTest(int num){
		
	}
	
	MethodTest(int num, String name){
//		this : 현재객체(현재글래스)
		this.num = num;
		this.name = name;
		String tel = "1234";
		this.tel = "02-1234-1234";
	}
	MethodTest(String name, int num){
		//생성자 메소드에서 다른 생성자 메소드 호출하기
		//생성자 메소드에서 다른 생성자를 호출할때는 메소드명을 직접표기할수 없고
		//		this()
//		MethodTest(num,name); 사용 불가
//		this()를 이용해서 다른 생성자 메소드를 호출할때는 반드시 첫번째 실행문이여야 한다.
//		System.out.println();//첫번째로 다른 생성자 메소드를 호출하면 안된느것을 보기위한 코드
		this(num, name);	//첫번째 실행문이고, this로 불러온다
	}
}
