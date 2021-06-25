package test;

public class ProtectedTest2 {
	protected String tel = "010-1234-8959";
	//객체생성 안됨
	protected ProtectedTest2(){
			System.out.println("다른패키지의 생성자메소드");
	}
	protected void telOutput(){
		System.out.println("전화번호"+tel);
	}
	public String getTel() {
		return tel;
	}
	public static ProtectedTest2 getInstance() {
		return new ProtectedTest2();
	}
}
