package ca.ubc.cpsc210.listreverser.reverser;

import java.util.List;

public class ListReverserWithoutIterator<T> implements ListReverser<T>
{
    public void reverse(List<T> list)
    {
        int numElements = list.size();
        for (int i = 0; i < numElements/2; i++) {
            int mirrorIndex = i;  // TODO: Compute the mirror index (the index i "flipped" about centre of list)

            // Swap the elements at i and mirrorIndex
            T temp = list.get(i);
            list.set(i, list.get(mirrorIndex));
            list.set(mirrorIndex, temp);
        }
    }
}
