
public class MemberVO {
	// 1개의 레코드를 보관할 변수를 선언하는 클래스
	// 멤버변수는 캡슐화한다.
	private String name;
	private String depart;
	private String hire;
	private int sal;
	
	public MemberVO() {
		
	}
	
	public MemberVO(String name, String depart, String hire, int sal) {
		this.name = name;
		this.depart = depart;
		this.hire = hire;
		this.sal = sal;
	}
	
	//캡슐화된멤버를 접근할 메소든
	//규칙임		set멤버변수명	반듯이이렇게 해야함
	public void setName(String name) {	//	setter
		this.name = name;
	}
	public String getName() {		//getter
		return name;
	}
	
	public void setDepart(String depart) {
		this.depart = depart;
	}
	public String getDepart() {
		return depart;
	}
	
	public void setHire(String hire) {
		this.hire = hire;
	}

	public String getHire() {
		return hire;
	}
	
	public void setSal(int sal) {
		this.sal = sal;
	}
	
	public int getSal() {
		return sal;
	}
	///////////////////////////////////////
	//출력메소드
	public void memberPrint() {
		System.out.println("이름="+name);
		System.out.println("부서명="+depart);
		System.out.println("입사일="+hire);
		System.out.println("임금="+sal);
		System.out.println();
	}
	//상위클래스인 Object의 toString()매소드를 오버라이딩
	public String toString() {
		String memberData = name+", "+depart+", "+hire+", "+sal;
		return memberData;
	}
	
	
	
}
