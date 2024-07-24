package api;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class apimain3 {
	
	//해당 프로젝트에 대한 module 호출 (@Repository)
	//@Resource(name = "pointmodule")
	//private point_module pm;	//해당 module을 필드에 객체생성 후 적용
	PrintWriter pw = null;
	
	@Resource(name = "rainfalls")
	private rainfall_model rm;
	
	//강우량 수정
	@PostMapping("/rainfall/rainfall_modify.do")
	public ResponseEntity<String> rainfall_modify(@RequestBody rainfall_dao data) {
		this.rm.data_modify(data);
		return null;
	}
	
	
	//날짜에 따른 강우량 select
	@GetMapping(value = "/rainfall/rainfall_select.do", produces = "application/json")
	@ResponseBody
	public String rainfall_select(@RequestParam String today) {
		System.out.println(today);
		JSONArray ja = new JSONArray(this.rm.data_select(today));
		System.out.println(ja);
		return ja.toString();
	}
	
	//강우량 날짜 select
	@GetMapping("/rainfall/rainfall_list.do")
	public String rainfall_list(Model m) throws Exception {
		m.addAttribute("data",this.rm.rain_select());
		return "/rainfall/rainfall_list";
	}
	
	//날짜 중복 검사
	@GetMapping("/rainfall/rainfall_check.do")
    @ResponseBody
	public String rainfall_check(@RequestParam String today) throws Exception {
        String checks = rm.today_select(today);
        return checks;
    }
	
	
	//통계데이터 관련 프로젝트 만들기 (쓰기, 출력, 수정, 삭제)
	@PostMapping("/rainfall/rainfall_writeok.do")
	public String rainfall_writeok(@ModelAttribute("fall") rainfall_dao dao, HttpServletResponse res) throws Exception {
		res.setContentType("text/html charset=utf-8");
		this.pw = res.getWriter();
		try {
			int callback = rm.rain_insert(dao);
			if(callback > 0) {
				this.pw.print("<script>"
						+ "alert('정상적으로 등록 완료되었습니다');"
						+ "location.href='./rainfall_list.do;"
						+ "</script>");
			}
		}catch(Exception e) {
			this.pw.print("<script>"
					+ "alert('DB 오류로 인하여 등록되지 않았습니다.');"
					+ "location.href='./rainfall_write.jsp;"
					+ "</script>");
			System.out.println(e);
		}finally {
			this.pw.close();
		}
		
		return null;
	}
	
	/*
	//데이터 한 개의 값을 가져오는 페이지
	@GetMapping("/point_one.do")
	public String point_one(Model m) {
		int nidx = 7;
		try {
			//selectOne으로 핸들링시 dao를 활용하여 데이터를 이관 받음
			point_dao result = pm.one_list(nidx);
			//샘플로 getter 함수 또는 dao에 변수값으로 출력
			System.out.println(result.getUname());	//result.uname
			m.addAttribute("result",result);
		}
		catch(Exception e) {
			System.out.println("Data Module Error");
		}
		
		return null;
	}
	
	//데이터 전체 리스트
	@GetMapping("/point_select.do")
	public String point_select(Model m) {
		try {
			List<point_dao> result = pm.all_list();
			m.addAttribute("result",result);
		}
		catch(Exception e) {
			System.out.println("Data Module Error");
		}
		
		return null;
	}*/
}
