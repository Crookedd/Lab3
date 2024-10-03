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
                Collections1();
                break;
            case 2:
                PrimesGeneratorTest.Part2();
                break;
            case 3:
                HumanPart3();
                break;
            case 4:
                MapPart4();
                break;
            case 5:
                Map<String, Integer> originalMap = new HashMap<>();
                originalMap.put("One", 1);
                originalMap.put("Two", 2);
                originalMap.put("Three", 3);

                Map<Integer, String> swappedMap = swapKeysAndValues(originalMap);

                System.out.println("Оригинал: " + originalMap);
                System.out.println("Наоборот: " + swappedMap);
                break;
            default:
                System.out.println("Неверный выбор");
        }
        scanner.close();
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

    public static void HumanPart3() {
        HashSet<Human> humans = getHumans();
        System.out.println("HashSet:");
        for (Human human : humans) {
            System.out.println(human);
        }

        Set<Human> linkedHashSet = new LinkedHashSet<>(humans);
        System.out.println("\nLinkedHashSet:");
        for (Human human : linkedHashSet) {
            System.out.println(human);
        }

        Set<Human> treeSet = new TreeSet<>(humans);
        System.out.println("\nTreeSet:");
        for (Human human : treeSet) {
            System.out.println(human);
        }

        Set<Human> treeSetWithComparator = new TreeSet<>(new HumanComparatorByName());
        treeSetWithComparator.addAll(humans);
        System.out.println("\nTreeSet с компаратором по фамилии:");
        for (Human human : treeSetWithComparator) {
            System.out.println(human);
        }

        TreeSet<Human> tree = new TreeSet<>(Comparator.comparing(o -> o.age));
        tree.addAll(humans);
        System.out.println("\nTreeSet с анонимным компаратором по возрасту:");
        for (Human human : tree) {
            System.out.println(human);
        }


    }

    private static HashSet<Human> getHumans() {
        Human Misha = new Human("Михаил", "Михайлович", 10);
        Human Alex = new Human("Алексей", "Попов", 20);
        Human Ivan = new Human("Иван", "Иванов", 12);
        Human Sidor = new Human("Сидор", "Сидоров", 28);
        Human Petr = new Human("Петр", "Петров", 21);
        Human Andrey = new Human("Андрей", "Андреев", 22);

        HashSet<Human> humans = new HashSet<>();
        humans.add(Misha);
        humans.add(Alex);
        humans.add(Petr);
        humans.add(Sidor);
        humans.add(Ivan);
        humans.add(Andrey);
        return humans;
    }

    public static void MapPart4() {
        String str = "In Java, Map Interface is present in java.util package represents a" +
                " mapping between a key and a value." +
                "Java Map interface is not a subtype of the Collection interface."+
                "from the rest of the collection types. A map contains unique keys.";
        str = str.toLowerCase();
        str = str.replaceAll("\\W", " ");

        System.out.println("\nПовторение:\n");
        Map<String, Integer> map = new HashMap<>();
        for(String s: str.split(" ")) {
            if(map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            }
            else {
                map.put(s, 1);
            }
        }
        map.remove("");
        System.out.println(map);
    }

    public static <K, V> Map<V, K> swapKeysAndValues(Map<K, V> originalMap) {
        Map<V, K> swappedMap = new HashMap<>();

        for (Map.Entry<K, V> entry : originalMap.entrySet()) {
            swappedMap.put(entry.getValue(), entry.getKey());
        }

        return swappedMap;
    }

}