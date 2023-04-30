import java.sql.*;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Application {
    public static void main(String[] args) throws SQLException {

        EmployeeDao employeeDao = new EmployeeDaoImpl();

        Employee employee1 = new Employee("Bat", "Man", "man", 33, 1);
        Employee employee2 = new Employee("Bat", "Girl", "woman", 25, 2);

        System.out.println(employeeDao.getAllEmployees());

        employeeDao.createEmployee(employee1);
        System.out.println(employeeDao.getEmployeeById(1));
        employeeDao.updateEmployee(employee2, 5);
        employeeDao.deleteEmployee(7);

        System.out.println(employeeDao.getAllEmployees());


    }
}