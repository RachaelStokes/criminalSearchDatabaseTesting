
//Benjamin Williams
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;

public class SuspectTester {
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
    private String relationshipToVictim;
    private String criminalRecord;
    private String reasonWhySus;

    @Test
    public void testSuspectConstructor() {
        Suspect s = new Suspect(firstName, lastName, type, id, phoneNumber, address, email, birthDate, race, gender,
                accountGiven, relationshipToVictim, criminalRecord, reasonWhySus, height, age);
        assertEquals(firstName, s.getFirstName());
        assertEquals(id, s.getId());
        assertEquals(type, s.getType());
        assertEquals(lastName, s.getLastName());
        assertEquals(phoneNumber, s.getPhoneNumber());
        assertEquals(address, s.getAddress());
        assertEquals(email, s.getEmail());
        assertEquals(birthDate, s.getBirthDate());
        assertEquals(race, s.getRace());
        assertEquals(gender, s.getGender());
        assertEquals(height, s.getHeight());
        assertEquals(age, s.getAge());
        assertEquals(accountGiven, s.getAccountGiven());
        assertEquals(relationshipToVictim, s.getRelationshipToVictim());
        assertEquals(criminalRecord, s.getCriminalRecord());
        assertEquals(reasonWhySus, s.getReasonWhySus());
    }

    @Test
    public void testSuspectToString() {
        Suspect s = new Suspect(firstName, lastName, type, id, phoneNumber, address, email, birthDate, race, gender,
                accountGiven, relationshipToVictim, criminalRecord, reasonWhySus, height, age);
        Suspect d = new Suspect(firstName, lastName, type, id, phoneNumber, address, email, birthDate, race, gender,
                accountGiven, relationshipToVictim, criminalRecord, reasonWhySus, height, age);
        assertEquals(s.toString(), d.toString());
    }
}
