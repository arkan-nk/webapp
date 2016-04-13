package main;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * GKislin
 * 12.04.2016
 */
public class MainStream {
    public static void main(String[] args) {
//        IntStream stream = Arrays.stream(new int[]{1, 2, 3});
//        stream.filter(i -> i % 2 != 0).map(Integer::valueOf).collect(Collectors.toList());

        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3});
        System.out.println(stream.filter(i -> i % 2 != 0).collect(Collectors.toList()));
    }
}
