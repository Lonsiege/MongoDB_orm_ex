package tel_ran.persons.crud.repo;

import java.time.LocalDate;
import java.util.stream.Stream;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tel_ran.persons.entities.Person;

public interface PersonsRepository extends CrudRepository<Person,Integer> {

	Iterable<Person> findByBirthDateBetween(LocalDate dateFromAge, LocalDate dateFromAge2);
	Iterable<Person> findByAddressCity(String city);
	@Query("{'salary' : {'$gt' : ?0, '$lt' : ?1}}") //?0 - first param
	Iterable<Person> findEmployeesBySalary(int minSalary, int maxSalary);
	@Query("{'_class': {'$regex' : ?0}}") /*query needed for fields on subclasses or virtual fields*/
	Iterable<Person> findEmployees(String type);
	Stream<Person> findAllBy();
	 

}
