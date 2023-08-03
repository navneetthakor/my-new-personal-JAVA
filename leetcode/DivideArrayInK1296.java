import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
     if((nums.length % k) != 0){
        return false;
     }  
        return checkIt(nums, k);
    }

    boolean checkIt(int nums[], int k){
        ArrayList<Integer> v = new ArrayList<>();
        ArrayList<Integer> vtemp = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            v.add(nums[i]);
        }

        Collections.sort(v);

        int n=0;
        int index =0;
        while(n<nums.length){
            //to add into temp
            for(int i=0; i<k; i++){
                while(vtemp.contains(v.get(index))){
                    index++;
                }
                vtemp.add(v.get(index));
            }
            

            //to check sequence
            Collections.sort(vtemp);
            for(int i=0; i<2; i++){
                System.out.println(vtemp.get(i));
            }
            // to remove from main
            for(int i=0; i<k; i++){
                if(i < (k-1)){
                    if((vtemp.get(i+1) - vtemp.get(i)) == 1){
                        
                    }else{
                        System.out.println("ok");
                        return false;
                    }
                }
                int temp = vtemp.get(i);
                v.remove(Integer.valueOf(temp));
                
            }
            vtemp.clear();
            n += k;
            index = 0;
        }
        if(v.isEmpty()){
        return true;
        }else{
            return false;
        }
        
    }
}

public class DivideArrayInK1296 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int arr[] = {1,1,2,2,3,3};
       System.out.println(s.isPossibleDivide(arr, 2));
    }
}
