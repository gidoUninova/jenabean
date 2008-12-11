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

	/**
	 * Return a name for this builtin, normally this will be the name of the
	 * functor that will be used to invoke it.
	 */
	public String getName() {
		return "xsdInt";
	}

	/**
	 * Return the expected number of arguments for this functor or 0 if the
	 * number is flexible.
	 */
	public int getArgLength() {
		return 2;
	}

	/**
	 * This method is invoked when the builtin is called in a rule body.
	 * 
	 * @param args
	 *            the array of argument values for the builtin, this is an array
	 *            of Nodes, some of which may be Node_RuleVariables.
	 * @param length
	 *            the length of the argument list, may be less than the length
	 *            of the args array for some rule engines
	 * @param context
	 *            an execution context giving access to other relevant data
	 * @return return true if the buildin predicate is deemed to have succeeded
	 *         in the current environment
	 */
	public boolean bodyCall(Node[] args, int length, RuleContext context) {
		checkArgs(length, context); 
		
		BindingEnvironment env = context.getEnv();
		Node n0 = getArg(0, args, context);
		if (Util.isNumeric(n0)) {
			return env.bind(args[1], n0);
		} else if (n0.isLiteral()) {
			Object v1 = n0.getLiteralValue();
			if (v1 instanceof String) {				
				Node n = com.hp.hpl.jena.reasoner.rulesys.Util.makeLongNode(Long
						.valueOf(v1.toString()));
				return env.bind(args[1], n);
			}
		}
		return false;
	}


}
