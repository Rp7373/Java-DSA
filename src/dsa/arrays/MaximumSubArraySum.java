/*

* *** KADANE'S ALGORITHM — MAXIMUM SUBARRAY SUM ***

* OBJECTIVE:
      Given an array of integers, find the maximum sum of a
      CONTIGUOUS subarray.

* WORKING:
      * Initialize currentSum = 0 to keep track of the sum of the
        current subarray.
      * Initialize maxSum = Integer.MIN_VALUE to store the maximum
        subarray sum found so far.
      * Traverse the array from left to right.
      * Add the current element to currentSum.

      * If currentSum becomes negative:
          * The current subarray is no longer useful because
            carrying a negative sum can only reduce the sum
            of any future subarray.
          * Discard the current subarray by resetting currentSum
            to 0.
          * After every element, compare currentSum with maxSum and
            update maxSum if currentSum is greater.

* ALL-NEGATIVE CASE:
      * If every element is negative, currentSum will
        repeatedly become negative and reset to 0.
      * As a result, maxSum becomes 0 even though 0 is not
        an actual subarray sum.
      * Therefore, when maxSum == 0, find the maximum element
        in the array.
      * The maximum element is the correct answer because
        when all elements are negative, the maximum-sum
        contiguous subarray will contain only the
        least-negative element.
      * Return maxSum.

* TIME COMPLEXITY:
      * Best Case:    O(N)
      * The array still needs to be traversed to determine
        the maximum subarray sum.
      * Average Case: O(N)
      * Worst Case:   O(N)
      * Every element is processed once.
      * The additional loop for the all-negative case is
        also O(N), so the overall complexity remains O(N).

* SPACE COMPLEXITY: O(1)
      * Only a constant number of variables are used.
      * No additional array or data structure is required.

* KEY IDEA:
      * Add element → Check current sum → Discard if negative
      * Keep track of the maximum sum.

* IMPORTANT THING TO REMEMBER:
      * A negative-sum subarray is treated as a LIABILITY.
      * It can only decrease the sum of a future subarray.
      * Therefore, when currentSum becomes negative, discard it
        and start a new subarray from the next element.

* ALL-NEGATIVE EXAMPLE:

  Array: [-5, -2, -8, -3]

    * Every element makes currentSum negative.
    * currentSum is therefore reset to 0 after each element.
    * maxSum becomes 0, but 0 is not an actual subarray sum.
    * The maximum element is -2.
    * Therefore, the maximum subarray sum is -2.
*/


package dsa.arrays;

import java.util.*;

public class MaximumSubArraySum {

    public static int maxSubArraySum(int[] array){
        // Using Kadane's Algorithm
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for(int i = 0; i< array.length; i++){
            currentSum += array[i];

            if(currentSum < 0){
                // Discarding the elements if they su up to a negative number
                currentSum = 0;
            }
            maxSum = Math.max(currentSum, maxSum);
        }
        if(maxSum == 0){// This condition will execute when every
                        // element of the array is negative
            maxSum = array[0];

            for(int i = 1; i < array.length; i++){
                maxSum =  Math.max(array[i],maxSum);
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int size = sc.nextInt();
        int[] arr = new int[size];

        System.out.println("Enter the elements in the array: ");
        for(int i = 0; i < size; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("Original Array: "+Arrays.toString(arr));

        System.out.println("Maximum Sub Array Sum: "+maxSubArraySum(arr));
    }
}
