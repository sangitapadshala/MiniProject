import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import lti.entity.Comment;
import lti.entity.Feed;
import lti.entity.User;
import lti.util.HibernateUtil;

public class TestForum {
	@Test
	public void testSaveCustomer() {
		Session session = HibernateUtil.getSession();
		Transaction txn = session.getTransaction();
		 
		try {
			txn.begin();	 		//starting db transaction
			User user = new User();
			user.setUserId("iamsangita");
			user.setPassword("san123");
			user.setEmail("san123@gmail.com");
			
			session.save(user);		//saving customer object
			txn.commit();			//ending transaction with commit
		} catch (Exception e) {
			txn.rollback();			// transaction failed hence rollback
			e.printStackTrace();
		}
		
	}
	@Test
	public void testSaveCustomer2() {
		Session session = HibernateUtil.getSession();
		Transaction txn = session.beginTransaction();
		 
		try {
			Feed feed = new Feed();
			User user = (User)session.get(User.class, "iamsan");
			feed.setUser(user);
			feed.setTimefeed((new Date()));
			feed.setQuestion("What is your area of interest?");
			session.save(feed);		//saving customer object
			txn.commit();			//ending transaction with commit
		} catch (Exception e) {
			txn.rollback();			// transaction failed hence rollback
			e.printStackTrace();
		}
		
	}
	@Test
	public void testSaveCustomer3() {
		Session session = HibernateUtil.getSession();
		Transaction txn = session.getTransaction();
		 
		try {
			txn.begin();	 		//starting db transaction
			User user = (User) session.get(User.class, "iamsan");
			Feed feed = (Feed) session.get(Feed.class,301);
			Comment comment = new Comment();
			/*comment.setTimestamp(new Date());
			comment.setUser(user);
			*/comment.setFeed(feed);
			comment.setComment("JAVA");
			session.save(comment);		//saving customer object
			txn.commit();			//ending transaction with commit
		} catch (Exception e) {
			txn.rollback();			// transaction failed hence rollback
			e.printStackTrace();
		}
	}
}
