import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class EveryNthIterator<E> implements Iterator<E> {

    private Iterator<E> in;
    private int n;

    public EveryNthIterator(Iterator<E> in, int n) {
        this.in = in;
        this.n = n;
    }

    @Override
    public boolean hasNext() { return in.hasNext(); }

    @Override
    public E next() {
        if (!hasNext()) throw new NoSuchElementException();
        E currPosition = in.next();
        // skip n times in the iterator
        for (int i=0; i<n-1; i++)
        {
            if (hasNext())
            {
                in.next();
            }
        }
        return currPosition;
    }
}
