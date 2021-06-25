
public class StringTest {

	public StringTest() {
		// TODO Auto-generated constructor stub
	}
	
	public void start() {
		//			  0 1234
		String str1 = "서울시 마포 신수";
		String str2 = "서울시 마포 신수";
		String str3 = new String("서울시 마포 신수");
		String data = str3;
		
		byte[] byteData = {65,66,67,68}; // 아스키코드 -> ABCD
		String str4 = new String(byteData);
		
		char[] charData = {'X','Y','Z'}; // "XYZ"
		String str5 = new String(charData);
		
		int[] intData = {65,66,67,68,69,70};
		String str6 = new String(intData,2,3);
		
		System.out.println("byteData="+str4);
		System.out.println("charData="+str5);
		System.out.println("intData="+str6); // index 2부터 3개를 문자로 생성하라
		
		if(str1 == str2) {
			System.out.println("같다");
		}else {
			System.out.println("다르다");
		}
		
		if(str1 == str3) {
			System.out.println("같다!!!!");
		}else {
			System.out.println("다르다!!!!");
		}
		
		if(str1.equals(str3)) {// 객체와 객체가 같은지를 구한다.
			System.out.println("같다~~~~~");
		}else {
			System.out.println("다르다~~~~~");
		}
		
		if(str3 == data) {
			System.out.println("같다~~123~~~");
		}else {
			System.out.println("다르다~~~123~~");
		}
		str3 = "서울시 종로구";
		System.out.println(str3);
		System.out.println(data);
		
		char c = str1.charAt(2);//index위치의 문자 1개를 얻어온다
		System.out.println("str1.charAt="+c);
		
		String result = str1 +str2;
		String result2 = str1.concat(str2);
		System.out.println(result);
		System.out.println(result2);
		
		//			           6
		String data2 = "Java String Test....";
		String data3 = "java string test....";
		
		if(data2.equals(data3)) {
			System.out.println("12같다");
		}else {
			System.out.println("12다르다");
		}
		
		if(data2.equalsIgnoreCase(data3)) {//대소문자 구별없이 비교
			System.out.println("1212312같다");
		}else {
			System.out.println("1123122다르다");
		}
		
		byte[] byteCode = data2.getBytes();
		for(byte b :byteCode) {
			System.out.println((char)b+"--> "+b);
		}
		
		int idx = data2.indexOf("t");//특정 문자의 index위치를 구한다.
		System.out.println("indexOf="+idx);
		
		int idx2 = data2.indexOf("t",10);//특정 위치부터 index위치를 구한다.
		System.out.println("indexOf=>"+idx2);
		
		//특정문자를 뒤에서 검색하여 index를 구한다.
		int idx3 = data2.lastIndexOf("t");
		System.out.println("lasteIndexOf-> "+idx3);
		
		System.out.println("length="+data2.length());
		
		//String data2 = 
		//특정문자를 다른문자로 변경
		data2 = data2.replaceAll("a", "에이");
		System.out.println("replaceAll=>"+data2);
		
		String data4 = "010-1234-5678";
		String[] tel = data4.split("-");
		for(int i=0; i<tel.length; i++) {
			System.out.println("tel["+i+"]"+tel[i]);
		}
		
		//substring : 특정문자열에서 
		String tel1 = data4.substring(4);	// 1234-5678
		String tel2 = data4.substring(4, 8);
		System.out.println(tel1+"--"+tel2);
		
		//toCharArray(): 문자열을 char배열로 구해준다.
		char[] chardata2 = data2.toCharArray();
		for(char cc: chardata2) {
			System.out.println(cc);
		}
		
		//toLowerCase : 소문자로, toUpperCase : 대문자로
		String toLower = data3.toLowerCase();
		String toUpper = data3.toUpperCase();
		System.out.println(toLower+", "+toUpper);
		
		String data6 = "         Spring     FrameWork          ";
		// trim() : 문자열의 양쪽에 공백문자 지운다.
		String dataTrim = data6.trim();
		System.out.println("aa"+dataTrim+"bb");
		
		int num =1234;
		String s1 = num+"";//숫자 -> 문자화
		String s2 = String.valueOf(num);
		System.out.println(s1+1234);
		System.out.println(s2+5678);
		
		char[] aa = {'S','T','U'};
		// char을 String으로 변경 하는 것.
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
