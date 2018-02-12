package tel_ran.persons.model;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import tel_ran.persons.crud.repo.PersonsRepository;
import tel_ran.persons.entities.Address;
import tel_ran.persons.entities.Person;
import tel_ran.persons.model.interfaces.IPersons;

public class PersonsCrud implements IPersons{
	@Autowired /*after the annotation spring searching bean with this interface*/
	PersonsRepository personsRepository;

	@Override
	public boolean addPerson(Person person) {
		Person res = personsRepository.findOne(person.getId());
		if(res != null) return false;
		personsRepository.save(person);
		return true;
	}

	@Override
	public void addPersons(Iterable<Person> persons) {
		personsRepository.save(persons); /*we are not checking the duplicate -> for optimisation*/		
	}

	@Override
	public boolean updateAddress(int id, Address newAddress) {
		Person person = personsRepository.findOne(id);
		if(person == null) 
			return false;
		person.setAddress(newAddress);
		personsRepository.save(person);
		return true;
	}

	@Override
	public Person getPerson(int id) {		
		return personsRepository.findOne(id);
	}

	@Override
	public Iterable<Person> getAllPersons() {		
		return personsRepository.findAll();
	}

	@Override
	public boolean removePersons(int id) {
		Person person = personsRepository.findOne(id);
		if(person == null) 
			return false;
		personsRepository.delete(person);
		return true;
	}

	@Override
	public Iterable<Person> getPersonsAge(int minAge, int maxAge) {
		return personsRepository.findByBirthDateBetween(getDateFromAge(maxAge),getDateFromAge(minAge));

	}

	private LocalDate getDateFromAge(int age) {		
		return LocalDate.now().minusYears(age);
	}

	@Override
	public Iterable<Person> getPersonsByCity(String city) {
		return personsRepository.findByAddressCity(city); /*AddressCity = address.city in obj*/
	}

	@Override
	public Iterable<Person> getEmployeesBySalary(int minSalary, int maxSalary) {		
		return personsRepository.findEmployeesBySalary(minSalary,maxSalary);
	}

	@Override
	public Iterable<Person> getEmployees() {
		return personsRepository.findEmployees("tel_ran.persons.entities.Employee");
	}

	@Override
	public Iterable<String> getMostPopulatedCities() {
		Map<String,Long> citiesPopulation = personsRepository.findAllBy().
				collect(Collectors.groupingBy(x->x.getAddress().getCity(), Collectors.counting()));
		long max = citiesPopulation.values().stream().max(Long::compare).orElse(0L);
		return citiesPopulation.entrySet().stream().filter(x->x.getValue()==max)
				.map(x->x.getKey()).collect(Collectors.toList());
		//return citiesPopulatio;
	}
	
	

}
