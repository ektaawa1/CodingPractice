package otheTopicsExample;

import java.util.Objects;

public class Employee implements Comparable<Employee> {
    private int empId;
    private String empName;
    private double empSalary;
    private int empAge;
    private int empExperience;

    public Employee(int empId, String empName, double empSalary, int empAge, int empExperience) {
        this.empId = empId;
        this.empName = empName;
        this.empSalary = empSalary;
        this.empAge = empAge;
        this.empExperience = empExperience;
    }

    // Getters
    public int getEmpId() { return empId; }
    public String getEmpName() { return empName; }
    public double getEmpSalary() { return empSalary; }
    public int getEmpAge() { return empAge; }
    public int getEmpExperience() { return empExperience; }

    // Default Sorting by empId
    @Override
    public int compareTo(Employee other) {
        return Integer.compare(this.empId, other.empId);
    }

    // equals() and hashCode() - Best practice to keep consistent with compareTo
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return empId == employee.empId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId);
    }

    @Override
    public String toString() {
        return empId + " - " + empName + " - Salary: " + empSalary +
                " - Age: " + empAge + " - Exp: " + empExperience;
    }
}

