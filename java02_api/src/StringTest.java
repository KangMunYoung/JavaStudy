
public class StringTest {

	public StringTest() {
		// TODO Auto-generated constructor stub
	}
	
	public void start() {
		//			  0 1234
		String str1 = "����� ���� �ż�";
		String str2 = "����� ���� �ż�";
		String str3 = new String("����� ���� �ż�");
		String data = str3;
		
		byte[] byteData = {65,66,67,68}; // �ƽ�Ű�ڵ� -> ABCD
		String str4 = new String(byteData);
		
		char[] charData = {'X','Y','Z'}; // "XYZ"
		String str5 = new String(charData);
		
		int[] intData = {65,66,67,68,69,70};
		String str6 = new String(intData,2,3);
		
		System.out.println("byteData="+str4);
		System.out.println("charData="+str5);
		System.out.println("intData="+str6); // index 2���� 3���� ���ڷ� �����϶�
		
		if(str1 == str2) {
			System.out.println("����");
		}else {
			System.out.println("�ٸ���");
		}
		
		if(str1 == str3) {
			System.out.println("����!!!!");
		}else {
			System.out.println("�ٸ���!!!!");
		}
		
		if(str1.equals(str3)) {// ��ü�� ��ü�� �������� ���Ѵ�.
			System.out.println("����~~~~~");
		}else {
			System.out.println("�ٸ���~~~~~");
		}
		
		if(str3 == data) {
			System.out.println("����~~123~~~");
		}else {
			System.out.println("�ٸ���~~~123~~");
		}
		str3 = "����� ���α�";
		System.out.println(str3);
		System.out.println(data);
		
		char c = str1.charAt(2);//index��ġ�� ���� 1���� ���´�
		System.out.println("str1.charAt="+c);
		
		String result = str1 +str2;
		String result2 = str1.concat(str2);
		System.out.println(result);
		System.out.println(result2);
		
		//			           6
		String data2 = "Java String Test....";
		String data3 = "java string test....";
		
		if(data2.equals(data3)) {
			System.out.println("12����");
		}else {
			System.out.println("12�ٸ���");
		}
		
		if(data2.equalsIgnoreCase(data3)) {//��ҹ��� �������� ��
			System.out.println("1212312����");
		}else {
			System.out.println("1123122�ٸ���");
		}
		
		byte[] byteCode = data2.getBytes();
		for(byte b :byteCode) {
			System.out.println((char)b+"--> "+b);
		}
		
		int idx = data2.indexOf("t");//Ư�� ������ index��ġ�� ���Ѵ�.
		System.out.println("indexOf="+idx);
		
		int idx2 = data2.indexOf("t",10);//Ư�� ��ġ���� index��ġ�� ���Ѵ�.
		System.out.println("indexOf=>"+idx2);
		
		//Ư�����ڸ� �ڿ��� �˻��Ͽ� index�� ���Ѵ�.
		int idx3 = data2.lastIndexOf("t");
		System.out.println("lasteIndexOf-> "+idx3);
		
		System.out.println("length="+data2.length());
		
		//String data2 = 
		//Ư�����ڸ� �ٸ����ڷ� ����
		data2 = data2.replaceAll("a", "����");
		System.out.println("replaceAll=>"+data2);
		
		String data4 = "010-1234-5678";
		String[] tel = data4.split("-");
		for(int i=0; i<tel.length; i++) {
			System.out.println("tel["+i+"]"+tel[i]);
		}
		
		//substring : Ư�����ڿ����� 
		String tel1 = data4.substring(4);	// 1234-5678
		String tel2 = data4.substring(4, 8);
		System.out.println(tel1+"--"+tel2);
		
		//toCharArray(): ���ڿ��� char�迭�� �����ش�.
		char[] chardata2 = data2.toCharArray();
		for(char cc: chardata2) {
			System.out.println(cc);
		}
		
		//toLowerCase : �ҹ��ڷ�, toUpperCase : �빮�ڷ�
		String toLower = data3.toLowerCase();
		String toUpper = data3.toUpperCase();
		System.out.println(toLower+", "+toUpper);
		
		String data6 = "         Spring     FrameWork          ";
		// trim() : ���ڿ��� ���ʿ� ���鹮�� �����.
		String dataTrim = data6.trim();
		System.out.println("aa"+dataTrim+"bb");
		
		int num =1234;
		String s1 = num+"";//���� -> ����ȭ
		String s2 = String.valueOf(num);
		System.out.println(s1+1234);
		System.out.println(s2+5678);
		
		char[] aa = {'S','T','U'};
		// char�� String���� ���� �ϴ� ��.
		String sss= new String(aa);
		String sss2 = String.valueOf(aa);
		
		System.out.println(sss);
		System.out.println(sss2);
		
		String data7 = "Apple";
		String data8 = "apple";

//		int r1 = data7.compareToIgnoreCase(data8);	//	-32
//		int r2 = data8.compareToIgnoreCase(data7);	//	32
		//       65               97       
		int r1 = data7.compareTo(data8);	//	-32
		//			97				65
		int r2 = data8.compareTo(data7);	//	32
		
		System.out.println(r1+", "+r2);
		
		
		
		
	}
	

	public static void main(String[] args) {
		new StringTest().start();
	}

}
