import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class City {
    @Id
    private int location_id;
    private String country;
    private String region;
    private String city;
    private String postal_code;
    private String latitude;
    private String longitude;
    private String metro_code;
    private String area_code;

    public City(){}

    public City(int location_id, String country, String region, String city, String postal_code, String latitude, String longitude, String metro_code, String area_code) {
        this.location_id = location_id;
        this.country = country;
        this.region = region;
        this.city = city;
        this.postal_code = postal_code;
        this.latitude = latitude;
        this.longitude = longitude;
        this.metro_code = metro_code;
        this.area_code = area_code;
    }

    public int getLocation_id() {
        return location_id;
    }

    public String getCountry() {
        return country;
    }

    public String getRegion() {
        return region;
    }

    public String getCity() {
        return city;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getMetro_code() {
        return metro_code;
    }

    public String getArea_code() {
        return area_code;
    }

    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void setMetro_code(String metro_code) {
        this.metro_code = metro_code;
    }

    public void setArea_code(String area_code) {
        this.area_code = area_code;
    }
}
