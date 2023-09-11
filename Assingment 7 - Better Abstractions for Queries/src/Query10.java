import java.io.IOException;

public class Query10 extends AbstractQuery<Iterable<String>> {

    public Query10(String filename) throws IOException {
        super(filename);
    }

    public static void main(String[] args) throws IOException {
        Iterable<String> results = new Query10("flights2020").execute();
        for (String s : results) {
            System.out.println(s);
        }
    }

    @Override
    public Iterable<String> execute() {
        return null;
    }
}
