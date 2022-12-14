import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PhoneBookTest {

    PhoneBook sut = new PhoneBook();

    @BeforeEach
    public void init() {
        System.out.println("Test started");
    }

    @BeforeAll
    public static void started() {
        System.out.println("Tests started");
    }

    @AfterEach
    public void finished() {
        System.out.println("Test completed");
    }

    @AfterAll
    public static void finishedAll() {
        System.out.println("Tests completed");
    }

    @ParameterizedTest
    @MethodSource("sourceForAdd")
    public void testAdd(String name, String phoneNumber, int expected) {
        sut.phoneBook.put("Pasha", "+7(812)888-79-12");
        sut.phoneBook.put(name, phoneNumber);
        int result = sut.phoneBook.size();
        assertEquals(expected, result);
    }
    @MethodSource("sourceForAdd")
    public static Stream<Arguments> sourceForAdd() {
        return Stream.of(Arguments.of("Petya", "+7(812)888-77-66", 2),
                Arguments.of("Masha", "+7(812)888-78-11", 2),
                Arguments.of("Pasha", "+7(812)888-79-12",  1));
    }

    @Test
    public void testFindByNumber() {
        sut.phoneBook.put("Pasha", "+7(812)888-79-12");
        sut.phoneBook.put("Masha", "+7(812)888-78-11");
        sut.phoneBook.put("Petya", "+7(812)888-77-66");

        String result = sut.findByNumber("+7(812)888-79-12");
        String expected = "Pasha";

        assertEquals(result, expected);
    }


}
