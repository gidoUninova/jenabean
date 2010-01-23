package example.fluentwriter;

import thewebsemantic.Thing;
import thewebsemantic.vocabulary.Geo;
import thewebsemantic.vocabulary.Ical;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class Main {

	/**
	 * This is our event written to ical
	 * using Jenabean's fluent programming interface.
	 * 
	 */
	public static void main(String[] args) {
		
      Model m = ModelFactory.createDefaultModel(); 
      m.setNsPrefix("foaf","http://xmlns.com/foaf/0.1/");
      m.setNsPrefix("xsd" , "http://www.w3.org/2001/XMLSchema#");
      m.setNsPrefix("ical" ,"http://www.w3.org/2002/12/cal#");    
      m.setNsPrefix("geo", "http://www.w3.org/2003/01/geo/wgs84_pos#");
      
      Ical.Vevent t = new Thing(m).isa(Ical.Vevent.class);
      t.uid("event_11978192@meetup.com").
      	dtstart("20100124T200000Z").
			dtend("20100124T220000Z").
			summary("Jena Semantic Web Programming with Taylor Cowan, Sanjiva Nath & Jeremy Carroll").
			location("Parisoma - 1436 Howard (at 10th) in San Francisco - San Francisco, CA  94103 - USA")
		.as(Geo.class).
			lat(37.77f).
			long_(-122.41f);
              
      m.write(System.out, "N3");
	}

}
