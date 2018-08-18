package lti.ctrl;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lti.entity.Comment;
import lti.entity.Feed;
import lti.entity.User;
import lti.service.FeedService;

@Controller
public class FeedController {
	@Autowired
	private FeedService service;

	@RequestMapping(value = "query.do", method = { RequestMethod.POST })
	public String askQuestion(@RequestParam("query") String query, Map model, HttpSession session) {
		Feed feed = new Feed();
		feed.setQuestion(query);
		User user = (User) session.getAttribute("User");
		feed.setUser(user);

		service.askQuestion(feed);
		model.put("Feeds", service.getMyFeeds(user.getUserId()));
		return "feeds";
	}

	@RequestMapping("feeds.do")
	public String showFeeds(Map model, HttpSession session) {
		User user = (User) session.getAttribute("User");
		model.put("Feeds", service.getMyFeeds(user.getUserId()));
		return "feeds";
	}
	
	@RequestMapping("question.do")
	public String showQuestion(@RequestParam("id") int fid,HttpSession session) {
		Feed feed = service.getQuestion(fid);
		session.setAttribute("Question", feed);
		return "response";
		
	}
	
	@RequestMapping(value="comment.do",method= {RequestMethod.POST})
	public String submitComment(@RequestParam("response")String response, HttpSession session) {
		Comment comment = new Comment();
		comment.setComment(response);
		comment.setFeed((Feed)session.getAttribute("Question"));
		comment.setUser1((User)session.getAttribute("User"));
		
		Feed feed = service.submitComment(comment);
		session.setAttribute("Question", feed);
		return "response";
		
		
	}
}
