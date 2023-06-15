package edbms;

import java.util.Scanner;

import ExceptionEmployee.InvalidChoiceException;

public class Solution {

	public static void main(String[] args) {
System.out.println("Welcome To Employee Database");
System.out.println();

Scanner scan=new Scanner(System.in);
EmployeeManagementSystemImpl ems=new EmployeeManagementSystemImpl();
while(true) {
System.out.println("Enter 1:addEmployee \nEnter 2:displayEmployee \nEnter 3:displayAllEmployee \nEnter 4:removeEmployee \nEnter 5:removeAllEmployee \nEnter 6:update Employee \nEnter 7:sortEmployee \nEnter 8:countEmployee \nEnter 9:getHighestSalaryEmployee \nEnter 10:getlowestSalaryEmployee \nEnter 11:Exit...");

int choice=scan.nextInt();
switch(choice) {

case 1:
	ems.addEmployee();
break;
case 2:
	ems.displayEmployee();
	break;
case 3:
	ems.displayAllEmployee();
	break;
case 4:
	ems.RemoveEmployee();
	break;
case 5:
	ems.RemoveAllEmployee();
	break;
case 6:
	ems.updateEmployee();
	break;
case 7:
	ems.sortEmployee();
	break;
case 8:
	ems.countEmployee();
	break;
case 9:
	ems.getHighestSalaryEmployee();
	break;
case 10:
	ems.getLowestSalaryEmployee();
	break;
case 11:
	System.out.println("Thank You...");
	System.exit(0);

default:
	try {
		throw new InvalidChoiceException("Invalid Choice,kindly Enter valid Choice");
	}catch (InvalidChoiceException e) {
System.out.println(e.getMessage());
}

}
	}

}
}
