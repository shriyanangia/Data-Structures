import java.io.IOException;
//
public abstract class AbstractQuery<R> implements Query<R> {
    protected final Iterable<FlightRecord> input;
    private final String filename;

    public AbstractQuery(String filename) throws IOException {
        this.filename = filename;
        this.input = DataImporter.getData(filename);
    }

    @Override
    public final String name() {
        return this.getClass().getName();
    }

    @Override
    public final String filename() {
        return this.filename;
    }

    @Override
    public String toString() {
        return this.name() + " on " + this.filename;
    }

    @Override
    public int compareTo(Query<R> that)
    {
        while(true) {
            if ((this.filename.equals(that.filename())) && (this.name().equals(that.name()))) {
                return 0;
            }
        }
    }

    public boolean equals(Object o)
    {
        if (!(o instanceof  AbstractQuery))
        {
            return false;
        }
        AbstractQuery a = (AbstractQuery) o;
        return ((a.filename==filename()) && (a.name()==name()));
    }


}
