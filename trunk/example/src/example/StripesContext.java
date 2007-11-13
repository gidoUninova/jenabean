package example;

import thewebsemantic.Bean2RDF;
import thewebsemantic.RDF2Bean;
import example.model.User;
import net.sourceforge.stripes.action.ActionBeanContext;

public class StripesContext extends ActionBeanContext {
	
	
	public User getLogin() {
		return (User)getRequest().getSession().getAttribute(Constants.LOGIN);
	}

	public void setLogin(User u) {
		getRequest().getSession().setAttribute(Constants.LOGIN, u);
	}

	public RDF2Bean getReader() {
		return (RDF2Bean)getRequest().getSession().getAttribute(Constants.READER);
	}

	public Bean2RDF getWriter() {
		return (Bean2RDF)getRequest().getSession().getAttribute(Constants.WRITER);
	}
}
