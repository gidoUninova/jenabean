package action;

import java.io.IOException;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.Resolution;

public class DumpAction extends BaseAction {
	@DefaultHandler
	public Resolution dump() throws IOException {
		m().write(context.getResponse().getWriter());
		return null;
	}
}
