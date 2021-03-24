package com.company;
import java.util.ArrayList;
import java.util.List;

public class Employee {
    String firstName;
    String lastName;
    int age;
    int CompanyId;


    public double Salary;
    int counter = 0;
    public Employee() {

    }
    public  List<Employee> employees = new ArrayList<Employee>();


    public Employee(String firstName, String lastName, int age, double Salary, int companyId){
      this.firstName = firstName;
      this.lastName = lastName;
      this.age = age;
      this.CompanyId = companyId;
      this.Salary = Salary;

  }



    public boolean equals(Object obj){
        Employee emp = (Employee) obj;
        boolean status = false;
        if(emp != null && this.firstName != null && this.firstName.equalsIgnoreCase(emp.firstName)
                && this.lastName.equalsIgnoreCase(emp.lastName)
                && this.age == emp.age
                && this.Salary == emp.Salary)
                //&& this.CompanyId == emp.CompanyId)
        {
            status = true;
        }
        return status;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", CompanyId=" + CompanyId +
                ", Salary=" + Salary +
                ", counter=" + counter +
                ", employees=" + employees +
                '}';
    }



}