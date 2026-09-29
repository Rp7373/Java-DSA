/*
* OBJECTIVE: Given two strings, determine whether the second string is an anagram
             of the first string.

* ANAGRAM: What is an Anagram?
              * From given string a set of strings are formed of same length
                that of the original one.
              * From the set of strings each string contain characters with
                same frequency as that of the original one.
              * Character order does not matter, but character frequency and
                length must be the same.
* EXAMPLE:      listen → silent → Anagram

* SOLUTION:     The approach converts both strings into character arrays, sorts both arrays,
                and then compares the sorted arrays character by character.
                If the sorted arrays are identical, the strings are anagrams.

* TIME COMPLEXITY: The sorting algorithm uses O(n log n) time, so the
                   the time complexity is O(NlogN).
                   Generally Complexity = O(n log n) + O(n log n)
                                        = O(2n log n)
                                        = O(n log n)

* SPACE COMPLEXITY: The program uses two character arrays which so the space used is O(n).
*/

package dsa.string;

import java.util.*;

public class Anagram {

    public static boolean isAnagram(String s, String t) {
        char[] chs =  s.toLowerCase().toCharArray();
        char[] cht = t.toLowerCase().toCharArray();
        Arrays.sort(chs);
        Arrays.sort(cht);

        if(s.length() == t.length()){
            for(int i = 0; i < s.length(); i++){
                if(chs[i] != cht[i]){
                    System.out.println("The string ("+t+") is not an Anagram of string ("+s+")");
                    return false;
                }
            }
        }else{
            System.out.println("The string "+t+" is not an Anagram of string ("+s+")");
            return false;
        }
        System.out.println("The string ("+t+") is an Anagram of string ("+s+")");
        return true;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String firstString = sc.nextLine();
        System.out.print("Enter the anagram string: ");
        String secondString = sc.nextLine();

        isAnagram(firstString,secondString);
    }
}
