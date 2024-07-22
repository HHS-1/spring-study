package api;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

//Mybatis를 이용하여 DAO + config,mapper.xml DB연결
@Controller
public class apiMain2 {

	SqlSession se = null;
	PrintWriter pw = null;
	
	@Inject
	private SqlSessionFactory sqlfact;
	
	@Resource
	private SqlSessionTemplate sqlSession;
	
	@GetMapping("/point_delete.do")
	public String point_delete(int uidx) {
		try {
			this.se = sqlfact.openSession();
			this.se.delete("datadb.point_delete", uidx);
			
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			this.se.close();
		}
		return "point_list";
	}
	
	@GetMapping("/point_person.do")
	public String point_persion(Model m, int uidx) {
		System.out.println(uidx);
		try {
			this.se = sqlfact.openSession();
			point_dao pd = this.se.selectOne("datadb.point_one", uidx);
			ArrayList<Object> onedata = new ArrayList<Object>();
			onedata.add(pd.getUidx());
			onedata.add(pd.getUid());
			onedata.add(pd.getUname());
			onedata.add(pd.getUpoin());
			onedata.add(pd.getUdate());
			System.out.println(onedata);
			
		}catch(Exception e) {
			System.out.println(e);
			System.out.println("DB연결 오류");
		}finally {
			this.se.close();
		}
		return null;
	}
	
	@GetMapping("/point_list.do")
	public String point_list(Model m) {
		List<point_dao> all = null;  // getter, setter로 이루어진 배열
		try {
			this.se = sqlfact.openSession();
			//selectList : 여러 개의 데이터를 dao 이용하여 출력하는 방식
			//selectOne : 하나의 데이터를 dao 이용하여 출력
			all = this.se.selectList("datadb.point_select");
			m.addAttribute("all", all);
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			this.se.close();
		}
		
		return null;
	}
	
	
	@PostMapping("/pointok.do")
	public String pointok(@ModelAttribute("point") point_dao dao, HttpServletResponse res) {

		try {
			this.se = sqlfact.openSession();
			this.se.insert("datadb.point_insert", dao);
			this.pw = res.getWriter();
			this.pw.print("<script>"
					+ "alert('정상적으로 지급 완료 되었습니다');"
					+ "location.href='./point_list.do';"
					+ "</script>");
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	@GetMapping("/test_insert.do")
	public String test_insert(cpdao dao) {
		try {
			dao.setCpname("2024년 연말정산 40% 할인");
			dao.setCprate(40);
			dao.setCpuse("Y");
			dao.setCpdate("2024-12-31");
			SqlSession se = this.sqlfact.openSession();
			se.insert("datadb.coupon_insert",dao);
			se.close();
		}catch(Exception e) {
			System.out.println("DataBase 연결 실패!!");
		}
		
		return null;
	}
}
