package Practice;

public class PermanentEmployee extends Employee {
	private double basicSalary;
    private double bonus;

    public PermanentEmployee(int empId, String name, double basicSalary, double bonus) {
        super(empId, name);
        this.basicSalary = basicSalary;
        this.bonus = bonus;
    }

	@Override
	double calculateSalary() {
		return basicSalary + bonus;
	}
	
	public void display() {
        super.display();
        System.out.println("Type: Permanent, Salary: " + calculateSalary());
    }

    public void update(double basic, double bonus) {
        this.basicSalary = basic;
        this.bonus = bonus;
    }
}