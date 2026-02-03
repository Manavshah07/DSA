// Question Link:- https://leetcode.com/problems/last-stone-weight/description/

// BRUTE FORCE APPROACH WITH O(n² log n) 
import java.util.*;

class Solution {
    public int lastStoneWeight(int[] stones) {
        ArrayList<Integer> list = new ArrayList<>();

        // CONVERT ARRAY TO LIST
        for (int i = 0; i < stones.length; i++) {
            list.add(stones[i]);
        }

        // IT RUNS FOR O(n² log n) times
        // WHILE LOOP RUNS FOR O(N) TIME AND SORTING RUNS FOR O(NLOGN) TIMES
        while (list.size() > 1) {
            // SORT IN REVERSE ORDER
            // SORTING RUNS FOR O(nlogn times)
            Collections.sort(list, Collections.reverseOrder());

            int y = list.get(0); // largest
            int x = list.get(1); // second largest

            // remove both stones
            // here it will remove the index 0 i.e largest element of list and after that
            // second largest element comes at index 0 so thats why are again remove index 0
            // i.e. second largest element
            list.remove(0);
            list.remove(0);

            if (y != x) {
                list.add(Math.abs(x - y));
            }
        }
        if (list.size() == 0)
            return 0;
        else
            // Atlast we will get the answer in the list at the index 0 so thats why we are
            // returning list.get(0)
            return list.get(0);
    }
}