import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SmartSearch {

    private static final int DISTANCE_THRESHOLD = 1500;

    public static double distance(double lat1, double lon1, double lat2, double lon2, String unit) {

        if ((lat1 == lat2) && (lon1 == lon2)) {
            return 0;

        } else {
            double theta = lon1 - lon2;
            double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) +
                                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
            dist = Math.acos(dist);
            dist = Math.toDegrees(dist);
            dist = dist * 60 * 1.1515;

            if (unit == "K") {
                dist = dist * 1.609344;
            } else if (unit == "N") {
                dist = dist * 0.8684;
            }
            return (dist);
        }
    }

    public List<City> getNearbyCitiesByLatLong(Double latitude, Double longitude){
        DBHandler handler = new DBHandler();
        List cities = handler.listCities();
        List<City> nearbyCities = new ArrayList<City>();
        for (Iterator iterator = cities.iterator(); ((Iterator) iterator).hasNext();){
            City city = (City) iterator.next();

            if (distance(latitude, longitude, Double.parseDouble(city.getLatitude()), Double.parseDouble(city.getLongitude()), "K") <= DISTANCE_THRESHOLD){
                nearbyCities.add(city);
            }
        }
        handler.close();
        return nearbyCities;
    }

    public List<City> getNearbyCitiesByName(String city){
        DBHandler handler = new DBHandler();
        Double[] lat_long = handler.searchCity(city);
        handler.close();
        if (lat_long == null)
            return null;
        List<City> cities = getNearbyCitiesByLatLong(lat_long[0], lat_long[1]);
        return cities;
    }
}
