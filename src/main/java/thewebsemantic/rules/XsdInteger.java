package thewebsemantic.rules;

import java.text.NumberFormat;
import java.text.ParseException;

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
					NumberFormat f = NumberFormat.getInstance();
					Number num = f.parse(v1.toString());
					Node n = Util.makeLongNode(num.longValue());
					return env.bind(args[1], n);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			} 
		}
		return false;
	}

}
