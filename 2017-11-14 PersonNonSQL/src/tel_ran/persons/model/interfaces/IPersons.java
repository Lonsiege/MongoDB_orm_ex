package tel_ran.persons.model.interfaces;

import tel_ran.persons.entities.*;

public interface IPersons {
	
	boolean addPerson(Person person);
	
	/*default void addPersons(Iterable<Person> persons){
		persons.forEach(this::addPerson);
	}; working but not optimized method. each addperson is response to server*/
	
	/*in nonsql driver is availabe to send batch request*/	
	void addPersons(Iterable<Person> persons);
	
	boolean updateAddress(int id, Address newAddress);
	Person getPerson(int id);
	Iterable<Person> getAllPersons();	
	boolean removePersons(int id);	
	Iterable<Person> getPersonsAge(int minAge, int maxAge);
	Iterable<Person> getPersonsByCity(String string);
	Iterable<Person> getEmployeesBySalary(int minSalary, int maxSalary);
	Iterable<Person> getEmployees();	
	Iterable<String> getMostPopulatedCities();
	
}
