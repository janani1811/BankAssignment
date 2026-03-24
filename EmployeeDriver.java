package Practice;
import java.util.*;

public class EmployeeDriver {
    private ArrayList<Employee> list = new ArrayList<>();

    public void addTemporary(Scanner sc) {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Hours Worked: ");
        int hrs = sc.nextInt();
        System.out.print("Rate Per Hour: ");
        double rate = sc.nextDouble();
        list.add(new TemporaryEmployee(id, name, hrs, rate));
    }

    
    public void addPermanent(Scanner sc) {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Basic Salary: ");
        double basic = sc.nextDouble();
        System.out.print("Bonus: ");
        double bonus = sc.nextDouble();
        list.add(new PermanentEmployee(id, name, basic, bonus));
    }

  
    public Employee search(int id) {
        for (Employee e : list) {
            if (e.getEmpId() == id) {
                return e;
            }
        }
        return null;
    }

   
    public void displayAll() {
        for (Employee e : list) {
            e.display();
        }
    }

    
    public void calculateSalary(Scanner sc) {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        Employee e = search(id);
        if (e != null) {
            System.out.println("Salary: " + e.calculateSalary()); 
        } else {
            System.out.println("Employee Not Found!");
        }
    }

    public void update(Scanner sc) {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        Employee e = search(id);
        if (e instanceof TemporaryEmployee) {
            System.out.print("New Hours: ");
            int hrs = sc.nextInt();
            System.out.print("New Rate: ");
            double rate = sc.nextDouble();
            ((TemporaryEmployee) e).update(hrs, rate);
        } 
        else if (e instanceof PermanentEmployee) {
            System.out.print("New Basic Salary: ");
            double basic = sc.nextDouble();
            System.out.print("New Bonus: ");
            double bonus = sc.nextDouble();
            ((PermanentEmployee) e).update(basic, bonus);
        } 
        else {
            System.out.println("Employee Not Found!");
        }
    }

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeDriver system = new EmployeeDriver();
        int choice;

        do {
            System.out.println("\n1.Add Temp 2.Add Perm 3.Calculate Salary 4.Display 5.Search 6.Update 7.Exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1: 
                	system.addTemporary(sc); 
                	break;
                case 2: 
                	system.addPermanent(sc); 
                	break;
                case 3: 
                	system.calculateSalary(sc); 
                	break;
                case 4: 
                	system.displayAll(); 
                	break;
                case 5:
                    System.out.print("Enter ID: ");
                    Employee e = system.search(sc.nextInt());
                    if (e != null) 
                    	e.display();
                    else 
                    	System.out.println("Not Found!");
                    break;
                case 6: 
                	system.update(sc); 
                	break;
            }
        } 
        while (choice != 7);

        sc.close();
    }
}
