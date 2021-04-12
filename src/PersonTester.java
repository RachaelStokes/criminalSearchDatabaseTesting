import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.*;

class PersonTester {
    private String firstName;
    private UUID id;
    private String type;
    private String lastName;
    private String phoneNumber;
    private String address;
    private String email;
    private String birthDate;
    private String race;
    private String gender;
    private String height;
    private String age;

    @Test
    public void testPersonConstructor() {
        Person p = new Person(firstName, lastName, type, id, phoneNumber, address, email, birthDate, race, gender,
                height, age);
        assertEquals(firstName, p.getFirstName());
        assertEquals(lastName, p.getLastName());
        assertEquals(type, p.getType());
        assertEquals(id, p.getId());
        assertEquals(phoneNumber, p.getPhoneNumber());
        assertEquals(address, p.getAddress());
        assertEquals(email, p.getEmail());
        assertEquals(birthDate, p.getBirthDate());
        assertEquals(race, p.getRace());
        assertEquals(gender, p.getGender());
        assertEquals(height, p.getHeight());
        assertEquals(age, p.getAge());
    }

    @Test
    public void testPersonToString() {
        Person p = new Person(firstName, lastName, type, id, phoneNumber, address, email, birthDate, race, gender,
                height, age);
        Person q = new Person(firstName, lastName, type, id, phoneNumber, address, email, birthDate, race, gender,
                height, age);
        assertEquals(p.toString(), q.toString());
    }

}