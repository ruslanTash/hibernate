import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class CityDaoImpl implements  CityDao{

    static Connection getConnection() throws SQLException {
        final String user = "postgres";
        final String password = "8258";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        return DriverManager.getConnection(url, user, password);
    }
    @Override
    public City add(City city) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.persist(city);
        entityManager.getTransaction().commit();
        entityManager.close();
        return city;
    }

    @Override
    public City getById(int cityId) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        City city = entityManager.find(City.class, cityId);
        entityManager.getTransaction().commit();
        entityManager.close();
        return city;
    }

    @Override
    public List<City> getAllCity() {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        String sql = "SELECT e FROM City e";
        TypedQuery<City> query = entityManager.createQuery(sql, City.class);
        List<City> cities = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return cities;
    }

    @Override
    public City updateCity(City city, int cityId) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        city.setCityId(cityId);
        entityManager.merge(city);
        entityManager.getTransaction().commit();
        entityManager.close();
        return city;
    }

    @Override
    public void deleteCity(int cityId) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.remove(entityManager.find(City.class, cityId));
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
