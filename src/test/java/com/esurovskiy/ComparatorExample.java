package com.esurovskiy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ComparatorExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("100", "12",
                "00003", "4", "5"));
        Collections.sort(list, (o1, o2) ->
                o1.compareTo(o2));
        System.out.println(list);
    }


}
