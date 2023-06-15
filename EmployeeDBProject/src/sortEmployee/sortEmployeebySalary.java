package sortEmployee;

import java.util.Comparator;

import edbms.Employee;

public class sortEmployeebySalary  implements Comparator<Employee>{
	public int compare(Employee e1,Employee e2) {
		return e1.getSalary().compareTo(e2.getSalary());
	}

}
