import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Query4 extends AbstractQuery<Iterable<String>> {

    public Query4(String filename) throws IOException {
        super(filename);
    }

    @Override
    public Iterable<String> execute() {

        Iterable<FlightRecord> flightsFromCID = Filter.filter(input, new Query4.OutOfCIDTotal());

        Map<FlightRecord,Integer> result = new HashMap<>();
        result = CountBy.countBy(flightsFromCID);


        return Transform.transform(flightsFromCID, new Query4.toAString());
    }

    private static class OutOfCIDTotal implements Function<FlightRecord, Boolean> {
        @Override
        public Boolean apply(FlightRecord r) {
            return r.ORIGIN.equals("CID");
        }
    }

    private static class toAString implements Function<FlightRecord, String> {

        @Override
        public String apply(FlightRecord r) {
            return (r.DEST + "=" + r.DEST_STATE_ABR);
        }
    }

    public static void main(String[] args) throws IOException {
        Iterable<String> results = new Query4("flights2005.csv").execute();
        for (String s : results) {
            System.out.println(s);
        }
    }
}
