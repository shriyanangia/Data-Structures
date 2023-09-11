import java.util.Map;

public class MaxOfMap {
    public static <K> Map.Entry<K,Integer> maxOfMap(Map<K, Integer> input)
    {
        Map.Entry<K,Integer> max = null;
        for (Map.Entry<K,Integer> i : input.entrySet())
        {
            if (max==null || i.getValue().compareTo(max.getValue())>0)
            {
                max = i;
            }
        }
        return max;
    }
}
