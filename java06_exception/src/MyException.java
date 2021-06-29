//1. 예외클래스 생성시 반드시 Exception class extends 생성
public class MyException extends Exception{

	public MyException() {
		super("1~100사이의 값이여야합니다.");
	}
	public MyException(String message) {
		super(message);
	}

}
