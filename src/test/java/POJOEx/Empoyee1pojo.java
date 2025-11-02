package POJOEx;

import java.util.List;

public class Empoyee1pojo 
{
private String name;
private String job;
private boolean ismarried;
private float salary;
private EmployeeAddressPojo empAddress;
private List<String>banks;
public String getName() 
{
	return name;//give you the value
}
public void setName(String name) 
{

	this.name = name;//set the value
}
public String getJob() {
	return job;
}
public void setJob(String job) {
	this.job = job;
}
public boolean isIsmarried() {
	return ismarried;
}
public void setIsmarried(boolean ismarried) {
	this.ismarried = ismarried;
}
public float getSalary() {
	return salary;
}
public void setSalary(float salary) {
	this.salary = salary;
}
}
