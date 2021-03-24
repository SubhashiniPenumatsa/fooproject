package com.company;
import java.util.ArrayList;
import java.util.List;

public class PersonnelSystem {

    private ArrayList<Employee> employees = new ArrayList<Employee>();

    //To get Auto Generated number
    public Integer getAutoIncrementNumber() {

        if (employees.size() == 0) return 1;
        Employee last = employees.get(employees.size() - 1);

        return last.CompanyId + 1;
    }

    public List<Employee> initializeEmployeedetails() {

        this.employees.add(new Employee("Subhashini","Penumatsa",33,40000, getAutoIncrementNumber()));
        this.employees.add(new Employee("Jyothirmayee","Behuria",34,45000, getAutoIncrementNumber()));
        this.employees.add(new Employee("Sarada","Kumar",40,50000, getAutoIncrementNumber()));
        this.employees.add( new Employee("Pallavi","Varma",20,55000,getAutoIncrementNumber()));
        this.employees.add(new Employee("Vincent","Adler",30,60000, getAutoIncrementNumber()));

        return this.employees;
    }

    //Method to Adding Employees
    public void addEmployees(Employee employee) {
        this.employees.add(employee);


    };

    //Method to get All Employees
    public ArrayList<Employee> getAllEmployees() {
        return this.employees;
    }

    //Method to Remove Employee
    public void removeEmployee(Employee employee) {
        this.employees.remove(employee);
    }

    //Method to Increment Salary
    public void incrementSalary(double percentage) {
        if(percentage > 0 && percentage <100) {
            for (Employee emp : this.employees) {
                double increment = (percentage * emp.Salary) / 100;
                emp.Salary = emp.Salary + increment;
            }
        }
    }

    //Increment salary for specific employee
    public Employee incrementSalaryOfAnEmployee(Employee employee, int percentage) {
        Employee employ = new Employee();
        for (Employee emp : this.employees) {
            if (employee.equals(emp)) {
                double increment = (emp.Salary * percentage) / 100;
                emp.Salary = emp.Salary + increment;
                employ = emp;
            }
        }
            return employ;
        }
    }