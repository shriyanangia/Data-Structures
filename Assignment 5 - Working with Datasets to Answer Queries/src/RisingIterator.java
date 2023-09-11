import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RisingIterator implements Iterator<Integer> {

   private Iterator<Integer> input;
   private Integer currPosition;
   boolean check;

   public RisingIterator(Iterator<Integer> input)
   {
      this.input = input;
      if (input.hasNext())
      {
         currPosition = input.next();
         check = true;
      }
   }

   private void getNext()
   {
      while (input.hasNext() && !check)
      {
         Integer comparison = input.next();
         if (currPosition<comparison)
         {
            currPosition = comparison;
            check = true;
         }
      }
   }

   @Override
   public boolean hasNext()
   {
      return check;
   }

   @Override
   public Integer next()
   {
      if (!hasNext()) throw new NoSuchElementException();
      Integer temp = currPosition;
      check = false;
      getNext();
      return temp;
   }
}
