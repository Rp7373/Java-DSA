/*
 * *** BINARY SEARCH USING RECURSION ***
 * OBJECTIVE:
         Given a sorted array in ASCENDING ORDER, repeatedly divide the search range into
         two halves and compare the middle element with the element to be searched (key).

 * WORKING:
         * The array must be sorted in ascending order.
         * Find the middle element of the current search range.
         * Compare arr[mid] with the key.
         * If arr[mid] == key:
                  * The element is found, so return mid.
         * If arr[mid] < key:
                  * The key can only exist in the right half because all
                    elements in the left half are smaller than arr[mid].
         * Search the right half recursively.
         * If arr[mid] > key:
                  * The key can only exist in the left half.
         * Search the left half recursively.
         * If left > right:
                  * The search range is empty, so the element does not exist.
         * Return -1.

* TIME COMPLEXITY:
         * Best Case:    O(1)
                  * When the key is found at the middle element in the first call.
         * Average Case: O(log N)
         * Worst Case:   O(log N)

* SPACE COMPLEXITY: O(log N)
         * Due to the recursive call stack.

* KEY IDEA:
         * Compare with middle → Eliminate half → Repeat recursively.
 */

package dsa.recursion;
import java.util.Arrays;
import java.util.Scanner;
public class BinarySearchRecursion {

    public static int binSearch(int[] arr, int left, int right, int key){
       if(left <= right){

           int mid = left + (right - left) / 2;

           if(arr[mid] == key){
               return mid;
           }

           else if (arr[mid] < key) return binSearch(arr, mid + 1, right, key);
           else return binSearch(arr, left, mid - 1, key);
       }

       return -1;
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

        System.out.println("Original Array: "+ Arrays.toString(arr));

        System.out.print("Enter the element to be searched: ");
        int searchKey = sc.nextInt();

        int index = binSearch(arr, 0, arr.length-1, searchKey);

        if(index == -1){
            System.out.println("Element "+searchKey+ " not found int the array");
        }
        else{
            System.out.println("Element "+searchKey+ " found in the array at index "+index);
        }
    }
}
