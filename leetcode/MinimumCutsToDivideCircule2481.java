// A valid cut in a circle can be:

// A cut that is represented by a straight line that touches two points on the edge of the circle and passes through its center, or
// A cut that is represented by a straight line that touches one point on the edge of the circle and its center.


// solution

class Solution {
    public int numberOfCuts(int n) {
        if(n == 1){
            return 0;
        }
        else if(n%2 == 0){
            return n/2;
        }else{
            return n;
        }
    }
}

class MinimumCutsToDivideCircle{
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numberOfCuts(5));
    }
}