class Solution {
    public int divide(int dividend, int divisor) {
        int flag=0;
        int count=0;
        int m = 2147483647;
        if(dividend < 0 && divisor < 0){
            dividend = -(dividend);
            divisor = -(divisor);
            
        }else if(dividend < 0 || divisor < 0){
            if(dividend < 0){
                dividend = -(dividend);
            }else{
                divisor = -(divisor);
            }
            flag = 1;
        }
     
        if(dividend < 0){
            while(dividend < 0){
            dividend += divisor;
            count++;    
        }
        }else{
            while(dividend > 0){
                dividend -= divisor;
                count++;
                
            }
        }
        

        if(dividend < 0){
            count--;
        }

        // to return the result
        if(flag == 1){
            System.out.println(count);
            if(count < 0)
            return (-2147483648);
            return (int)(- count);
        }else{
            if(count < 0)
            return (2147483647);
            return (int)count;
        }
    }
}

public class DivideTwoInt29 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.divide(-2147483648, -3));
    }
}
