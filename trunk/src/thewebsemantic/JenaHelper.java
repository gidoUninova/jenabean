package thewebsemantic;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Calendar;
import java.util.Date;

import com.hp.hpl.jena.datatypes.xsd.XSDDateTime;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.ibm.icu.math.BigDecimal;

public class JenaHelper {

	public static Object convertLiteral(RDFNode node, Class<?> c) {
		return convertLiteral((Literal)node.as(Literal.class), c);
	}

	public static Object convertLiteral(Literal l, Class<?> c) {
		if (c.equals(Date.class)) {
			return date(l);
		} else if ( c.equals(Calendar.class)) {
			return ((XSDDateTime)l.getValue()).asCalendar();
		} else if (c.equals(BigDecimal.class)) {
			return bigDecimal(l);
		} else if (c.equals(URI.class)) {
			return uri(l);
		} else
			return l.getValue();
	}
	
	private static URI uri(Literal l) {
		try {
			return new URI(l.getString());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Date date(Literal l) {
		XSDDateTime date = (XSDDateTime) l.getValue();
		return date.asCalendar().getTime();
	}
	
	public static Object bigDecimal(Literal l) {
		Object o = l.getValue();
		System.out.println(o.getClass());
		return null;
	}
		
	public static Literal asLiteral(RDFNode n) {
		return (Literal)n.as(Literal.class);
	}

}
