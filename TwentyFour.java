import java.util.ArrayList;

/**
 * Main method for solving the twenty four game.
 * 
 * @author Sydney Edwards
 * @version 11/2015
 *
 */
public class TwentyFour
{
    /**
     * Provides error checking and means of running TwentyFourSolver in the
     * terminal.
     * 
     * @param args - list of numbers given by the user.
     */
    public static void main(String[] args)
    {
        double target;
        ArrayList<Double> numbers = new ArrayList<Double>();

        if (args.length < 2)
        {
            System.out.println("Not enough arguments.\nUsage: TwentyFour TARGET NUM1...");

        }

        else
        {

            for (String number : args)
            {
                try
                {

                    Integer.parseInt(number);
                }

                catch (Exception e)
                {
                    System.out
                            .println("Badly formatted argument.\nUsage: TwentyFour TARGET NUM1...");
                    return;

                }
            }

            target = Double.parseDouble(args[0]);

            for (int place = 1; place < args.length; place++)
            {

                numbers.add(Double.parseDouble(args[place]));

            }

            boolean result;
            result = TwentyFourSolver.solve(target, numbers);

            if (!result)
            {
                System.out.println("No solution exists!");
            }

        }
    }
}

/*
 * References and Acknowledgments: I received no outside help with this
 * programming assignment.
 */
