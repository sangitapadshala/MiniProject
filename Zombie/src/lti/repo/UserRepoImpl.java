package lti.repo;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lti.bean.ForgetBean;
import lti.bean.LoginBean;
import lti.entity.User;

@Repository
public class UserRepoImpl implements UserRepo {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User authenticate(LoginBean login) {
		Session session = sessionFactory.openSession();
		User user = (User) session.get(User.class, login.getUserId());
		if (user != null && user.getPassword().equals(login.getPassword()))
			return user;
		else
			return null;
	}

	@Override
	public boolean validate(ForgetBean forget) {
		Session session = sessionFactory.openSession();
		User user = (User) session.get(User.class, forget.getUserId());
		if (user != null && user.getEmail().equals(forget.getEmail()))
			return true;
		else
			return false;
	}

	@Override
	public boolean changePassword(LoginBean change) {
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();
		
		try {
			User user = (User) session.get(User.class, change.getUserId());
			user.setPassword(change.getPassword());
			txn.commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			txn.rollback();
			return false;
		}
	}

	@Override
	public boolean persist(User user) {
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();
		try {
			session.save(user);
			txn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			txn.rollback();
			return false;
		}

	}

}
