package examples.assembler;

import com.hp.hpl.jena.assembler.Assembler;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.util.FileManager;

public class AssemblerExample {
	public static void main(String[] args) {		
		
		Model model = FileManager.get().loadModel("file:assemblers/basic.ttl");
		Model data = Assembler.general.openModel(model.getResource("http://example.com#root"));
		data.write(System.out, "N3");
	
	}
}

