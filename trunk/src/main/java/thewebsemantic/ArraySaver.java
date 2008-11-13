package thewebsemantic;

import java.lang.reflect.Array;

import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Seq;
import com.hp.hpl.jena.shared.PropertyNotFoundException;

public class ArraySaver extends Saver {

	@Override
	public void save(Bean2RDF writer, Resource subject, Property property,
			Object array) {
		Seq s = getSeq(subject, property);
		int len = Array.getLength(array);
		int difference = s.size() - len;
		int seqsize = s.size();
		if (difference > 0)
			for (int i = 0; i < difference; s.remove(seqsize-i++)) {}
		
		for (int i = 0; i < len; i++) {
			Object o = Array.get(array, i);
			if (o==null)
				continue;
			if (i >= s.size()) {
				s.add(writer.toNode(o));
			} else {
				s.set(i + 1, writer.toNode(o));
			}
		}

	}
	
	protected Seq getSeq(Resource subject, Property property) {
		try {
			return subject.getRequiredProperty(property).getSeq();
		} catch (PropertyNotFoundException e) {
			Seq seq = subject.getModel().createSeq();
			subject.addProperty(property, seq);
			return seq;			
		}

	}

}
