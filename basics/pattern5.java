//         * 
//       * *
//     * * *
//   * * * *

import java.util.*;
class pattern5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no of rows : ");
        int n = sc.nextInt();

        // indicates rows
        for(int i=0; i<n; i++)
        {
            // white spaces in evry row before stars 
            for(int j=i; j<n; j++)
            {
                System.out.print(" " + " ");
            }

            // stars in every row
            for(int k=0; k<=i; k++)
            {
                System.out.print("*" + " ");
            }

            // to go into the next line 
            System.out.println();
        }
    }
}
