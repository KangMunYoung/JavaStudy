
public class WrapperTest {

	public WrapperTest() {
		//Wrapper클래스는 기본 데이터형의 정보를 객체로 변경시키는 클래스이다.
		//Byte, Short, Integer, Long
		//Float, Double
		//Boolean
		//Character
		
		int a =1234;
		Integer i= Integer.valueOf(a);//new Integer(a); //객체화
		
		System.out.println(a);//객체가아님
		System.out.println(i);//객체
		
		Object obj = a;	//오토박싱 1.5버전 이전에사용하면오류남
		Object obj2 = i;
		System.out.println(obj);
		System.out.println(obj2);
		
//		1.1, 1.2 , 1.3, 1.4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16
	
		int x = i;//오토언박싱
		System.out.println(x);
	}

	public static void main(String[] args) {
		new WrapperTest();
		
	}

}
