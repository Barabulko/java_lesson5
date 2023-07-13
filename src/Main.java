import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Создание HashMap для хранения номеров телефонов
        HashMap<String, TreeSet<String>> phoneBook = new HashMap<>();

        // Добавление номеров телефонов в книгу
        addPhoneNumber(phoneBook, "John", "1234567890");
        addPhoneNumber(phoneBook, "Mary", "9876543210");
        addPhoneNumber(phoneBook, "John", "5555555555");
        addPhoneNumber(phoneBook, "Mark", "1111111111");
        addPhoneNumber(phoneBook, "John", "9999999999");
        addPhoneNumber(phoneBook, "Mary", "2222222222");

        // Вывод номеров телефонов, отсортированных по убыванию числа телефонов
        TreeMap<Integer, Set<String>> sortedPhoneBook = sortPhoneBook(phoneBook);
        for (var entry : sortedPhoneBook.entrySet()) {
            int count = entry.getKey();
            Set<String> names = entry.getValue();
            for (String name : names) {
                for (var item : phoneBook.entrySet()) {
                    if (Objects.equals(item.getKey(), name))
                        System.out.println(item);
                }
            }
        }
    }

    // Метод для добавления номера телефона в книгу
    public static void addPhoneNumber(HashMap<String, TreeSet<String>> phoneBook, String name, String phoneNumber) {
        TreeSet<String> numbers = phoneBook.getOrDefault(name, new TreeSet<>());
        numbers.add(phoneNumber);
        phoneBook.put(name, numbers);
    }

    // Метод для сортировки книги по убыванию числа телефонов
    public static TreeMap<Integer, Set<String>> sortPhoneBook(HashMap<String, TreeSet<String>> phoneBook) {
        TreeMap<Integer, Set<String>> sortedPhoneBook = new TreeMap<>(Collections.reverseOrder());
        for (var entry : phoneBook.entrySet()) {
            String name = entry.getKey();
            int count = entry.getValue().size();
            Set<String> names = sortedPhoneBook.getOrDefault(count, new TreeSet<>());
            names.add(name);
            sortedPhoneBook.put(count, names);
        }
        return sortedPhoneBook;
    }
}