package edbms;

public class Employee {
	
	private String Id;
	private String Name;
	private  Integer age;
	private Double salary;
	private static Integer count=100;
	public Employee(String name, Integer age, Double salary) {
		this.Id="EMP"+count++;
		Name = name;
		this.age = age;
		this.salary = salary;
	}
	public  String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public static Integer getCount() {
		return count;
	}
	public static void setCount(Integer count) {
		Employee.count = count;
	}
	@Override
	public String toString() {
		return "Employee >>> Id=" + Id + ", Name=" + Name + ", age=" + age + ", salary=" + salary ;
	}
	
	
}
