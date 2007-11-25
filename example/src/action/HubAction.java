package action;

import java.util.Collection;
import java.util.LinkedList;

import example.model.Post;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;

@UrlBinding("/action/home")
public class HubAction extends BaseAction {
	
	private Collection<Post> posts;
	private String postid;

	@DefaultHandler
	public Resolution show() {
		if (postid != null) {
			Post p = context.getReader().find(Post.class, postid);
			posts = new LinkedList<Post>();
			posts.add(p);
		} else
			posts = context.getReader().loadAll(Post.class);
		return new ForwardResolution("/hub.jsp");
	}

	public Collection<Post> getPosts() {
		return posts;
	}

	public void setP(String id) {
		postid = id;
	}

	public String getP() { return postid;}
	
}
