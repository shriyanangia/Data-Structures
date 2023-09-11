import java.io.IOException;
import java.util.*;
import java.util.LinkedList;
import java.util.List;

public class Query4 {

    public static Iterable<String> Query4(Iterable<FlightRecord> input)
    {
        HashMap<String,Integer> freqFromCID = new HashMap<>();
        Set<String> hashSet2 = new HashSet<String>();
        for (FlightRecord r : input)
        {
            int currVal = 0;
            if (r.ORIGIN.equals("CID"))
            {
                if (freqFromCID.containsKey(r.DEST))
                {
                    currVal = freqFromCID.get(r.DEST);
                    freqFromCID.put(r.DEST, currVal+1);
                }
                else
                {
                    freqFromCID.put(r.DEST, 1);
                }
            }
        }
        for (String temp: freqFromCID.keySet())
        {
            hashSet2.add(temp + "=" + freqFromCID.get(temp));
        }

        return hashSet2;
    }

    public static void main(String[] args) throws IOException {
        Iterable<FlightRecord> input = DataImporter.getData("flights2005.csv");
        Iterable<String> results = Query4(input);
        for (String s : results) {
            System.out.println(s);
        }
    }
}
