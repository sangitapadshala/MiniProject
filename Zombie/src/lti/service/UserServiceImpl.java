package lti.service;

import java.util.Base64;
import java.util.Base64.Encoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lti.bean.ForgetBean;
import lti.bean.LoginBean;
import lti.entity.User;
import lti.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo repo;

	@Override
	public User authenticate(LoginBean login) {
		Encoder encoder = Base64.getEncoder();
		String encoded = encoder.encodeToString(login.getPassword().getBytes());
		login.setPassword(encoded);
		return repo.authenticate(login);

	}

	@Override
	public boolean validate(ForgetBean forget) {
		// movie encoding
		return repo.validate(forget);
	}

	@Override
	public boolean changePassword(LoginBean change) {
		// password encoding
		Encoder encoder = Base64.getEncoder();
		change.setPassword(encoder.encodeToString(change.getPassword().getBytes()));
		return repo.changePassword(change);
	}

	@Override
	public boolean persist(User user) {
		Encoder encoder = Base64.getEncoder();
		user.setPassword(encoder.encodeToString(user.getPassword().getBytes()));
		return repo.persist(user);

	}

}
