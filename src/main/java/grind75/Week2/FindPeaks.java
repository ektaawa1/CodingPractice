package grind75.Week2;

import java.util.ArrayList;
import java.util.List;

// 2951. Find the Peaks
public class FindPeaks {
    public List<Integer> findPeaks(int[] mountain) {
        ArrayList<Integer> indexList = new ArrayList<>();
        for(int i = 1; i< mountain.length-1; i++){
            if(mountain[i] > mountain[i-1] && mountain[i] > mountain[i+1]){
                indexList.add(i);
            }
        }
        return indexList;
    }
}
