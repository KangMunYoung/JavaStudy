import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLTest {

	public URLTest() {
		
		try {
			// url�ּ�(protocol, host(������), port, filename)���� �̿��Ͽ� ��ü�������ϸ�
			// �ش� ������ ���ҽ��� ���� �� �ִ�.
//			URL url = new URL("https://www.phoneppu.com/product/list.html?cate_no=1719");
			URL url = new URL("https://www.nate.com/");
			String protocol = url.getProtocol();
			String host = url.getHost();
			int port = url.getPort();
			String file = url.getFile();
			String path = url.getPath();
			
			System.out.println("protocol--> "+ protocol);
			System.out.println("host------> "+ host);
			System.out.println("port------> "+ port);
			System.out.println("file------> "+ file);//���+���ϸ�+������
			System.out.println("path------> "+ path);//���+���ϸ�
			
			//URLConnection��ü�� ���Ͽ� ��������� ���� �� �ִ�.
			URLConnection connection = url.openConnection();
			connection.connect();//���ä���� Ȯ���Ͽ��� ��������� ���ü� �ִ�.
			
			String type = connection.getContentType();//������� ���ϱ�
			System.out.println("content-type-->"+type);
			
			// �ڵ� ������
			int idx = type.indexOf("charset=");
			String encode = type.substring(idx+8);
			
			System.out.println("encode-> "+encode);
			//url��ü���� resource��������
			InputStream is =url.openStream();
			
			InputStreamReader isr = new InputStreamReader(is, encode);
			BufferedReader br = new BufferedReader(isr);
			
			while(true){
				String readData=br.readLine();
				if(readData == null)break;
				System.out.println(readData);
			}
			
			
		}catch(Exception e) {
			
		}
		
		
		
	}

	public static void main(String[] args) {
		new	URLTest();
	}

}
