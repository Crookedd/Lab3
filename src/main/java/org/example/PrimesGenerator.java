package org.example;

import java.util.ListIterator;
import java.util.Scanner;

public class PrimesGenerator implements ListIterator {
    private Integer[] primes;
    private int currentSize;
    private int currentIndex;

    public void CreatePrimes(int n) {
        primes = new Integer[n];
        currentSize = n;
        currentIndex = 0;

        int index = 0;
        int i = 2;
        while (index < n) {
            if (isPrime(i))
                primes[index++] = i;
            i++;
        }
    }

    private boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0) return false;
        return true;
    }

    // Проверяет, существует ли следующий элемент
    @Override
    public boolean hasNext() {
        return currentIndex < currentSize;
    }

    //Этот метод возвращает следующий элемент и увеличивает курсор на одну позицию.
    @Override
    public Object next() {
        return primes[currentIndex++];
    }

    @Override
    public boolean hasPrevious() {
        return currentIndex > 0;
    }
    //Этот метод возвращает предыдущий элемент списка и
    // сдвигает курсор на одну позицию назад
    @Override
    public Object previous() {
        return primes[--currentIndex];
    }

    //Этот метод возвращает индекс элемента,
    // который был бы возвращен при вызове метода next().
    @Override
    public int nextIndex() {
        return 0;
    }
    //Этот метод возвращает индекс элемента,
    // который был бы возвращен при вызове предыдущего метода().
    @Override
    public int previousIndex() {
        return 0;
    }

    //удаление
    @Override
    public void remove() {

    }

    //Этот метод заменяет последний элемент,
    // который был возвращен при вызове метода next() или previous(),
    // указанным элементом.
    @Override
    public void set(Object o) {

    }

    //добавление
    @Override
    public void add(Object o) {

    }
}

