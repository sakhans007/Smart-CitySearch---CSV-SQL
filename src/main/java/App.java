import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        CSVReader reader = new CSVReader();
        DBHandler handler = new DBHandler();

        if (handler.checkDB() == false){
            try {
                reader.storeCSVInDatabase();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        SmartSearch search = new SmartSearch();

        System.out.println("\t\t\t\tWelcome to Smart Search");
        System.out.println("1. Lat/Long");
        System.out.println("2. City");
        System.out.print("Enter Option: ");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();

        if (option == 1) {
            System.out.print("Enter Latitude: ");
            Double latitude = scanner.nextDouble();
            System.out.print("Enter Longitude: ");
            Double longitude = scanner.nextDouble();
            List<City> cities = search.getNearbyCitiesByLatLong(latitude, longitude);

            for (City city : cities) {
                if (!city.getCity().equals("")) {
                    System.out.println("City Name: " + city.getCity() + " - Latitude: " + city.getLatitude() + " - Longitude: " + city.getLongitude());
                } else {
                    System.out.println("City Name: No name exists in database" + " - Latitude: " + city.getLatitude() + " - Longitude: " + city.getLongitude());
                }
            }

        } else if (option == 2) {
            System.out.print("Enter the name of city: ");
            String city_name = scanner.next();

            List<City> cities = search.getNearbyCitiesByName(city_name);
            if (cities != null) {
                for (City city : cities) {
                    if (!city.getCity().equals("")) {
                        System.out.println("City Name: " + city.getCity() + " - Latitude: " + city.getLatitude() + " - Longitude: " + city.getLongitude());
                    } else {
                        System.out.println("City Name: No name exists in database" + " - Latitude: " + city.getLatitude() + " - Longitude: " + city.getLongitude());
                    }
                }
            }

        }


    }
}
