package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Collections1();
        PrimesGeneratorTest.Part2();
    }

    public static void Collections1() {
        int n = 10;
        Integer[] array = new Integer[n];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(6);
        }

        System.out.println("Исходный массив: " + Arrays.toString(array));


        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(array));
        System.out.println("Список:" + list);

        ArrayList<Integer> list2 = new ArrayList<>(list);

        Collections.sort(list);
        System.out.println("Отсортированный список:" + list);

        list.sort(Collections.reverseOrder());
        System.out.println("Список в обратном порядке:" + list);

        Collections.shuffle(list);
        System.out.println("Перемешанный список:" + list);

        Collections.rotate(list, 1);
        System.out.println("Список после циклического сдвига на 1 элемент:" + list);

        ArrayList<Integer> unique = list.stream().distinct().collect(Collectors.toCollection(ArrayList::new));
        System.out.println("Список с уникальными элементами: " + unique);

        unique.forEach(x -> list.remove(list.indexOf(x)));
        ArrayList<Integer> duplicates = list.stream().distinct().collect(Collectors.toCollection(ArrayList::new));
        System.out.println("Список с дублирующимися элементами:" + duplicates);

        Integer[] arr = new Integer[list2.size()];
        list2.toArray(arr);
        System.out.println("Массив из списка" +  Arrays.toString(arr));

        System.out.println("Повтор значений\n");
        Arrays.stream(arr)
                .collect(Collectors.groupingBy(value2-> value2))
                .forEach((key, value) -> System.out.println(key+" "+value.size()));
    }
}