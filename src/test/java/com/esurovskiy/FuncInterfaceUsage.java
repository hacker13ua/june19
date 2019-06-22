package com.esurovskiy;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FuncInterfaceUsage {
    public static void main(String[] args) {
        List<Integer> integers =
                Arrays.asList(1, 2, 3, 4, 5, 6, -7, -8, -9, 10);
        System.out.println(sumFunc2(integers, x -> x * x));
        System.out.println(sumFunc2(integers,
                Function.identity()));
        System.out.println(sumFunc2(integers, Math::abs));
    }

    public static long sumFunc(List<Integer> list,
                               CustomFuncInterface cfi) {
        long sum = 0;
        for (final Integer elem : list) {
            sum += cfi.calc(elem);
        }
        return sum;
    }

    public static long sumFunc2(List<Integer> list,
                                Function<Integer, Integer> cfi) {
        long sum = 0;
        for (final Integer elem : list) {
            sum += cfi.apply(elem);
        }
        return sum;
    }
}
