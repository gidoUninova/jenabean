package test.jpa;

import javax.persistence.Id;

public class Yin {
	private Yang yang;
	@Id int id;
	
	public Yang getYang() {
		return yang;
	}

	public void setYang(Yang yang) {
		this.yang = yang;
	}
}
