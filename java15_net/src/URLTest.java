import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLTest {

	public URLTest() {
		
		try {
			// url주소(protocol, host(도메인), port, filename)등을 이용하여 객체를생성하면
			// 해당 서버의 리소스를 얻어올 수 있다.
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
			System.out.println("file------> "+ file);//경로+파일명+데이터
			System.out.println("path------> "+ path);//경로+파일명
			
			//URLConnection객체를 구하여 헤더정보를 얻어올 수 있다.
			URLConnection connection = url.openConnection();
			connection.connect();//통신채널을 확보하여야 헤더정보를 얻어올수 있다.
			
			String type = connection.getContentType();//헤더정보 구하기
			System.out.println("content-type-->"+type);
			
			// 코드 얻어오기
			int idx = type.indexOf("charset=");
			String encode = type.substring(idx+8);
			
			System.out.println("encode-> "+encode);
			//url객체에서 resource가져오기
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
