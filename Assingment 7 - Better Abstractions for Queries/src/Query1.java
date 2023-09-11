import java.io.IOException;
import java.util.function.Function;

public class Query1 extends AbstractQuery<Integer> {

    public Query1(String filename) throws IOException {
        super(filename);
    }

    @Override
    public Integer execute() {
        Iterable<FlightRecord> laxToOrdInAugust = Filter.filter(input, new Query1.OutOfCIDTotal());
        return Count.count(laxToOrdInAugust);
    }

    private static class OutOfCIDTotal implements Function<FlightRecord, Boolean> {
        @Override
        public Boolean apply(FlightRecord r) {
            return r.ORIGIN.equals("CID");
        }
    }

    public static void main(String[] args) throws IOException {
        int total = new Query1("flights1990.csv").execute();
        System.out.println(total);
    }
}
