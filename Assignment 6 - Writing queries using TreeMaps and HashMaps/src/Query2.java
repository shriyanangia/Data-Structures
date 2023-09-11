import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Query2 {

    public static Iterable<String> Query2(Iterable<FlightRecord> input)
    {
        Set<String> hashSet = new HashSet<String>();
        for (FlightRecord r : input) {
            if (r.ORIGIN.equals("CID"))
            {
                hashSet.add(r.DEST + ", " + r.DEST_STATE_ABR);
            }
        }
        return hashSet;
    }

    public static void main(String[] args) throws IOException {
        Iterable<FlightRecord> input = DataImporter.getData("flights2005.csv");
        Iterable<String> results = Query2(input);
        for (String s : results) {
            System.out.println(s);
        }
    }
}
