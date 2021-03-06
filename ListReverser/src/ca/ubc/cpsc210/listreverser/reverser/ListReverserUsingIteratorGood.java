package ca.ubc.cpsc210.listreverser.reverser;

import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;

public class ListReverserUsingIteratorGood<T> implements ListReverser<T>
{
    public void reverse(List<T> list)
    {
        List<T> revList = new LinkedList<T>();
        Iterator<T> it = list.iterator();

        while (it.hasNext()) {
            // Get the next element from the iterator and place it at the
            // beginning of revList (a copy of list, but reversed). Then,
            // remove the element returned by the iterator from list
            T next = it.next();

           revList.add(0,next);
           it.remove();
        }
        //list.clear();
        list.addAll(revList);
    }
}
