package action;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.hp.hpl.jena.ontology.OntModel;

import example.StripesContext;
import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;

public class BaseAction implements ActionBean {
	protected StripesContext context;
	
	public OntModel m() {
		return (OntModel)context.getServletContext().getAttribute("model");
	}
	
	@Override
	public StripesContext getContext() {
		return context;
	}

	@Override
	public void setContext(ActionBeanContext c) {
		context = (StripesContext)c;
	}

	protected String hashPassword(String s) throws NoSuchAlgorithmException {
		MessageDigest md;
		md = MessageDigest.getInstance("SHA-1");
		md.update(s.getBytes());
		return Hex.toHex(md.digest());
	}
}
