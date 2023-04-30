import java.util.List;

public interface CityDao {
    City add (City city);
    City getById (int id);
    List<City> getAllCity();
    City updateCity(City city, int cityId);
    void deleteCity(int cityId);
}
