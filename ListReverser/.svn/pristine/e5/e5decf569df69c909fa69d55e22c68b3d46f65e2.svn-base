package ca.ubc.cpsc210.listreverser.driver;

import ca.ubc.cpsc210.listreverser.reverser.ListReverser;

import java.util.List;
import java.util.LinkedList;

public class Demonstration
{
    private ListReverser<Integer> reverser;
    private String name;

    public Demonstration(ListReverser<Integer> reverser, String name)
    {
        this.reverser = reverser;
        this.name = name;
    }

    public void run(int numElements)
    {
        if (numElements < 0)
            throw new IllegalArgumentException("Negative elements");

        List<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < numElements; i++)
            list.add(i+1);

        System.out.println("Demonstrating " + this.name.toLowerCase().trim());
        System.out.print("Original: ");
        this.outputList(list);

        this.reverser.reverse(list);

        System.out.print("Reversed: ");
        this.outputList(list);
    }

    private void outputList(List<Integer> list)
    {
        boolean first = true;
        for (Integer i : list) {
            if (first == false)
                System.out.print(", ");
            else
                first = false;
            System.out.print(i);
        }
        System.out.println();
    }
}
