// User function Template for Java
// Question Link:- https://www.geeksforgeeks.org/problems/pair-with-given-sum-in-a-sorted-array4940/1 

// BRUTE FORCE WITH TIME COMPLEXITY AS O(N^2) AND SPACE COMPLEXITY AS O(1)
class Solution {
    int countPairs(int arr[], int target) {
        // Complete the function
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target)
                    count++;
            }
        }
        return count;
    }
}



// OPTIMAL APPROACH USING HASHMAP AND TIME COMPLEXITY AS O(N) AND SPACE COMPLEXITY AS O(N) USING HASHMAP
// class Solution {
//     int countPairs(int arr[], int target) {
//         // Complete the function
//         int count = 0;
//         HashMap<Integer, Integer> hmap = new HashMap<>();
        
//         for(int i=0; i<arr.length; i++) {
//             int pair = target - arr[i];
            
//             // HERE AS A DUPLICATE NUMBER OCCURS WE FIRST INCREASE COUNT AND AFTER THAT WE STORE IN MAP
//             if(hmap.containsKey(pair))
//                 count+=hmap.get(pair);
                
//             hmap.put(arr[i], hmap.getOrDefault(arr[i], 0) + 1);
//         }
//         return count;
//     }
// }