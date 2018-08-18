package lti.repo;

import java.util.List;

import lti.bean.CommentBean;
import lti.entity.Comment;
import lti.entity.Feed;

public interface FeedRepo {
	void askQuestion(Feed feed);

	List<Feed> getMyFeeds(String userId);

	List<Feed> searchFeeds(String keyword);
	
	Feed getQuestion(int fid);

	Feed submitComment(Comment comment);

}
