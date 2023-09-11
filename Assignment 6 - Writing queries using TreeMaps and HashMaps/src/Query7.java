import java.io.IOException;
import java.util.*;

public class Query7 {
    public static Iterable<String> Query7(Iterable<FlightRecord> input)
    {
        HashSet<String> statesNotFromIowa = new HashSet<>();

        for (FlightRecord r : input) {
            if (!(statesNotFromIowa.contains(r.ORIGIN_STATE_ABR))) {
                statesNotFromIowa.add(r.ORIGIN_STATE_ABR);
            }
            if (!(statesNotFromIowa.contains(r.DEST_STATE_ABR)))
            {
                statesNotFromIowa.add(r.DEST_STATE_ABR);
            }
        }

        for (FlightRecord r : input) {
            if (r.ORIGIN_STATE_ABR.equals("IA"))
            {
                if (statesNotFromIowa.contains(r.DEST_STATE_ABR))
                {
                    statesNotFromIowa.remove(r.DEST_STATE_ABR);
                }
            }
        }

        return statesNotFromIowa;
    }

    public static void main(String[] args) throws IOException {
        Iterable<FlightRecord> input = DataImporter.getData("flights1990.csv");
        Iterable<String> rs = Query7(input);
        for (String r : rs) {
            System.out.println(r);
        }
    }
}
