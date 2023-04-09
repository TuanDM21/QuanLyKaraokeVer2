package com.dmt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dmt.model.Manager;
import com.dmt.service.ManagerService;

@Controller
public class ManagerController {

	@RequestMapping(value = "/LoginManager", method = RequestMethod.GET)
	public String loginCustomer() {
		return "LoginManager";
	}

	@RequestMapping(value = "/LoginManager", method = RequestMethod.POST)
	public String loginCustomer(@RequestParam("userName") String userName, HttpServletRequest request,
			@RequestParam("pswd") String password) {
		ManagerService service = new ManagerService();
		try {
			Manager manager = service.login(userName, password);
			if (manager == null) {
				request.setAttribute("LoginFail", 1);
				return "LoginManager";
			}
			HttpSession session = request.getSession();
			session.setAttribute("loginPersonM", manager);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/Product";
	}
	
	@RequestMapping(value = "/Product", method = RequestMethod.GET)
	public String Product() {
		return "Product";
	}

	@RequestMapping(value = "/register-manager", method = RequestMethod.GET)
	public String addNewCustomer() {
		return "RegisterManager";
	}

	@RequestMapping(value = "/register-manager", method = RequestMethod.POST)
	public String addNewCustomer(@RequestParam("userName") String userName, @RequestParam("password") String password,
			@RequestParam("fullName") String fullName, @RequestParam("email") String email,
			@RequestParam("phoneNumber") String phoneNumber, @RequestParam("address") String address,
			HttpServletRequest request) {

		ManagerService service = new ManagerService();
		try {
			service.addNewManager(userName, password, fullName, email, phoneNumber, address);
			request.setAttribute("checkFlag", 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "redirect:/Home";
	}

}
