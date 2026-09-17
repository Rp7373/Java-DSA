/*
* OBJECTIVE:
       * Given heights of towers where the width of each tower is 1,
         calculate the total amount of water that can be trapped
         between the towers after raining.

* APPROACH :
       * Find a potential left boundary from which water trapping can begin.
       * Now, find the potential right boundary.
       * The left and right boundaries must have at least one tower between them to trap water.
       * For the selected boundaries, calculate water above each intermediate tower using
         the smaller boundary height..

* CALCULATION :
       * Find the minimum height of the two boundaries.
           minHeight = Math.min(leftBoundary, rightBoundary).

       * Amount of Water Trapped at a certain tower = (minHeight - height of that Tower)

       * Total waterAmount = Summation of water trapped at each Tower.

* WORKING:
       1. Start with the first tower as a potential left boundary.
       2. Check the next tower.
          If the next tower is taller than the current left boundary,
          move the left boundary to that taller tower.
       3. Start searching for a suitable right boundary.
          The right boundary should have at least one tower between
          it and the left boundary.
       4. If the current right boundary is not suitable, continue
          searching towards the right.
       5. If the left boundary is taller than the selected right
          boundary, search further for a tower that can provide a
          taller right boundary.
       6. Once the boundaries are selected, calculate the water
          trapped between them using the smaller boundary.
       7. Move the left boundary to the current right boundary
          and continue searching.

* SPECIAL CASE:
       * If the left boundary is taller than the available right
         boundary, a taller tower on the right should be preferred when one exists.
       * If no taller tower exists, the current right boundary can
         still be used because the shorter boundary determines the
         amount of water that can be trapped.

* TIME COMPLEXITY:  O(n^2)

       * The algorithm may perform a search for a suitable right
         boundary and another traversal for calculating the water
         between boundaries.
       * In the worst case, these operations can be repeated for
         multiple boundary pairs.

* SPACE COMPLEXITY: O(1)
       * Only a constant number of variables are used.
*/

package dsa.arrays;

import java.util.*;

public class TrappingRainWater {

    public static int trappedWater(int[] arr) {

        if (arr.length < 3) {
            return 0;
        }

        int leftBoundary = 0;
        int waterAmount = 0;

        while (leftBoundary < arr.length - 2) {

            int rightBoundary = leftBoundary + 1;
            int tallestBoundary = rightBoundary;

            // Find a suitable right boundary
            for (int i = leftBoundary + 1; i < arr.length; i++) {

                // If a tower equal to or taller than left boundary is found,
                // it can act as the right boundary.
                if (arr[i] >= arr[leftBoundary]) {
                    rightBoundary = i;
                    break;
                }

                // Keep track of the tallest tower on the right.
                if (arr[i] > arr[tallestBoundary]) {
                    tallestBoundary = i;
                }

                rightBoundary = tallestBoundary;
            }

            // If no tower equal to or taller than left boundary was found,
            // use the tallest available tower on the right.
            if (arr[rightBoundary] < arr[leftBoundary]) {
                rightBoundary = tallestBoundary;
            }

            int minHeight = Math.min(arr[leftBoundary], arr[rightBoundary]);

            // Calculate water between the two boundaries
            for (int i = leftBoundary + 1; i < rightBoundary; i++) {
                waterAmount += Math.max(0, minHeight - arr[i]);
            }

            leftBoundary = rightBoundary;
        }

        return waterAmount;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        int[] arr = new int[size];

        System.out.println("Enter the heights of the towers: ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Heights: " + Arrays.toString(arr));

        int result = trappedWater(arr);

        System.out.println("Amount of water trapped is: " + result);
    }
}
