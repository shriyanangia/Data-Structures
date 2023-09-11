import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Concatenate {
    public static <E> Iterable<E> concatenate(Iterable<E> first, Iterable<E> second) {

        Iterator<E> firstList = first.iterator();
        Iterator<E> secondList = second.iterator();

        ArrayList<E> finalList = new ArrayList<>();

        while(firstList.hasNext())
        {
            finalList.add(firstList.next());
        }
        while (secondList.hasNext())
        {
            finalList.add(secondList.next());
        }

        Iterable<E> result = finalList;

        return result;
    }
}
