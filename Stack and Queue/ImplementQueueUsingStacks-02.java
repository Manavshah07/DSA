// Question Link:- https://leetcode.com/problems/implement-queue-using-stacks/description/ 

// APPROACH WITH TIME COMPLEXITY AS O(N) AND SPACE COMPLEXITY AS O(N)
// HERE MY PUSH OPERATION IS COSTLIER
import java.util.*;

class MyQueue {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public MyQueue() {

    }

    public void push(int x) {
        // REMOVE ALL ELEMENT FROM s1 AND PUSH IT INTO s2
        /***
         * - s1 -> s2
         * - x -> s1
         * - s2 -> s1
         */
        while (!s1.empty()) {
            s2.push(s1.peek());
            s1.pop();
        }
        // PUSH ALL ELEMENT INTO s1
        s1.push(x);
        // REMOVE ALL ELEMENT FROM s2 AND PUSH IT INTO s1
        while (!s2.empty()) {
            s1.push(s2.peek());
            s2.pop();
        }
        // HERE WE WILL FIND OUR TOP IN s1
    }

    public int pop() {
        int curr = s1.peek();
        s1.pop();
        return curr;
    }

    public int peek() {
        return s1.peek();
    }

    public boolean empty() {
        return s1.empty();
    }
}

// APPROACH WITH TIME COMPLEXITY AS O(N) AND SPACE COMPLEXITY AS O(N)
// HERE MY POP OPERATION IS COSTLIER

class MyQueue2 {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public MyQueue2() {

    }

    public void push(int x) {
        // PUSHING ALL THE ELMENTS INTO s1
        s1.push(x);
    }

    public int pop() {
        // PUSH ALL THE ELEMENTS TO s2 and POP THE ELEMENTS FROM s1
        if (s2.empty()) {
            while (!s1.empty()) {
                s2.push(s1.peek());
                s1.pop();
            }
        }
        return s2.pop();
    }

    public int peek() {
        // PUSH ALL THE ELEMENTS TO s2 and POP THE ELEMENTS FROM s1
        if (s2.empty()) {
            while (!s1.empty()) {
                s2.push(s1.peek());
                s1.pop();
            }
        }
        return s2.peek();
    }

    public boolean empty() {
        return s1.empty() && s2.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */