package api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("notice")
public class notice_model {

	@Resource(name="sqlSession2")
	private SqlSessionTemplate tm;
	
	public List<notice_dao> allData(){
		List<notice_dao> nd = new ArrayList<notice_dao>();
		nd = this.tm.selectList("noticeDB.notice_all");
		return nd;
	}
	//게시판 전체 게시물 메소드
	public List<notice_dao> allData(String search_part, String search_word){
		List<notice_dao> nd = new ArrayList<notice_dao>();
		Map<String, String> m = new HashMap<String, String>();
		m.put("search_part", search_part);
		m.put("search_word", search_word);
		nd = this.tm.selectList("noticeDB.notice_search",m);
		return nd;
	}
}
