package com.kouyy.training.dowith.java8;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 并行数组
 * @author kouyy
 */
public class ParallelArrays {
    public static void main(String[] args) {
        long[] arrayOfLong = new long [ 20000 ];

        Arrays.parallelSetAll( arrayOfLong,
                index -> ThreadLocalRandom.current().nextInt( 1000000 ) );

        System.out.print("unsorted: ");
        Arrays.stream( arrayOfLong ).limit( 20).forEach(
                i -> System.out.print( i + " " ) );
        System.out.println();

        System.out.print("sorted: ");
        Arrays.parallelSort( arrayOfLong );
        Arrays.stream( arrayOfLong ).limit( 20 ).forEach(
                i -> System.out.print( i + " " ) );

    }
}
