package thewebsemantic;

import thewebsemantic.vocabulary.Foaf;
import thewebsemantic.vocabulary.Geo;
import thewebsemantic.vocabulary.Sioc;

import com.hp.hpl.jena.rdf.model.Resource;

/**
 * Provides standard polymorphic interface for
 * "Thing" interfaces.  "as" returns dynamic proxies related
 * to the same model of a different vocabulary, while "isa" does 
 * the same in addition to asserting a classification <code>(a rdf:type p)</code>.
 * Typically the interface is used allong with the <code>Namespace</code> annotation
 * like this:
 * <code>
 * @Namespace("http://xmlns.com/foaf/0.1/")
 * public interface Foaf extends As {
 *   // ...
 * }
 * </code>
 *
 * @see Thing
 * @see Foaf
 * @see Geo
 * @see Sioc
 */
public interface As {
	public <T> T as(Class<T> c);
	public <T> T isa(Class<T> c);
	public Resource asResource();
}
