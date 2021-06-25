
public class StringBufferTest {

	public StringBufferTest() {
		start();
	}

	
	public void start() {
		StringBuffer sb1 = new StringBuffer();//16byte
		StringBuffer sb2 = new StringBuffer(100);//100byte
		
		//append(): 문자열추가
		sb1.append("buffer append Test..");
		sb1.append(123456);
		
		//insert(): index위치 문자 삽입
		sb1.insert(5, "(스트링버퍼)");
		sb1.insert(15, 23236.21542554);
		//
		//buffe(스트링버퍼)r a23236.21542554ppend Test..123456
		//delete(): 
		//deleteCharAt():
		sb1.deleteCharAt(6);
		//buffe(트링버퍼)r a23236.21542554ppend Test..123456
		
		sb1.delete(1, 4);// index 1부터 4까지 지우기
		//be(트링버퍼)r a23236.21542554ppend Test..123456
		
		sb1.replace(1, 3, "(자바)");//index 1부터 3앞까지 "(자바)"로 치환
		//b(자바)트링버퍼)r a23236.21542554ppend Test..123456
		
		sb1.reverse();
		
		//확보된 공간 확인
		System.out.println("sb1.capacity="+ sb1.capacity());
		System.out.println("sb2.capacity="+ sb2.capacity());
		System.out.println(sb1);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new StringBufferTest();
	}

}
