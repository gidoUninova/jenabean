package action;

import java.util.Collection;

import example.model.Post;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;

public class HubAction extends BaseAction {
	
	private Collection<Post> posts;
	
	@DefaultHandler
	public Resolution show() {
		posts = context.getReader().loadAll(Post.class);
		return new ForwardResolution("hub.jsp");
	}
	
	public Collection<Post> getPosts() {
		return posts;
	}
	
}
