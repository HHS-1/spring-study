package api;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbcp.BasicDataSource;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class apiMain {
	@Autowired
	BasicDataSource dbinfo;
	PrintWriter pw = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	
	@CrossOrigin(origins="*")
	@ResponseBody
	@GetMapping(value = "/jq/test_ajax5.do", produces="application/json")
	public String rest_ajax5() throws Exception {

		Connection con = dbinfo.getConnection();
		String sql = "select * from user order by uidx desc";
		this.ps = con.prepareStatement(sql);		
		this.rs = this.ps.executeQuery();
		JSONArray ja = new JSONArray();
		JSONArray ja2 = new JSONArray();
		
		while(rs.next()) {
			ja.put(rs.getInt(1));
			ja.put(rs.getString(2));
			ja.put(rs.getString(4));
			ja.put(rs.getString(5));
			
			ja2.put(ja);
		}
		
		rs.close();
		ps.close();
		System.out.println(ja2.toString());
		return ja2.toString();
	}
	
	
	
	@CrossOrigin(origins="*")
	@GetMapping("/jq/test_ajax4.do")
	public String rest_ajax4(String keycode,HttpServletResponse res) throws Exception {
		this.pw = res.getWriter();
		try {
			if(keycode == "" || keycode == null || !keycode.equals("a1234")) {
				this.pw.print("인증키가 확인 되지 않습니다.");
			}else {
				Connection con = dbinfo.getConnection();
				String sql = "select * from event order by cidx desc";
				this.ps = con.prepareStatement(sql);
				this.rs = this.ps.executeQuery();
				String[] columns = {"cidx","cpname","cpuse","cpdate"};
				JSONObject jo = new JSONObject();
				JSONObject jo2 = new JSONObject();
				JSONArray ja = new JSONArray();
				while(this.rs.next()) {
					for(String c : columns) {
						jo.put(c, rs.getString(c));
					}
					ja.put(jo);
				}
				jo2.put("coupon", ja);
				System.out.println(jo2.toString());
				this.pw.print(jo2.toString());			
			}
		}catch(Exception e) {
			System.out.println(e);
			this.pw.print("error");
		}
		
		
		return null;
	}
	
	
	
	@CrossOrigin(origins="http://localhost:8080")
	@GetMapping(value="jq/rest_json3.do", produces="application/json")
	public String rest_json3(Model m, HttpServletResponse res) throws Exception {
		JSONObject jo = new JSONObject();
		JSONArray ja = new JSONArray(); 
		Object[][] pd = {
				{"선풍기",50000},
				{"치약", 5000},
		};
		String columns[] = {"product_nm", "product_money"};
		
		for(Object[] o : pd) {
			for(int f = 0 ; f < columns.length ; f++) {
				jo.put(columns[f], o[f]);
			}
		}
		ja.put(jo);
		String result = ja.toString();
		m.addAttribute("data",result);
		System.out.println(result);
		
		return "jq/rest_json3";
	}
	
	
	@GetMapping(value="jq/rest.json2.do", produces="application/json")
	public String rest_json2(Model m) throws Exception{
		String member[] = {"hong","park","kim"};
		JSONObject jo = new JSONObject();
		jo.put("member", member);
		String result = jo.toString();
		m.addAttribute("data", result);
		return "/jq/rest_json";
	}
	
	@GetMapping("json_make.do")
	public String json_make(HttpServletResponse res, HttpServletRequest req) {
		try {
			res.setContentType("text/html; charset=utf-8");
			this.pw = res.getWriter();
			String member[] = {"hong","park","kim"};
			JSONObject jo = new JSONObject();
			jo.put("member", member);
			String result = jo.toString();
			
			String url = req.getServletContext().getRealPath("/upload");
			System.out.println(url);
			FileWriter fw = new FileWriter(url + "data.json");
			fw.write(result);
			fw.flush();
			fw.close();
			this.pw.write("<script>alert('회원가입 완료');</script>");
		}catch(Exception e) {
			System.out.println(e);
			this.pw.write("<script>alert('error');</script>");
		}finally {
			this.pw.close();
		}
		return null;
	}
	
	@GetMapping("/jq/rest_json.do")
	public String rest_json(Model m, HttpServletResponse res) throws Exception {
		String member[] = {"hong","park","kim"};
		JSONObject jo = new JSONObject();
		jo.put("member", member);
		String result = jo.toString();
		m.addAttribute("data",result);
		return "/jq/rest_json";
	}
	
}
