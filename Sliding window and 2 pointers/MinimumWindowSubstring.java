import java.util.*;

// BRUTE FORCE: TIME COMPLEXITY:- O(N^3) & SPACE COMPLEXITY:- O(1) AS ALPHABET SIZE IS FIXED
class Solution {
    public String minWindow(String s, String t) {
        int ans = Integer.MAX_VALUE;
        int start = 0; // IT WILL REMEMBER THE BEST WINDOW SIZE I.E. ith VALUE
        int n = s.length();

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                // HERE WE ARE CHECKING WITH ONLY 3 CHARACTER AS WE NEED TO CHECK WITH t WHICH
                // IS 3 CHARACTERS
                String sub = s.substring(i, j + 1);

                // HERE WE ARE CHECKING THAT CHARACTER IN WINDOW SIZE IS SAME AS T OR NOT
                if (isValid(sub, t)) {
                    // CHECKING FOR THE MINIMUM LENGTH LIKE THE NEW LENGTH IS SMALLLER THAN ANS OR
                    // NOT IF YES THEN UPDATE THE NEW MINIMUM LENGTH AS ANS
                    if (sub.length() < ans) {
                        ans = sub.length();
                        start = i;
                    }
                }
            }
        }

        if (ans == Integer.MAX_VALUE)
            return "";
        // IT WILL GIVE US THE ANS BY CALCULATING THE INDEX.
        // START MEANS FROM WHERE THE WINDOWS START AND START + ANS CALCULATE THE
        // ENDINDEX OF THE STRING AND AS WE GET INDEX IT WILL CALCULATE THE ANS
        /**
         * FOR Input: s = "ADOBECODEBANC", t = "ABC"
         * IT WILL START = 9, START + ANS = 9 + 4 = 13 WHICH WILL PRINT BANC
         */
        return s.substring(start, start + ans);
    }

    // HERE WE ARE CHECKING THAT "t" STRING EXIST IN THE STRING "sub"
    private boolean isValid(String sub, String t) {
        // WE TOOK 128 BECAUSE IT COVERS ALL BASIC ENGLISH CHARACTERS AND WE REFER IT AS
        // A ASCII CHARACTERS AND HERE WE ARE GOING TO STORE THE CHARACTER AND ITS COUNT
        // THAT HOW MANY TIME IT CAME
        int[] freq = new int[128];

        // HERE WE ARE TRAVERSING THROUGH EACH CHARACTER AND COUNTING IT
        for (int i = 0; i < sub.length(); i++) {
            freq[sub.charAt(i)]++;
        }

        // HERE WE CHECK THAT "t" STRING CHARACTER IS PRESENT IN FREQ ARRAY OR NOT
        for (int i = 0; i < t.length(); i++) {
            if (--freq[t.charAt(i)] < 0)
                return false;
        }
        return true;
    }
}

// OPTIMAL APPROACH: TIME COMPLEXITY:- O(N) & SPACE COMPLEXITY:- O(1) AS
// ALPHABET SIZE IS FIXED
// class Solution {
// public String minWindow(String s, String t) {
// int ans = Integer.MAX_VALUE;
// int start = 0;

// HashMap<Character, Integer> hmap = new HashMap<>();
// // STORING ALL THE CHARACTER OF 'T' INTO THE HASHMAP
// for (int i = 0; i < t.length(); i++) {
// char ch = t.charAt(i);
// hmap.put(ch, hmap.getOrDefault(ch, 0) + 1);
// }

// int i = 0, j = 0;
// int count = hmap.size();
// int n = s.length();

// while (j < n) {
// char ch = s.charAt(j);
// // HERE WE ARE CHECKING THAT THE CHARACTER IS PRESENT IN MAP OR NOT, IF IT IS
// // PRESENT THEN DECREMENTING THE COUNT OF CHARACTER IN HMAP
// if (hmap.containsKey(ch)) {
// hmap.put(ch, hmap.get(ch) - 1);

// // IF THE COUNT OF THAT CHARACTER COMES TO 0 THEN WE WILL DO COUNT--
// if (hmap.get(ch) == 0)
// count--;
// }

// // HERE AS WE GET COUNT == 0 THEN WE STORE OUR ANS AND INCREMENT THE I FOR
// // CHECKING THE NEXT POSSIBLE MINIMUM ANSWER
// while (count == 0) {
// // HERE WE ARE STORING THE MINIMUM ANSWER AND WE NEED START SO LATER WE CAN
// GET
// // EXACT SUBSTRING
// if (j - i + 1 < ans) {
// ans = j - i + 1;
// // WE USE START TO CALCUATE THE SUBSTRING FROM THE I
// start = i;
// }

// // DOING ALL THE CALCULATION FOR I
// char ch1 = s.charAt(i);
// if (hmap.containsKey(ch1)) {
// hmap.put(ch1, hmap.get(ch1) + 1);

// // AFTER INCREMENTING I WE REMOVE ALL THE PREVIOUS CALCULATIONS OF I SO IF
// THE
// // CHARACTER EXIST IN HASHMAP AND WE REMOVE THAT CHARACTER THEN IT SAYS THAT
// // CHARACTER IS MISSING AND ALSO WE INCREMENT THE COUNT
// if (hmap.get(ch1) == 1)
// count++;
// }
// i++;
// }
// j++;
// }

// if (ans == Integer.MAX_VALUE)
// return "";
// // IT WILL GIVE US THE ANS BY CALCULATING THE INDEX.
// // START MEANS FROM WHERE THE WINDOWS START AND START + ANS CALCULATE THE
// // ENDINDEX OF THE STRING AND AS WE GET INDEX IT WILL CALCULATE THE ANS
// /**
// * FOR Input: s = "ADOBECODEBANC", t = "ABC"
// * IT WILL START = 9, START + ANS = 9 + 4 = 13 WHICH WILL PRINT BANC
// */
// return s.substring(start, start + ans);
// }
// }