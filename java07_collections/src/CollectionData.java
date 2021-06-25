import java.util.ArrayList;
import java.util.List;

public class CollectionData {

	public CollectionData() {
		// TODO Auto-generated constructor stub
	}
	public List<MemberVO> getMember() {
		//ArrayList에서사원정보를 담아서 리턴한다.
		// <> 안에 기입된 타입만 사용가능하게 만들수있다.
		//ArrayList<MemberVO> al = new ArrayList<MemberVO>();
		List<MemberVO> al2 = new ArrayList<MemberVO>();
		
		al2.add(new MemberVO("AAA","기획부","2021-05-10",5000));
		al2.add(new MemberVO("BBB","총무부","2021-01-01",6000));
		al2.add(new MemberVO("CCC","인사부","2021-10-10",7000));
		al2.add(new MemberVO("DDD","총무부","2021-02-02",5500));
		al2.add(new MemberVO("EEE","인사부","2021-03-02",6500));
		
		return al2;
	}
}
