/*
 ::::::: TRAPPING RAIN WATER :::::::

 * OBJECTIVE:
      * Given a non-negative integer array representing an elevation map,
        where the width of each bar is 1, calculate the total amount of
        water that can be trapped after raining.

 * APPROACH:
      * For every bar, find:

        1. The maximum height present on its left side.
        2. The maximum height present on its right side.

      * Two auxiliary arrays are used to store these maximum boundaries:

          * leftMaxBoundary[i]
          * rightMaxBoundary[i]

      * The water trapped above a bar depends on the shorter of its two
        maximum boundaries.

 * CALCULATION:
      minHeight = Math.min(leftMaxBoundary[i], rightMaxBoundary[i])
      waterAtCurrentBar = minHeight - arr[i]
      totalWater += waterAtCurrentBar

 * WORKING:
        1.Create leftMaxBoundary array.
          Store the maximum height encountered from the left up to
          every index.
        2.Create rightMaxBoundary array.
          Store the maximum height encountered from the right up to
          every index.

        3.Traverse the original array.
          For every index, calculate the water trapped using:

          min(leftMaxBoundary[i], rightMaxBoundary[i]) - arr[i]

        4. Add the water trapped at every bar to totalWater.


 * TIME COMPLEXITY: O(n)

       * Three linear traversals are performed:
            Build leftMaxBoundary  → O(n)
            Build rightMaxBoundary → O(n)
            Calculate water        → O(n)

       * Total:
           O(n) + O(n) + O(n)
            = O(3n)
            = O(n)

 * SPACE COMPLEXITY: O(n)
       * Two auxiliary arrays of size n are used:
           leftMaxBoundary  → O(n)
           rightMaxBoundary → O(n)

       * Therefore, auxiliary space complexity is O(n).
 */



package dsa.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class TrappingRainWaterCorrected {

    public static int trappedWater(int[] arr){
        int totalWater = 0;

        //LeftBoundary
        int[] leftMaxBoundary = new int[arr.length];
        leftMaxBoundary[0] = arr[0];

        for(int i =  1; i < arr.length; i++){
            leftMaxBoundary[i] = Math.max(arr[i], leftMaxBoundary[i-1]);
        }
        //RightBoundary
        int[] rightMaxBoundary = new int[arr.length];
        rightMaxBoundary[arr.length - 1] = arr[arr.length - 1];

        for(int i = arr.length - 2; i >= 0; i--){
            rightMaxBoundary[i] = Math.max(arr[i], rightMaxBoundary[i + 1]);
        }

        //Calculation of amount of water trapped
        for(int i = 0; i < arr.length; i++){
            int minHeight = Math.min(leftMaxBoundary[i], rightMaxBoundary[i]);

            totalWater += minHeight - arr[i];
        }
        return totalWater;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        int[] arr = new int[size];

        System.out.println("Enter the heights of the towers: ");
        for(int i = 0; i < size; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("Heights: "+ Arrays.toString(arr));

        System.out.println("Amount of water trapped is: " +trappedWater(arr));
    }
}
