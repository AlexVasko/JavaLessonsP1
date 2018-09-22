package com.javalesson.lambdas;

import com.javalesson.lambdas.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaFunctionExample {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1,"Alex", "Black", 50000, "IT"));
        employees.add(new Employee(2,"John", "Green", 75000, "IT"));
        employees.add(new Employee(3,"Sam", "Brown", 80000, "IT"));
        employees.add(new Employee(4, "Tony", "Grey", 90000, "IT"));

        List<Person> people = new ArrayList<>();
        people.add(new Person("Alex", "Smith", 25));
        people.add(new Person("John", "Green", 30));
        people.add(new Person("Sam", "Brown", 32));
        people.add(new Person("Tony", "Grey", 34));

//  Predicate
        System.out.println(findMatch(employees, e->e.getSalary()>80000));
        System.out.println(findMatch(people, p->p.getAge()>30));

//  Function
        System.out.println("Total salary "+calcSum(employees, Employee::getSalary));
        System.out.println("Total age "+calcSum(people, Person::getAge));

        BinaryOperator<Integer> combiner = (n1,n2)->Math.min(n1,n2);
        Integer zeroElement = 1000000;
        System.out.println("Combined salary "+combine(employees,zeroElement, Employee::getSalary, combiner));

        employees.forEach(e->e.setSalary(e.getSalary()*11/10));
        employees.forEach(System.out::println);

        Supplier[] shapes = {Circle::new, Rectangle::new, Square::new};
        Random random = new Random();
        for(int i = 0; i<4; i++) {
            int index = random.nextInt(3);
            Supplier supplier = shapes[index];
            supplier.get();
        }
    }


    private static <T> T findMatch(List<T> elements, Predicate<T> predicateFunction){
        for(T e : elements){
            if(predicateFunction.test(e)){
                return e;
            }
        }
        return null;
    }

    private static <T> int calcSum(List<T> elements, Function<T, Integer>function){
        int sum = 0;
        for(T e: elements){
            sum = sum + function.apply(e);
        }
        return sum;
    }


    private static <T,R> R combine(List<T> elements, R zeroElement, Function<T, R>function, BinaryOperator<R> combiner){
        for(T e: elements){
            zeroElement = combiner.apply(zeroElement, function.apply(e));
        }
        return zeroElement;
    }


}
