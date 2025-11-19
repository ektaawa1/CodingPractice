package otheTopicsExample;

import java.util.ArrayList;
import java.util.List;

public class SampleTestArrayList {
    public static void main(String[] args){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr1 = new ArrayList<>();

        //Case1:
        curr.add(1); //[1]
        res.add(curr);  // adding reference [[1]] (but holds reference to same curr)
        curr.add(2); //[1,2]
        res.add(curr);  // adding same reference again output = [[1,2],[1,2]]
        System.out.println(res);
        //res doesn’t store a snapshot; it stores a reference to the same list curr.
        //When you later modify curr, all references inside res also reflect that change.
        //So both entries end up pointing to the same memory object, resulting in duplicated content

        //Case2:
        //Here, new ArrayList<>(curr) creates a copy (a snapshot of current state).
        //Thus, even if curr changes later, the snapshot inside res remains intact.
        curr1.add(3);//[3]
        result.add(new ArrayList<>(curr1));  // Adds a snapshot copy → stored safely  [[3]]
        curr1.add(4);//[3,4]
        result.add(new ArrayList<>(curr1)); // [[3], [3,4]]
        System.out.println(result);
    }
}
