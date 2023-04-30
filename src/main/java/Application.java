import java.sql.*;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Application {
    public static void main(String[] args){

        EmployeeDao employeeDao = new EmployeeDaoImpl();
        CityDao cityDao = new CityDaoImpl();

        City gotham = new City(8, "Gotham");
        Employee employee1 = new Employee("Bat", "Man", "man", 33, gotham);
        Employee employee2 = new Employee("Bat", "Girl", "woman", 25, gotham);

        cityDao.add(gotham);
        System.out.println("City contains: " + cityDao.getAllCity().contains(gotham));

        gotham.setEmployees(List.of(employee1, employee2));

        System.out.println("Все сотрудники сохранены: " + employeeDao.getAllEmployees().containsAll(gotham.getEmployees()));
        cityDao.getById(gotham.getCityId());

    }
}