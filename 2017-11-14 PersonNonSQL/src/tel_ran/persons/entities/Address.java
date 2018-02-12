package tel_ran.persons.entities;

public class Address {
	String city;
	String street;
	int building;
	int aprt;
	
	public Address(){} /*needed for json*/
	
	public Address(String city, String street, int building, int aprt) {
		super();
		this.city = city;
		this.street = street;
		this.building = building;
		this.aprt = aprt;
	}



	public String getCity() {
		return city;
	}

	public String getStreet() {
		return street;
	}

	public int getBuilding() {
		return building;
	}

	public int getAprt() {
		return aprt;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", street=" + street + ", building=" + building + ", aprt=" + aprt + "]";
	}
	
	
	
	
}
