//Benjamin Williams
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.json.simple.JSONObject;
import java.util.*;

public class VictimTester {
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
    private String familyContactInfo;
    private String condition;
    private String bloodType;
    private String accountGiven;

    @Test
    public void testVictim() {
        Victim v = new Victim(firstName, lastName, type, id, phoneNumber, address, email, birthDate, race, gender, familyContactInfo, condition, bloodType, accountGiven, height, age);
        assertEquals(firstName, v.getFirstName());
        assertEquals(id, v.getId());
        assertEquals(type, v.getType());
        assertEquals(lastName, v.getLastName());
        assertEquals(phoneNumber, v.getPhoneNumber());
        assertEquals(address, v.getAddress());
        assertEquals(email, v.getEmail());
        assertEquals(birthDate, v.getBirthDate());
        assertEquals(race, v.getRace());
        assertEquals(gender, v.getGender());
        assertEquals(height, v.getHeight());
        assertEquals(age, v.getAge());
        assertEquals(familyContactInfo, v.getFamilyContactInfo());
        assertEquals(condition, v.getCondition());
        assertEquals(bloodType, v.getBloodType());
        assertEquals(accountGiven, v.getAccountGiven());
    }

    @Test
    public void testVictimToString() {
        Victim v = new Victim(firstName, lastName, type, id, phoneNumber, address, email, birthDate, race, gender, familyContactInfo, condition, bloodType, accountGiven, height, age);
        Victim a = new Victim(firstName, lastName, type, id, phoneNumber, address, email, birthDate, race, gender, familyContactInfo, condition, bloodType, accountGiven, height, age);
        assertEquals(a.toString(), v.toString());
    }
}
