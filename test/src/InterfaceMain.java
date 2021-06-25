//클래스에서 interface를 상속받을경우 impliements 키워드를 이용한다.
//		  interface는 여러개 상속받을수 있다 ->개수제한없다
//		  상속받은 모든 추상메소드는 오버라이딩을 하여야한다.
public class InterfaceMain implements InterfaceTest1, InterfaceTest2 {

	public InterfaceMain() {

	}
	//추상메소드 오버라이딩
	public void output() {}
	public int sum() {
		return 5050;//1~100까지합
	}
	
	public void oddSum() {
		int sum=0;
		for(int i=1; i<=MAX; i+=2) {
			sum+=i;
		}
		System.out.println("1~"+MAX+"까지의 합은"+sum);
	}
	
	public int evenSum() {
		int sum=0;
		for(int i=2; i<=MAX; i+=2) {
			sum+=i;
		}
		return sum;
	}
	public void resultPrint(int data) {
		System.out.println("결과값="+data);
	}
	
	
	
	public void start() {
		resultPrint(sum());//합1~100 결과값은 505
		oddSum();//1~100까지 홀수합 2500
		resultPrint(evenSum());// 1~100 짝수합
	}
	public static void main(String[] args) {
		new InterfaceMain().start();
		
	}

}
