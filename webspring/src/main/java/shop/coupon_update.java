package shop;
//한 개의 데이터값 및 수정 model

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.commons.dbcp.BasicDataSource;


public class coupon_update {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	/*
	 * 1. DB데이터 1개 값을 dao로 setter 값에 적용 후 Controller에서 해당 배열을 Model 인터페이스로 -> View
	 * 2. 해당 Model('M'VC)에서 1차배열을 미리 만든 후 Controller로 return 후 Model(I)->View
	 * */
	
	//new를 사용하지 않을 경우 dao는 model과 controller 모두 동일한 값을 공유할 수 있음
	public void select_one(BasicDataSource dbinfo, coupon_dao dao, int cidx) throws Exception{
		try {
			this.con = dbinfo.getConnection();
			String sql = "select * from event where cidx=?";
			this.ps = this.con.prepareStatement(sql);
			this.ps.setInt(1, cidx);
			this.rs = this.ps.executeQuery();
			this.rs.next();
			dao.setCidx(this.rs.getInt(1));
			dao.setCpname(this.rs.getString(2));
			dao.setCprate(this.rs.getInt(3));
			dao.setCpuse(this.rs.getString(4));
			dao.setCpdate(this.rs.getString(5));
			dao.setIndate(this.rs.getString(6));
			
			
			
		}catch(Exception e) {
			System.out.println(e);
			System.out.println("error");
		}finally {
			this.rs.close();
			this.ps.close();
		}
	}
	
	public boolean update_coupon(int cidx, BasicDataSource dbinfo, coupon_dao dao) throws Exception{
		String columns[] = {"cpname","cprate","cpuse","cpdate"};
		Object datas[] = {dao.getCpname(), dao.getCprate(), dao.getCpuse(), dao.getCpdate()};
		try {
			this.con = dbinfo.getConnection();
			for(int i = 0 ; i < columns.length ; i++) {
				String sql = "update event set " + columns[i] + "=? where cidx=?";
				this.ps = this.con.prepareStatement(sql);
				this.ps.setString(1, String.valueOf(datas[i]));
				this.ps.setInt(2, cidx);
				this.ps.executeUpdate();
			}
			return true;
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
		
		
	}
	
}
