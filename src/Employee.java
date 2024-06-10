public class Employee {

    // Declaring the variables to which we will report the entire project
    private int id;
    private String name;
    private double salary;
    private int age;

    // Our constructor
    public Employee () {

    }
    // Code to Create our constrictor, so we can initialize the variables present
    public Employee(int id, String name, double salary, int age) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    // Creating getter elements so that we can access the values of each of our variables
    public int getId() {
        return id;
    }

    // Creating setter elements so that we can set the values of each of our variables
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // The method used to return a string with our values.
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}
