package lesson3.HW;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Задание №1
        ex1();
        // Задание №2
        ex2();
    }

    private static void ex1() {
        String[] arr = {"1", "2", "3", "4", "5", "6", "7", "3", "8", "9", "10", "11", "12", "13", "14", "15", "16", "16"};
        List<String> inArray = new ArrayList<>(Arrays.asList(arr));
        List<String> outArray = new ArrayList<>();
        for (String str : inArray) {
            if ((inArray.indexOf(str) == inArray.indexOf(str)) && !outArray.contains(str)) {
                outArray.add(str);
            }
        }
        System.out.println(inArray);
        System.out.println(outArray);
    }

    private static void ex2() {
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
