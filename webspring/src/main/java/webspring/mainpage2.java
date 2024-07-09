package webspring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	//Database연결(spring) 
	//1. XML형태의 DB연결, 2. properties + JSTL(legacy)
	/*[XML형태의 DB] - 라이브러리
	 * MysqlConnect/J
	 * spring-jdbc : @ 이용하여 Resource 형태로 구성
	 */
	//autowired 단점 : 외부 클래스를 호출하여 데이터베이스를 연결 시 오류 발생
	//autowired는 controller에서만 사용 가능함. (Model 안 됨)
	@Autowired //모든 메소드에 사용할 수 있는 객체 및 Bean을 사용할 수 있도록 의존성여부 실행
	BasicDataSource dbinfo; // database 접속정보 xml 파일 로드
	@GetMapping("/datalist.do")
	
	public String datalist() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = this.dbinfo.getConnection();
			String sql = "select count(*) as ctn from user";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			rs.next();
			System.out.println(rs.getString("ctn"));
		}catch(Exception e) {
			
			System.out.println("Database 접속오류");
		}
		return null;
	}
	
	//name값을 배열로 받을 경우 필수로 값을 받겠다라는 어노테이션을 사용하지 못함(required = true)
	/*datasource를 이용하여 해당 정보를 db에 insert 하시오.*/
	@RequestMapping(value="/memberok.do",method=RequestMethod.POST)
	public String memberok(@ModelAttribute("mb") member_dao dao) {	
		try {
			Connection con = dbinfo.getConnection();
			String sql = "insert into user values('0',?,?,?,now())";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dao.getUid());
			ps.setString(2, dao.getUpass());
			ps.setString(3, dao.getUname());
			int result = ps.executeUpdate();
			
			if(result > 0) System.out.println("db저장 성공");
			else System.out.println("저장 실패");
			
			}catch(Exception e) {
			System.out.println(e);
		}
		
		return null;
	}
}
