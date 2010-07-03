package test.jpa;

import java.util.List;

import javax.persistence.Id;

public class Hotel {
	
	@Id
	int hotelid;
	List<Ammenity> ammenities;
	
	public int getHotelid() {
		return hotelid;
	}
	public void setHotelid(int hotelid) {
		this.hotelid = hotelid;
	}
	public List<Ammenity> getAmmenities() {
		return ammenities;
	}
	public void setAmmenities(List<Ammenity> ammenities) {
		this.ammenities = ammenities;
	}

}
