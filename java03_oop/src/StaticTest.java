
public class StaticTest {
	int num = 1234;
	String name ="홍길동";
	static String addr ="마포구";
//	static으로 만든 변수는 main메소드에서 전역변수로 사용된다.
//	현재클래스의 모든 객체에서 1개만 존재한다.(공통변수로 사용)
	
	public StaticTest() {
		// TODO Auto-generated constructor stub
	}
	//주소를 변경하는 메소드
	void setAddr(String addr) {
		this.addr=addr;
	}
	String getAddr() {
		return addr;
	}
}
