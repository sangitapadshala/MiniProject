package lti.repo;

import lti.bean.ForgetBean;
import lti.bean.LoginBean;
import lti.entity.User;

public interface UserRepo {
	User authenticate(LoginBean login);

	boolean validate(ForgetBean forget);

	boolean changePassword(LoginBean change);

	boolean persist(User user);
}
