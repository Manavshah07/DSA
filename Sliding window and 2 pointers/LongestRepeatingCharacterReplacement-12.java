// Question Link:- https://leetcode.com/problems/longest-repeating-character-replacement/

// BRUTE FORCE WITH TIME COMPLEXITY AS O(N^2) AND SPACE COMPLEXITY AS O(26) AS WE ARE USING EXTERNAL SPACE OF STORING 26 LETTERS INTO THE ARRAY
class Solution {
    public int characterReplacement(String s, int k) {
        // IF WE NEED TO CALCUALTE HOW MANY LETTER WE NEED TO CHANGE WE CAN CALUCATE IT
        // BY TOTAL LENGTH - MAX FREQUENCY OF LETTER
        int n = s.length();
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            int[] hash = new int[26];
            int maxFreq = 0;

            for (int j = i; j < n; j++) {
                // IT WILL CONVERT CHARACTER INTO THE INTEGER AND ACCORDING TO THE CHARACTER IT
                // WILL STORE ITS FREQUENCY IN THE ARRAY
                // FOR AABC AT HASH[0] IT WILL STORE A -> 2, AT HASH[1] IT WILL STORE B -> 1, AT
                // HASH[2] IT WILL STORE C -> 1
                hash[s.charAt(j) - 'A']++;

                // MAXFREQ WILL HELP US TO COUNT THE MAXFREQ OF THE LETTER PRESENT IN STRING S
                maxFreq = Math.max(maxFreq, hash[s.charAt(j) - 'A']);

                // CHANGES WILL HELP US TO COUNT THAT HOW MANY LETTER WE NEED TO CHANGE
                int changes = (j - i + 1) - maxFreq;
                if (changes <= k)
                    maxLength = Math.max(maxLength, j - i + 1);
                else
                    break;
            }
        }
        return maxLength;
    }
}

// OPTIMAL APPROACH WITH TIME COMPLEXITY AS O(N + N) * 26 INSIDE WHILE WE ARE
// CHECKING EXTRA CHARACTER OR HASH OF FREQUENCY AND SPACE COMPLEXITY AS O(26)
// class Solution {
// public int characterReplacement(String s, int k) {
// int i = 0, j = 0, maxLength = 0, maxFreq = 0;
// int n = s.length();
// HashMap<Character, Integer> hmap = new HashMap<>();

// while(j < n) {
// char ch = s.charAt(j);
// hmap.put(ch, hmap.getOrDefault(ch, 0) + 1);

// // HERE WE WILL GET THE MAXFREQ OF THE CHARACTER
// maxFreq = Math.max(maxFreq, hmap.get(ch));

// // HERE IF NEED TO CHANGE THE CHARACTER MORE THAN K THEN WE WILL START
// REMOVING THE CHARACTER FROM START I.E I
// while((j-i+1) - maxFreq > k) {
// char ch1 = s.charAt(i);
// hmap.put(ch1, hmap.get(ch1) - 1);

// // HERE WE SHRINK OUR WINDOW BY REMOVING FIRST CHARACTER OF I OR FROM LEFT
// SIDE AND AFTER THAT DOING I++ SO FOR THAT WE WILL RECALCUATE OUR MAXFREQ
// // recalculate maxFreq
// maxFreq = 0;

// // HERE THIS LOOP IS ALSO USED FOR RECALCULATING THE MAXFREQ
// for (int val : hmap.values()) {
// maxFreq = Math.max(maxFreq, val);
// }
// i++;
// }

// if((j-i+1) - maxFreq <= k)
// maxLength = Math.max(maxLength, j-i+1);
// else
// break;
// j++;
// }

// return maxLength;
// }
// }

// MORE OPTIMAL APPROACH WITH TIME COMPLEXITY AS O(N) INSIDE WHILE WE ARE
// CHECKING EXTRA CHARACTER OR HASH OF FREQUENCY AND SPACE COMPLEXITY AS O(26)
// class Solution {
// public int characterReplacement(String s, int k) {
// int i = 0, j = 0, maxLength = 0, maxFreq = 0;
// int n = s.length();
// HashMap<Character, Integer> hmap = new HashMap<>();

// while(j < n) {
// char ch = s.charAt(j);
// hmap.put(ch, hmap.getOrDefault(ch, 0) + 1);

// // HERE WE WILL GET THE MAXFREQ OF THE CHARACTER
// maxFreq = Math.max(maxFreq, hmap.get(ch));

// // HERE IF NEED TO CHANGE THE CHARACTER MORE THAN K THEN WE WILL START
// REMOVING THE CHARACTER FROM START I.E I
// // HERE IT WILL SHRINK ONLY ONCE
// if((j-i+1) - maxFreq > k) {
// char ch1 = s.charAt(i);
// hmap.put(ch1, hmap.get(ch1) - 1);

// i++;
// }

// if((j-i+1) - maxFreq <= k)
// maxLength = Math.max(maxLength, j-i+1);
// else
// break;
// j++;
// }

// return maxLength;
// }
// }