package action;

import java.rmi.server.UID;
import net.sourceforge.stripes.action.Before;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.HandlesEvent;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.controller.LifecycleStage;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidateNestedProperties;
import example.model.Post;

public class PostAction extends BaseAction {

	private Post post;
	private String[] tags = new String[0];
	private String tag;

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}

	@Before(LifecycleStage.EventHandling)
	public Resolution secure() throws Exception {
		return ( context.getLogin() == null) ?
			new RedirectResolution(LoginAction.class) : null;
	}

	@Before(LifecycleStage.BindingAndValidation)
	public void rehydrate() {
		String id = context.getRequest().getParameter("p");
		if (id != null)
			this.post = context.getReader().find(Post.class, id);
	}

	@DefaultHandler
	public Resolution start() {
		return new ForwardResolution("/post.jsp");
	}
	
	@HandlesEvent("tag")
	public Resolution addTag() {
		
		return new ForwardResolution("/post.jsp"); 
	}

	@HandlesEvent("post")
	public Resolution post() {
		if ( post.getId() == null) {
			post.setAuthor(context.getLogin());
			post.setId(new UID().toString());
		}
		context.getWriter().write(post);
		return new RedirectResolution(HubAction.class);
	}

	@ValidateNestedProperties({
        @Validate(field="title", required=true, maxlength=75, on = "post"),
        @Validate(field="content", required=true, maxlength=5000, on = "post")
    })
	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
}
