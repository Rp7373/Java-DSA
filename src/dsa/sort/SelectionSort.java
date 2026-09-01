/*
* OBJECTIVE:
       * Repeatedly finds the smallest element from the unsorted portion and places it at
         the beginning of that portion.
* WORKING:
       * Staring from the 0th index looking for the smaller element and placing it at
         initial index of the array.
       * It selects a position and searches the entire unsorted portion to find the smallest element.
       * If the smaller element is found then it is swapped with that element.
       * The outer loop tracks the sorted array.
       * The inner loop traverse through the array looking for a smaller element in the unsorted part.

* IMPORTANT:
       * Unlike Bubble Sort, Selection Sort does not repeatedly
         compare and swap adjacent elements.
       * Unlike Insertion Sort, it does not shift elements to insert
         the current element into the sorted portion.
       * Selection Sort finds the smallest element from the unsorted
         portion and places it at the beginning of that portion.

         * Bubble Sort     → Compare adjacent → Swap → Largest moves right
         * Insertion Sort  → Pick → Compare backwards → Shift → Insert
         * Selection Sort  → Find smallest → Swap → Move forward

* TIME COMPLEXITY:
       * Best Case : O(n^2)
       * Average Case : O(n^2)
       * Worst Case : O(n^2)

* SPACE COMPLEXITY:  O(1)
*/



package dsa.sort;

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {
    public static void selectionSort(int[] arr){
        /*
        * Find smaller → Swap immediately
        * Find smaller → Swap immediately
        * Find smaller → Swap immediately
        */
        for(int i = 0; i < arr.length - 1; i++){
            for(int j = i + 1; j < arr.length; j++){
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }

    public static void minSwapSelectionSort(int[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            int minIndex = i;
            /*
            * In this function the smallest element is found and swapped directly with the minIndex element.
            * Search → Find the smallest → Swap ONCE
            */
            for(int j = i + 1; j < arr.length; j++){
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            if(minIndex != i){
                int temp = arr[i];
                arr[i]= arr[minIndex];
                arr[minIndex]=temp;
            }
        }

        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        int[] arr = new int[size];
        int[] arr2;
        System.out.println("Enter the elements of the array: ");

        //  Taking input in the array
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        //Printing the original array
        System.out.print("Original Array: ");
        for(int i = 0; i < size; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();

        arr2 = Arrays.copyOf(arr, size);
        System.out.println("Copied Array: "+Arrays.toString(arr2));

        System.out.print("Sorted Array: ");
        selectionSort(arr);

        System.out.println();

        System.out.print("Sorted array using selection sort with minimum swap: ");
        minSwapSelectionSort(arr2);

    }
}
