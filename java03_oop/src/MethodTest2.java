
public class MethodTest2 {
	boolean power = false;	//	true:����, false:����
//	ä��
//		���ȭ
//		�������� ���ʿ� fianl�� ǥ��
//		���ȭ�� ������ ��纯������ �빮�ڷ� ǥ���Ѵ�.
	final int CHANNEL_MIN = 1;
	final int CHANNEL_MAX = 20;
	int channelNow = 11;

	public MethodTest2() {
	
	}
//	power��ư ���� ���
//	��ȯ�� �޼ҵ��(�Ű�����, �Ű�����,.....){
//		���๮;//��ɱ���
//	}
//	�Ϲ� �޼ҵ�� �ҹ��ڷ� ����, �ռ����ϰ�� �ι�°�ܾ���� �빮��()�� �ִ�
	void powerStart() {
		power = !power;
		
		/*
		 * if(power) { power = false; }else { power = true; }
		 */
		System.out.println("power="+power);
	}
//	���� �Է��ϸ鱸������ ���Ͽ� ��ȯ�ϴ� �޼ҵ带 ����
//	void : ��ȯ���� ����.
	String gugudan(int dan){
//		���๮ 1���� ��������.
		String result = "";
		for(int i=2; i<=9; i++) {
			result += dan+"*"+i+"="+dan*i+"\n";
		}
		return result;
	}
//	ä�ι�ȣ �ø���
	void channelUp() {
		if(channelNow == CHANNEL_MAX) {
			channelNow = CHANNEL_MIN;
		}else {
			channelNow++;
		}
		channelPrint();//����Ŭ������ �ٸ� �޼ҵ� ȣ��
	}
//	ä�ι�ȣ ������
	void channelDown() {
		if(channelNow == CHANNEL_MIN) {
			channelNow = CHANNEL_MAX;
		}else {
			channelNow--;
		}
		channelPrint();//����Ŭ������ �ٸ� �޼ҵ� ȣ��
	}
//	ä�ι�ȣ ����ϴ� �޼ҵ�
	void channelPrint() {
		System.out.println("ä�ι�ȣ:"+channelNow);
	}
//	static Ű����
	static void sum(int max) {
		int tot=0;
		for(int i=1; i<=max; i++) {
			tot+=i;
		}
		System.out.println("1~"+max+"�� ����"+ tot);
	}
	
}
