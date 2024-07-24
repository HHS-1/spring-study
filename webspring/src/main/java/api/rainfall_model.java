package api;

import java.util.List;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.json.JSONObject;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("rainfalls")
public class rainfall_model {
	
	@Resource(name="sqlSession")
	private SqlSessionTemplate tm;
	

	
	//날짜 중복 체크
	public String today_select(String today) {
		String result = tm.selectOne("datadb.today_select",today);
		return result;
	}
	
	//데이터 insert
	public int rain_insert(rainfall_dao dao) {
		//insert시 dao를 활용하여 setter 값을 mapper로 전달하여 저장합니다.
		
		int result = tm.insert("datadb.rain_insert",dao);
		return result;
	}
	
	//데이터 전체 select
	public List<String> rain_select(){
		return this.tm.selectList("datadb.rain_select");
	}
	
	//날짜별 데이터 select
	public List<rainfall_dao> data_select(String today){
		return this.tm.selectList("datadb.rainfall_select", today);
	}
	
	//강우량 수정
	public int data_modify(rainfall_dao data) {
		return this.tm.update("datadb.rainfall_update", data);
	}
}
