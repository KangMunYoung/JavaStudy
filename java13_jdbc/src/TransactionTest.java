
public class TransactionTest extends DBConnection {

	public TransactionTest() {
		
		try {
			//a_bank - 5000 ���, b_bank : 5000�� �Ա�
			dbConn();
			
			//�ڵ� commit�����ϱ�			
			con.setAutoCommit(false);//true :�ڵ�Ŀ�� , false : �ڵ�Ŀ�� ����
			
			int abank = -5000, bbank = 5000;;
			
			//��ݰ���
			sql = "insert into a_bank(num, money) values(a_number.nextval, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, abank);
			int cnt = pstmt.executeUpdate();
			if(cnt>0) {
				System.out.println(Math.abs(abank) + "�� ��ݵǾ����ϴ�.");
			}else {
				System.out.println(Math.abs(abank) + "�� ����� �����߽��ϴ�.");
			}
			
			if(cnt>0)throw new Exception();
			
			//�Աݰ���
			sql = "insert into b_bank(num, money) values(b_number.nextval, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bbank);
			int cnt2 = pstmt.executeUpdate();
			if(cnt2>0) {
				System.out.println(Math.abs(bbank) + "�� �Ա޵Ǿ����ϴ�.");
			}else {
				System.out.println(Math.abs(bbank) + "�� �Ա� �����Ͽ����ϴ�.");
			}
			
			con.commit();
			
		}catch(Exception e) {
			try {
				con.rollback();
			}catch(Exception ee) {
				ee.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			dbClose();
		}
	}

	public static void main(String[] args) {
		new TransactionTest();
	}

}
