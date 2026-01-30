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

// OPTIMISED APPROACH WITH TIME COMPLEXITY AS O(2N) + O(M) AND SPACE COMPLEXITY
// AS O(256)
// class Solution {
// public String minWindow(String s, String t) {
// int n = s.length();
// int m = t.length();
// int minLength = Integer.MAX_VALUE;
// int startIndex = -1;
// int i = 0, j = 0, count = 0;
// HashMap<Character, Integer> hmap = new HashMap<>();

// // ADDING THE CHARACTER OF STRING T INTO THE HASHMAP
// // TIME COMPLEXITY FOR THIS LOOP IS O(M)
// for (int k = 0; k < t.length(); k++) {
// char ch = t.charAt(k);
// hmap.put(ch, hmap.getOrDefault(ch, 0) + 1);
// }

// // TIME COMPLEXITY FOR THIS LOOP IS O(n)
// while (j < s.length()) {
// char ch = s.charAt(j);

// // IF HMAP HAS THE CHARACTER WHICH IS PRESENT IN STRING T AND AFTER THAT WE
// ARE
// // CHECKING THAT CHARACTER FREQUENCY IS GREATER THAN 0 THEN WE ARE INCREASING
// // THE COUNT AND DECREMENTING ITS FREQUENCY FROM THE MAP
// if (hmap.containsKey(ch)) {
// if (hmap.get(ch) > 0)
// count += 1;
// hmap.put(ch, hmap.get(ch) - 1);
// }

// // IF MY COUNT IS EQUAL TO STRING T LENGTH THEN WE WILL CALCULATE MINLENGTH
// // TIME COMPLEXITY FOR THIS LOOP IS O(N) AND THIS WILL RUN IN MAXIMUM WORST
// CASE
// while (count == m) {
// if (j - i + 1 < minLength) {
// minLength = j - i + 1;
// // WE USED STARTINDEX TO CALCUATE THE MINIMUM STRING
// startIndex = i;
// }

// // HERE WE ARE CALCULATING FOR ITH INDEX POSITION
// char leftChar = s.charAt(i);
// // IF MY CHARACTER CONTAINS IN HASHMAP THEN WE NEED DO ALL THE CALCULATIONS
// THAT
// // ARE THEIR PREVIOUSLY SO WE ARE JUST INCREASING THE FREQUENCY OF THAT
// // CHARACTER AND AFTER THAT IF ITS FREQUENCT IS GREATER THAN 0 SO WE ARE
// DOING
// // COUNT-- AS WE SHRINKING OUR WINDOW SO WE WILL REMOVE THAT CHARACTER
// if (hmap.containsKey(leftChar)) {
// hmap.put(leftChar, hmap.get(leftChar) + 1);
// if (hmap.get(leftChar) > 0)
// count--;
// }
// i++;
// }
// j++;
// }
// if (startIndex == -1)
// return "";
// return s.substring(startIndex, startIndex + minLength);
// }
// }