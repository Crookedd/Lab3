package org.example;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class PrimesGenerator implements Iterable<Integer> {
    private Integer[] primes;

    public PrimesGenerator() {
        primes = new Integer[0]; // Инициализируем пустой массив
    }

    public void createPrimes(int n) {
        primes = new Integer[n];
        int index = 0;
        int i = 2;
        while (index < n) {
            if (isPrime(i)) {
                primes[index++] = i;
            }
            i++;
        }
    }

    private boolean isPrime(int n) {
        if (n < 2) return false; // Проверка на простое число
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    @Override
    public Iterator<Integer> iterator() {
        return Arrays.asList(primes).iterator(); // Возвращаем итератор для массива
    }

    public Iterator<Integer> reverseIterator() {
        return new Iterator<>() {
            private int index = primes.length - 1; // Используем длину массива

            @Override
            public boolean hasNext() {
                return index >= 0;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return primes[index--]; // Возвращаем элемент и уменьшаем индекс
            }
        };
    }
}

