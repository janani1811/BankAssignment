package Practice;
import java.util.*;

public class BankAccount {
	    private ArrayList<Customer> customers = new ArrayList<>();

	    public void createAccount(Scanner sc) {
	        System.out.print("Enter Account Number: ");
	        int accNo = sc.nextInt();
	        sc.nextLine();
	        System.out.print("Enter Name: ");
	        String name = sc.nextLine();
	        System.out.print("Enter Balance: ");
	        double bal = sc.nextDouble();
	        sc.nextLine();
	        System.out.print("Enter Account Type: ");
	        String type = sc.nextLine();
	        System.out.print("Enter Email: ");
	        String email = sc.nextLine();
	        customers.add(new Customer(accNo, name, bal, type, email));
	        System.out.println("Account Created!");
	    }

	    public Customer search(int accNo) {
	        for (Customer c : customers) {
	            if (c.getAccountNumber() == accNo) {
	                return c;
	            }
	        }
	        return null;
	    }

	    public void deposit(Scanner sc) {
	        System.out.print("Enter Account Number: ");
	        int accNo = sc.nextInt();

	        Customer c = search(accNo);
	        if (c != null) {
	            System.out.print("Enter Amount: ");
	            double amt = sc.nextDouble();
	            c.setBalance(c.getBalance() + amt);
	            System.out.println("Deposit Successful!");
	        } else {
	            System.out.println("Account Not Found!");
	        }
	    }

	   
	    public void withdraw(Scanner sc) {
	        System.out.print("Enter Account Number: ");
	        int accNo = sc.nextInt();

	        Customer c = search(accNo);
	        if (c != null) {
	            System.out.print("Enter Amount: ");
	            double amt = sc.nextDouble();

	            if (c.getBalance() >= amt) {
	                c.setBalance(c.getBalance() - amt);
	                System.out.println("Withdrawal Successful!");
	            } else {
	                System.out.println("Insufficient Balance!");
	            }
	        } else {
	            System.out.println("Account Not Found!");
	        }
	    }

	    
	    public void enquiry(Scanner sc) {
	        System.out.print("Enter Account Number: ");
	        int accNo = sc.nextInt();

	        Customer c = search(accNo);
	        if (c != null) {
	            System.out.println("Balance: " + c.getBalance());
	        } else {
	            System.out.println("Account Not Found!");
	        }
	    }

	  
	    public void transfer(Scanner sc) {
	        System.out.print("From Account: ");
	        int from = sc.nextInt();
	        System.out.print("To Account: ");
	        int to = sc.nextInt();
	        Customer c1 = search(from);
	        Customer c2 = search(to);
	        if (c1 != null && c2 != null) {
	            System.out.print("Enter Amount: ");
	            double amt = sc.nextDouble();

	            if (c1.getBalance() >= amt) {
	                c1.setBalance(c1.getBalance() - amt);
	                c2.setBalance(c2.getBalance() + amt);
	                System.out.println("Transfer Successful!");
	            } else {
	                System.out.println("Insufficient Balance!");
	            }
	        } else {
	            System.out.println("Invalid Account!");
	        }
	    }

	   
	    public void displayAll() {
	        for (Customer c : customers) {
	            c.display();
	        }
	    }

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        BankAccount bank = new BankAccount();
	        int choice;

	        do {
	            System.out.println("\n1.Create 2.Deposit 3.Withdraw 4.Enquiry 5.Transfer 6.Search 7.Display 8.Exit");
	            choice = sc.nextInt();

	            switch (choice) {
	                case 1: bank.createAccount(sc); break;
	                case 2: bank.deposit(sc); break;
	                case 3: bank.withdraw(sc); break;
	                case 4: bank.enquiry(sc); break;
	                case 5: bank.transfer(sc); break;
	                case 6:
	                    System.out.print("Enter Account Number: ");
	                    Customer c = bank.search(sc.nextInt());
	                    if (c != null) 
	                    	c.display();
	                    else 
	                    	System.out.println("Not Found!");
	                    break;
	                    
	                case 7: 
	                	bank.displayAll(); 
	                	break;
	            }
	        } while (choice != 8);

	        sc.close();
	    }
}