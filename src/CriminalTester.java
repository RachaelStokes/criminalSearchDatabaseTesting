import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;

public class CriminalTester {
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
    private String age;
    private String hairColor;
    private String height;
    private String eyeColor;
    private String incarcerationStatus;
    private int numOfOffenses;
    private String severityOfCrime;
    private String tattoos;
    private String knownLocation;
    private String distinguishingFeatures;
    private String recordDescription;

    @Test
    public void testCriminalConstructor() {
        Criminal c = new Criminal(firstName, lastName, type, id, phoneNumber, address, email, birthDate, race, gender,
                hairColor, eyeColor, incarcerationStatus, numOfOffenses, severityOfCrime, tattoos, knownLocation,
                distinguishingFeatures, recordDescription, height, age);
        assertEquals(firstName, c.getFirstName());
        assertEquals(lastName, c.getLastName());
        assertEquals(type, c.getType());
        assertEquals(id, c.getId());
        assertEquals(phoneNumber, c.getPhoneNumber());
        assertEquals(address, c.getAddress());
        assertEquals(email, c.getEmail());
        assertEquals(birthDate, c.getBirthDate());
        assertEquals(race, c.getRace());
        assertEquals(gender, c.getGender());
        assertEquals(height, c.getHeight());
        assertEquals(age, c.getAge());
        assertEquals(hairColor, c.getHairColor());
        assertEquals(eyeColor, c.getEyeColor());
        assertEquals(incarcerationStatus, c.getIncarcerationStatus());
        assertEquals(numOfOffenses, c.getNumOfOffenses());
        assertEquals(tattoos, c.getTattoos());
        assertEquals(knownLocation, c.getKnownLocation());
        assertEquals(distinguishingFeatures, c.getDistinguishingFeatures());
        assertEquals(recordDescription, c.getRecordDescription());
    }

    @Test
    public void testCriminalToString() {
        Criminal c = new Criminal(firstName, lastName, type, id, phoneNumber, address, email, birthDate, race, gender,
                hairColor, eyeColor, incarcerationStatus, numOfOffenses, severityOfCrime, tattoos, knownLocation,
                distinguishingFeatures, recordDescription, height, age);
        Criminal d = new Criminal(firstName, lastName, type, id, phoneNumber, address, email, birthDate, race, gender,
                hairColor, eyeColor, incarcerationStatus, numOfOffenses, severityOfCrime, tattoos, knownLocation,
                distinguishingFeatures, recordDescription, height, age);
        assertEquals(c.toString(), d.toString());
    }
}
