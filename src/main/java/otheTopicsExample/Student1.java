package otheTopicsExample;

import java.util.Comparator;

public class Student1 {
    private String name;
    private int age;
    private double score;

    public Student1(String stuName, int stuAge, double stuScore){
        this.name = stuName;
        this.age = stuAge;
        this.score = stuScore;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public double getScore() { return score; }

    @Override
    public String toString(){
        return name + " | age=" + age + " | score=" + score;
    }
}

