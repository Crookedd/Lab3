package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите задачу 1-5");
        int taskNumber = scanner.nextInt();
        switch (taskNumber) {
            case 1:
                collections1();
                break;
            case 2:
                PrimesGeneratorTest.part2();
                break;
            case 3:
                humanPart3();
                break;
            case 4:
                mapPart4();
                break;
            case 5:
                Map<String, Integer> originalMap = new HashMap<>();
                originalMap.put("One", 1);
                originalMap.put("Two", 1);
                originalMap.put("Three", 3);

                Map<Integer, List<String>> mapInversed =
                        originalMap.entrySet()
                                .stream()
                                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())));

                System.out.println("Оригинал: " + originalMap);
                System.out.println("Наоборот: " + mapInversed);
                break;
            default:
                System.out.println("Неверный выбор");
        }
        scanner.close();
    }

    public static void collections1() {
        int n = 10;
        Integer[] array = new Integer[n];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(101);
        }

        System.out.println("Исходный массив: " + Arrays.toString(array));


        List<Integer> list = new ArrayList<>(Arrays.asList(array));
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

        List<Integer> unique = list.stream().distinct().toList();
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

    public static void humanPart3() {
        List<Human> humans = getHumans(); // Получаем список людей
        System.out.println("Список людей:");
        for (Human human : humans) {
            System.out.println(human);
        }

        // Создаем HashSet и выводим
        HashSet<Human> humanSet = new HashSet<>(humans);
        System.out.println("\nHashSet:");
        for (Human human : humanSet) {
            System.out.println(human);
        }

        // Создаем LinkedHashSet и выводим
        Set<Human> linkedHashSet = new LinkedHashSet<>(humanSet);
        System.out.println("\nLinkedHashSet:");
        for (Human human : linkedHashSet) {
            System.out.println(human);
        }

        // Создаем TreeSet и выводим
        Set<Human> treeSet = new TreeSet<>(humans);
        System.out.println("\nTreeSet:");
        for (Human human : treeSet) {
            System.out.println(human);
        }

        // Создаем TreeSet с компаратором по фамилии
        Set<Human> treeSetWithComparator = new TreeSet<>(new HumanComparatorByName());
        treeSetWithComparator.addAll(humans);
        System.out.println("\nTreeSet с компаратором по фамилии:");
        for (Human human : treeSetWithComparator) {
            System.out.println(human);
        }

        // Создаем TreeSet с анонимным компаратором по возрасту
        TreeSet<Human> tree = new TreeSet<>(Comparator.comparing(Human::age));
        tree.addAll(humans);
        System.out.println("\nTreeSet с анонимным компаратором по возрасту:");
        for (Human human : tree) {
            System.out.println(human);
        }
    }

    private static List<Human> getHumans() {
        Human Misha = new Human("Михаил", "Михайлович", 10);
        Human Alex = new Human("Алексей", "Попов", 20);
        Human Ivan = new Human("Иван", "Иванов", 12);
        Human Sidor = new Human("Сидор", "Сидоров", 28);
        Human Petr = new Human("Петр", "Петров", 21);
        Human Andrey = new Human("Андрей", "Андреев", 22);

        List<Human> humans = new ArrayList<>();
        humans.add(Misha);
        humans.add(Alex);
        humans.add(Petr);
        humans.add(Sidor);
        humans.add(Ivan);
        humans.add(Andrey);
        return humans;
    }

    public static void mapPart4() {
        String str = "In Java, Map Interface is present in java.util package represents a" +
                " mapping between a key and a value." +
                "Java Map interface is not a subtype of the Collection interface."+
                "from the rest of the collection types. A map contains unique keys.";
        str = str.toLowerCase();
        str = str.replaceAll("\\W", "");

        System.out.println("\nПовторение:\n");
        Map<String, Integer> map = new HashMap<>();
        for(String s: str.split(" ")) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        map.remove("");
        System.out.println(map);
    }
}