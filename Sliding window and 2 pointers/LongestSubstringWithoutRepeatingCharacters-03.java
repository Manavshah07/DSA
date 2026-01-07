
// QUESTION LINK:- https://leetcode.com/problems/longest-substring-without-repeating-characters/

// BRUTE FORCE : TIME COMPLEXITY:-O(N^2) AND SPACE COMPLEXITY:- O(N) BECAUSE USING HASHSET
import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLen = 0;

        // starting index & using HashSet for storing unique characters
        for (int i = 0; i < n; i++) {
            HashSet<Character> set = new HashSet<>();

            // ending index
            for (int j = i; j < n; j++) {

                // if character already exists, stop
                if (set.contains(s.charAt(j))) {
                    break;
                }

                // add character to set
                set.add(s.charAt(j));

                // update maximum length
                maxLen = Math.max(maxLen, j - i + 1);
            }
        }
        return maxLen;
    }
}

// OPTIMAL APPROACH : TIME COMPLEXITY:-O(N) AND SPACE COMPLEXITY:- O(N) BECAUSE
// USING HASHMAP

// class Solution {
// public int lengthOfLongestSubstring(String s) {
// int n = s.length();
// int ans = 0;
// int i=0;
// int j=0;
// HashMap<Character, Integer> hmap = new HashMap<>();

// while(j < n) {
// char ch = s.charAt(j);
// hmap.put(ch, hmap.getOrDefault(ch, 0) + 1);

// if(hmap.size() == j-i+1) {
// // HERE WE GOT THE UNIQUE CHARACTERS
// ans = Math.max(ans, j-i+1);
// j++;
// } else if(hmap.size() < j-i+1) {
// // HERE DUPLICATE CHARACTER OCCURS IN MY MAP
// while(hmap.size() < j-i+1) {
// char ch1 = s.charAt(i);
// hmap.put(ch1, hmap.get(ch1) - 1);

// if(hmap.get(ch1) == 0)
// hmap.remove(ch1);
// i++;
// }
// j++;
// }
// }
// return ans;
// }
// }
