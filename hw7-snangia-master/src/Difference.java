import java.util.HashSet;
import java.util.Set;

public class Difference {
    public static <T> Set<T> difference(Set<T> first, Set<T> second) {

        Set<T> result = new HashSet<>();
        for (T temp: first)
        {
            if (!(second.contains(temp)))
            {
                result.add(temp);
            }
        }

        return result;
    }
}
