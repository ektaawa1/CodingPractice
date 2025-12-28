package otheTopicsExample;

import java.util.*;

/**
 * Word Ladder = Shortest path in an unweighted graph
 * Example 1:
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: 5
 * Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
 *
 * Example 2:
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * Output: 0
 * Explanation: The endWord "cog" is not in wordList,
 */
public class WordLadder {
    //BFS + level order
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dictSet = new HashSet<>(wordList); //to mark visited nodes
        if(!dictSet.contains(endWord)){
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int count = 1;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i<size; i++){
                String currWord = queue.poll();
                if(currWord.equals(endWord)){
                    return count;
                }

                char[] arr = currWord.toCharArray();
                for(int j = 0; j< arr.length; j++){
                    char oldCh = arr[j];
                    for(char k = 'a'; k <= 'z'; k++){
                        arr[j] = k;
                        String nextStr = new String(arr);
                        if(dictSet.contains(nextStr)){
                            queue.offer(nextStr);
                            dictSet.remove(nextStr); //mark it visited
                        }
                    }
                    arr[j] = oldCh;
                }
            }
            count++;
        }
        return 0;
    }
}
//Time: O(N × L × 26)
//Space: O(N)
/**
 * Explanation-
 * Add the beginWord to the queue, check if the queue is not empty then get inside the while loop,
 * then get the size of the queue. Then run the for loop from 0 to size of the queue,
 * poll the currWord from the queue and check if this word equals the endWord.
 * if yes then return the count. Otherwise, convert the word to a char array.
 * then run a for loop to work on each character of this array, make a copy of the extracted character,
 * then run another for loop from a to z and insert the character in arr[j].
 * Then convert that array to string. Finally check if the hashset contains that new word created.
 * If it does then offer it to the queue and remove it from the set to mark it visited.
 * then change the arr[j] back to old character. finally before exiting the while loop increase the counter value.
 */
