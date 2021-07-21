import java.net.InetAddress;

public class InetAddressTest {

	public InetAddressTest() {
		//현재 내컴퓨터의 ip를 이용한 InetAddress객체 생성하기
		try {
			InetAddress ia1 = InetAddress.getLocalHost();
			
			String hostAddr1 = ia1.getHostAddress();
			String hostName1 = ia1.getHostName();
			System.out.println("hostAddr1 = "+hostAddr1);
			System.out.println("hostName1 = "+hostName1);
			
			//url 주소로 InetAddress 객체를 생성하면 ip, url정보를 객체가 가지고 있다.
			InetAddress nate = InetAddress.getByName("www.nate.com");
			System.out.println("nate->address-->"+nate.getHostAddress());
			System.out.println("nate->name-->"+nate.getHostName());
			
			InetAddress google = InetAddress.getByName("www.google.com");
			System.out.println("google->address-->"+ google.getHostAddress());
			System.out.println("google->name-->"+ google.getHostName());
			
			InetAddress nateIp = InetAddress.getByName("120.50.131.112");
			System.out.println("nateIp->address->"+ nateIp.getHostAddress());
			System.out.println("nateIp->name->"+ nateIp.getHostName());
			
			//InetAddress 전체 객체 구하기
			System.out.println("-------------------------------------------");
			InetAddress[] ip = InetAddress.getAllByName("www.daum.net");
			for(InetAddress ia:ip) {
				System.out.println("address--->"+ ia.getHostAddress());
				System.out.println("name------>"+ ia.getHostName()+"\n==================================");
				
			}
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}

	public static void main(String[] args) {
		new InetAddressTest();
	}

}
