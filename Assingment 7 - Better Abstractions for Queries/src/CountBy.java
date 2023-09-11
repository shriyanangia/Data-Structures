import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountBy {
    public static <E> Map<E, Integer> countBy(Iterable<E> input) {

        Map<E,Integer> result = new HashMap<>();


        // iterate through all records in the input
        for (E r : input ) {
            Integer count = result.get(r);

            if (count==null)
            {
                result.put(r, 1);
            }

            else{
                result.put(r, count+1);
            }

        }
        return result;
    }
}
