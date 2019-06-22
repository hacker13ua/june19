package com.esurovskiy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        Random rnd = new Random();
        for (int i = 0; i < 100; i++) {
            integers.add(rnd.nextInt(100) - 50);
        }


        List<String> positive = new ArrayList<>();
        for (final Integer elem : integers) {
            if (elem >= 0) {
                int i = elem % 10;
                final String s = "e" + i;
                if (s.endsWith("1")) {
                    positive.add(s);
                }
            }
        }

        final List<String> collect = integers.stream()
                .filter(t -> t >= 0)
                .map(t -> t % 10)
                .map(t -> "e" + t)
                .filter(t -> t.endsWith("1"))
                .collect(Collectors.toList());

        System.out.println(collect);
        System.out.println(positive);

        int count = 0;
        for (final Integer elem : integers) {
            if (elem > 0) {
                count++;
            }
        }

        final long count1 = integers.stream()
                .filter(t -> t > 0)
                .count();
        System.out.println(count1);
        System.out.println(count);
        integers.parallelStream()
                .sorted()
                .sequential()
                .peek(integer -> System.out.println(integer))
                .collect(Collectors.toList());


        Stream<Integer> integerStream = integers.stream()
                .sorted()
                .limit(10)
                .filter(t -> t > 0);
        integerStream = integerStream.map(t -> t % 3);
//        final List<Integer> collect1 =
//                integerStream.collect(Collectors.toList());
        long a = integerStream
                .count();


        System.out.println(rnd.ints()
                .limit(1999)
                .sum());


        final Optional<Integer> first = integers.stream()
                .findFirst();
        final Integer integer = first
                .map(i -> i / 2)
                .orElse(-10);

        for (final Integer integer1 : integers) {
            System.out.println("i " + integer1);
        }

        integers.forEach(integer1 ->
            System.out.println("i " + integer1));
    }
}
