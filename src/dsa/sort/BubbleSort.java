/*
*** BUBBLE SORT ***
* OBJECTIVE: Bubble Sort is a comparison-based sorting algorithm that sorts
             the elements of an array in ascending order.
* WORKING:
         * Compares adjacent elements of array.
         * Swaps them if left element is greater than right element.
         * After every pass, the largest unsorted element reaches its correct position at the end of the array.
         * The outer loop controls the number of passes.
         * The inner loop compares elements in the unsorted portion.

         * OUTER LOOP (i):
            * Controls the number of passes.
            * After every pass, one more, largest element reaches its correct position at the end.

         * INNER LOOP (j):
            * Compares adjacent elements.
            * Works only on the UNSORTED portion of the array.

* TIME COMPLEXITY:
         * Since it uses a nested loops that runs for n and n-1 times therefore:
         * Best Case:    O(n) [If the array is already Sorted].
         * Average Case: O(n^2)  [Array elements are randomly distributed]
         * Worst Case:   O(n^2)  [Array is in reverse order]

*  SPACE COMPLEXITY O(1): Since the bubble sort does not make any replica of the array it sorts
                          the array in the original array itself therefore Space complexity is O(1).
* */


package dsa.sort;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {
    public static void bubbleSort(int[] arr){
        for(int i = 0; i < arr.length -1; i++){
            boolean swapped = false;
            for(int j = 0; j< arr.length - 1 - i; j++){
                /* WHY j < length - 1 - i; why -i;
                 * Because after every pass, one element at the end is already
                  sorted, so there is no need to compare it again.
                 */
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }

                if(!swapped){
                    break;
                    /*
                    * By using a swap variable we can optimize the code by coming out of the loop if
                      no swap is performed in inner loop, that is array is already sorted.
                    * This makes time complexity as O(n).
                    */
                }
            }
        }

        System.out.print("Array after bubble sort: ");
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }

    static void main() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();
        //Array Creation
        int[] arr = new int[size];

        System.out.println("Enter the elements of the array: ");
        for(int i = 0; i < size; i++){
            arr[i] = sc.nextInt();
        }

        //Original Array
        for(int i = 0; i < size; i++){
            System.out.print(arr[i]+" ");
        }

        // Array after sorting
        System.out.println();
        bubbleSort(arr);
    }
}
