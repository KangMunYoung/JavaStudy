
public class ClassMain {

	public static void main(String[] args) {
		ClassTest ct = new ClassTest();
		//						객체명.멤버변수
		//System.out.println("b="+ ct.b);
		
		ClassTest ct2 = new ClassTest(5679);
		
		//메소드 호출 : 객체명.메소드명()
		ct.sum();
		
		ct.total(100,200);
		ct2.total(111, 1123124);
		
		
	}

}
