// * * * * * 
// *       *
// *       *
// * * * * *


import java.util.*;

class pattern2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of rows : ");
        int n = sc.nextInt();

        System.out.println("Enter the no of cols : ");
        int m = sc.nextInt();

        // indicates rows 
        for(int i=0; i<n; i++)
        {
            // indicates cols
            for(int j=0; j<m; j++)
            {
                if(i == 0 || i == n-1 || j == 0 || j == m-1)
                {
                    System.out.print("*" + " ");
                }
                else {
                    System.out.print(" " + " ");
                }
            }
            System.out.println();
        }
        sc.close();

    }
}
