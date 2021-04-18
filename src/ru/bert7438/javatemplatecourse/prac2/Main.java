package ru.bert7438.javatemplatecourse.prac2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        ArrayList<Human> lst = new ArrayList<Human>();
        lst.add(new Human(20, "Albert", "Abdullin", LocalDate.of(2001,2,27), 56));
        lst.add(new Human(18, "Nikita", "Volkov", LocalDate.of(2003,2,1), 52));
        lst.add(new Human(44, "Makoto", "Yamamoto", LocalDate.of(1976,11,10), 75));
        lst.add(new Human(10, "Naomi", "Serizawa", LocalDate.of(2011,1,6), 40));
        lst.add(new Human(16, "Keiichi", "Maebara", LocalDate.of(2005,1,8), 53));
        lst.add(new Human(16, "Nikolay", "Petrov", LocalDate.of(1950,3,20), 82));

        //Sorting by first name
        Stream<Human> stream1 = lst.stream();
        System.out.println("Sorting by first name");
        stream1.sorted(Comparator.comparing(Human::getFirstName)).forEach(System.out::println);

        //Filtering by birthdate(Later than 24 June 2000)
        Stream<Human> stream2 = lst.stream();
        System.out.println("Filtering by birthdate(Later than 24 June 2000)");
        stream2.filter(a -> a.getBirthDate().isAfter(LocalDate.of(2000,6,24)))
                .forEach(System.out::println);

        //Sorting by last name
        Stream<Human> stream3 = lst.stream();
        System.out.println("Sorting by last name");
        stream3.sorted(Comparator.comparing(Human::getLastName)).forEach(System.out::println);

        //Finding sum of ages
        Stream<Human> stream4 = lst.stream();
        System.out.println("Finding sum of ages");
        Optional<Integer> sum = stream4.map(Human::getAge).reduce((a, b) -> a+b);
        System.out.println(sum.get());

    }
}
