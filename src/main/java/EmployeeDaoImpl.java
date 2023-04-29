import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class EmployeeDaoImpl implements EmployeeDao {

    private static Connection getConnection() throws SQLException {
        final String user = "postgres";
        final String password = "8258";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        return DriverManager.getConnection(url, user, password);
    }


    @Override
    public void createEmployee(Employee employee) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Employee getEmployeeById(int id) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        String s = "SELECT e FROM Employee e";
        TypedQuery<Employee> query = entityManager.createQuery(s, Employee.class);
        List<Employee> employees = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return employees;
    }

    @Override
    public void updateEmployee(Employee employee, int id) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        employee.setId(id);
        entityManager.merge(employee);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void deleteEmployee(int id) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.remove(entityManager.find(Employee.class, id));
        entityManager.getTransaction().commit();
        entityManager.close();
    }


}