package tel_ran.persons.entities;

import java.time.LocalDate;

public class Child extends Person {
	

	String kinderGarden;
	
	public Child(){}
	
	public Child(int personId, String name, Address address, LocalDate birthDate, String kinderGarden) {
		super(personId, name, address, birthDate);
		this.kinderGarden = kinderGarden;
	}

	@Override
	public String toString() {
		return "Child [kinderGarden=" + kinderGarden + ", id=" + personId + ", name=" + name + ", address=" + address
				+ ", birthDate=" + birthDate + "]";
	}

	public String getKinderGarden() {
		return kinderGarden;
	}

	public void setKinderGarden(String kinderGarden) {
		this.kinderGarden = kinderGarden;
	} /*need getter for deserialization*/
	
	

	


}
