package com.yicheng.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.yicheng.pojo.User;
import com.yicheng.service.UserService;
import com.yicheng.util.GenericResult;
import com.yicheng.util.ResultCode;
import com.yicheng.util.UserInfoStorage;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/", "/Login" }, method = RequestMethod.GET)
	public ModelAndView loginView(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		return new ModelAndView("login", null);
	}

	@RequestMapping(value = { "/Login" }, method = RequestMethod.POST)
	public void login(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		if (StringUtils.isBlank(name) || StringUtils.isBlank(password)) {
			response.sendRedirect(request.getContextPath() + "/Login");
			return;
		}

		name = name.trim();
		password = password.trim();
		GenericResult<User> userResult = userService.getByNameAndPassword(
				name, password);
		if (userResult.getResultCode() == ResultCode.NORMAL) {
			User user = userResult.getData();
			String sessionId = request.getSession(true).getId();
			UserInfoStorage.putUser(sessionId, user);
			response.sendRedirect(request.getContextPath() + "/Home");
			return;
		} else {
			response.sendRedirect(request.getContextPath() + "/Login");
			return;
		}

	}

	@RequestMapping(value = { "/Logout", "/logout" })
	public void logout(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		UserInfoStorage.removeUser(request.getSession(true).getId());
		response.sendRedirect(request.getContextPath() + "/Login");
		return;
	}
}