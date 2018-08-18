package lti.ctrl;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lti.bean.ForgetBean;
import lti.bean.LoginBean;
import lti.entity.User;
import lti.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService service;

	@RequestMapping("login.do")
	public String checkLogin(LoginBean login, Map model, HttpSession session) {
		User user = service.authenticate(login);
		if (user != null) {
			session.setAttribute("User", user);
			return "dashboard";
		} else {
			model.put("Prompt", "User ID/Password is invalid");
			return "home";
		}
	}

	@RequestMapping("forget.do")
	public String forgetPass(ForgetBean forget, Map model, HttpSession session) {
		if (service.validate(forget)) {
			session.setAttribute("Id", forget.getUserId());
			return "change";
		} else {
			model.put("Invalid", "User ID & email does not match");
			return "forget";
		}
	}

	@RequestMapping("change.do")
	public String changePass(LoginBean change, Map model, HttpSession session) {
		change.setUserId((String) session.getAttribute("Id"));

		if (service.changePassword(change)) {
			model.put("Prompt", "Password successfully changed");
			return "home"; 

		} else {
			model.put("Invalid", "User ID/Password does not match");
			return "change";
		}

	}

	@RequestMapping("register.do")
	public String persist(User user, Map model, HttpSession session) {
		if (service.persist(user)) {
			model.put("Prompt", "Thank you for registration");
			return "home";
		} else {
			model.put("Invalid", "User ID already exist");
			return "register";
		}

	}

	@RequestMapping("logout.do")
	public String logout(Map model, HttpSession session) {

		session.invalidate();
		model.put("Prompt", "Logged out successfully");
		return "home";
	}

}
