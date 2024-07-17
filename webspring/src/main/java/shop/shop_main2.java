package shop;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.Thread;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class shop_main2 {
	
	
	//PathVariable : REST API URI에 변수값을 이용하여 해당 페이지를 로드하는 형태의 데이터 출력 방식
	/*
	 * API 서버 : REST, RESTful, CDN 의 차이가 뭐니
	 * */
	@GetMapping("/api/{id}")
	public String apiUrl(@PathVariable String id) {
		System.out.println(id);
		return null;
	}

	
	//ajax 동기 및 비동기 테스트 페이지
	//Spring ajax의 전송 데이터를 받을 경우, printWriter을 사용 시 View를 생성할 필요 없음 단,
	//미사용 시 무조건 view(.jsp)를 생성해야만 404에러를 방지
	@PostMapping("/ajaxok.do")
	public String ajaxok(String mid, HttpServletResponse res) throws Exception {
		PrintWriter pw = res.getWriter();
		System.out.println(mid);
		java.lang.Thread.sleep(5000);
		pw.write("ok");
		pw.close();
		return null;
	}
	
	
	//jstl.jsp 안에 있는 import 페이지에 해당 변수값 전달하기
	@GetMapping("/jstl7.do")
	public String jstl(Model m) {
		m.addAttribute("username","apink");
		return null;
	}
}
