package covid;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    Person person;
    Validation validation;

    @BeforeEach
    void init() {
        validation = new Validation();
        person = new Person("Hadik Péter", "8000", 50, "hadikp@freemail.hu", "030377215",
                2, LocalDate.of(2021, 12, 05));
    }

    @Test
    void testPersonName() {
        assertEquals("Hadik Péter",person.getName());
        assertEquals("8000",person.getPostCode());
        assertEquals("030377215",person.getTaj());
    }

    @Test
    void testNotCorrectName() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> new Person(" ", "8000", 50, "hadikp@freemail.hu", "030377215", 2, LocalDate.of(2022, 01, 23)));
        assertEquals("Name can't be empty or null!", iae.getMessage());
    }

    @Test
    void testNameNull() {
        Exception ex = assertThrows(NullPointerException.class,
                () -> new Person(null, "8000", 50, "hadikp@freemail.hu", "030377215", 2, LocalDate.of(2022, 01, 30)));
        assertEquals("Name can't be null!", ex.getMessage());
    }

}