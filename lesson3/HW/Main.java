package lesson3.HW;

public class Main {
    public static void main(String[] args) {
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
