
public class Login {
	private final String USERID = "admin";
	private final String USERPWD = "1234";
	public Login() {
	}
	//login check 구현(true : 로그인성공, false:로그인실패)
	public boolean loginCheck(String userid, String userpwd) {
		if(userid.equals(USERID) && userpwd.equals(USERPWD)) {
			//로그인 성공
			return true;
		}else {
			//로그인 실패
			return false;
		}
	}

}
