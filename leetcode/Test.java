import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if ((nums.length % k) != 0) {
            return false;
        }
        return checkIt(nums, k);
    }

    boolean checkIt(int nums[], int k) {
        ArrayList<Integer> v = new ArrayList<>();
        ArrayList<Integer> vtemp = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            v.add(nums[i]);
        }

        Collections.sort(v);

        int n = 0;
        int index = 0;
        int t1 = 0, t2 = 0;
        try {
            while (n < nums.length) {
                // to add into temp
                for (int i = 0; i < k; i++) {
                    t1 = v.get(index);
                    System.out.println(t1);
                    if (i < (k - 1)) {
                        while (v.get(index + 1) == t1) {
                            index++;
                        }
                        t2 = v.get(index + 1);
                        // System.out.println(t2);

                        if ((t2 - t1) == 1) {
                        } else {
                            return false;
                        }
                    }
                    v.remove(Integer.valueOf(t1));
                    index++;
                }
                n += k;
                index = 0;
            }
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        if (v.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }
}

public class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        int arr[] = { 1, 2, 3, 3, 4, 4, 5, 6 };
        System.out.println(s.isPossibleDivide(arr, 4));
    }
}
