// * * * * *
// * * * *
// * * *
// * *
// *

import java.util.*;
class pattern4{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no of rows : ");
        int n = sc.nextInt();

        // indicates rows 
        for(int i=0; i<n; i++)
        {
            // indicates cols
            for(int j=n-1; j>=i; j--)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}