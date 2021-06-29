
public class MethodTest2 {
	boolean power = false;	//	true:켜짐, false:꺼짐
//	채널
//		상수화
//		데이터형 왼쪽에 fianl을 표기
//		상수화된 변수는 모든변수명을 대문자로 표시한다.
	final int CHANNEL_MIN = 1;
	final int CHANNEL_MAX = 20;
	int channelNow = 11;

	public MethodTest2() {
	
	}
//	power버튼 누른 경우
//	반환형 메소드명(매개변수, 매개변수,.....){
//		실행문;//기능구현
//	}
//	일반 메소드는 소문자로 시작, 합성어일경우 두번째단어부터 대문자()가 있다
	void powerStart() {
		power = !power;
		
		/*
		 * if(power) { power = false; }else { power = true; }
		 */
		System.out.println("power="+power);
	}
//	단을 입력하면구구단을 구하여 반환하는 메소드를 생성
//	void : 반환형이 없다.
	String gugudan(int dan){
//		실행문 1개만 내보낸다.
		String result = "";
		for(int i=2; i<=9; i++) {
			result += dan+"*"+i+"="+dan*i+"\n";
		}
		return result;
	}
//	채널번호 올리기
	void channelUp() {
		if(channelNow == CHANNEL_MAX) {
			channelNow = CHANNEL_MIN;
		}else {
			channelNow++;
		}
		channelPrint();//현재클래스의 다른 메소드 호출
	}
//	채널번호 내리기
	void channelDown() {
		if(channelNow == CHANNEL_MIN) {
			channelNow = CHANNEL_MAX;
		}else {
			channelNow--;
		}
		channelPrint();//현재클래스의 다른 메소드 호출
	}
//	채널번호 출력하는 메소드
	void channelPrint() {
		System.out.println("채널번호:"+channelNow);
	}
//	static 키워드
	static void sum(int max) {
		int tot=0;
		for(int i=1; i<=max; i++) {
			tot+=i;
		}
		System.out.println("1~"+max+"의 합은"+ tot);
	}
	
}
