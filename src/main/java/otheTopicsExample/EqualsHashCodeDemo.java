package otheTopicsExample;

import java.util.HashSet;
import java.util.Objects;

class EmployeeA {
    int empId;
    String empName;

    public EmployeeA(int empId, String empName) {
        this.empId = empId;
        this.empName = empName;
    }

    // Uncomment these two methods and see the difference
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; //This checks if the two objects are literally the same thing in memory.
        if (!(o instanceof EmployeeA)) return false; //This checks if the object o is even an Employee
        EmployeeA employee = (EmployeeA) o; //we convert (cast) the Object o into an Employee type.
        return empId == employee.empId; //we compare the empId of this object with the empId of the other Employee.
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId);
    }

    @Override
    public String toString() {
        return empId + " - " + empName; //Decides how that emp info is printed for humans to read.
    }
}

public class EqualsHashCodeDemo {
    public static void main(String[] args) {
        HashSet<EmployeeA> employees = new HashSet<>();

        EmployeeA e1 = new EmployeeA(101, "Alice");
        EmployeeA e2 = new EmployeeA(101, "Alice");

        employees.add(e1);
        employees.add(e2);

        System.out.println("Employees in set: " + employees);
    }
}

/**
 * Step 1: Run Without equals() & hashCode()
 * Output: Employees in set: [101 - Alice, 101 - Alice]
 * Java thinks they’re different because it’s comparing memory addresses.
 */
/**
 * Step 2: Uncomment equals() & hashCode()
 * Output: Employees in set: [101 - Alice]
 * Now Java knows they are the same object logically, and avoids duplicates.
 */

