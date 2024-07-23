/*
 * package api; //point table => Module(select, insert...)
 * 
 * import java.util.ArrayList; import java.util.List;
 * 
 * import javax.annotation.Resource;
 * 
 * import org.mybatis.spring.SqlSessionTemplate; import
 * org.springframework.stereotype.Repository;
 * 
 * @Repository("pointmodule") //해당 module을 controller에서 호출받을 이름 public class
 * point_module {
 * 
 * //DB 연결
 * 
 * @Resource(name="template") private SqlSessionTemplate tm;
 * 
 * //한 명의 사용자 아이디에 대한 포인트 내역 //* selectList selectMap => 배열O / selectOne => 배열X
 * public point_dao one_list(int nidx){ point_dao data =
 * tm.selectOne("datadb.point_one",nidx);
 * 
 * return data; }
 * 
 * //전체 포인트 내역 public List<point_dao> all_list(){ List<point_dao> data = new
 * ArrayList<point_dao>(); //selectList로 데이터 전체를 가져옴 data =
 * tm.selectList("datadb.point_select");
 * 
 * return data; }
 * 
 * }
 */