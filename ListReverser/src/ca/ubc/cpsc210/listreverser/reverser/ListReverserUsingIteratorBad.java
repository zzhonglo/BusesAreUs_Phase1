package ca.ubc.cpsc210.listreverser.reverser;

import java.util.Iterator;
import java.util.List;

public class ListReverserUsingIteratorBad<T> implements ListReverser<T>
{
    public void reverse(List<T> list)
    {
        Iterator<T> it = list.iterator();

        while (it.hasNext()) {
            // Get the next element, add it to the beginning of the list, then
            // remove the element at the last position returned by the iterator
            T next = it.next();
            it.remove();
            list.add(0, next);
        }
    }
}
