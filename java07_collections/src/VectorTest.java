import java.util.Calendar;
import java.util.Vector;

public class VectorTest {

	public VectorTest() {}
	public Vector start() {
		//Vector 컬렉션
		Vector v = new Vector();
		//int Integer 오토박싱
		String username = "홍길동";
		Integer num = 25010;
		Calendar cal = Calendar.getInstance();
		MemberVO vo = new MemberVO("세종대왕","기획부","2021-06-10",1000);
		
		
		//Vector 객체에 다른 객체 추가하기
		v.add(username);
		v.addElement(num);
		v.add(1, cal);
		v.addElement(vo);
		
		//v.remove(1);
		//v.remove(cal);
		return v;
	}
//	public static void main(String[] args) {
//		new VectorTest().start();
//	}

}
/*

List(interface):	index가 존재한다.
					저장순소를 유지한다.

*/