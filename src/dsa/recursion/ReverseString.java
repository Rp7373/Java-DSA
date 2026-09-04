/*
*** REVERSE STRING USING RECURSION ***

* OBJECTIVE:
     * Given a string, return/print the reverse of that string.

* WORKING:
     * The function is passed the string and the index of its last character.
     * It prints the character at the current index and then calls itself
       with the index decreased by 1.
     * Since the character is printed BEFORE the recursive call, no additional
       work is performed during stack unwinding.
     * The recursion stops when the index reaches 0.
     * This is an example of TAIL RECURSION because the recursive call is the
       last operation performed by the function.

* APPROACH:
     * Direct + Linear + Tail Recursion

* TIME COMPLEXITY: O(n)
     * For a string of N characters, the function is executed N times.
     * Each call performs constant work.
     * Therefore, the overall time complexity is O(n).

* SPACE COMPLEXITY: O(n)
     * O(n) auxiliary space is used by the recursive call stack.
     * At the deepest point, there can be N recursive calls on the stack.
*/


package dsa.recursion;

import  java.util.Scanner;

public class ReverseString {
    public static void reverseString(String str, int index){
        if(index == -1){
            System.out.println("You have entered an empty String");
            return;
        }

        if(index == 0){
            System.out.print(str.charAt(index));
            return;
        }

        System.out.print(str.charAt(index));
        reverseString(str, index-1);  //TAIL RECURSION
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        reverseString(str,str.length()-1);
    }
}
