package lti.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.*;

@Entity
@Table(name = "zombie")
public class User {
	@Id
	@Column(length = 30)
	private String userId;
	@Column(length = 65)
	private String password;
	@Column(length = 60)
	private String email;
	@OneToMany(mappedBy = "user1", fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	private Set<Feed> feed = new HashSet<Feed>();

	@Formula("(select count(*) from feeds f where f.userId=userId)")
	private int totalFeeds;

	public int getTotalFeeds() {
		return totalFeeds;
	}

	public void setTotalFeeds(int totalFeeds) {
		this.totalFeeds = totalFeeds;
	}

	public Set<Feed> getFeed() {
		return feed;
	}

	public void setFeed(Set<Feed> feed) {
		this.feed = feed;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userid) {
		this.userId = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
