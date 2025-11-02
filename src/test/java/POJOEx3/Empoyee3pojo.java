package POJOEx3;
//----main pojo----//
import java.util.List;

public class Empoyee3pojo 
{
private String name;
private String job;
public EmployeeAddress3Pojo getEmpAddress() {
	return empAddress;
}
public void setEmpAddress(EmployeeAddress3Pojo empAddress) {
	this.empAddress = empAddress;
}
public List<String> getBanks() {
	return banks;
}
public void setBanks(List<String> banks) {
	this.banks = banks;
}
private boolean ismarried;
private float salary;
private EmployeeAddress3Pojo empAddress;
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
