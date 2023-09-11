import java.io.IOException;

public class Query7 extends AbstractQuery<Iterable<String>> {
    public Query7(String filename) throws IOException {
        super(filename);
    }

    public static void main(String[] args) throws IOException {
        Iterable<String> rs = new Query7("flights1990.csv").execute();
        for (String r : rs) {
            System.out.println(r);
        }
    }

    @Override
    public Iterable<String> execute() {
        return null;
    }
}
