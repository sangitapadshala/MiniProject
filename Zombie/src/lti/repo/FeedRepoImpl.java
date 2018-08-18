package lti.repo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lti.bean.CommentBean;
import lti.entity.Comment;
import lti.entity.Feed;

@Repository
public class FeedRepoImpl implements FeedRepo {

	@Autowired
	private SessionFactory factory;

	@Override
	public void askQuestion(Feed feed) {
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		session.save(feed);
		txn.commit();
	}

	@Override
	public List<Feed> getMyFeeds(String userId) {
		Session session = factory.openSession();
		String hql = "from Feed where userId =:uid order by timefeed";
		return session.createQuery(hql).setParameter("uid", userId).list();
	}

	@Override
	public List<Feed> searchFeeds(String keyword) {
		return null;
	}

	@Override
	public Feed getQuestion(int fid) {
		Session session = factory.openSession();
		Feed feed = (Feed) session.get(Feed.class,fid);
		
		return feed;
	}

	@Override
	public Feed submitComment(Comment comment) {
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		session.save(comment);
		txn.commit();
		
		return comment.getFeed();
	}

}
