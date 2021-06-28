import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ObjectCompareTest {

	public ObjectCompareTest() {
		
		List<MemberVO> mem = new ArrayList<MemberVO>();
		
		mem.add(new MemberVO("홍길동","기획부","2020-10-10", 5000));
		mem.add(new MemberVO("이순신","총괄부","2020-01-01", 6000));
		mem.add(new MemberVO("장영실","총무부","2020-07-08", 3000));
		mem.add(new MemberVO("세종대왕","인사부","2020-02-01", 7000));
		mem.add(new MemberVO("유승룡","기획부","2020-03-05", 6000));
		mem.add(new MemberVO("김삿갓", "영업부", "2021-02-10", 5000));

		System.out.println("=====정렬전======================");
		//		: 컬렉션객체
		for(MemberVO vo : mem ) {
			System.out.println(vo.toString());
		}
		
		//
		System.out.println("=======급여를 오름차순으로 정렬==========");
		Collections.sort(mem, new CompareAscSal());
		for(MemberVO vo : mem) {
			System.out.println(vo.toString());
		}
		
		System.out.println("=======급여를 내림차순으로 정렬==========");
		Collections.sort(mem, new CompareDescSal());
		for(MemberVO vo : mem) {
			System.out.println(vo.toString());
		}
		
		System.out.println("-=====이름을 오름차순으로 정렬=========");
		Collections.sort(mem, new CompareAscName());
		for(MemberVO vo : mem) {
			System.out.println(vo.toString());
		}
		
		System.out.println("-=====이름을 내림차순으로 정렬=========");
		Collections.sort(mem, new CompareDescName());
		for(MemberVO vo : mem) {
			System.out.println(vo.toString());
		}
		
		System.out.println("======입사일 오름차순 정렬==========");
		Collections.sort(mem, new CompareAscHire());
		for(MemberVO vo : mem) {
			System.out.println(vo.toString());
		}
		System.out.println("======입사일 내림차순 정렬==========");
		Collections.sort(mem, new CompareDescHire());
		for(MemberVO vo : mem) {
			System.out.println(vo.toString());
		}
	}
	
	
	//정렬하는 클래스는 Comparator 인터페이스를 상속받아 만든
	// 숫자를 이용한 오름차순 정렬하는 클래스
	class CompareAscSal implements Comparator<MemberVO>{
		public int compare(MemberVO v1, MemberVO v2){	// 5000, 6000
			//삼항연산자 조건식
			//			왼쪽의 값이 작으면 -1(음수), 		왼쪽값이 크면 +1(양수),		같으면 0을 리턴
			// +1, -1, 0
			return (v1.getSal() < v2.getSal())? -1 : (v1.getSal() > v2.getSal())? 1: 0 ;
//			return (v1.getSal() < v2.getSal())? 1 : (v1.getSal() > v2.getSal())? -1: 0 ;
		}
	}
	
	//숫자를 이용한 내림차순 정렬하는 클래스
	class CompareDescSal implements Comparator<MemberVO>{
		public int compare(MemberVO v1, MemberVO v2) {
			//			왼쪽의 값이 작으면 1(양수), 			왼쪽값이 크면 -1(음수),		같으면 0을 리턴
			// +1, -1, 0
			return (v1.getSal() < v2.getSal())? 1 : (v1.getSal() > v2.getSal())? -1 : 0 ;
		}
	}
	//이름을 오름차순으로 정렬하는 클래스
	class CompareAscName implements Comparator<MemberVO>{
		public int compare(MemberVO v1, MemberVO v2) {
			//System.out.println(v1.getName()+", "+v2.getName()+"-->"+v1.getName().compareToIgnoreCase(v2.getName()));
			return v1.getName().compareToIgnoreCase(v2.getName());//
		}
	}
	//이름을 내림차순으로 정렬하는 클래스
	class CompareDescName implements Comparator<MemberVO>{
		public int compare(MemberVO v1, MemberVO v2) {
			return v2.getName().compareToIgnoreCase(v1.getName());
		}
	}
	//입사일 오름차순으로 정렬하는 클래스	
	class CompareAscHire implements Comparator<MemberVO>{
		public int compare(MemberVO v1, MemberVO v2) {
			//System.out.println(v1.getHire()+", "+v2.getHire()+"-->"+v1.getHire().compareToIgnoreCase(v2.getHire()));
			return v1.getHire().compareToIgnoreCase(v2.getHire());
		}
	}
	//입사일 내림차순으로 정렬하는 클래스	
	class CompareDescHire implements Comparator<MemberVO>{
		public int compare(MemberVO v1, MemberVO v2) {
			return v2.getHire().compareToIgnoreCase(v1.getHire());
		}
	}
	public static void main(String[] args) {
		new ObjectCompareTest();

	}

}
