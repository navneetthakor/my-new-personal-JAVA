// * * * * * 
// * * * * *
// * * * * *
// * * * * *
// * * * * *

import java.util.*;
public class pattern1 {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      System.out.print("Enter the number : ");
      int n = sc.nextInt();
      
    //   it counts number of rows
      for(int i=0; i<n; i++)
      {
        // it refers columns 
        for(int j=0; j<n; j++)
        {
           System.out.print("*" + " ");
        }
        System.out.println();
      }
    }
}
