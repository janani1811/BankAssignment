package Practice;

public class TemporaryEmployee extends Employee {
	
	private int hoursWorked;
    private double ratePerHour;

    public TemporaryEmployee(int empId, String name, int hoursWorked, double ratePerHour) {
        super(empId, name);
        this.hoursWorked = hoursWorked;
        this.ratePerHour = ratePerHour;
    }

	@Override
	double calculateSalary() {
		return hoursWorked * ratePerHour;
	}
	
	public void display() {
        super.display();
        System.out.println("Type: Temporary, Salary: " + calculateSalary());
    }

    public void update(int hours, double rate) {
        this.hoursWorked = hours;
        this.ratePerHour = rate;
    }
}
