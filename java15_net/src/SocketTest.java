import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class SocketTest {

	public SocketTest() {

	}
	
	private void startClient() {
		// Socket(InetAddress, port)
		//InetAddress
		//port : 서버에서 open 된 port번호를 이용한다
		try {
			InetAddress ia = InetAddress.getByName("192.168.0.17");
			Socket s = new Socket(ia, 12000);//서버에 접속이됨
			
			//서버에서 보낸문자 받을 InputStream객체를 생성
			InputStream is = s.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			String inData = br.readLine();
			System.out.println("서버에서받은 문자-?>"+inData);
			
			//클라이언트가 서버로 문자 보내기
			OutputStream os =s.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			PrintWriter pw = new PrintWriter(osw);
			pw.println("client에서 보낸다123");
			pw.flush();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new SocketTest().startClient();
	}

}
