// Question Link:- https://leetcode.com/problems/find-the-duplicate-number/submissions/1892568987/

// BRUTE FORCE APPROACH WITH TIME COMPLEXITY AS O(N^2) AND SPACE COMPLEXITY AS O(1)
class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        // int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j])
                    return nums[i];
            }
        }
        return -1;
    }
}

// OPTIMAL APPROACH WITH TIME COMPLEXITY AS O(N) AND SPACE COMPLEXITY AS O(N)
// BECAUSE OF HASHMAP AS EXTRA SPACE IS USED
// class Solution {
// public int findDuplicate(int[] nums) {
// int n = nums.length;
// HashMap<Integer, Integer> hmap = new HashMap<>();

// for(int i=0; i<n; i++) {
// hmap.put(nums[i], hmap.getOrDefault(nums[i], 0) + 1);

// if(hmap.get(nums[i]) > 1)
// return nums[i];
// }
// return -1;
// }
// }