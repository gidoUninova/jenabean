package test.bean;

import org.junit.Test;

import thewebsemantic.Bean2RDF;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class TestScatterChart {
	
	@Test
	public void basic() {
		
		Model m = ModelFactory.createDefaultModel();
		Bean2RDF writer = new Bean2RDF(m);
		
		ScatterChart chart = new ScatterChart();
		chart.addYBinding("a");
		chart.addYBinding("b");
		chart.setXBinding("xbinding");
		writer.save(chart);
		
		m.write(System.out, "N3");
		
	}

}
