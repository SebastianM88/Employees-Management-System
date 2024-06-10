/* The interface created as a place for defining the methods
that will represent the functionality of the project and be implemented in a previous class */
public interface EmployeeDaoInt {

    public void createEmployee(Employee emp);
    public void showAllEmployee();
    public void showEmployeeBaseOnId(int id);
    public void updateEmployee(int id, String name);
    public void deleteEmployee(int id);
}
