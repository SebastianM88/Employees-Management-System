import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int id;
        String name;

        /* Creating the dao object that will appeal to all our methods from
        the previously created classes */
        EmployeeDaoInt dao = new EmployeeDaoImpl();
        System.out.println("Welcome to Employee management application");

        // Creating an object from the scanner
        Scanner sc = new Scanner(System.in);

        /* The beginning of a do-while loop that runs at least once and continues
        to run until the condition specified in while is false. In this case, the condition is "true", so the loop will run indefinitely.*/
        do{

            // Displaying a menu of options for the user
            System.out.println("1. Add Employee\n" +
                    "2. Show All Employee\n" +
                    "3. Show Employee based on id \n" +
                    "4. Update the employee\n" +
                    "5. Delete the employee\n");

            // Requesting a choice from the user
            System.out.println("Enter Choice: ");
            // Reading the user's choice
            int ch = sc.nextInt();

            /* The beginning of a switch instruction that
            executes a certain block of code according to the value of
            the variable "ch */
            switch (ch) {
                case 1:

                    // Creating a new Employee object with the purpose
                    // of helping later to set certain values
                    Employee emp = new Employee();

                    // choosing id
                    System.out.println("Enter Id : ");
                    id = sc.nextInt();

                    // choosing name
                    System.out.println("Enter name : ");
                    name = sc.next();

                    // choosing the salary
                    System.out.println("Enter Salary : ");
                    double salary = sc.nextDouble();

                    // choosing age
                    System.out.println("Enter age : ");
                    int age = sc.nextInt();

                    // Set each value in the console in the database
                    emp.setId(id);
                    emp.setName(name);
                    emp.setSalary(salary);
                    emp.setAge(age);

                    // Addition of the employee to the database
                    dao.createEmployee(emp);

                    // Ending this case and exiting the switch instruction
                    break;

                case 2:

                    // Display of all employees in the database
                    dao.showAllEmployee();
                    break;

                case 3:

                    System.out.println("Enter Id to how the details ");

                    // Reading employee id
                    int empId = sc.nextInt();

                    // Displaying employee details with specified id
                    dao.showEmployeeBaseOnId(empId);
                    break;

                case 4:

                    System.out.println("Enter id to update the details");
                    // Reading employee id
                    int empId1 = sc.nextInt();

                    System.out.println("Enter the new name");
                    name = sc.next();

                    dao.updateEmployee(empId1, name);

                    break;

                case 5:

                    System.out.println("Enter the id to delete");

                    // Reading employee id
                    id = sc.nextInt();
                    // Deleting the employee with the specified id from the database
                    dao.deleteEmployee(id);

                    break;

                case 6:

                    // Displaying a thank-you message
                    System.out.println("Thank you for using our Application");

                    // closure of the programme
                    System.exit(0);

                    // If "ch" is none of the above values, this block of code is running
                default:

                    System.out.println("Enter valid choice !");

                    break;
            }

        // The condition of the do-time loop is "true", so it will make the loop run indefinitely.
        } while (true);
    }
}