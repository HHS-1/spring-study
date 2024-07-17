package shop;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class api_main {
	@Autowired
	BasicDataSource dbinfo;
	PrintWriter pw = null;
	
	@CrossOrigin(origins="*")
	@PostMapping("/ecma/ecma12ok.do")
	public String ecma12(@RequestBody String data, HttpServletResponse res) throws Exception {
		try {
			JSONArray ja = new JSONArray(data);
			System.out.println(ja);
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	@CrossOrigin(origins="*")
	@PostMapping("/ecma/ecma12object.do")
	public String ecma12object(@RequestBody String data, HttpServletResponse res) throws Exception {
		try {
			JSONObject ja = new JSONObject(data);
			System.out.println(ja);
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	@PostMapping("/ecma/ecma11ok.do")
	public String ecma11(@RequestBody String data, HttpServletResponse res) throws Exception {
		System.out.println(data);
		try {
			JSONObject ja = new JSONObject(data);
			System.out.println(ja.get("mid"));
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	//ecma ajax (GET 통신)
	@CrossOrigin(origins = "*")
	@PostMapping("/ecma/ecma9ok.do")
	public String ecma9(@RequestBody String mid, HttpServletResponse res) throws Exception {
		this.pw = res.getWriter();
		System.out.println(mid);
		this.pw.print("ok");
		if(mid == null) {
			this.pw.print("error");
		}
		
		return null;
	}
	
		
	
	@GetMapping("/ecma/ecma8ok.do")
	public String ecma8(@RequestParam String mid, HttpServletResponse res) throws Exception {
		this.pw = res.getWriter();

		if(mid == null) {
			this.pw.print("error");
		}
		try {
			Connection con = dbinfo.getConnection();
			String sql = "select count(*) from login where mid=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			ResultSet rs = ps.executeQuery();
			rs.next();
			if(rs.getInt("count(*)") > 0) {
				pw.print("no");
			}else {
				pw.print("ok");
			}
			
			rs.close();
			ps.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		this.pw.close();
		return null;
	}
	
	//스트리밍 CDN API
	@GetMapping("/youtube/{id}")
	public @ResponseBody byte[] youtube(@PathVariable String id, HttpServletRequest req) throws Exception {
		String url = req.getServletContext().getRealPath("/upload/");
		//URL에 있는 파라미터를 받아서 해당 동영상을 byte로 변환 하여 결과를 return
		String filename = url + id + ".mp4";
		InputStream is = new FileInputStream(filename);
		byte[] movie = IOUtils.toByteArray(is);
		is.close();

		return movie;
	}
	
	//CDN 유의사항 : 파일명이 같으며 속성이 다를 경우 오작동이 발생함
	//CDN API Service (@PathVariable : Mapping에 있는 파라미터 이름을 로드하여 변수로 변환하는 역할)
	@GetMapping("/images/{name:[0-9a-z]+}") //정규식 코드 형태로 구성 가능(이름이 숫자만, 문자만, 둘다)
	public @ResponseBody byte[] images(@PathVariable String name, HttpServletRequest req) throws Exception {
		String webpath = req.getServletContext().getRealPath("/upload/");
		String url = webpath+ name + ".jpg";
		InputStream is = new FileInputStream(url);
		//IOUtils => 파일 읽기, 쓰기를 사용할 수 있음
		byte[] imgurls = IOUtils.toByteArray(is); 
		is.close();
		return imgurls; //경로에 대한 이미지를 출력하는 역할
	}
	
	
	@GetMapping("/ecma/ecma7.do")
	public String ecma7(Model m, api_main_dao dao) throws Exception {
		
		try {
			Connection con = dbinfo.getConnection();
			String sql = "select * from movies order by midx desc";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ArrayList<ArrayList<Object>> all = new ArrayList<ArrayList<Object>>();
			
			int count = 0;
			while(rs.next()) {
				count = rs.getRow();
				dao.setMidx(rs.getInt(1));
				dao.setMsubject(rs.getString(2));
				dao.setCinema(rs.getString(3));
				dao.setTicketing(rs.getInt(4));
				dao.setScreen_date(rs.getString(5));
				all.add(dao.data());
			}
			m.addAttribute("all",all);
			m.addAttribute("count",count);
			rs.close();
			ps.close();
		}catch(Exception e) {
			m.addAttribute("error",e);
		}
		
		
		return null;
	}
	
	@PostMapping("/ecma/ecma6ok.do")
	public void ecma6(@ModelAttribute("dao") api_main_dao dao, HttpServletResponse res) throws Exception {
		this.pw = res.getWriter();
		res.setContentType("text/html; charset=utf-8");
		try {
			Connection con = dbinfo.getConnection();
			String sql = "insert into movies values ('0',?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dao.getMsubject());
			ps.setString(2, dao.getCinema());
			ps.setInt(3, dao.getTicketing());
			ps.setString(4, dao.getScreen_date());
			ps.executeUpdate();
			con.close();
			ps.close();
			this.pw.write("<script>"
					+ "alert('정상적으로 등록 완료되었습니다.');"
					+ "location.href='./ecma7.do';"
					+ "</script>");
		}catch(Exception e) {
			this.pw.write("<script>"
					+ "alert('DB오류발생');"
					+ "</script>");
		}
	}
}
