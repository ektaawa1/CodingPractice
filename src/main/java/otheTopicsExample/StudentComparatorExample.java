package otheTopicsExample;

import java.util.Comparator;
import java.util.List;

public class StudentComparatorExample {
    public static void main(String[] args) {

        List<Student1> students = List.of(
                new Student1("Alice", 22, 85.5),
                new Student1("Bob", 20, 90.0),
                new Student1("Charlie", 22, 78.0)
        );

        // Sort by name
        students.stream()
                .sorted(Comparator.comparing(Student1::getName))
                .forEach(System.out::println);

        // Sort by age
        students.stream()
                .sorted(Comparator.comparingInt(Student1::getAge))
                .forEach(System.out::println);

        // Sort by score (desc)
        students.stream()
                .sorted(Comparator.comparingDouble(Student1::getScore).reversed())
                .forEach(System.out::println);

        // By name
        students.sort(Comparator.comparing(Student1::getName));

        // By age
        students.sort(Comparator.comparingInt(Student1::getAge));

        // By score (descending)
        students.sort(Comparator.comparingDouble(Student1::getScore).reversed());
    }
}
