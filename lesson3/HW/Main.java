package lesson3.HW;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Задание №1
        String[] arr = {"1", "2", "3", "4", "5", "6", "7", "3", "8", "9", "10", "11", "12", "13", "14", "15", "16", "16"};
        ex1a(arr);
        ex1b(arr);
        // Задание №2
        ex2();
    }

    private static void ex1b(String[] arr) {
        System.out.println("\nКоличество повторений элементов массива:");
        Map<String, Integer> words = new HashMap<>();
        ArrayList<String> inArray = new ArrayList<>(Arrays.asList(arr));

        for (String tempWord : inArray)
            if (!words.containsKey(tempWord)) words.put(tempWord, 1);
            else words.put(tempWord, words.get(tempWord) + 1);

        for (Map.Entry<String, Integer> entry : words.entrySet())
            System.out.println(entry.getKey() + " : " + entry.getValue());
    }

    private static void ex1a(String[] arr) {
        System.out.println("\nЗадание №1.");
        List<String> inArray = new ArrayList<>(Arrays.asList(arr));
        Set<String> outArray = new HashSet<>(inArray);
        System.out.println(inArray);
        System.out.println(outArray);
    }

    private static void ex2() {
        System.out.println("\nЗадание №2.");
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов", "+71231234567");
        phoneBook.add("Иванов", "+72342345678");
        phoneBook.add("Петров", "+73453456789");
        phoneBook.add("Сидоров", "+74564567890");
        phoneBook.get("Иванов");
        phoneBook.get("Петров");
        phoneBook.get("Сидоров");
    }
}