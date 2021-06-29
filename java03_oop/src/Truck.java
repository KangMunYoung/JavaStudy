
//	extends 키워드 사용 클래스를 상속
//			클래스는 1개만 상속 받을 수 있다.
public class Truck extends Car {
	int speed = 100;
	public Truck() {
		System.out.println("Truck()생성자 메소드 실행");
		System.out.println("Truck.speed-?"+speed);
		super.speedUp();
		
	}
	
	public Truck(String CarName) {
		//상위클래스위 생성자메소드 호출
		super(CarName);
		System.out.println("Truck(String)생성자 실행@!@");
	}
	
	//overriding :	상위클래스의 메소드를 하위클래스에서 재정의
	//				반환형,메소드명,매개변수가 같은 메소드를 재정의하느 ㄴ것이다.
	public void speedUp() {
		speed += 10;
		if(speed >= SPEED_MAX) {
			speed=SPEED_MAX;
		}
		System.out.println("truck.speed="+speed);
	}
	public static void main(String a[]) {
		//	상속관계에서 객체생성시 상위클래스의 생성자가 먼저 실행되고
		//	하위클래스의 생성자가 실행된다.
		Truck t = new Truck();
		System.out.println("t.speed="+t.speed);
		//상위클래스의 메소드 호출
		t.speedUp();
		t.speedUp();
		t.speedDown();

		//상위클래스의 생성자를 선택적으로 호출하기
		Truck tt = new Truck("소나타");
		System.out.println("tt.carName="+tt.carName);
	}
}
