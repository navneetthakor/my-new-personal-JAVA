


// question :
// You are given an integer array nums consisting of 2 * n integers.

// You need to divide nums into n pairs such that:

// Each element belongs to exactly one pair.
// The elements present in a pair are equal.
// Return true if nums can be divided into n pairs, otherwise return false



// Answere:

// package leetcode;
import java.util.ArrayList;
class Solution {
    public boolean divideArray(int[] nums) {
       return checkFirst(nums);
       
    }

    boolean checkFirst(int nums[]){
        //check whether even number of elements are theri or not
        if(nums.length % 2 != 0){
            return false;
        }

        // check whether the elements are in pair or not.
        ArrayList<Integer> v = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            // System.out.println("Stated : " + nums.length);
            if(v.contains(nums[i])){
                // System.out.println(i);
                v.remove(Integer.valueOf(nums[i]));
            }else{
                v.add(nums[i]);
            }
        }

        //now return the result 
        if(v.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
public class DivideArrayntoEqualPairs2206 {
 public static void main(String[] args) {
    Solution s = new Solution();
    int arr[] = {3,2,3,2,2,2};
    System.out.println(s.divideArray(arr));
 }   
}