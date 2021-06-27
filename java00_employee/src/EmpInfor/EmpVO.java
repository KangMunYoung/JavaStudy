package EmpInfor;

public class EmpVO {
	private String empNo;//占쏙옙占쏙옙占싫�
	private String empName;//占쏙옙占쏙옙占�
	private String tel;//占쏙옙占쏙옙처
	private int sal;//占쌨울옙
	private String hiredate;//占쌉삼옙占쏙옙
	
	public EmpVO() {
	
	}
	public EmpVO(String empNo, String empName, String tel, int sal, String hiredate) {
		this.empNo = empNo;
		this.empName = empName;
		this.tel = tel;
		this.sal = sal;
		this.hiredate = hiredate;
	}
	//占쏙옙占� 1占쏙옙 占쏙옙占� ==============================================
	public void empPrint() {
		System.out.printf("%-10s %-10s %-20s %-10d %-10s\n", empNo, empName, tel, sal, hiredate);
	}
	//타占쏙옙틀 占쏙옙占�
	public static void titlePrint() {
		System.out.printf("%-8s %-12s %-20s %-12s %-5s\n","占쏙옙占쏙옙占싫�", "占쏙옙占쏙옙占�", "占쏙옙占쏙옙처", "占쌨울옙", "占쌉삼옙占쏙옙");
		System.out.println("------------------------------------------------------------------");
	}
	
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	public String getEmpNo() {
		return empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	
}
