package com.jmark.controller;

import java.util.List;






import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jmark.entity.User;
import com.jmark.service.UserService;
import com.jmark.utils.Pager;
@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Resource private UserService userService;
	@RequestMapping(value="/list")
	public void list(@RequestParam(value="current",defaultValue="1")Integer current,Model model) {
		System.out.println(current);
		/*List<User> list = null;
		Pager pager = new Pager();
		pager.setCurrentPage(current);
		list = userService.findUserByPager(pager);
		model.addAttribute("pager", pager);
		model.addAttribute("list", list);*/
	}
}
