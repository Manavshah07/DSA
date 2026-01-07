
// QUESTION LINK:- https://leetcode.com/problems/fruit-into-baskets/ 
// BRUTE FORCE : TIME COMPLEXITY:-O(N^2) AND SPACE COMPLEXITY:- O(N) BECAUSE USING HASHSET
import java.util.*;

class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            // starting index & using HashSet for storing unique characters
            HashSet<Integer> hset = new HashSet<>();
            for (int j = i; j < n; j++) {
                // Adding all the furits into the hashet
                hset.add(fruits[j]);

                // if unique character size becomes more than 2 then will skip the line
                if (hset.size() > 2)
                    break;

                ans = Math.max(ans, j - i + 1);
            }
        }
        return ans;
    }
}

// OPTIMAL APPROACH:- TIME COMPLEXITY:-O(N) AND SPACE COMPLEXITY:- O(1) BECAUSE
// ONLY 2 KEYS MAX
// class Solution {
// public int totalFruit(int[] fruits) {
// int n = fruits.length;
// int i = 0, j = 0;
// int ans = 0;

// HashMap<Integer, Integer> hmap = new HashMap<>();

// while (j < n) {

// // EXPAND WINDOW, STORING THE NUMBER & ITS COUNT INTO HASHMAP
// hmap.put(fruits[j], hmap.getOrDefault(fruits[j], 0) + 1);

// // IF SIZE > 2, THEN REMOVE ELEMENTS FROM START I.E. FROM ITH INDEX
// while (hmap.size() > 2) {
// hmap.put(fruits[i], hmap.get(fruits[i]) - 1);

// // IF MY COUNT COMES TO 0 THEN WE ARE REMOVING THAT NUMBER
// if (hmap.get(fruits[i]) == 0) {
// hmap.remove(fruits[i]);
// }
// i++;
// }

// // UPDATING THE ANSWER (<= 2 types)
// ans = Math.max(ans, j - i + 1);

// j++;
// }
// return ans;
// }
// }
