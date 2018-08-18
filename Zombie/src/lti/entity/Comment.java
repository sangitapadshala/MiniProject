package lti.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="comments")
@SequenceGenerator(name="sc",sequenceName="seq_cmnt")
public class Comment {
	@Id
	@GeneratedValue(generator="sc")
	private int commentId;
	private Date timefeed;
	@ManyToOne
	@JoinColumn(name="feedId")
	private Feed feed;
	@ManyToOne
	@JoinColumn(name="userId")
	private User user1;

	@Column(name="comments")
	private String comment;
	
	/*private String timestamp;*/
	
	
	public Feed getFeed() {
		return feed;
	}
	public void setFeed(Feed feed) {
		this.feed = feed;
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	
public User getUser1() {
		return user1;
	}
	public void setUser1(User user1) {
		this.user1 = user1;
	}
	//	public String getFeedId() {
//		return feedId;
//	}
//	public void setFeedId(String feedId) {
//		this.feedId = feedId;
//	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	/*public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	*/public Date getTimefeed() {
		return timefeed;
	}
	public void setTimefeed(Date timefeed) {
		this.timefeed = timefeed;
	}


}
