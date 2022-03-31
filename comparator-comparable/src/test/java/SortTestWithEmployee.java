import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SortTestWithEmployee {
    List<Employee> employee;
    List<Employee> employeesWithNull;
    List<Employee> sortedEmployeesByName;
    List<Employee> sortedEmployeesByNameDesc;
    List<Employee> sortedEmployeesByAge;
    List<Employee> sortedEmployeesByNameWithNullFirst;
    List<Employee> sortedEmployeesByNameWithNullLast;
    List<Employee> sortedEmployeesByNameWithThenComparing;
    List<Employee> employeeForThenCompering;


    @Before
    public void init(){
        employee = Arrays.asList(
                new Employee("John", 25, 3000.0, 9922001),
                new Employee("Ace", 22, 2000.0, 5924001),
                new Employee("Keith", 35, 4000.0, 3924401)
        );
        employeeForThenCompering = Arrays.asList(
                new Employee("Keith", 40, 4000.0, 3924401),
                new Employee("John", 25, 3000.0, 9922001),
                new Employee("Ace", 22, 2000.0, 5924001),
                new Employee("Keith", 35, 4000.0, 3924401)
        );
        employeesWithNull = Arrays.asList(
                new Employee("John", 25, 3000.0, 9922001),
                null,
                new Employee("Ace", 22, 2000.0, 5924001),
                null,
                new Employee("Keith", 35, 4000.0, 3924401)
        );
        sortedEmployeesByName = Arrays.asList(
                new Employee("Ace", 22, 2000.0, 5924001),
                new Employee("John", 25, 3000.0, 9922001),
                new Employee("Keith", 35, 4000.0, 3924401)
        );
        sortedEmployeesByNameWithNullFirst = Arrays.asList(
                null,
                null,
                new Employee("Ace", 22, 2000.0, 5924001),
                new Employee("John", 25, 3000.0, 9922001),
                new Employee("Keith", 35, 4000.0, 3924401)
        );
        sortedEmployeesByNameWithNullLast = Arrays.asList(
                new Employee("Ace", 22, 2000.0, 5924001),
                new Employee("John", 25, 3000.0, 9922001),
                new Employee("Keith", 35, 4000.0, 3924401),
                null,
                null
        );
        sortedEmployeesByNameDesc = Arrays.asList(
                new Employee("Keith", 35, 4000.0, 3924401),
                new Employee("John", 25, 3000.0, 9922001),
                new Employee("Ace", 22, 2000.0, 5924001)
        );
        sortedEmployeesByAge = Arrays.asList(
                new Employee("Ace", 22, 2000.0, 5924001),
                new Employee("John", 25, 3000.0, 9922001),
                new Employee("Keith", 35, 4000.0, 3924401)
        );
        sortedEmployeesByNameWithThenComparing = Arrays.asList(
                new Employee("Ace", 22, 2000.0, 5924001),
                new Employee("John", 25, 3000.0, 9922001),
                new Employee("Keith", 35, 4000.0, 3924401),
                new Employee("Keith", 40, 4000.0, 3924401)
        );

    }

    @Test
    public void comparingWithComparatorSorterByNameDesc(){
        List<Employee> employeesExpected = employee.stream()
                .sorted(Comparator.comparing(Employee::getName, Comparator.reverseOrder()))
                .toList();

        assertEquals(employeesExpected, sortedEmployeesByNameDesc);
    }

    @Test
    public void comparingWithComparatorSortedByName(){
        List<Employee> employeesExpected = employee.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .toList();

        assertEquals(employeesExpected, sortedEmployeesByName);
    }

    @Test
    public void comparingWithComparatorSortedByAge(){
        List<Employee> employeesExpected = employee.stream()
                .sorted(Comparator.comparingInt(Employee::getAge))
                .toList();

        assertEquals(employeesExpected, sortedEmployeesByAge);
    }

    @Test
    public void sortedByName_nullFirst(){
        List<Employee> employeesExpected = employeesWithNull.stream()
                .sorted(Comparator.nullsFirst(Comparator.comparing(Employee::getName)))
                .toList();

        assertEquals(employeesExpected, sortedEmployeesByNameWithNullFirst);
    }

    @Test
    public void sortedByName_nullLast(){
        List<Employee> employeesExpected = employeesWithNull.stream()
                .sorted(Comparator.nullsLast(Comparator.comparing(Employee::getName)))
                .toList();

        assertEquals(employeesExpected, sortedEmployeesByNameWithNullLast);
    }

    @Test
    public void sortedByName_thenComparing(){
        List<Employee> employeesExpected = employeeForThenCompering.stream()
                .sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getAge))
                .toList();

        assertEquals(employeesExpected, sortedEmployeesByNameWithThenComparing);
    }
}
