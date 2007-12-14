package action;

import java.util.Collection;
import java.util.LinkedList;

import thewebsemantic.NotFoundException;
import static thewebsemantic.RdfBean.*;

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
	public Resolution show() throws NotFoundException {
		String pathInfo = context.getRequest().getPathInfo();
		if ( pathInfo.length() > 6) {
			postid = pathInfo.substring(6);		
			posts = new LinkedList<Post>();
			posts.add(load(Post.class, postid));
		} else {
			posts = load(Post.class);
			for (Post post : posts) post.fill();
		}
		return new ForwardResolution("/hub.jsp");
	}
	public Collection<Post> getPosts() {return posts;}
	public String getP() { return postid;}
	
}
