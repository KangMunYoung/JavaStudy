import java.util.List;

public class ArrayListTest {

	public ArrayListTest() {
		CollectionData data = new CollectionData();
		List<MemberVO> lst = data.getMember();
		MemberVO vo2 = new MemberVO("zzz","????????","2020-05-01",30000);
		lst.add(2, vo2);
		
		lst.remove(1); // index?? ????
		lst.remove(vo2); //????????? ????
		for(int i=0; i<lst.size(); i++) {
			MemberVO vo = lst.get(i);
			vo.memberPrint();
		}
	}

	public static void main(String[] args) {
		new ArrayListTest();

	}

}
