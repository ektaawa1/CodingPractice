package patternBased.graph.dfsBfs;
//841. Keys and Rooms

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Input: rooms = [[1],[2],[3],[]]
 * Output: true
 * Explanation:
 * We visit room 0 and pick up key 1.
 * We then visit room 1 and pick up key 2.
 * We then visit room 2 and pick up key 3.
 * We then visit room 3.
 * Since we were able to visit every room, we return true.
 *
 * Input: rooms = [[1,3],[3,0,1],[2],[0]]
 * Output: false
 * Explanation: We can not enter room number 2 since the only key that unlocks it is in that room.
 */
public class KeysAndRooms {
    //BFS Logic: TC is O(n+k) where n is the number of rooms and k is the total number of keys.
    // SC is O(n) for visited array and a queue
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        if(rooms == null || rooms.size() == 0){
            return false;
        }

        int n = rooms.size();
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];

        q.offer(0);
        visited[0] = true;
        int count = 1;
        while(!q.isEmpty()){
            int currRoom = q.poll();
            for(int r : rooms.get(currRoom)){
                if(!visited[r]){
                    visited[r] = true;
                    q.offer(r);
                    count++;
                }
            }
        }
        return count == n;
    }
    //DFS Approach
    public boolean canVisitAllRooms1(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();

        // Start at room 0
        stack.push(0);
        visited[0] = true;
        int count = 1;

        while (!stack.isEmpty()) {
            int currentRoom = stack.pop();

            for (int key : rooms.get(currentRoom)) {
                if (!visited[key]) {
                    visited[key] = true;
                    stack.push(key);
                    count++;
                }
            }
        }

        return count == n;
    }
}
