package sortEmployee;

import java.util.Comparator;

import edbms.Employee;

public class sortEmployeebyId implements Comparator<Employee> {
	public int compare(Employee e1,Employee e2) {
		return e1.getId().compareTo(e2.getId());
	}

}
