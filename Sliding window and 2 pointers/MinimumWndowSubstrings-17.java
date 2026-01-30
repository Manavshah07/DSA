// Question Link:- https://leetcode.com/problems/minimum-window-substring/

// BRUTE FORCE APPROACH WITH TIME COMPLEXITY AS O(N^2) AND SPACE COMPLEXITY AS O(256)
class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        int minLength = Integer.MAX_VALUE;
        int startIndex = -1;

        for (int i = 0; i < n; i++) {

            // initialize array with 0
            int[] hash = new int[256];
            int count = 0;

            // fill frequency for t
            for (int j = 0; j < m; j++) {
                hash[t.charAt(j)]++;
            }

            // scan window starting from i
            for (int j = i; j < n; j++) {
                char ch = s.charAt(j);

                // HERE IN MY HASH CHARACTER, THE CHARACTER WHICH WE FOUND IN CH IS REQUIRED OR
                // NOT. IF ITS FREQUENCY IS 1 THEN WE REQUIRED THAT CHARACTER SO WE INCREASE THE
                // COUNT
                if (hash[ch] > 0) {
                    count++;
                }
                // HERE WE JUST USED ONE OCCURENCE OF THE CHARACTER
                hash[ch]--;
                /**
                 * Before:
                 * hash['A'] = 1
                 * 
                 * After seeing A:
                 * hash['A'] = 0
                 */

                // CHECKING THAT MY COUNT HAS SAME CHARACTER WHICH IS THEIR IN T IF IT IS THEIR
                // THEN WE ARE CALCULATING THE MINIMUM LENGTH
                if (count == m) {
                    if (j - i + 1 < minLength) {
                        minLength = j - i + 1;
                        startIndex = i;
                    }
                    break;
                }
            }
        }

        if (startIndex == -1)
            return "";
        return s.substring(startIndex, startIndex + minLength);
    }
}

// OPTIMISED APPROACH