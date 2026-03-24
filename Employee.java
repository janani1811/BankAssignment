package Practice;

public abstract class Employee {
	    protected int empId;
	    protected String name;

	    public Employee(int empId, String name) {
	        this.empId = empId;
	        this.name = name;
	    }

	    abstract double calculateSalary();
	    
	    public void display() {
	        System.out.println("ID: " + empId + ", Name: " + name);
	    }

	    
	    public int getEmpId() {
	        return empId;
	    }
	    
	    
}


