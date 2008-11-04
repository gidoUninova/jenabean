package test.bean;

import thewebsemantic.binding.RdfBeanId;

public class Molecule extends RdfBeanId<Molecule>{

	Molecule[] neighbors;

	public Molecule() {
		super();
	}
	
	public Molecule[] getNeighbors() {
		return neighbors;
	}

	public void setNeighbors(Molecule[] neighbors) {
		this.neighbors = neighbors;
	}

}
