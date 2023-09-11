import java.io.IOException;
import java.util.*;

public class Query5 {
    public static String Query5(Iterable<FlightRecord> input)
    {
        HashMap<Integer,Integer> monthMostFlights = new HashMap<>();
        for (FlightRecord r : input)
        {
            int currVal = 0;

                if (monthMostFlights.containsKey(r.MONTH))
                {
                    currVal = monthMostFlights.get(r.DEST);
                    monthMostFlights.put(r.MONTH, currVal+1);
                }
                else
                {
                    monthMostFlights.put(r.MONTH, 0);
                }
        }
        for (Integer temp: monthMostFlights.keySet())
        {
            System.out.println(temp + " had " + monthMostFlights.get(temp));
        }

        return null;
    }

    public static void main(String[] args) throws IOException {
        Iterable<FlightRecord> input = DataImporter.getData("flights1990.csv");
        String r = Query5(input);
        System.out.println(r);
    }
}
