import java.util.*;
class Apattern1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value : ");
        int n = sc.nextInt();

        // upper part
        for(int i=1; i<n; i++)
        {
            // first half 
            for(int j=1; j<=i; j++)
            {
                System.out.print("*" + " ");
            }

            // btw spaces
            for(int k=1; k<= (n - (i*2)); k++)
            {
                System.out.print(" " + " ");
            }

            // last half 
            for(int l=1; l<=i; l++)
            {
                System.out.print("*" + " ");
            }
            System.out.println();
        }
    }
}
