package thewebsemantic.rules;

import com.hp.hpl.jena.graph.Node;
import com.hp.hpl.jena.reasoner.rulesys.BindingEnvironment;
import com.hp.hpl.jena.reasoner.rulesys.RuleContext;
import com.hp.hpl.jena.reasoner.rulesys.Util;
import com.hp.hpl.jena.reasoner.rulesys.builtins.BaseBuiltin;

/**
 * 
 */
public class XsdInteger extends BaseBuiltin {

	public String getName() {
		return "xsdInt";
	}

	public int getArgLength() {
		return 2;
	}

	public boolean bodyCall(Node[] args, int length, RuleContext context) {
		checkArgs(length, context);

		BindingEnvironment env = context.getEnv();
		Node n0 = getArg(0, args, context);
		if (Util.isNumeric(n0)) {
			return env.bind(args[1], n0);
		} else if (n0.isLiteral()) {
			Object v1 = n0.getLiteralValue();
			if (v1 instanceof String) {
				try {
					Node n = com.hp.hpl.jena.reasoner.rulesys.Util
							.makeLongNode(Long.valueOf(v1.toString()));
					return env.bind(args[1], n);
				} catch (NumberFormatException e) {
					return false;
				}
			}
		}
		return false;
	}

}
