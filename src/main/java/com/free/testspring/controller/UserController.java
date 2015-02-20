package com.free.testspring.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.free.testspring.domain.Role;
import com.free.testspring.domain.User;
import com.free.testspring.services.ITestService;
import com.free.testspring.utils.RolePropertyEditor;

@Controller
@RequestMapping("/user")
public class UserController {

	private static List<User> userList;
	private static List<Role> roleList;
	private static Map<Long, Role> roleMap;

	@Inject
	private ITestService testService;
	
	public UserController() {
		if (roleList == null) {
			roleList = new ArrayList<Role>();
			roleMap = new HashMap<Long,Role>();
			String[] roleArr = new String[] { "ROLE_VIEW", "ROLE_ADMIN",
					"ROLE_BE", "ROLE_TL", "ROLE_TEST" };
			Role role = null;
			for (int i = 0; i < roleArr.length; i++) {
				role = new Role();
				role.setName(roleArr[i]);
				role.setRemark(roleArr[i]);
				role.setId(i + 1);
				roleList.add(role);
				roleMap.put(role.getId(), role);
			}
		}

		if (userList == null) {
			User user = null;
			userList = new ArrayList<User>();
			for (int i = 0; i < 20; i++) {
				user = new User();
				user.setId(i + 1);
				user.setCreateDate(new Date());
				user.setName("name" + i);
				user.setRealName("realName" + i);
				user.setPasswd("passwd" + i);
				userList.add(user);
			}
		}
	}

	@InitBinder
	public void initBind(WebDataBinder binder){
		binder.registerCustomEditor(Role.class, new RolePropertyEditor(roleMap));
//		binder.addValidators(validators);
	}
	
	@RequestMapping("/list")
	public String list(ModelMap map) {
		map.addAttribute("personList", userList);

		return "user/list";
	}
	
	@RequestMapping("/list/{id}")
	public String listValue(ModelMap map) {
		map.addAttribute("personList", userList);

		return "user/list";
	}

	@RequestMapping("/create")
	public String create(ModelMap map) {
		map.addAttribute("person", new User());
		map.addAttribute("roleList", roleList);

		return "user/create";
	}

	@RequestMapping("/save")
	public String save(@ModelAttribute("person") @Valid User person,
			BindingResult result, ModelMap map, RedirectAttributes redirectAttr) {
//		result.addError(new ObjectError("version","version22 is failure"));
//		result.addError(new ObjectError("version", new String[]{"ds"}, null, "verwwewr"));
		if (result.hasErrors()) {
			map.addAttribute("person", person);
			map.addAttribute("roleList", roleList);
			return "user/create";
		} else {
			redirectAttr.addAttribute("message", "testmessage");
			return "redirect:/user/list";
		}
		
	}
}
