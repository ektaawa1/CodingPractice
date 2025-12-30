package otheTopicsExample;

import java.util.*;

/**
 * Example 1:
 * Input: startGene = "AACCGGTT", endGene = "AACCGGTA", bank = ["AACCGGTA"]
 * Output: 1
 *
 * Example 2:
 * Input: startGene = "AACCGGTT", endGene = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]
 * Output: 2
 */
public class MinGeneMutation {
    //same as word ladder
    public int minMutation(String startGene, String endGene, String[] bank) {
        char[] choices = {'A', 'C', 'G', 'T'};
        Set<String> visitedSet = new HashSet<>(Arrays.asList(bank));
        if(!visitedSet.contains(endGene)){
            return -1;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);
        int count = 0;
        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0; i<size; i++){
                String currStr = queue.poll();
                if(currStr.equals(endGene)){
                    return count;
                }
                char[] arr = currStr.toCharArray();
                for(int j = 0; j<8; j++){
                    char old = arr[j];
                    for(char g : choices){
                        arr[j] = g;
                        String nextWord = new String(arr);
                        if(visitedSet.contains(nextWord)){
                            queue.offer(nextWord);
                            visitedSet.remove(nextWord);
                        }
                    }
                    arr[j] = old;
                }
            }
            count++;
        }
        return -1;
    }
}
