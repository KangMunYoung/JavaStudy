import java.util.Enumeration;
import java.util.Properties;

public class PropertiesTest {

	public PropertiesTest() {
		//Propertises�÷��� : key value�� ��� String�÷����̴�.
		Properties prop = new Properties();
		
		//��ü �߰�
		prop.setProperty("���̹�", "https://www.naver.com");
		prop.setProperty("����Ʈ", "https://www.nate.com");
		prop.setProperty("����", "https://www.daum.net");
		prop.setProperty("����", "https://www.google.com");
		//getProperty() = Ű���̿��Ͽ� ��ü ������
		
		System.out.println(prop.getProperty("����"));
		
		//Ű ��� ��ü ���ϱ�
		Enumeration e = prop.propertyNames();
		
		while(e.hasMoreElements()) {//��ü�� ���� ���� ��� ��
			//Object obj = e. nextElement();
			String str = (String)e. nextElement();
			System.out.println("key="+str+", "+prop.getProperty(str));
		}
		
	}

	public static void main(String[] args) {
		new PropertiesTest();

	}

}
