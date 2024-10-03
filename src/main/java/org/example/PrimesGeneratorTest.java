package org.example;

public class PrimesGeneratorTest {
    public static void Part2() {
        PrimesGenerator primesGenerator = new PrimesGenerator();
        primesGenerator.CreatePrimes(10);

        System.out.println("Первые " + 10 + " простых чисел:");
        while (primesGenerator.hasNext()) {
            System.out.print(primesGenerator.next() + " ");
        }
        System.out.println();

        // Сбросим итератор для обратного вывода
        System.out.println("Первые " + 10 + " простых чисел в обратном порядке:");
        while (primesGenerator.hasPrevious()) {
            System.out.print(primesGenerator.previous() + " ");
        }
        System.out.println();
        
    }
}
