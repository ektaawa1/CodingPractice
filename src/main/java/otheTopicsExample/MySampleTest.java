package otheTopicsExample;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MySampleTest {
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<List<String>> outputList = new ArrayList<>();
        list1.add("aa");
        list1.add("bb");
        list1.add("cc");

        list2.add("cc");
        list2.add("dd");
        list2.add("aa");

        //["aa", "aa"]
        outputList.add(list1.stream().filter(s->s.charAt(0) == 'a').collect(Collectors.toList()));
        outputList.add(list2.stream().filter(s->s.charAt(0) == 'a').toList());

//        for(String s: list1){
//            if(s.charAt(0) == 'a'){
//                outputList.add(s);
//            }
//        }
//        for(String s1: list2){
//            if(s1.charAt(0) == 'a'){
//                outputList.add(s1);
//            }
//        }
        for(int i = 0; i< outputList.size(); i++){
            System.out.println(outputList.get(i));
        }
    }
}
