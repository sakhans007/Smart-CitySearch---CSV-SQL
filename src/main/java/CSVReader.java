import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import java.io.*;

public class CSVReader {
    private Iterable<CSVRecord> records;

    public void readCSV() throws IOException{
        Reader in = new FileReader("src/main/resources/GeoLiteCity-Location.csv");
        records = CSVFormat.EXCEL.parse(in);
    }

    public void storeCSVInDatabase() throws IOException{
        readCSV();
        City city;
        DBHandler handler = new DBHandler();
        for (CSVRecord record : records){
            city = new City(
                    Integer.parseInt(record.get(0)),
                    record.get(1),
                    record.get(2),
                    record.get(3),
                    record.get(4),
                    record.get(5),
                    record.get(6),
                    record.get(7),
                    record.get(8)
            );

            handler.save(city);
        }
        handler.close();
    }
}