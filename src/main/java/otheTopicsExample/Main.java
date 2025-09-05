package otheTopicsExample;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(103, "Alice", 65000, 28, 5),
                new Employee(101, "Bob", 55000, 35, 10),
                new Employee(105, "Charlie", 70000, 30, 8),
                new Employee(102, "David", 50000, 25, 3)
        );

        System.out.println("Original List:");
        employees.forEach(System.out::println);

        // 1. Default sort by empId (Comparable)
        System.out.println("\nSorted by empId (Default Comparable):");
        Collections.sort(employees);
        employees.forEach(System.out::println);

        // 2. Sort by empAge (Anonymous Class)
        System.out.println("\nSorted by empAge (Anonymous Class):");
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return Integer.compare(e1.getEmpAge(), e2.getEmpAge());
            }
        });
        employees.forEach(System.out::println);

        // 3. Sort by empExperience (Lambda)
        System.out.println("\nSorted by empExperience (Lambda):");
        employees.sort((e1, e2) -> Integer.compare(e1.getEmpExperience(), e2.getEmpExperience()));
        employees.forEach(System.out::println);

        // 4. Sort by empName (Comparator.comparing())
        System.out.println("\nSorted by empName (Comparator.comparing):");
        employees.sort(Comparator.comparing(Employee::getEmpName));
        employees.forEach(System.out::println);

        // 5. Sort by empSalary descending (Comparator.comparing + reversed)
        System.out.println("\nSorted by empSalary (Descending):");
        employees.sort(Comparator.comparing(Employee::getEmpSalary).reversed());
        employees.forEach(System.out::println);

        // 6. Multiple field sort: by Age, then Name
        System.out.println("\nSorted by empAge, then empName:");
        employees.sort(Comparator.comparing(Employee::getEmpAge)
                .thenComparing(Employee::getEmpName));
        employees.forEach(System.out::println);
    }
}
