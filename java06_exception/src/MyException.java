//1. ����Ŭ���� ������ �ݵ�� Exception class extends ����
public class MyException extends Exception{

	public MyException() {
		super("1~100������ ���̿����մϴ�.");
	}
	public MyException(String message) {
		super(message);
	}

}
