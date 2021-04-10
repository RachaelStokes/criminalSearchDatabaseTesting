
//package criminalSearchDatabase;
import java.util.*;
import org.json.simple.JSONObject;

public class Person extends DataConstants {
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
    private String numberOfOffenses;
    private String height;
    private String age;

    public Person(String firstName, String lastName, String type, UUID personId, String phoneNumber, String address,
            String email, String birthDate, String race, String gender, String height, String age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.type = type;
        this.id = personId;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
        this.birthDate = birthDate;
        this.race = race;
        this.gender = gender;
        this.age = age;
        this.height = height;

    }

    public String displayPerson() {
        return toString();
    }

    public String getType() {
        return this.type;
    }

    public String getHairColor() {
        return ""; // hair color only used for criminal
    }

    public void setType(String type) {
        this.type = type;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getRace() {
        return this.race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String toString() {
        return "\n*******************" + this.firstName + " " + this.lastName + "*******************" + "\n* " + "DOB: "
                + this.birthDate + "\tGender: " + this.gender + "\tRace: " + this.race + "\n* " + "Address: "
                + this.address + "\n* " + "Email Address: " + this.email + "\n* " + "Phone Number: " + this.phoneNumber
                + "\n";
    }

    public String getNumberOfOffenses() {
        return numberOfOffenses;
    }

    public String getTattoos() {
        return "";
    }

    public void setNumberOfOffenses(String numberOfOffenses) {
        this.numberOfOffenses = numberOfOffenses;
    }

    public String getHeight() {
        return height;
    }

    public String getAge() {
        return age;
    }

    public JSONObject getJSON() {
        JSONObject peopleDetails = new JSONObject();
        peopleDetails.put(PEOPLE_FIRST_NAME, firstName);
        peopleDetails.put(PEOPLE_LAST_NAME, lastName);
        peopleDetails.put(PEOPLE_TYPE, type);
        peopleDetails.put(PEOPLE_PERSON_ID, id.toString());
        peopleDetails.put(PEOPLE_PHONE_NUMBER, phoneNumber);
        peopleDetails.put(PEOPLE_ADDRESS, address);
        peopleDetails.put(PEOPLE_EMAIL, email);
        peopleDetails.put(PEOPLE_BIRTH_DATE, birthDate);
        peopleDetails.put(PEOPLE_RACE, race);
        peopleDetails.put(PEOPLE_GENDER, gender);
        peopleDetails.put(PEOPLE_AGE, age);
        peopleDetails.put(PEOPLE_HEIGHT, height);
        peopleDetails.put(PEOPLE_HAIR_COLOR, "");
        peopleDetails.put(PEOPLE_EYE_COLOR, "");
        peopleDetails.put(PEOPLE_INCARCERATION_STATUS, "");
        peopleDetails.put(PEOPLE_NUM_OF_OFFENSES, "");
        peopleDetails.put(PEOPLE_SEVERITY_OF_CRIME, "");
        peopleDetails.put(PEOPLE_TATTOOS, "");
        peopleDetails.put(PEOPLE_KNOWN_LOCATION, "");
        peopleDetails.put(PEOPLE_DISTINGUISHING_FEATURES, "");
        peopleDetails.put(PEOPLE_RECORD_DESCRIPTION, "");
        peopleDetails.put(PEOPLE_CRIMINAL_RECORD, "");
        peopleDetails.put(PEOPLE_REASON_WHY_SUS, "");
        peopleDetails.put(PEOPLE_ACCOUNT_GIVEN, "");
        peopleDetails.put(PEOPLE_RELATIONSHIP_TO_VICTIM, "");
        peopleDetails.put(PEOPLE_FAMILY_CONTACT_INFO, "");
        peopleDetails.put(PEOPLE_CONDITION, "");
        peopleDetails.put(PEOPLE_BLOOD_TYPE, "");
        return peopleDetails;
    }
}
