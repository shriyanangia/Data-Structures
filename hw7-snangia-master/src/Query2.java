import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public class Query2 extends AbstractQuery<Iterable<String>> {

    public Query2(String filename) throws IOException {
        super(filename);
    }

    @Override
    public Iterable<String> execute() {

        Iterable<FlightRecord> flightsFromCID = Filter.filter(input, new Query2.OutOfCIDTotal());


        return Distinct.distinct(Transform.transform(flightsFromCID, new toAString()));
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
            return (r.DEST + ", " + r.DEST_STATE_ABR);
        }
    }

    public static void main(String[] args) throws IOException {
        Iterable<String> results = new Query2("flights2005.csv").execute();
        for (String s : results) {
            System.out.println(s);
        }
    }
}
