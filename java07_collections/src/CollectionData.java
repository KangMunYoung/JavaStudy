import java.util.ArrayList;
import java.util.List;

public class CollectionData {

	public CollectionData() {
		// TODO Auto-generated constructor stub
	}
	public List<MemberVO> getMember() {
		//ArrayList������������� ��Ƽ� �����Ѵ�.
		// <> �ȿ� ���Ե� Ÿ�Ը� ��밡���ϰ� ������ִ�.
		//ArrayList<MemberVO> al = new ArrayList<MemberVO>();
		List<MemberVO> al2 = new ArrayList<MemberVO>();
		
		al2.add(new MemberVO("AAA","��ȹ��","2021-05-10",5000));
		al2.add(new MemberVO("BBB","�ѹ���","2021-01-01",6000));
		al2.add(new MemberVO("CCC","�λ��","2021-10-10",7000));
		al2.add(new MemberVO("DDD","�ѹ���","2021-02-02",5500));
		al2.add(new MemberVO("EEE","�λ��","2021-03-02",6500));
		
		return al2;
	}
}
