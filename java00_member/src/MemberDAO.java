import java.util.ArrayList;
import java.util.List;

public class MemberDAO extends DBCON {

	public MemberDAO() {

	}
	// 회원전체선택
	public List<MemberVO> allRecord() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			//1.db연결
			dbConn();
			String sql = "select mem_no, username, tel, email, addr, "
					+ "to_char(write_date,'YYYY-MM-DD') write_date from member order by username asc";
			//2. preparestatement생성
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setMem_no(rs.getInt(1));
				vo.setUsername(rs.getNString(2));
				vo.setTel(rs.getString(3));
				vo.setEmail(rs.getString(4));
				vo.setAddr(rs.getString(5));
				vo.setWrite_date(rs.getString(6));
				list.add(vo);
				
			}
		}catch(Exception e) {
			System.out.println("전체회워선택 에러 발생");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return list;
	}
	// 회원추가
	public int insertRecord(MemberVO vo) {
		int cnt=0;
		try {
			dbConn();
			String sql = "insert into member(mem_no, email, addr, username, tel ) values(mem_sq.nextval, ?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getEmail());
			pstmt.setString(2, vo.getAddr());
			pstmt.setString(3, vo.getUsername());
			pstmt.setString(4, vo.getTel());
			
			cnt = pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("회원추가에러 발생");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return cnt;
	}
	// 회원수정             번호,연락처,이메일,주소
	public int updateRecord(MemberVO vo) {
		int cnt=0;
		try {
			dbConn();
			
			String sql = "update member set tel=?, email=?, addr=? where mem_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTel());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getAddr());
			pstmt.setInt(4, vo.getMem_no());
			
			cnt = pstmt.executeUpdate();
			
			
		}catch(Exception e) {
			System.out.println("회원수정 에러 발생");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return cnt;
	}
	// 회원삭제
	// 검색
	
}
