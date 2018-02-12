package tel_ran.persons.controller;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import tel_ran.persons.entities.*;
import tel_ran.persons.model.interfaces.IPersons;

public class CreatePersonsAppl {
	 public static void main(String[] args) {
		Address addr1 = new Address("Rehovot", "Plaut", 10, 43);
		Address addr2 = new Address("Rishon", "Moshe Dayan", 108, 2);
		Address addr3 = new Address("Hod A Sharon", "Sokolov", 22, 26);
		Address addr4 = new Address("Dimona", "Shapiro", 19, 1);
		
		Person[] persons = {
				new Child(123, "Yosi", addr1, LocalDate.of(2012, 12, 13), "Salut"),
				new Employee(124, "Bogdan", addr2, LocalDate.of(1983, 05, 30), 8000, "Lamed Hey"),
				new Child(125, "Roza", addr3, LocalDate.of(2015, 1, 10), "Lavan"),
				new Employee(126, "Simona", addr4, LocalDate.of(1957, 04, 22), 5800, "Dan")
		};
		
		AbstractApplicationContext ctx = new FileSystemXmlApplicationContext("beans.xml");
		/*app context by xml*/
		IPersons personsModel = ctx.getBean(IPersons.class);
		
		//personsModel.addPersons(Arrays.asList(persons));
		personsModel.updateAddress(124, new Address("Rehovot","Shapiro",111,1));
		
		ctx.close(); /*application context closing*/
	
	}
}
