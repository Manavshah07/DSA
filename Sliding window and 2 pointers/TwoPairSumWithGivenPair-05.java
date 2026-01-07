// Question Link:- https://www.geeksforgeeks.org/problems/key-pair5616/1 

// BRUTE FORCE APPROACH:- TIME COMPLEXITY: O(N^2) & SPACE COMPLEXITY: O(1) AS NO EXTRA SPACE HAS BEEN USED
class Solution {
    boolean twoSum(int arr[], int target) {
        // code here
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == target)
                    return true;
            }
        }
        return false;
    }
}

// OPTIMAL APPROACH