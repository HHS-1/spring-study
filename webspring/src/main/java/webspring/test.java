package webspring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class test implements Controller {
	
	@GetMapping
	//POST, GET 모두 사용가능한 핸들러
@Override
public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

	//Attribute를 쉽게
	ModelAndView mv = new ModelAndView();
	
	String search = request.getParameter("search");
	System.out.println(search);
	
	String username="홍길동";
	int age = 33;
	//�ش� ���� ��,key �̸����� �迭���·� �߰� �� 
	mv.addObject("username",username);
	mv.addObject("userage",age);
	mv.setViewName("test.jsp");
	return mv;
	
}


}
