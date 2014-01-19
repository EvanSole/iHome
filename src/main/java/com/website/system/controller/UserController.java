package com.website.system.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.website.common.controller.BaseController;
import com.website.common.util.page.Page;
import com.website.system.model.User;
import com.website.system.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController {

	static Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	/***
	 * 默认登录页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String defaultView() {
		return "login";
	}

	/***
	 * 用户登录 GET
	 * 
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	/***
	 * 返回登录首页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/recover", method = RequestMethod.GET)
	public String recover() {
		return "login";
	}

	/**
	 * 用户登录 POST
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/login.do" }, method = RequestMethod.POST)
	public String login(HttpServletRequest request,
			HttpServletResponse response, String username, String password) {

		logger.info("User login......");

		Subject currentUser = SecurityUtils.getSubject();

		// 验证用户是否存在权限
		if (!currentUser.isAuthenticated()) {

			UsernamePasswordToken token = new UsernamePasswordToken(username,
					password);
			// 记录该令牌 ，如果不记录则类似购物车功能不能使用。
			token.setRememberMe(false);

			// Do some stuff with a Session (no need for a web or EJB
			// container!!!)
			Session session = currentUser.getSession();
			session.setAttribute("someKey", "aValue");
			String value = (String) session.getAttribute("someKey");
			if (value.equals("aValue")) {
				logger.info("Retrieved the correct vlaue!");
			}

			// let's login the current user so we can check against roles and
			// permissions:
			try {

				currentUser.login(token);

			} catch (UnknownAccountException ex) {
				logger.info("There is no user with username of "
						+ token.getPrincipal());
				return "login";
			} catch (IncorrectCredentialsException ix) {
				logger.info("Password for account " + token.getPrincipal()
						+ " was incorrect!");
				return "login";
			} catch (LockedAccountException lx) {
				logger.info("The account for username "
						+ token.getPrincipal()
						+ " is locked. Please contact your administrator to unlock it.");
				return "login";
			} catch (AuthenticationException ax) {
				logger.info("authentication exception.messages:" + ax);
				return "login";
			} catch (Exception e) {
				e.printStackTrace();
				return "login";
			}

			logger.info("User [" + currentUser.getPrincipal()
					+ "] logged in successfully.");
			// test login role:
			if (currentUser.hasRole("administrator")) {
				logger.info("Welcome to the [" + token.getPrincipal()
						+ "] to login to the Administrator role!");
			} else {
				logger.info("Welcome to the [" + token.getPrincipal()
						+ "] to login to the ordinary role");
			}

			return "redirect:/admin";

		} else {
			return "login";
		}
	}

	/**
	 * 注销用户
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/logout.do" })
	public String logout() {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		logger.info("The user [" + subject.getPrincipal() + "'] logs out!");
		return "redirect:/login";
	}

	/**
	 * 用户添加
	 */
	@RequestMapping(value = { "/user/add" }, method = RequestMethod.POST)
	public String add(User user, Model model) {
		userService.insertUser(user);
		return "user/user_register";
	}

	/**
	 * 用户修改
	 */
	@RequestMapping(value = { "/user/update" }, method = RequestMethod.POST)
	@ResponseBody
	public Object update(User user, Model model) {
		userService.updateUser(user);
		logger.info("用户修改");
		HashMap<String, String> msg = new HashMap<String, String>();
		msg.put("msg", "true");
		return msg;
	}

	/**
	 * 用户列表
	 */
	@RequestMapping(value = { "/user/list" })
	public String userList(Page page, Model model) {
		return "admin/system/user/user_manager";
	}
}
