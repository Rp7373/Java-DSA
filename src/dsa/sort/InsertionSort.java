/*
* OBJECTIVE:
          * Sorts an array in ascending order by taking one element at
            a time from the UNSORTED portion and inserting it into its
            correct position in the SORTED portion.

* BASIC IDEA:
          * Think about arranging playing cards in your hand.
          * You already have some cards arranged in sorted order.
          * You pick the next card and insert it into its correct
            position among the cards that are already sorted.

* WORKING:
          * Consider the first element as the initial SORTED portion.
          * Start from index 1 because index 0 is already considered sorted.
          * Pick the current element (currentValue).
          * Compare currentValue with the elements before it.
          * If a previous element is GREATER than currentValue, shift that element
            one position to the RIGHT.
          * Continue moving towards the beginning of the sorted portion until
            the correct position for currentValue is found.
          * Insert currentValue at that position.

 * IMPORTANT:
          * Insertion Sort does NOT repeatedly swap adjacent elements like Bubble Sort.
          * Instead, it:
                  PICK → COMPARE → SHIFT → INSERT
* Outer loop:
          * Picks one element at a time from the unsorted portion.

* Inner while loop:
          * Moves larger elements to the right until the correct position for currentValue is found.

* TIME COMPLEXITY:
          * Best Case: O(n) [If the array is already sorted].
          * Average Case: O(n^2) [Elements are randomly distributed].
          * Worst Case: O(n^2) [Array is in reverse order].

* SPACE COMPLEXITY O(1):
          * As Insertion sort is an in-place sorting algorithm and does not create
            any extra memory therefore space complexity is O(1).

* Insertion Sort builds the sorted portion of the array one element at a time by inserting each new element
  into its correct position.
 */


package dsa.sort;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {

    public static void insertionSort(int[] arr){
        int i, currentValue, index;
        for(i = 1; i < arr.length; i++){
            /*
              * Here the loop starts from 1 because it considers the 0th element
                as sorted element and rest as unsorted.
            */
            currentValue = arr[i];
            index = i;
             while(index > 0 && arr[index - 1] > currentValue){
                 arr[index] = arr[index - 1];
                 index--;
             }
             arr[index] = currentValue;
        }
        System.out.print("Sorted array: "+Arrays.toString(arr));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array:");
        int size = sc.nextInt();

        int[] arr = new int[size];

        // Array elements input
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        //Original Array
        System.out.print("Original array:"+ Arrays.toString(arr));

        System.out.println();
        //Sorted Array
        insertionSort(arr);
    }
}
