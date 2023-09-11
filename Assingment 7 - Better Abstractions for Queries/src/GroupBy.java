import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class GroupBy {
    // what does the <K,E> mean? For static methods you are required to declare the generic types
    // before you give the return type. You would read this signature as "Given the generic types K
    // and E, transform takes an Iterable<E> and a Function<E, K> and returns a Map<K, List<E>>
    public static <K,E> Map<K, List<E>> groupBy(Iterable<E> input, Function<E, K> extractKey) {

        Map<K,E> temp = new HashMap<>();


//        for (Map.Entry<K,E> entry: m1.entrySet())
//        {
//            for (Map.Entry<K,V2> entry2: m2.entrySet())
//            {
//                if (entry.getKey().equals(entry2.getKey()))
//                {
//                    Pair<V1,V2> pair = new Pair<>(entry.getValue(),entry2.getValue());
//                    temp.put(entry.getKey(),pair);
//                }
//            }
//        }
//        return temp;
        return null;
    }
}
