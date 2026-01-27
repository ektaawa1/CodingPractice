package otheTopicsExample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample {
    public static void main(String[] args) {

        List<Student1> students = new ArrayList<>();
        students.add(new Student1("Rahul", 22, 85.5));
        students.add(new Student1("Anita", 20, 92.0));
        students.add(new Student1("Vikram", 21, 78.0));

        // Sort by Name
        Collections.sort(students, new StudentNameComparator());
        System.out.println("By Name: " + students);

        // Sort by Age
        Collections.sort(students, new StudentAgeComparator());
        System.out.println("By Age: " + students);

        // Sort by Score
        Collections.sort(students, new StudentScoreComparator());
        System.out.println("By Score: " + students);
    }
}
class StudentNameComparator implements Comparator<Student1> {

    @Override
    public int compare(Student1 s1, Student1 s2) {
        return s1.getName().compareTo(s2.getName());
    }
}

class StudentAgeComparator implements Comparator<Student1> {

    @Override
    public int compare(Student1 s1, Student1 s2) {
        return Integer.compare(s1.getAge(), s2.getAge());
    }
}

class StudentScoreComparator implements Comparator<Student1> {

    @Override
    public int compare(Student1 s1, Student1 s2) {
        return Double.compare(s2.getScore(), s1.getScore());
    }
}