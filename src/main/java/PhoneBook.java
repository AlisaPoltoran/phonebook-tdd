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

    public String findByNumber (String number) {
        if (phoneBook.containsValue(number)) {
            String key = "";
            for (String k : phoneBook.keySet()) {
                if (phoneBook.get(k).equals(number) )  {
                    key = k;
                    break;
                }
            }
            System.out.println(key + " --- " + phoneBook.get(key));
            return key;
        } else {
            return "Unknown number";
        }
    }

    public String findByName (String name) {
        return null;
    }
}

