public class LinkedList<T> implements List<T>
{

    private static class Node<T>
    {
        private T element;
        private Node<T> next;

        public Node(T e)
        {
            element = e;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T input)
        {
            element = input;
        }

        public Node<T> getNext()
        {
            return next;
        }

        public void setNext(Node<T> n)
        {
            next = n;
        }
    }

    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    public LinkedList(){}

    @Override
    public int size() { return size;}

    public boolean isEmpty() {return size == 0;}

    @Override
    public void add(T e)
    {
        Node<T> newest = new Node<>(e);
        if (isEmpty())
        {
            head = newest;
        }
        else
        {
            tail.setNext(newest);
        }
        tail = newest;
        size ++;
    }

    @Override
    public T get(int i) {
        Node<T> current = head;
        int count = 0;
        for (int j=0; j<i; j++)
        {
            current = current.getNext();
        }
        return current.getElement();
    }

    @Override
    public T remove(int i) {
        Node<T> current = head;
        int count = 0;
        if (i == 0)
        {
            T temp1 = head.getElement();
            if (size == 1) {
                head = null;
                tail = null;
            }
            else {
                head = head.getNext();
            }
            size--;
            return temp1;
        }

        for (int j = 0; j < i -1; j++) {
            current = current.getNext();
        }
        T temp3 = current.getNext().getElement();
        if (current.getNext().getNext()==null)
        {
            current.setNext(null);
            size--;
            return temp3;
        }
        else {
            current.setNext(current.getNext().getNext());
            size--;
            return temp3;
        }
    }

    /**
     * Returns a string representation of this List
     * @return a string representation of this List
     */

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i=0; i<this.size(); i++) {
            sb.append(this.get(i));
            sb.append(", ");
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append("]");
        return sb.toString();
    }
}
