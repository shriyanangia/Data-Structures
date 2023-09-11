import java.util.Iterator;
import java.util.NoSuchElementException;

public class SameIterator<E>  implements Iterator<E>
{
   private Iterator<E> left;
   private Iterator<E> right;
   //private E currPositionLeft;
   //private E currPositionRight;
   private E valueToReturn;

   public SameIterator(Iterator<E> left, Iterator<E> right)
   {
      this.left = left;
      this.right = right;

   }

   @Override
   public boolean hasNext() {
      return (left.hasNext() && right.hasNext());
   }

   @Override
   public E next()
   {
      if (!hasNext()) throw new NoSuchElementException();
      E currPositionLeft;
      E currPositionRight;
      if (hasNext())
      {
         currPositionLeft = left.next();
         currPositionRight = right.next();
         if (currPositionLeft.equals(currPositionRight) && currPositionRight.equals(currPositionLeft))
         {
            valueToReturn=currPositionLeft;
         }

      }
      return valueToReturn;
   }
}
