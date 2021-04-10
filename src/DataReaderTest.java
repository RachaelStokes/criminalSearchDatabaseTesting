import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

class DataReaderTest {
    private RegisteredUsers users = RegisteredUsers.getInstance();
    private ArrayList<RegisteredUser> userList = users.getRegisteredUsers();
    private People people = People.getInstance();
    private ArrayList<Person> peopleList = people.getPeople();
    private Evidences evidences = Evidences.getInstance();
    private ArrayList<Evidence> evidenceList = evidences.getEvidence();
    private Crimes crimes = Crimes.getInstance();
    private ArrayList<Crime> crimeList = crimes.getCrime();
	
	@BeforeEach
	public void setup() {
        userList.clear();
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();
		userList.add(new RegisteredUser(id1, "Jane", "Doe", "jdoe1", "password", false));
		userList.add(new RegisteredUser(id2, "John", "Doe", "jdoe2", "password", false));
        DataWriter.saveUsers();
        
        peopleList.clear();
        UUID id3 = UUID.randomUUID();
        UUID id4 = UUID.randomUUID();
        peopleList.add(new Criminal("Rachael", "Stokes", "criminal", id3, "phoneNumber", "address", "email", "birthDate", "race", "gender", "hairColor", "eyeColor", "incarcerationStatus", 0, "severityOfCrime", "tattoos", "knownLocation", "distinguishingFeatures", "recordDescription", "height", "age"));
        //peopleList.add(new Victim(firstName, lastName, type, personId, phoneNumber, address, email, birthDate, race, gender, familyContactInfo, condition, bloodType, accountGiven, height, age));
        DataWriter.savePeople();

        evidenceList.clear();
        UUID id5 = UUID.randomUUID();
        UUID id6 = UUID.randomUUID();
        //evidenceList.add(new Evidence(id5, "columbia", "robbery", time, date, fingerprintInfo, bloodSampleInfo, DNAInfo, weapon, descriptionOfScene, hairSamples));
        //evidenceList.add(new Evidence(id6, location, crimeType, time, date, fingerprintInfo, bloodSampleInfo, DNAInfo, weapon, descriptionOfScene, hairSamples));
        DataWriter.saveEvidence();

        crimeList.clear();
        UUID id7 = UUID.randomUUID();
        UUID id8 = UUID.randomUUID();
        crimeList.add(new Crime("crime 1", id7, "the first crime", peopleList, evidenceList, userList));
        crimeList.add(new Crime("crime 2", id8, "the second crime", peopleList, evidenceList, userList));

	}
	
	@AfterEach
	public void tearDown() {
		RegisteredUsers.getInstance().getRegisteredUsers().clear();
        DataWriter.saveUsers();
        People.getInstance().getPeople().clear();
        DataWriter.savePeople();
    }
    
    @Test
    void testGetUserSize() {
        userList = DataReader.readUser();
		assertEquals(2, userList.size());
    }

    @Test
    void testGetUserSizeZero() {
        RegisteredUsers.getInstance().getRegisteredUsers().clear();
        userList = DataReader.readUser();
		assertEquals(0, userList.size());
    }

    @Test
    void testGetUserUsername() {
        userList = DataReader.readUser();
		assertEquals("jdoe1", userList.get(0).getUsername());
    }

    @Test
    void testGetUserLastName() {
        userList = DataReader.readUser();
		assertEquals("Doe", userList.get(1).getLastName());
    }

    @Test
    void testGetPeopleSize() {
        peopleList = DataReader.readPeople();
        assertEquals(1, peopleList.size());
    }

    @Test
    void testGetPeopleType() {
        peopleList = DataReader.readPeople();
        assertEquals("criminal", peopleList.get(0).getType());
    }

    @Test
    void testGetPeopleizeZero() {
        People.getInstance().getPeople().clear();
        peopleList = DataReader.readPeople();
		assertEquals(0, peopleList.size());
    }
    

}