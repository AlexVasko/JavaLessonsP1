package com.javalesson.lambdas;

import com.javalesson.lambdas.model.RichPerson;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class HigherOrderFunctionExample {

    public static void main(String[] args) {
        List<RichPerson> persons = new ArrayList<>();
        persons.add(new RichPerson("Alex", "Black", 50000, 25));
        persons.add(new RichPerson("John", "Green", 75000, 35));
        persons.add(new RichPerson("Sam", "Brown", 80000, 40));
        persons.add(new RichPerson("Tony", "Grey", 90000, 50));
        testPredicate(persons);
        testFunction(persons);
        testConsumer(persons);

    }

    private static void testPredicate(List<RichPerson> persons) {
        System.out.println("Testing predicate...");
        Predicate<RichPerson> isRich = x -> x.getSalary() >= 75000;
        Predicate<RichPerson> isYoung = y -> y.getAge() <= 40;
        System.out.println("Is reach and young");
        findAll(persons, isRich.and(isYoung)).forEach(System.out::println);
        System.out.println("Is reach or young");
        findAll(persons, isRich.or(isYoung)).forEach(System.out::println);
        System.out.println("Is not young");
        findAll(persons, isYoung.negate()).forEach(System.out::println);


    }

    private static <T> List<T> findAll(List<T> elements, Predicate<T> predicate) {
        List<T> filteredList = new ArrayList<>();
        for (T element : elements) {
            if (predicate.test(element)) {
                filteredList.add(element);
            }
        }
        return filteredList;
    }


    private static void testFunction(List<RichPerson> persons) {
        System.out.println("Testing function...");
//        f1.compose(f2) ==> f1(f2(x));
//        f1.andThen(f2) ==> f2(f1(x));
//        Function.identity();
        Function<RichPerson, String> name = x -> x.getFirstName() + " " + x.getLastName();
        Function<String, String> sayHello = y -> "Hello " + y;
        Function<RichPerson, String> composedFunction = sayHello.compose(name);
        List<String> transformedList = transform(persons, composedFunction);

        Function<String, String> exclaim = z -> z + "!!!";
        Function<String, String> toUpper = String::toUpperCase;

        transform(transformedList, compose(toUpper, exclaim)).forEach(System.out::println);


    }

    private static <T> Function<T, T> compose(Function<T, T>... functions) {
        Function<T, T> result = Function.identity();
        for (Function<T, T> f : functions) {
            result = result.andThen(f);
        }
        return result;
    }


    private static <T, R> List<R> transform(List<T> elements, Function<T, R> function) {
        List<R> list = new ArrayList<>();
        for (T elem : elements) {
            list.add(function.apply(elem));
        }
        return list;
    }

    private static void testConsumer(List<RichPerson> persons) {
        System.out.println("Testing consumer...");
//        f1.andThen(f2(x)) => f1(x) andThen f2(x);
        Consumer<RichPerson> rise = x -> x.setSalary(x.getSalary() * 11 / 10);
        processList(persons, rise.andThen(System.out::println));
    }

    private static <T> void processList(List<T> elements, Consumer<T> consumer) {
        for (T e : elements) {
            consumer.accept(e);
        }
    }

}
