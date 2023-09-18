// 561. Array partition 
// Given an integer array nums of 2n integers, group these integers into n pairs (a1, b1), (a2, b2), ..., (an, bn) such that the sum of min(ai, bi) for all i is maximized. Return the maximized sum.

// class Solution {
//     public int arrayPairSum(int[] nums) {
//         int GlobalSum = 0, sum = 0;
//         int len = nums.length; 
//         int revIndex, arrIndex = 0;
//         int sizeA = len*(len +1)/2;

//         int tempA[][] = new int[sizeA][2];

//         for(int i=0; i<nums.length; i++){
//             revIndex = len -1;
//             for(int j=revIndex; j>i; j--){
//                 tempA[arrIndex][0] = i;
//                 tempA[arrIndex][1] = j;
//             }
//         }

//         arrIndex = len - 1;
//         for(int i=0; i<sizeA; i++){
//             for(int j=arrIndex; j<sizeA; j++)
//         }
//         return 0;
//     }
// }



public class ArrayPartition {
    
}
