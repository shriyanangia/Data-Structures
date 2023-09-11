import java.io.IOException;

public class Query5 extends AbstractQuery<String> {

    public Query5(String filename) throws IOException {
        super(filename);
    }

    public static void main(String[] args) throws IOException {
        String r = new Query5("flights2005.csv").execute();
        System.out.println(r);
    }

    @Override
    public String execute() {
        return null;
    }
}
