import java.io.IOException;

public class Query8 extends AbstractQuery<Iterable<String>> {
    public Query8(String filename) throws IOException {
        super(filename);
    }

    public static void main(String[] args) throws IOException {
        Iterable<String> rs = new Query8("flights2020.csv").execute();
        for (String r : rs) {
            System.out.println(r);
        }
    }

    @Override
    public Iterable<String> execute() {
        return null;
    }
}
