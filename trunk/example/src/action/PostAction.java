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

	@Before(LifecycleStage.EventHandling)
	public Resolution secure() throws Exception {
		return ( context.getLogin() == null) ?
			new RedirectResolution(LoginAction.class) : null;
	}

	@DefaultHandler
	public Resolution start() {
		return new ForwardResolution("/post.jsp");
	}

	@HandlesEvent("post")
	public Resolution post() {
		post.setAuthor(context.getLogin());
		post.setId(new UID().toString());
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
