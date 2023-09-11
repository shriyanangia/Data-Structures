import java.io.IOException;
import java.util.*;
import java.util.LinkedList;
import java.util.List;

public class Query9 {
    public static Iterable<String> Query9(Iterable<FlightRecord> input)
    {
        HashMap<String,String> freqOfAirlines = new HashMap<>();
        Set<String> hashSet2 = new HashSet<String>();
        for (FlightRecord r : input)
        {
            String airline;
                if (freqOfAirlines.containsKey(r.DEST))
                {
                    airline = freqOfAirlines.get(r.UNIQUE_CARRIER_NAME);
                    freqOfAirlines.put(r.DEST, airline);
                }
                else
                {
                    freqOfAirlines.put(r.DEST, r.UNIQUE_CARRIER_NAME);
                }
        }
        for (String temp: freqOfAirlines.keySet())
        {
            hashSet2.add(temp + "," + freqOfAirlines.get(temp));
        }

        return hashSet2;
    }

    public static void main(String[] args) throws IOException {
        Iterable<FlightRecord> input = DataImporter.getData("flights2005.csv");
        Iterable<String> rs = Query9(input);
        for (String r : rs) {
            System.out.println(r);
        }
    }
}
