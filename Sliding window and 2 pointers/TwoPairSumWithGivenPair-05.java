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

// OPTIMAL APPROACH - TIME COMPLEXITY:- O(n log n) HERE SORTING TAKES O(n log n)
// TIME COMPLEXITY AND TWO POINTER TAKES O(n) COMPLEXITY SO TOTAL IT TAKES O(n
// log n) AND SPACE COMPLEXITY IS O(1) AS NO EXTRA SPACE IS USED

// class Solution {
// boolean twoSum(int arr[], int target) {
// // code here
// Arrays.sort(arr);
// int left = 0;
// int right = arr.length - 1;

// while(left < right) {
// int sum = arr[left] + arr[right];

// if(sum > target)
// right--;
// else if(sum < target)
// left++;
// else
// return true;

// }
// return false;
// }
// }

// OPTIMAL APPROACH WITH TIME COMPLEXITY AS O(N) AND SPACE COMPLEXITY ALSO AS
// O(N) AS WE TOOK HASHMAP
// class Solution {
// boolean twoSum(int arr[], int target) {
// // code here
// HashMap<Integer, Boolean> hmap = new HashMap<>();
// // HERE WE TOOK BOOLEAN AS THE NUMBER EXIST IN HASHMAP SO WE ENTER IT AS TRUE
// AND IF IT FOUND WHILE CHECKING THEN WE MARK IT AS TRUE

// for(int i=0; i<arr.length; i++) {
// int pair = target - arr[i];

// if(hmap.containsKey(pair)) {
// return true;
// }
// hmap.put(arr[i], true);
// }
// return false;
// }
// }