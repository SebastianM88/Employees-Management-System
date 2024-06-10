import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

// The class where we will be implemented the EmployeeDaoInt interface
public class EmployeeDaoImpl implements EmployeeDaoInt {

    Connection con;
    @Override

    // Method to add new employees to our database
    public void createEmployee(Employee emp) {

        // create connections to the database
        con = DBConnection.createDBConnection();

        // Code to help query some value that will be transmitted to the database
        String query = "insert into employee values (?, ?, ?, ?)";

       try {

           // Creating our object meant to make possible our query in the database
           PreparedStatement pstm = con.prepareStatement(query);

           // Code to set each parameter that will be questioned
           pstm.setInt(1,emp.getId());
           pstm.setString(2,emp.getName());
           pstm.setDouble(3,emp.getSalary());
           pstm.setInt(4,emp.getAge());

           // Code to execute the action
           int cnt = pstm.executeUpdate();

           // Code to signal an amendment and offer an answer accordingly
           if (cnt != 0)
               System.out.println("Employee Inserted Successfully !!! ");


       } catch(Exception ex) {

           ex.printStackTrace();
       }
    }

    // Method to display all existing employees
    @Override
    public void showAllEmployee() {

        con = DBConnection.createDBConnection();

        // Code to define our query to select values from the database
        String query = "select * from employee";
        System.out.println("Employee Details : ");

        try {

            // Creating an object so that we can execute our query
            Statement stmt = con.createStatement();

            // code to store the result in an object
            ResultSet result = stmt.executeQuery(query);

            // Code to provide a space between terms
            System.out.format("%s\t%s\t%s\t%s\n", "ID", "Name", "Salary", "age" );
            System.out.println("------------------------------------");

            // Loop to scroll through the query results
            while (result.next()) {
                System.out.format("%d\t%s\t%f\t%d\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getDouble(3),
                        result.getInt(4));
                System.out.println("------------------------------------");
            }

        } catch(Exception ex){

            ex.printStackTrace();
        }
    }

    // The method designed to show each employee according to his id
    @Override
    public void showEmployeeBaseOnId(int id) {

        con = DBConnection.createDBConnection();

        // Code to provide the specified result from the database
        String query = "select * from employee where id =" +id;

        try{

            // Creation of the object to execute the query and store the result
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(query);

            while (result.next()) {
                System.out.format("%d\t%s\t%f\t%d\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getDouble(3),
                        result.getInt(4));

            }

        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

    // Method for updating the values in the database
    @Override
    public void updateEmployee(int id, String name) {

        con = DBConnection.createDBConnection();

        // code to make changes to id and name
        String query = "update employee set name=? where id=?";

        try{

            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1, name);
            pstm.setInt(2, id);

            // Code to execute the command from the code applied to the database
            pstm.executeUpdate();

            int cnt = pstm.executeUpdate();
            if (cnt != 0)
                System.out.println("Employee Details updated successfully !!!");

        } catch(Exception ex) {

            ex.printStackTrace();
        }
    }

    // Method to remove items from database
    @Override
    public void deleteEmployee(int id) {

        con = DBConnection.createDBConnection();
        String query = "delete from employee where id=?";

        try{

            PreparedStatement psmt = con.prepareStatement(query);
            psmt.setInt(1,id);

            int cnt = psmt.executeUpdate();
            if (cnt != 0)
                System.out.println("Employee Deleted Successfully !!! " + "id number:" + id);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
