package edu.miracosta.cs113.change;

import java.util.ArrayList;
import java.util.List;

/**
 * ChangeCalculator : Class containing the recursive method calculateChange, which determines and prints all
 * possible coin combinations representing a given monetary value in cents.
 *
 * Problem derived from Koffman & Wolfgang's Data Structures: Abstraction and Design Using Java (2nd ed.):
 * Ch. 5, Programming Project #7, pg. 291.
 *
 * NOTE: An additional method, printCombinationsToFile(int), has been added for the equivalent tester file to
 * verify that all given coin combinations are unique.
 */
public class   ChangeCalculatorRecursive extends ChangeCalculator {

    /**
     * Wrapper method for determining all possible unique combinations of quarters, dimes, nickels, and pennies that
     * equal the given monetary value in cents
     *
     * @param cents a monetary value in cents
     * @return the total number of unique combinations of coins of which the given value is comprised
     */

    public static List<String> calculateRecursive(int cents) {
        // TODO:
        // Implement a recursive solution following the given documentation.
        List<String> combinations = new ArrayList<>();

        recursiveChange(cents, combinations, 0, 0, 0, 0, 0);

        return combinations;


    }

    static void recursiveChange(int change, List<String> combinations, int q, int d, int n, int p, int coinIndex) {

        if (change == 0) {
            String temp = combinationToString(q, d, n, p);
            if (!combinations.contains(temp)) {
                combinations.add(temp);
                //code was printing duplicates, so this checks and stops them.
            }
            return;
        }

        if (change < 0 || coinIndex >= COINS.length){
            return;
        }

        for (int coins = 0; coins <= change / COINS[coinIndex]; coins++){
            int spent = coins * COINS[coinIndex];
            switch (coinIndex) {
                case Quarter: q = coins; break;
                case Dime: d = coins; break;
                case Nickel: n = coins; break;
                case Penny: p = coins; break;
            }


            recursiveChange(change - spent, combinations, q, d, n, p, coinIndex + 1);
        }


    }


}