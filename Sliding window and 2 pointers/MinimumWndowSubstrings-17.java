// Question Link:- https://leetcode.com/problems/minimum-window-substring/

// BRUTE FORCE APPROACH
class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        int minLength = Integer.MAX_VALUE;
        int startIndex = -1;

        for (int i = 0; i < n; i++) {

            int[] hash = new int[256]; // initialize array with 0
            int count = 0;

            // fill frequency for t
            for (int j = 0; j < m; j++) {
                hash[t.charAt(j)]++;
            }

            // scan window starting from i
            for (int j = i; j < n; j++) {
                char ch = s.charAt(j);

                if (hash[ch] > 0) {
                    count++;
                }
                hash[ch]--;

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