package tel_ran.persons.entities;

import java.time.LocalDate;

public class Employee extends Person {
	
	int salary;
	int phonenumber;
	String company;
	
	public Employee(){}
	
	public Employee(int personId, String name, Address address, LocalDate birthDate, int salary, String company) {
		super(personId, name, address, birthDate);
		this.salary = salary;
		this.company = company;
	}

	@Override
	public String toString() {
		return "Employee [salary=" + salary + ", phonenumber=" + phonenumber + ", company=" + company + ", id=" + personId
				+ ", name=" + name + ", address=" + address + ", birthDate=" + birthDate + "]";
	}

	public int getSalary() {
		return salary;
	}

	public int getPhonenumber() {
		return phonenumber;
	}

	public String getCompany() {
		return company;
	}
	
	
	
}
