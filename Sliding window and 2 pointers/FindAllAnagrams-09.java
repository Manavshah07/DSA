// Question Link:- https://leetcode.com/problems/find-all-anagrams-in-a-string/

// BRUTE FORCE APPROACH WITH

// OPTIMAL APPROACH WITH TIME COMPLEXITY AS O(N) AND SPACE COMPLEXITY AS O(1) because map holds at most 26 letters
import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        // Base guard
        // if (p.length() > s.length()) return result;

        // Step 1: Create frequency map for pattern p
        // CREATING HASHMAP AND STORING THE COUNT OF STRING P
        HashMap<Character, Integer> hmap = new HashMap<>();
        for (int k = 0; k < p.length(); k++) {
            char ch = p.charAt(k);
            hmap.put(ch, hmap.getOrDefault(ch, 0) + 1);
        }

        int i = 0, j = 0;
        int k = p.length(); // window size
        int count = hmap.size(); // // CREATNG COUNT SO WE DON'T NEED TO TRAVERSE WHOLE MAP INSTEAD WE USE IT FOR
                                 // DISTINCT CHARACTER IN PATTERN

        while (j < s.length()) {
            char ch = s.charAt(j);

            // Calculation for character at j
            if (hmap.containsKey(ch)) {
                hmap.put(ch, hmap.get(ch) - 1);

                if (hmap.get(ch) == 0)
                    count--; // all occurrences of this char matched
            }

            // if window size not reached, just move j
            if (j - i + 1 < k) {
                j++;
            }
            // window size reached
            else if (j - i + 1 == k) {

                // count == 0 means valid anagram
                if (count == 0) {
                    result.add(i); // store starting index
                }

                // Before sliding, remove char at i
                char leftChar = s.charAt(i);

                if (hmap.containsKey(leftChar)) {
                    hmap.put(leftChar, hmap.get(leftChar) + 1);

                    if (hmap.get(leftChar) == 1) {
                        count++; // restoring distinct char
                    }
                }

                // slide window
                i++;
                j++;
            }
        }

        return result;
    }
}
