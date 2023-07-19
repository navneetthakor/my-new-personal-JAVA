// * 
// * *
// * * *
// * * * *
// * * * * *

import java.util.*;
class pattern3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no of rows  : ");
        int n = sc.nextInt();

        // indicates rows
        for(int i=0;i<n;i++)
        {
            // indicates cols 
            for(int j=0; j<=i; j++)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
        sc.close();
    }
}
