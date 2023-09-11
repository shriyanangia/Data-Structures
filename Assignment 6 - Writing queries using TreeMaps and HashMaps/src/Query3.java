import java.io.IOException;
import java.util.*;

public class Query3 {

    public static int Query3(Iterable<FlightRecord> input)
    {
        int sum = 0;
        Set<String> hashSet = new HashSet<String>();
        for (FlightRecord r : input) {
            if (r.ORIGIN.equals("CID"))
            {
                hashSet.add(r.DEST + ", " + r.DEST_STATE_ABR);
            }
        }
        return hashSet.size();
    }

    public static void main(String[] args) throws IOException {
        Iterable<FlightRecord> input = DataImporter.getData("flights2020.csv");
        int results = Query3(input);
        System.out.println(results);
    }
}
