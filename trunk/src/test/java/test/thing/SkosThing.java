package test.thing;

import java.util.Collection;

import thewebsemantic.As;
import thewebsemantic.Namespace;
import thewebsemantic.Thing;

@Namespace("http://www.w3.org/2008/05/skos#")
public interface SkosThing extends As {
	interface ConceptScheme extends SkosThing{}
	interface Concept extends SkosThing{}
	SkosThing narrowerTransitive(Thing t);
	Collection<Thing> narrowerTransitive();
	SkosThing broaderTransitive(Thing t);
	Collection<Thing> broaderTransitive();
	SkosThing note(Thing t);
	Collection<Thing> note();
	SkosThing related(Thing t);
	Collection<Thing> related();
	SkosThing closeMatch(Thing t);
	Collection<Thing> closeMatch();
	SkosThing semanticRelation(Thing t);
	Collection<Thing> semanticRelation();
	SkosThing inScheme(Thing t);
	Collection<Thing> inScheme();
	SkosThing broader(Thing t);
	Collection<Thing> broader();
	SkosThing narrower(Thing t);
	Collection<Thing> narrower();
	SkosThing broadMatch(Thing t);
	Collection<Thing> broadMatch();
	SkosThing scopeNote(Thing t);
	Collection<Thing> scopeNote();
	SkosThing exactMatch(Thing t);
	Collection<Thing> exactMatch();
	SkosThing prefLabel(String a, String lang);
	Collection<String> prefLabel();
	SkosThing hiddenLabel(Object o);
	Collection<String> hiddenLabel();
	SkosThing historyNote(Thing t);
	Collection<Thing> historyNote();
	SkosThing editorialNote(Thing t);
	Collection<Thing> editorialNote();
	SkosThing definition(Thing t);
	SkosThing definition(String def, String lang);
	Collection<Thing> definition();
	SkosThing changeNote(Thing t);
	Collection<Thing> changeNote();
	SkosThing narrowMatch(Thing t);
	Collection<Thing> narrowMatch();
	SkosThing relatedMatch(Thing t);
	Collection<Thing> relatedMatch();
	SkosThing altLabel(Object o, String lang);
	Collection<String> altLabel();
	SkosThing topConceptOf(Thing t);
	Collection<Thing> topConceptOf();
	SkosThing example(Thing t);
	Collection<Thing> example();
	SkosThing hasTopConcept(Thing t);
	Collection<Thing> hasTopConcept();
	SkosThing member(Thing t);
	Collection<Thing> member();
}
