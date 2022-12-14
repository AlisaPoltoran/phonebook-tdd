import java.util.Map;
import java.util.TreeMap;

public class PhoneBook {

    Map<String, String> phoneBook = new TreeMap<>();

    public int add(String name, String phoneNumber) {
        if (phoneBook.containsKey(name)) {
            System.out.println("The contact " + name + " already exists");
        } else {
            phoneBook.put(name, phoneNumber);
        }
        return phoneBook.size();
    }


}

