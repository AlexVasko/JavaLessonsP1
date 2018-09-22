package com.javalesson.constructors;

import com.javalesson.domainmodel.Employee;

public class ConstructorsMain {

    public static void main(String[] args) {


        Employee employee = new Employee();
        Employee employee1 = new Employee();
        Employee employee2 = new Employee();
//       Employee employee2 = new Employee("Alex", "developer", 100);
//       Employee employee1 = new Employee("John", "developer", 100);
//
        System.out.println(employee);
        System.out.println(employee1);
        System.out.println(employee2);



    }
}
