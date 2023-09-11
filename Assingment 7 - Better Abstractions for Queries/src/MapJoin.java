import java.util.HashMap;
import java.util.Map;

public class MapJoin {
    public static <K,V1,V2> Map<K,Pair<V1,V2>> mapJoin(Map<K,V1> m1, Map<K,V2> m2) {

        Map<K,Pair<V1,V2>> temp = new HashMap<>();


        for (Map.Entry<K,V1> entry: m1.entrySet())
        {
            for (Map.Entry<K,V2> entry2: m2.entrySet())
            {
                if (entry.getKey().equals(entry2.getKey()))
                {
                    Pair<V1,V2> pair = new Pair<>(entry.getValue(),entry2.getValue());
                    temp.put(entry.getKey(),pair);
                }
            }
        }
        return temp;
    }
}
