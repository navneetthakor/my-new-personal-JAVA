// 409. longest palindrom 
// Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
// Letters are case sensitive, for example, "Aa" is not considered a palindrome here.

import java.util.HashMap;

class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        int n = s.length();
        // filling the data in hashmap 
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(hm.containsKey(ch)){
                hm.put(ch, hm.get(ch) + 1);
            }else{
                hm.put(ch, 1);
            }
        }

        // now chanking for longest palindrom
        int odd = 0;
        for (HashMap.Entry<Character,Integer> e:hm.entrySet())
        {
            int temp = e.getValue();
            if(temp%2 != 0){
            odd++;
                // if(temp > max){
                //     max = temp;
                // }
            }
        }

        return odd > 0 ? (n - odd + 1 ) : n;

    }
}

public class LongestPalindrom {
    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth...";
        System.out.println(s.longestPalindrome(str));
    }
}
