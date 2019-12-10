package com.ag.oops;

final class Employee
{
	private String name;
	private int empId;
	private double salary;
	
	public Employee(){}

	public Employee(String name, int empId, double salary) {
		this.name= name;
		this.empId = empId;
		this.salary = salary;
	}

	
	public	Employee setName(String name){
		return chackObjectModified(name, this.empId, this.salary);
	}

	public Employee setEmpId(int empId){
		return chackObjectModified(this.name, empId, this.salary);
	}

	public Employee setSalary(double sal){
		return chackObjectModified(this.name, this.empId, sal);
	}

	/*
	public String getName(){
	return this.name;
	}
		public int getEmpId(){
	return this.empId;
	}
	public double getSalary(){
	return this.salary;
	}
*/

	public Employee chackObjectModified(String name, int empId, double sal) {
			if(!name.equals(this.name)){
				return new Employee(name, this.empId, this.salary);
		}
			if(empId != this.empId){
				return new Employee(this.name, empId, this.salary);
		}
			if(sal != this.salary){
				return new Employee(this.name, this.empId, sal);
		}
		return this;
	}

	public String toString(){
	return ("name = "+this.name+ " empId = "+this.empId +" salary = "+this.salary);
	}

}//class

class ImmutableEmployee 
{
	public static void main(String[] args) 
	{
		System.out.println("------------------------------------------------------------------");
			Employee s1 = new Employee("raj",1001,500.00);
			System.out.println("s1 hashcode = "+s1.hashCode());
			System.out.println(s1);
			Employee s2 = s1.setSalary(600.00);
			System.out.println("s2 hashcode updated = "+s2.hashCode() );
			System.out.println(s2);
	
			Employee s3 = s2.setSalary(600.00);
			System.out.println("s3 hashcode updated = "+s3.hashCode() );
			System.out.println(s1.hashCode()==s3.hashCode());
			System.out.println(s2.hashCode()==s3.hashCode());
			System.out.println("---------------------------------------------------------------");
	}
}
 