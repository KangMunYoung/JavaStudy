import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapTest {

	public HashMapTest() {
		//Map interface를 상속받은 클래스는 key, value가 존재한다.
		//1. HashMap은 key와 value데이터를 저장한다
		//2. TreeMap은 key와 value데이터를 저장한다, key기준으로 정렬한다.
		
		
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(1, "홍길동");//객체추가
		hm.put(100, "세종대왕");
		hm.put(50, "이순신");
		hm.put(25, "장영실");
		hm.put(33, "유승룡");
		
		String name = hm.get(100); // int --> Integer
		System.out.println("100->"+name);
		
		//HashMap에서 Key목록을 구하여 set에 담아준다.
		Set<Integer> keyList = hm.keySet();
		
		Iterator<Integer> ii = keyList.iterator();
		while(ii.hasNext()) {
			int k = ii.next();
			System.out.println("key="+k+", value="+hm.get(k));
		}
		
		System.out.println("===============================================");
		HashMap<String, MemberVO> hm2 = new HashMap<String, MemberVO>();
		hm2.put("홍길동", new MemberVO("홍길동","기획부","2020-10-10", 5000));
		hm2.put("이순신", new MemberVO("이순신","총괄부","2020-01-01", 6000));
		hm2.put("장영실", new MemberVO("장영실","총무부","2020-07-08", 3000));
		hm2.put("세종대왕", new MemberVO("세종대왕","인사부","2020-02-01", 7000));
		hm2.put("유승룡", new MemberVO("유승룡","기획부","2020-03-05", 6000));
		
		System.out.println("======key를 이용 정보 얻어오기=======");
		String test = hm2.get("홍길동").getHire();
		System.out.println(test);
		//key목록 
		Set<String> memberKey = hm2.keySet();
		//Iterator
		Iterator<String> iii = memberKey.iterator();
		while(iii.hasNext()){
			String key = iii.next();
			MemberVO value = hm2.get(key);
			//System.out.println(value.toString());
			System.out.print(value.getName());
			System.out.print(", "+value.getDepart());
			System.out.print(", "+value.getHire());
			System.out.println(", "+value.getSal());
		}
		System.out.println("======value 이용 정보 얻어오기=======");
		Collection<MemberVO> values = hm2.values();
		
		Iterator<MemberVO> memberValue= values.iterator();
		while(memberValue.hasNext()) {
			MemberVO vo = memberValue.next();
			System.out.println(vo.toString());
		}
	}

	public static void main(String[] args) {
		new HashMapTest();
	}
}
