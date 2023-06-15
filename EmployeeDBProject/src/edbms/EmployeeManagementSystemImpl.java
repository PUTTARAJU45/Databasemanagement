package edbms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import ExceptionEmployee.EmployeeNotFoundException;
import ExceptionEmployee.InvalidChoiceException;
import sortEmployee.sortEmployeebyId;
import sortEmployee.sortEmployeebyName;
import sortEmployee.sortEmployeebySalary;

public class EmployeeManagementSystemImpl implements EmployeeManagementSystem {
	Scanner scan = new Scanner(System.in);
	Map<String, Employee> map = new LinkedHashMap<String, Employee>();

	@Override
	public void addEmployee() {

		System.out.println("Enter Name ");
		String name = scan.next();
		System.out.println("Enter Age");
		int age = scan.nextInt();
		System.out.println("Enter Salary");
		Double salary = scan.nextDouble();

		Employee emp = new Employee(name, age, salary);
		map.put(emp.getId(), emp);
		System.out.println("Employee Record Inserted Successfully");
		System.out.println("Student EMPID is " + emp.getId());
		System.out.println();

	}

	@Override
	public void displayEmployee() {
		System.out.println("Enter U R ID");
		String id = scan.next().toUpperCase();
		if (map.containsKey(id)) {

			Employee emp = map.get(id);
			System.out.println(emp);
			System.out.println();
		} else {
			try {
				throw new EmployeeNotFoundException("Employee with ID " + id + " Not Found");

			} catch (EmployeeNotFoundException e) {
				System.out.println(e.getMessage());
				System.out.println();
			}
		}

	}

	@Override
	public void displayAllEmployee() {
		if (map.size() != 0) {
			Set<String> keys = map.keySet();
			System.out.println("All Employee Records As Follows :");
			for (String key : keys) {
				Employee emp = map.get(key);
				System.out.println(emp);

			}
			System.out.println();
		} else {
			try {
				throw new EmployeeNotFoundException("Employee DataBase is Empty,Nothing to Display");

			} catch (EmployeeNotFoundException e) {
				System.out.println(e.getMessage());
				System.out.println();
			}

		}

	}

	@Override
	public void RemoveEmployee() {
		System.out.println("Enter U R ID");
		String id = scan.next().toUpperCase();
		if (map.containsKey(id)) {
			map.remove(id);
			System.out.println("Employee " + id + " Records Removed Succefully");
			System.out.println();

		} else {
			try {
				throw new EmployeeNotFoundException("Employee with ID " + id + " Not Found");

			} catch (EmployeeNotFoundException e) {
				System.out.println(e.getMessage());
				System.out.println();
			}
		}

	}

	@Override
	public void RemoveAllEmployee() {
		if (map.size() != 0) {
			map.clear();
			System.out.println("All Records Removed Succesfully");
			System.out.println();

		} else {
			try {
				throw new EmployeeNotFoundException("Employee DataBase is Empty,Nothing to Remove");

			} catch (EmployeeNotFoundException e) {
				System.out.println(e.getMessage());
				System.out.println();
			}
		}
	}

	@Override
	public void updateEmployee() {
		System.out.println("Enter U R EMPID");
		String id = scan.next().toUpperCase();
		if (map.containsKey(id)) {
			Employee emp = map.get(id);

			System.out.println("Enter 1:update Name \nEnter 2:update Age \nEnter 3:update Salary");
			int choice = scan.nextInt();
			switch (choice) {

			case 1:
				System.out.println("Enter Name");
				String name = scan.next();
				emp.setName(name);
				System.out.println("Updated Name Succefully");
				System.out.println();
				break;
			case 2:
				System.out.println("Enter Age");
				int age = scan.nextInt();
				emp.setAge(age);
				System.out.println("Updated Age Succefully");
				System.out.println();
				break;
			case 3:
				System.out.println("Enter Salary");
				Double salary = scan.nextDouble();
				emp.setSalary(salary);
				System.out.println("Updated Name Succefully");
				System.out.println();
				break;
			default:
				try {
					throw new InvalidChoiceException("Invalid Choice,kindly Enter valid Choice");
				} catch (InvalidChoiceException e) {
					System.out.println(e.getMessage());
					System.out.println();
				}
			}

		} else {
			try {
				throw new EmployeeNotFoundException("Employee with ID " + id + " Not Found");

			} catch (EmployeeNotFoundException e) {
				System.out.println(e.getMessage());
				System.out.println();
			}
		}

	}

	@Override
	public void sortEmployee() {
		if (map.size() >= 2) {
			List<Employee> list = new ArrayList<Employee>();
			Set<String> keys = map.keySet();
			for (String key : keys) {
				Employee emp = map.get(key);
				list.add(emp);
			}

			System.out.println(
					"Enter 1:sort Employee by Name \nEnter 2:sort Employee by Id \nEnter 3:sort Employee by Salary");
			int choice = scan.nextInt();
			switch (choice) {

			case 1:

				Collections.sort(list, new sortEmployeebyName());
				display(list);
				System.out.println();
				break;
			case 2:
				Collections.sort(list, new sortEmployeebyId());
				display(list);
				System.out.println();
				break;
			case 3:
				Collections.sort(list, new sortEmployeebySalary());
				display(list);
				System.out.println();
				break;
			default:
				try {
					throw new InvalidChoiceException("Invalid Choice,kindly Enter valid Choice");
				} catch (InvalidChoiceException e) {
					System.out.println(e.getMessage());
				}

			}
		} else {
			try {
				throw new EmployeeNotFoundException("No Sufficient Records To Sort");

			} catch (EmployeeNotFoundException e) {
				System.out.println(e.getMessage());
				System.out.println();
			}

		}

	}

	private static void display(List<Employee> list) {
		for (Employee e : list) {
			System.out.println(e);
		}
	}

	@Override
	public void countEmployee() {
		if (map.size() != 0) {
			System.out.println("Total Employee Records :" + map.size());
			System.out.println();
		} else {

			try {
				throw new EmployeeNotFoundException("Employee DataBase is Empty,Nothing to Count");

			} catch (EmployeeNotFoundException e) {
				System.out.println(e.getMessage());
				System.out.println();
			}
		}
	}

	@Override
	public void getHighestSalaryEmployee() {
		if (map.size() >= 2) {
			List<Employee> l = new ArrayList<Employee>();
			Set<String> keys = map.keySet();
			for (String key : keys) {
				Employee emp = map.get(key);
				l.add(emp);
			}
			Collections.sort(l, new sortEmployeebySalary());
			System.out.println(l.get(l.size() - 1));
			System.out.println();
		} else {
			try {
				throw new EmployeeNotFoundException("No Sufficient Records To Get highest Salary");

			} catch (EmployeeNotFoundException e) {
				System.out.println(e.getMessage());
				System.out.println();
			}
		}

	}

	@Override
	public void getLowestSalaryEmployee() {
		if (map.size() >= 2) {
			List<Employee> l = new ArrayList<Employee>();
			Set<String> keys = map.keySet();
			for (String key : keys) {
				Employee emp = map.get(key);
				l.add(emp);
			}
			Collections.sort(l, new sortEmployeebySalary());
			System.out.println(l.get(0));
			System.out.println();
		} else {
			try {
				throw new EmployeeNotFoundException("No Sufficient Records To Get lowest Salary");

			} catch (EmployeeNotFoundException e) {
				System.out.println(e.getMessage());
				System.out.println();
			}
		}

	}

}
