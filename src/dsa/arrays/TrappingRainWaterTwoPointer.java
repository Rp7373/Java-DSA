package dsa.arrays;

import java.util.*;

public class TrappingRainWaterTwoPointer  {

    public static int trappedWater(int[] arr){
        if(arr.length < 3){
            return 0;
        }

        int left = 0;
        int right = arr.length-1;

        int leftMax = 0;
        int rightMax = 0;

        int trappedWater = 0;

        while(right > left){
            if(arr[right] < arr[left]){
                rightMax = Math.max(arr[right], rightMax);
                trappedWater += rightMax - arr[right];
                right--;
            }
            else{
                leftMax = Math.max(arr[left], leftMax);
                trappedWater += leftMax - arr[left];
                left++;
            }
        }
        return trappedWater;
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
