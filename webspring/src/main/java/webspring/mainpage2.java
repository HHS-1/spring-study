package webspring;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class mainpage2 {
	
	//@RequestMapping (value="가상의URL", method="RequestMethod.GET(POST)")
	@RequestMapping(value="/admin/adminok.do", method=RequestMethod.GET)
	public String adminok(HttpServletRequest req, Model m) {
		String pidx = req.getParameter("pidx");
		System.out.println(pidx);
		return null;
	}
	
	//form에서 name 값 전송 시 spring은 인자 값으로 모든 핸들링 가능
	//인자값에 사용한 name은 무조건 필수로 값을 전달 받아야 합니다.
	//RequestParm : 인자값에 적용하는 어노테이션이며, 값이 없을 경우 defaultValue를 이용하여 기본 default값을 적용할 수 있스빈다.
	//required = true (무조건  필수 name 사용  - 없으면에러), false(name유/무 - 없어도 에러X)
	@RequestMapping(value="/admin/telok.do", method=RequestMethod.POST)
	public String telok(@RequestParam(defaultValue = "N", required = false) String agree, 
			String tel, String email[]) {
		System.out.println(tel);
		System.out.println(Arrays.toString(email));
		System.out.println(agree);
		return null;
	}
}
