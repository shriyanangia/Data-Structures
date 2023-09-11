import java.io.IOException;
import java.util.function.Function;

public class Query3 extends AbstractQuery<Integer> {
    public Query3(String filename) throws IOException {
        super(filename);
    }

    public static void main(String[] args) throws IOException {
        int results = new Query3("flights2020.csv").execute();
        System.out.println(results);
    }

    @Override
    public Integer execute() {

        Iterable<FlightRecord> flightsFromCID = Filter.filter(input, new Query3.OutOfCIDTotal());


        return Count.count(Distinct.distinct(Transform.transform(flightsFromCID, new Query3.toAString())));
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
}
