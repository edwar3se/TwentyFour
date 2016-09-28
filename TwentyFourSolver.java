import java.util.ArrayList;

/**
 * Utility class containing methods for solving the card game "24".
 * 
 * @author Sydney Edwards
 * @version 11/2015
 *
 */
public class TwentyFourSolver
{

    /**
     * This method determines if a particular instance of the "24"-problem has a
     * solution, and prints the steps of the solution if it exists.
     * 
     * The "24"-problem can be described as follows: Given some target value,
     * and some collection of integers, is it possible to find a sequence of
     * arithmetic operations (+, -, *, /) where each intermediate result is an
     * integer, and the final result is equal to the target value?
     * 
     * For example, if the target is 24 and the provided integers are 3, 3, 7
     * and 13, this method will return true and print the following result:
     * 
     * <pre>
     * 7 * 3 = 21
     * 21 - 13 = 8
     * 8 * 3 = 24
     * </pre>
     * 
     * On the other hand, if the target value is 24 and only the numbers 1 and 2
     * are provided, no solution is possible: nothing will be printed and the
     * return value will be false.
     * 
     * All input values should be integers represented as doubles. It is
     * convenient to represent the arguments as doubles because Java integer
     * arithmetic could lead to odd results:
     * 
     * <pre>
     * 11 / 2 = 5
     * 5 + 19 = 24
     * </pre>
     * 
     * No error checking is performed on the provided list of integers, but the
     * method will return false if the provided target value is not an integer.
     * 
     * @param target The target value (traditionally 24)
     * @param numbers An ArrayList of integers to use in the solution
     * @return False if there is no solution, or if target is not an integer.
     *         True otherwise.
     */
    public static boolean solve(double target, ArrayList<Double> numbers)
    {

        // In developing your solution, it may be useful to
        // systematically remove each of the provided numbers from the list of
        // numbers. Here is some sample code showing how this can be done:

        ArrayList<Double> remaining;
        double newTarget;
        boolean finished = false;

        if (numbers.size() == 1)
        {
            return numbers.get(0) == target;
        }

        for (double numberCopy : numbers)
        {
            remaining = new ArrayList<Double>(numbers);
            remaining.remove(numberCopy);

            // Adds together
            newTarget = target - numberCopy;

            if (solve(newTarget, remaining))
            {
                System.out
                        .println((int) newTarget + " + " + (int) numberCopy + " = " + (int) target);
                return true;
            }
            // Subtracts
            newTarget = target + numberCopy;

            if (solve(newTarget, remaining))
            {
                System.out
                        .println((int) newTarget + " - " + (int) numberCopy + " = " + (int) target);
                return true;
            }

            // Multiplies
            newTarget = target / numberCopy;

            if (solve(newTarget, remaining))
            {
                System.out
                        .println((int) newTarget + " * " + (int) numberCopy + " = " + (int) target);
                return true;
            }

            // Divides
            newTarget = target * numberCopy;

            if (solve(newTarget, remaining))
            {
                System.out
                        .println((int) newTarget + " / " + (int) numberCopy + " = " + (int) target);
                return true;
            }

        }

        return false;

    }
}

/*
 * References and Acknowledgments: I received no outside help with this
 * programming assignment.
 */
