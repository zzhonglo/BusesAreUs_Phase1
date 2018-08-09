package ca.ubc.cpsc210.listreverser.driver;

import ca.ubc.cpsc210.listreverser.reverser.ListReverserUsingIteratorBad;
import ca.ubc.cpsc210.listreverser.reverser.ListReverserUsingIteratorGood;
import ca.ubc.cpsc210.listreverser.reverser.ListReverserWithoutIterator;

public class Main
{
    private static final int NUM_ELEMENTS = 3;

    public static void main(String[] args)
    {
        Demonstration demo;

        demo = new Demonstration(new ListReverserWithoutIterator<Integer>(),
                "Reverser that does not use iterator");
        demo.run(Main.NUM_ELEMENTS);

        System.out.println();

        //demo = new Demonstration(new ListReverserUsingIteratorBad<Integer>(),
         //       "Reverser that uses iterator incorrectly");
        //demo.run(Main.NUM_ELEMENTS);

        //System.out.println();

        demo = new Demonstration(new ListReverserUsingIteratorGood<Integer>(),
                "Reverser that uses iterator properly");
        demo.run(Main.NUM_ELEMENTS);

    }
}
