package shop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

//쿠폰생성 model 파일
public class coupon_insert {
	Connection con = null;
	PreparedStatement ps = null;
	String result;
	//DB정보 및 setter값을 받아서 insert
	
	//선택 삭제 기능
	public void coupon_delete_check(BasicDataSource dbinfo, String ck[]) {
		try {
			this.con = dbinfo.getConnection();
			String sql = "delete from event where cidx=?";
			this.ps = this.con.prepareStatement(sql);
			for(int i = 0 ; i < ck.length ; i++) {
				this.ps.setString(1, ck[i]);
				this.ps.executeUpdate();
			}
			this.result="Y";
		}catch(Exception e) {
			this.result="N";
			System.out.println(e);
		}
	}
	
	//삭제 기능 추가
	public void coupon_delete(BasicDataSource dbinfo, int cidx) {
		try {
			this.con = dbinfo.getConnection();
			String sql = "delete from event where cidx=?";
			this.ps = this.con.prepareStatement(sql);
			this.ps.setInt(1, cidx);
			this.ps.executeUpdate();
			this.result = "Y";
		}catch(Exception e) {
			this.result="N";
			System.out.println(e);
			System.out.println("db 쿼리문 오류 발생");
		}finally {
			try {
				this.ps.close();
				this.con.close();
			} catch (SQLException e) {
			}
			
		}
	}
	
	
	public coupon_insert(BasicDataSource dbinfo, coupon_dao dao){
		try {
			this.con = dbinfo.getConnection();
			String sql = "insert into event value('0',?,?,?,?,now())";
			this.ps = this.con.prepareStatement(sql);
			this.ps.setString(1, dao.getCpname());
			this.ps.setInt(2, dao.getCprate());
			this.ps.setString(3, dao.getCpuse());
			this.ps.setString(4, dao.getCpdate());
			this.ps.executeUpdate();
			this.result = "Y";
			this.ps.close();
			this.con.close();
		}catch(Exception e) {
			
			this.result = "N";
		}
	}
	
	public String result() {	
		return result;
	}
}
