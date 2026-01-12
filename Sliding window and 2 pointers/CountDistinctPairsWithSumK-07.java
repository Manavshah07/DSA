// Question Link:- https://www.geeksforgeeks.org/problems/count-distinct-pairs-with-difference-k1233/1 

import java.util.*;

// BRUTE FORCE WITH TIME COMPLEXITY AS O(N^2) AND SPACE COMPLEXITY AS O(N)
class Solution {
    public int TotalPairs(int[] nums, int k) {
        // Code here
        int count = 0;
        // HERE WE ARE STORING AS A PAIR IN A HASHSET AND INTEGER ONLY STORES THE SINGLE
        // VALUE, BUT STRING CAN STORES MULTIPLE VALUE AS "5:3" OR "3:5" SO THATS THE
        // REASON WE USED STRING
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                if (Math.abs(nums[i] - nums[j]) == k) {
                    int a = Math.max(nums[i], nums[j]);
                    int b = Math.min(nums[i], nums[j]);

                    // store pair in sorted order so (5,3) and (3,5) become the same
                    set.add(a + ":" + b);
                }
            }
        }
        return set.size();
    }
}

// OPTIMAL APPROACH WITH TIME COMPLEXITY AS O(N) AND SPACE COMPLEXITY AS O(N)
// User function Template for Java
// class Solution {
// public int TotalPairs(int[] nums, int k) {
// // Code here
// // This will store numbers we have already visited in the array
// // Purpose: fast lookup (O(1)) to check existence
// Set<Integer> seen = new HashSet<>();

// // It stores the distinct pairs in string format like "1, 3" and it avoid
// // counting duplicates"
// Set<String> result = new HashSet<>();
// for (int x : nums) {
// // HERE WE ARE CHECKING THAT X-K CONTAINS IN HASHSET OR NOT IF IT CONTAINS
// THEN
// // WE ARE STORING IN RESULT AS A PAIR. IF NOT THEN WE ARE STORING THE NUMBER
// IN
// // HASHSET
// if (seen.contains(x - k)) {
// int a = x - k;
// int b = x;
// result.add(a + "," + b);
// }

// if (seen.contains(x + k)) {
// int a = x;
// int b = x + k;
// result.add(a + "," + b);
// }
// seen.add(x);
// }
// return result.size();
// }
// }