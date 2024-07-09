package webspring;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class mainpage {

	
	//즉시실행 메소드는 Spring에서 사용하지 않음(Controller에서)
	
	//������ �� ������1
	@RequestMapping("/mainpage.do") //post, get
	//@PostMapping("/mainpage.do") post
	//@GetMapping("/mainpage.do") get
	// response를 사용시 JSTL을 사용하지 못함 일반 JSP를 사용해야 함 (model 사용하지 못함)
	// PrintWriter 사용시 response를 사용하며 해당 script를 활성화 시킵니다. 단, view페이지는 제작하지 않음
	public String main(HttpServletRequest req, Model m) {
		String search = req.getParameter("search");
		System.out.println(search);
		m.addAttribute("search",search);
		return "test"; // .jsp를 입력하지 않아도 됨 (webpage.xml에서 prefix, suffix 사용했으므로), null이면 mainpage.jsp
	}
	//기본적으로 spring Controller가 있으면 view를 찾음(.jsp)
	//void - jsp를 사용하지 않을 경우 script를 이용함
	@RequestMapping("/mainpage2.do")
	public void main2(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String mid = req.getParameter("mid");
		String mpass = req.getParameter("mpass");
		PrintWriter pw = res.getWriter(); //HttpServletResponse res는 printwriter 쓸 때만 씀
		res.setContentType("text/html; charset=utf-8");
		if(mid.equals("")) System.out.println("아이디 또는 비밀번호를 입력해주세요");
		else pw.write("<script>alert('로그인되셨습니다.')</script>");
	}
	
	//가상 웹 페이지3
	@RequestMapping("/mainpage3.do")
	public ModelAndView main3(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		String mid = req.getParameter("mid");
		String mpass = req.getParameter("mpass");
		mv.addObject(mid);
		mv.addObject(mpass);
		mv.setView(null); // null쓰면 mapping 주소 찾아감
		return mv; 
	}
	
	//가상 웹 페이지4
	@RequestMapping("/mainpage4.do")
	public ArrayList<Integer> main4(HttpServletRequest req, Model m) { //Integer,int,long,float 안됨
		String mid = req.getParameter("mid");
		String mpass = req.getParameter("mpass");
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(25);
		al.add(35);
		al.add(45);
		m.addAttribute("mid",mid);
		m.addAttribute("al",al);
		return null;
	}
	
}
