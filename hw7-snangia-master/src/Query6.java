import java.io.IOException;

public class Query6 extends AbstractQuery<String> {

    public Query6(String filename) throws IOException {
        super(filename);
    }

    public static void main(String[] args) throws IOException {
        String r = new Query6("flights1990.csv").execute();
        System.out.println(r);
    }

    @Override
    public String execute() {
        return null;
    }
}
