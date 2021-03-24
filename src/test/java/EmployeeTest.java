package test;

import com.company.PersonnelSystem;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.company.Employee;
import java.util.Arrays;

public class EmployeeTest {

    Object[] expectedEmps = new Object[5];
    Object[] addEmps = new Object[6];

    @Before
    public void initInputs(){
        expectedEmps[0] =  new Employee("Subhashini","Penumatsa",33,40000, 1);
        expectedEmps[1] =  new Employee("Jyothirmayee","Behuria",34,45000,2);
        expectedEmps[2] =  new Employee("Sarada","Kumar",40,50000,3);
        expectedEmps[3] =  new Employee("Pallavi","Varma",20,55000,4);
        expectedEmps[4] =  new Employee("Vincent","Adler",30,60000,5);
    }

    public void initAddInputs(){
        addEmps[0] =  new Employee("Subhashini","Penumatsa",33,40000,1);
        addEmps[1] =  new Employee("Jyothirmayee","Behuria",34,45000,2);
        addEmps[2] =  new Employee("Sarada","Kumar",40,50000,3);
        addEmps[3] =  new Employee("Pallavi","Varma",20,55000,4);
        addEmps[4] =  new Employee("Vincent","Adler",30,60000,5);
        addEmps[5] =  new Employee("Akshaj","Varma",25,20000,6);
    }
    @Test
    public void getEmployeedetails() {
        PersonnelSystem employee = new PersonnelSystem();
        initInputs();
        Assertions.assertArrayEquals(expectedEmps, employee.initializeEmployeedetails().toArray());
    }
// TODO: 2021-02-12 want to see comparing object values
    @Test
    public void addingEmployees(){
        PersonnelSystem employee= new PersonnelSystem();
        initAddInputs();
        employee.initializeEmployeedetails();
        employee.addEmployees(new Employee("Akshaj","Varma",25,20000, employee.getAutoIncrementNumber()));
        System.out.println("expected= "+ Arrays.toString(employee.getAllEmployees().toArray()));
        System.out.println("actual= "+  Arrays.toString(addEmps));
         Assertions.assertArrayEquals(addEmps, employee.getAllEmployees().toArray());
    }
    @Test
    public void deletingEmployees(){
        PersonnelSystem employee = new PersonnelSystem();
        initInputs();
         employee.initializeEmployeedetails();
        Employee temp1 = new Employee("Akshaj","Varma",25,20000,employee.getAutoIncrementNumber());
        employee.addEmployees(temp1);
         employee.removeEmployee(temp1);
         System.out.println("expected= "+ this.toString(employee.getAllEmployees().toArray()));
        System.out.println("actual= "+ this.toString(expectedEmps));
        Assertions.assertArrayEquals(expectedEmps, employee.getAllEmployees().toArray());
    }

    public String toString(Object[] objects) {
        return  "objects=" + Arrays.toString(objects) ;
    }
    @Test
    void increasingEmployeeSalary(){
        PersonnelSystem employee = new PersonnelSystem();
        initInputs();
        for(int i=0 ; i < expectedEmps.length; i++){
            Employee emp = (Employee)expectedEmps[i];
            double increment = (emp.Salary * 0.10);
            emp.Salary =  emp.Salary + increment;
        }
        employee.initializeEmployeedetails();
        employee.incrementSalary(10);
        System.out.println("expected= "+ this.toString(expectedEmps));
        System.out.println("actual= "+ this.toString(employee.getAllEmployees().toArray()));
        Assertions.assertArrayEquals(expectedEmps, employee.getAllEmployees().toArray());
    }

    @Test
    void increasingEmployeeSalaryMorethan100Percent(){
        PersonnelSystem employee = new PersonnelSystem();
        initInputs();
        employee.initializeEmployeedetails();
        employee.incrementSalary(101);
        System.out.println("expected= "+ this.toString(expectedEmps));
        System.out.println("actual= "+ this.toString(employee.getAllEmployees().toArray()));
        Assertions.assertArrayEquals(expectedEmps, employee.getAllEmployees().toArray());
    }

    @Test
    void decrementEmployeeSalary(){
        PersonnelSystem employee = new PersonnelSystem();
        initInputs();
        employee.initializeEmployeedetails();
        employee.incrementSalary(-10);
        System.out.println("expected= "+ this.toString(expectedEmps));
        System.out.println("actual= "+ this.toString(employee.getAllEmployees().toArray()));
        Assertions.assertArrayEquals(expectedEmps, employee.getAllEmployees().toArray());
    }

    @Test
    void increasingSalaryOfEmployee(){
        PersonnelSystem employee = new PersonnelSystem();
        employee.initializeEmployeedetails();
        Object[] incrementEmp = new Object[1];
        incrementEmp[0] =  new Employee("Subhashini","Penumatsa",33,40000, employee.getAutoIncrementNumber());
        Employee incrementEmp1 = (Employee)incrementEmp[0];
        Employee actual = employee.incrementSalaryOfAnEmployee(incrementEmp1,10);
        double increment = (incrementEmp1.Salary * 0.10);
        double salaryIncrement = incrementEmp1.Salary + increment;
        incrementEmp1.Salary =  salaryIncrement;
        System.out.println("expected= "+ incrementEmp1.toString());
        System.out.println("actual= "+ actual.toString());
        Assertions.assertEquals(incrementEmp1, actual);
    }
}


