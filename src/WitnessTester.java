
//Benjamin Williams
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;

public class WitnessTester {
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
    private String accountGiven;

    @Test
    public void testWitnessConstructor() {
        Witness w = new Witness(firstName, lastName, type, id, phoneNumber, address, email, birthDate, race, gender,
                accountGiven, height, age);
        assertEquals(firstName, w.getFirstName());
        assertEquals(id, w.getId());
        assertEquals(type, w.getType());
        assertEquals(lastName, w.getLastName());
        assertEquals(phoneNumber, w.getPhoneNumber());
        assertEquals(address, w.getAddress());
        assertEquals(email, w.getEmail());
        assertEquals(birthDate, w.getBirthDate());
        assertEquals(race, w.getRace());
        assertEquals(gender, w.getGender());
        assertEquals(height, w.getHeight());
        assertEquals(age, w.getAge());
        assertEquals(accountGiven, w.getAccountGiven());
    }

    @Test
    public void testWitnessToString() {
        Witness w = new Witness(firstName, lastName, type, id, phoneNumber, address, email, birthDate, race, gender,
                accountGiven, height, age);
        Witness a = new Witness(firstName, lastName, type, id, phoneNumber, address, email, birthDate, race, gender,
                accountGiven, height, age);
        assertEquals(a.toString(), w.toString());
    }
}
