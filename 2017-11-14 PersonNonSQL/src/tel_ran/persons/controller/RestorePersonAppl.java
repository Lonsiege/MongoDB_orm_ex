package tel_ran.persons.controller;


import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import tel_ran.persons.entities.*;
import tel_ran.persons.model.interfaces.IPersons;

public class RestorePersonAppl {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new FileSystemXmlApplicationContext("beans.xml");
		/*app context by xml*/
		IPersons personsModel = ctx.getBean(IPersons.class);

		//personsModel.updateAddress(124, new Address("Rehovot","Parshani",11,3));
		//personsModel.removePersons(123);
		Iterable<Person> persons = null;
		//persons = personsModel.getAllPersons();
		//persons = personsModel.getPersonsAge(1,10);
		//persons = personsModel.getPersonsByCity("Rehovot");
		persons = personsModel.getEmployeesBySalary(3000,12000);
		persons = personsModel.getEmployees();
		personsModel.getMostPopulatedCities().forEach(System.out::println);
		//persons.forEach(System.out::println);
		
		ctx.close(); /*application context closing*/
	}
}
