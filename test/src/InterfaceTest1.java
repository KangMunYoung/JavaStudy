//interface는 추상메소드와 static final변수가 있는 클래스다.
public interface InterfaceTest1 {
	//final변수 -> 값을 변경할수 없는 변수
	public static final int MAX=100;
	public static final String LOGO = "비트캠프";

	//추상메소드
	public void output();
	public int sum();
}
