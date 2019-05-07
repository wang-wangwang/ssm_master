package com.oracle.web.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.oracle.web.bean.PageBean;
import com.oracle.web.bean.Monster;
import com.oracle.web.bean.School;
import com.oracle.web.bean.SubMonster;
import com.oracle.web.service.MonsterService;
import com.oracle.web.service.SchoolService;

@Controller
@Scope(value = "prototype")
public class MonsterHandler {

	@Autowired
	private MonsterService monsterService;

	@Autowired
	private SchoolService schoolService;

//	@RequestMapping(value = "/monsters/{pageNow}", method = RequestMethod.GET)
//	public String monsters(@PathVariable("pageNow")int pageNow, HttpServletRequest request) {
//		
//		//System.out.println(pageNow);
//		
//        int i = (pageNow - 1) * 5;
//
//		List<SubMonster> list = monsterService.Bypage(i);
//		
//		PageBean<SubMonster> pb = new PageBean<SubMonster>();
//		
//		int counts = monsterService.selectCounts();
//		
//		pb.setBeanList(list);
//		
//		pb.setCounts(counts);
//		
//		pb.setPageNow(pageNow);
//		
//		pb.setPageSize(5);
//		
//		//System.out.println(counts);
//		
//		System.out.println(pb);
//
//		request.setAttribute("pb", pb);
//
//		return "list";
//	}
	
	@RequestMapping(value = "/monsters/{pageNow}", method = RequestMethod.GET)
	public String monsters(@PathVariable("pageNow")int pageNow, HttpServletRequest request) {
		
        PageBean<SubMonster> pb = this.monsterService.selectAllByPageHelper(pageNow);

		request.setAttribute("pb", pb);
		
		System.out.println(pb);

		return "list";
	}

	@RequestMapping(value = "/addUI", method = RequestMethod.GET)
	public String addUI(HttpServletRequest req) {

		List<School> list = schoolService.list();
		
		//System.out.println(list);

		req.setAttribute("slist", list);

		return "add";

	}


	@RequestMapping(value = "/monster", method = RequestMethod.POST)
	public String add(Monster monster) {

		monsterService.save(monster);

		return "redirect:/monsters/1";

	}

	@RequestMapping(value = "/monster/{monsterId}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("monsterId") Integer id) {
		
		//System.out.println(id);

		Monster m = new Monster();

		m.setMonsterId(id);

		monsterService.delete(m);

		return "redirect:/monsters/1";

	}
	
	@RequestMapping(value = "/monster/{monsterId}", method = RequestMethod.GET)
	public String updateUI(@PathVariable("monsterId") Integer id, HttpSession session) {
		
		Monster monster = monsterService.queryOneMonster(id);
		
		//System.out.println(monster);
		
		session.setAttribute("m", monster);
		
		List<School> list = schoolService.list();
		
		System.out.println(list+"\t"+monster);

		session.setAttribute("slist", list);

		return "update";
		
	}
	
	@RequestMapping(value = "/monster", method = RequestMethod.PUT)
	public String update(Monster monster) {
		
		System.out.println(monster);

		monsterService.update(monster);

		return "redirect:/monsters/1";

	}

}
