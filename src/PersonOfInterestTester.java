import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.*;

class PersonOfInterestTester {
    String firstName; 
    String lastName;
    String type; 
    UUID personId;
    String phoneNumber; 
    String address;
    String email; 
    String birthDate;
    String race; 
    String gender;
    String accountGiven; 
    String relationshipToVictim;
    String height;
    String age;

    @Test
    public void testPersonOfInterestConstructor() {
        PersonOfInterest p = new PersonOfInterest(firstName, lastName, type, personId, phoneNumber, address, email, birthDate, race, gender, accountGiven, relationshipToVictim, height, age);
        assertEquals(firstName, p.getFirstName());
        assertEquals(lastName, p.getLastName());
        assertEquals(type, p.getType());
        assertEquals(personId, p.getId());
        assertEquals(phoneNumber, p.getPhoneNumber());
        assertEquals(address, p.getAddress());
        assertEquals(email, p.getEmail());
        assertEquals(birthDate, p.getBirthDate());
        assertEquals(race, p.getRace());
        assertEquals(gender, p.getGender());
        assertEquals(accountGiven, p.getAccountGiven());
        assertEquals(relationshipToVictim, p.getRelationshipToVictim());
        assertEquals(height, p.getHeight());
        assertEquals(age, p.getAge());
    }

    @Test
    public void testPersonofInterestToString() {
        PersonOfInterest p = new PersonOfInterest(firstName, lastName, type, personId, phoneNumber, address, email,
                birthDate, race, gender, accountGiven, relationshipToVictim, height, age);
        PersonOfInterest i = new PersonOfInterest(firstName, lastName, type, personId, phoneNumber, address, email,
                birthDate, race, gender, accountGiven, relationshipToVictim, height, age);
        assertEquals(p.toString(), i.toString());
    }
}
