/*   ::: SUBSETS :::
* A subarray is a contiguous sequence of elements from an array.
  The relative order of elements is maintained, and no elements
  can be skipped between the starting and ending indices.

* OBJECTIVE : To print all the subsets of an array.

* WORKING :
    * The algorithm uses three nested loops:
        * Outer loop (start): Selects the starting index of the subarray.
        * Middle loop (end): Selects the ending index, beginning from start.
        * Inner loop (i): Prints all elements between start and end, inclusive.

* COMPLEXITY :
    * Time Complexity: O(n³) — The three nested loops take cubic time in the worst case.
    * Auxiliary Space Complexity: O(1) — The algorithm uses only a constant amount of additional space.

* IMPORTANT :
* Number Of Subarray = (n * (n + 1)) / 2;
*/

package dsa.arrays;

import java.util.*;

public class SubArray {

    public static void subArray(int[] arr){
        for(int start = 0; start < arr.length; start++){
            for(int end = start; end < arr.length; end++){
                for(int i = start; i <= end; i++){
                    System.out.print(arr[i]+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();
        int[] arr = new int[size];

        System.out.println("Enter the elements of the array: ");
        for(int i = 0; i < size; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("Array: "+Arrays.toString(arr));

        System.out.println("All possible subarrays are: ");
        subArray(arr);
    }
}
