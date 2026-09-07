package programmingconcepts.patterns;

import java.util.Scanner;

public class Diamond {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = sc.nextInt();

        // Upper Triangle
        // Total No. of stars totalStar = (rowsNum * 2) -1
        // Star in ith row rowStar = (i * 2 ) -1
        // No. of spaces in a row = totalStar - rowStar;

        for(int i = 1; i <= rows; i++){
            // Print spaces
            int rowStar = (i*2)-1;
            int space = (((rows * 2) - 1) - rowStar) / 2;
            for(int j =  1; j <= space; j++){
                System.out.print("  ");
            }

            // Print star
            for(int j = space+1; j <= (rows*2 - 1) - space; j++){
                System.out.print(" *");
            }
            System.out.println();
        }

        // Lower Triangle
        // Total  Rows = rows - 1;

        for(int i = rows - 1; i >=1 ; i--){
            int rowStar = (i*2)-1;
            int space = (((rows * 2) - 1) - rowStar) / 2;

            //print space
            for(int j = 1; j <= space; j++){
                System.out.print("  ");
            }

            // print sta
            for(int j = space + 1; j <= rowStar + space; j++){
                System.out.print(" *");
            }
            System.out.println();
        }
    }
}
