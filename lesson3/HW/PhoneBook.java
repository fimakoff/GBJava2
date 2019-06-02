package lesson3.HW;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class PhoneBook {
    private HashMap<String, List<String>> phbk = new HashMap<>();

    void add(String surname, String number) {
        List<String> list = phbk.computeIfAbsent(surname, k -> new ArrayList<>());
        list.add(number);
    }

    void get(String surname) {
        List<String> value = phbk.get(surname);
        System.out.print(surname + " ");
        for (String i :
                value) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
