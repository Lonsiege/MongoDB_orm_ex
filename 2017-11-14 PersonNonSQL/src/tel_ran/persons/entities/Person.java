package tel_ran.persons.entities;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="persons") /*annotation for the collection name in MongoDB name (w/o using classname)*/
public abstract class Person {
	@Id //annotation for the field showing this is id
	int personId;
	String name;
	Address address;
	@Indexed /*making index for that column -> map (key,all objects with key)*/
	/*Indexed(Unique true) - for non duplication objects*/
	LocalDate birthDate;
	
	@Override
	public abstract String toString(); /*for daughter classes will must be tostring*/
	
	public Person(){}

	public Person(int id, String name, Address address, LocalDate birthDate) {
		super();
		this.personId = id;
		this.name = name;
		this.address = address;
		this.birthDate = birthDate;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getId() {
		return personId;
	}
	
	
}
