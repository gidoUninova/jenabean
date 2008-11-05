package test.bean;

import thewebsemantic.Bean2RDF;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Seq;
import com.hp.hpl.jena.rdf.model.Statement;

public class CodeExample {
	public static void main(String[] args) throws thewebsemantic.NotFoundException {
		OntModel model = ModelFactory.createOntologyModel();	
		model.setNsPrefix("xsd", "http://www.w3.org/2001/XMLSchema#");	
		
		/*
		model.read("file:src/test/java/test/bean/seq.n3", "N3");
		Individual ind = model.getIndividual("http://test.bean/Molecule/weird");
		Property p = model.getProperty("http://test.bean/symbols");
		Statement node = ind.getProperty(p);
		Seq s = node.getSeq();
		s.remove(1);
		s.remove(1);
		s.add("hello");
		ind.getProperty(p).getSeq().remove(1);
		ind.getProperty(p).getSeq().remove(1);
		*/
		Bean2RDF writer = new Bean2RDF(model);		
		Molecule m = new Molecule();
	    m.setSymbols(new String[] {"a","b"});
		writer.saveDeep(m);
	    m.setSymbols(new String[] {"a"});
		model.write(System.out, "N3");
	    writer.saveDeep(m);
		
	}
}
