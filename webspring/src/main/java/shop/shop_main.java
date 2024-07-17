package shop;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class shop_main {
	static int cidx = 0;
	@Autowired
	BasicDataSource dbinfo;

	PrintWriter pw = null;
	/*select에서만 사용함*/
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	//쿠폰 수정(select)
	@GetMapping("/coupon_modify1.do")
	public String coupon_modify1(int cidx, @ModelAttribute("coupon") coupon_dao dao, Model m) throws Exception {
		coupon_update cu = new coupon_update();
		cu.select_one(dbinfo, dao, cidx);
		System.out.println(dao.list());
		m.addAttribute("info", dao.list());
		return null;
	}
	
	//쿠폰 수정(update)
		@PostMapping("/coupon_modify2.do")
		public void coupon_modify2(int cidx, @ModelAttribute("coupon") coupon_dao dao, HttpServletResponse res) throws Exception {
			res.setContentType("text/html; charset=utf-8");
			coupon_update cu = new coupon_update();
			this.pw = res.getWriter();
			boolean update = cu.update_coupon(cidx, dbinfo, dao);
			if(update == true) {
				this.pw.write("<script>"
						+ "alert('수정완료');"
						+ "location.href='./coupon_list.do';"
						+ "</script>");
			}else {
				this.pw.write("<script>"
						+ "alert('수정실패');"
						+ "history.go(-1);"
						+ "</script>");
			}

		}
	
	
	
	//쿠폰 선택삭제
	@PostMapping("/coupon_del_ck.do")
	public void coupon_del_ck(String ck[], HttpServletResponse res) throws Exception{
		res.setContentType("text/html; charset=utf-8");
		coupon_insert ci = new coupon_insert(null,null);
		ci.coupon_delete_check(dbinfo, ck);
		String callback = ci.result();
		this.pw = res.getWriter();
		if(callback == "Y") {
			this.pw.write("<script>"
					+ "alert('선택 삭제 완료');"
					+ "location.href='./coupon_list.do';"
					+ "</script>");
		}else {
			this.pw.write("<script>"
					+ "alert('선택 삭제 실패');"
					+ "</script>");
		}
	}
	
	
	
	
	//쿠폰 삭제
	@GetMapping("/coupon_del.do")
	public void coupon_del(int cidx, HttpServletResponse res) throws Exception{
		res.setContentType("text/html; charset=utf-8");
		coupon_insert ci = new coupon_insert(null, null);
		ci.coupon_delete(dbinfo,cidx);
		String callback = ci.result();
		
		this.pw = res.getWriter();
		if(callback == "Y") {
			this.pw.write("<script>"
					+ "alert('삭제완료');"
					+ "</script>");
		}else {
			this.pw.write("<script>"
					+ "alert('삭제실패');"
					+ "history.go(-1);"
					+ "</script>");
		}
	}
	
	
	//쿠폰 리스트 (M : dao, C:coupon_list, C:jstl)
	@GetMapping("/coupon_list.do")
	public String coupon_list(Model m) throws Exception {
		try {
			this.con = dbinfo.getConnection();
			String sql = "select cidx,cpname,cprate,cpuse from event order by cidx desc";
			this.ps = this.con.prepareStatement(sql);
			this.rs = this.ps.executeQuery();
			coupon_dao cd = new coupon_dao();
			ArrayList<ArrayList<Object>> all = new ArrayList<ArrayList<Object>>(); 
			int ctn = 0;
			while(this.rs.next()) {
				ctn = this.rs.getRow();
				cd.setCidx(Integer.parseInt(this.rs.getString(1)));
				cd.setCpname(this.rs.getString(2));
				cd.setCprate(Integer.parseInt(this.rs.getString(3)));
				cd.setCpuse(this.rs.getString(4));
				all.add(cd.list());
			}
			//View(JSTL로 해당 데이터를 이관)
			//data 총 개수
			m.addAttribute("ctn",ctn);
			//데이터 리스트 배열
			m.addAttribute("all_list",all);

		}catch(Exception e) {
			System.out.println("DB 연결오류 발생!");
		}finally {
			this.rs.close();
			this.con.close();
		}
		
		return null;
	}
	
	
	
	
	
	@RequestMapping(value="/coupon_writeok.do", method=RequestMethod.POST)
	public void coupon_writeok(@ModelAttribute("coupon") coupon_dao dao, HttpServletResponse res) throws Exception {
		res.setContentType("text/html; charset=utf-8");
		
		//Model에서 데이터를 insert 시키며 결과값을 return 받아서 처리
		//데이터베이스 정보, dao 정보를 인자값으로 이관
		coupon_insert ci = new coupon_insert(dbinfo, dao);
		String callback = ci.result();
		this.pw = res.getWriter();
		
		if(callback.equals("Y")) {
			this.pw.write("<script>"
					+ "alert('정상적으로 쿠폰이 등록되었습니다.');"
					+ "location.href='./coupon_list.do';"
					+ "</script>");
		}
		else {
			this.pw.write("<script>"
					+ "alert('데이터 오류로 인하여 쿠폰이 등록되지 않았습니다.');"
					+ "history.go(-1);"
					+ "</script>");
		}
		
		
	}
	
	
	
}
