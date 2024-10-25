package org.example;

import java.util.Iterator;

public class PrimesGeneratorTest {
    public static void part2() {
        PrimesGenerator primesGenerator = new PrimesGenerator();
        primesGenerator.createPrimes(10);

        System.out.println("Первые 10 простых чисел:");
        for (Integer prime : primesGenerator) {
            System.out.print(prime + " ");
        }
        System.out.println();

        // Использование обратного итератора
        System.out.println("Первые 10 простых чисел в обратном порядке:");
        Iterator<Integer> reverseIterator = primesGenerator.reverseIterator();
        while (reverseIterator.hasNext()) {
            System.out.print(reverseIterator.next() + " ");
        }
        System.out.println();
    }
}
