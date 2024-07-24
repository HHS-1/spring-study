package api;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class notice_controller {
	PrintWriter pw = null;
	
	@Resource(name = "notice")
	private notice_model nm;
	
	@GetMapping("/notice/notice_del.do")
	public String notice_del() {
		
		return null;
	}
	
	@GetMapping("/notice/notice_list.do")
	public String notice_list(Model m,
			@RequestParam(defaultValue = "", required = false) String search_part,
			@RequestParam(defaultValue = "", required = false) String search_word) {
		List<notice_dao> result = null;
		try {
			if(search_part =="" && search_word == "") {
				result = this.nm.allData();
			}else {
				m.addAttribute("search_part",search_part);
				m.addAttribute("search_word",search_word);
				result = this.nm.allData(search_part,search_word);				
			}
			m.addAttribute("result",result); 		
		}catch(Exception e) {
			System.out.println(e);
		}
		

		return null;
	}
}	
