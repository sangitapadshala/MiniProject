package lti.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "feeds")
@SequenceGenerator(name = "sf", sequenceName = "seq_feed")
public class Feed {
	@Id
	@GeneratedValue(generator = "sf")
	private int feedId;
	private String question;
	private Date timefeed;
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user1;
	@OneToMany(mappedBy = "feed", cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<Comment> comment = new HashSet<Comment>();

	@Formula("(select count(*) from comments c where c.feedId=feedId)")
	private int totalCmnts;

	public int getTotalCmnts() {
		return totalCmnts;
	}

	public void setTotalCmnts(int totalCmnts) {
		this.totalCmnts = totalCmnts;
	}

	public User getUser() {
		return user1;
	}

	public void setUser(User user) {
		this.user1 = user;
	}

	public Set<Comment> getComment() {
		return comment;
	}

	public void setComment(Set<Comment> comment) {
		this.comment = comment;
	}

	public int getFeedid() {
		return feedId;
	}

	public void setFeedId(int feedid) {
		this.feedId = feedid;
	}

	public String getQuestion() {
		return question;
	}

	public Date getTimefeed() {
		return timefeed;
	}

	public void setTimefeed(Date timefeed) {
		this.timefeed = timefeed;
	}

	public int getFeedId() {
		return feedId;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
}
