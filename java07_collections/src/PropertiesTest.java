import java.util.Enumeration;
import java.util.Properties;

public class PropertiesTest {

	public PropertiesTest() {
		//Propertises컬렉션 : key value가 모두 String컬렉션이다.
		Properties prop = new Properties();
		
		//객체 추가
		prop.setProperty("네이버", "https://www.naver.com");
		prop.setProperty("네이트", "https://www.nate.com");
		prop.setProperty("다음", "https://www.daum.net");
		prop.setProperty("구글", "https://www.google.com");
		//getProperty() = 키를이용하여 객체 얻어오기
		
		System.out.println(prop.getProperty("다음"));
		
		//키 목록 전체 구하기
		Enumeration e = prop.propertyNames();
		
		while(e.hasMoreElements()) {//개체가 남아 있을 경우 ㄱ
			//Object obj = e. nextElement();
			String str = (String)e. nextElement();
			System.out.println("key="+str+", "+prop.getProperty(str));
		}
		
	}

	public static void main(String[] args) {
		new PropertiesTest();

	}

}
