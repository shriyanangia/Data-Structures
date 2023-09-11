import java.util.HashSet;
import java.util.Set;

public class Distinct<E> {
    public static <E> Set<E> distinct(Iterable<E> input) {
        Set<E> result = new HashSet<E>();


        // iterate through all records in the input
        for (E r : input ) {

            result.add(r);
            // ...add it to the list
        }
        return result;
    }
}
