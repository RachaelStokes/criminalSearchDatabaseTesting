import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

class DataWriterTest {
	private RegisteredUsers users = RegisteredUsers.getInstance();
	private ArrayList<RegisteredUser> userList = users.getRegisteredUsers();
	private People people = People.getInstance();
	private ArrayList<Person> peopleList = people.getPeople();
	
	@BeforeEach
	public void setup() {
		RegisteredUsers.getInstance().getRegisteredUsers().clear();
		DataWriter.saveUsers();
		People.getInstance().getPeople().clear();
		DataWriter.savePeople();
	}
	
	@AfterEach
	public void tearDown() {
		RegisteredUsers.getInstance().getRegisteredUsers().clear();
		DataWriter.saveUsers();
		People.getInstance().getPeople().clear();
		DataWriter.savePeople();
	}
	
	
	@Test
	void testWritingZeroUsers() {
		userList = DataReader.readUser();
		assertEquals(0, userList.size());
    }
    
    @Test
	void testWritingOneUser() {
        UUID id = UUID.randomUUID();
		userList.add(new RegisteredUser(id, "Rachael", "Stokes", "rachstokes", "mypassword", false));
		DataWriter.saveUsers();
		assertEquals("rachstokes", DataReader.readUser().get(0).getUsername());
    }

    @Test
    void testWritingFiveUsers() {
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();
        UUID id3 = UUID.randomUUID();
        UUID id4 = UUID.randomUUID();
        UUID id5 = UUID.randomUUID();
        userList.add(new RegisteredUser(id1, "Rachael", "Stokes", "rachstokes1", "mypassword1", false));
		userList.add(new RegisteredUser(id2, "Rachael", "Stokes", "rachstokes2", "mypassword2", false));
		userList.add(new RegisteredUser(id3, "Rachael", "Stokes", "rachstokes3", "mypassword3", false));
		userList.add(new RegisteredUser(id4, "Rachael", "Stokes", "rachstokes4", "mypassword4", false));
		userList.add(new RegisteredUser(id5, "Rachael", "Stokes", "rachstokes5", "mypassword5", false));
		DataWriter.saveUsers();
		assertEquals("rachstokes5", DataReader.readUser().get(4).getUsername());
	}

	@Test
	void testWritingTenUsers() {
		UUID id1 = UUID.randomUUID();
		UUID id2 = UUID.randomUUID();
		UUID id3 = UUID.randomUUID();
		UUID id4 = UUID.randomUUID();
		UUID id5 = UUID.randomUUID();
		UUID id6 = UUID.randomUUID();
		UUID id7 = UUID.randomUUID();
		UUID id8 = UUID.randomUUID();
		UUID id9 = UUID.randomUUID();
		UUID id10 = UUID.randomUUID();
		userList.add(new RegisteredUser(id1, "Rachael", "Stokes", "rachstokes1", "mypassword1", false));
		userList.add(new RegisteredUser(id2, "Rachael", "Stokes", "rachstokes2", "mypassword2", false));
		userList.add(new RegisteredUser(id3, "Rachael", "Stokes", "rachstokes3", "mypassword3", false));
		userList.add(new RegisteredUser(id4, "Rachael", "Stokes", "rachstokes4", "mypassword4", false));
		userList.add(new RegisteredUser(id5, "Rachael", "Stokes", "rachstokes5", "mypassword5", false));
		userList.add(new RegisteredUser(id6, "Rachael", "Stokes", "rachstokes1", "mypassword1", false));
		userList.add(new RegisteredUser(id7, "Rachael", "Stokes", "rachstokes2", "mypassword2", false));
		userList.add(new RegisteredUser(id8, "Rachael", "Stokes", "rachstokes3", "mypassword3", false));
		userList.add(new RegisteredUser(id9, "Rachael", "Stokes", "rachstokes4", "mypassword4", false));
		userList.add(new RegisteredUser(id10, "Rachael", "Stokes", "rachstokes5", "mypassword5", false));
		DataWriter.saveUsers();
		assertEquals("rachstokes5", DataReader.readUser().get(9).getUsername());
	}
	
	@Test
	void testWritingZeroPeople() {
		peopleList = DataReader.readPeople();
		assertEquals(0, peopleList.size());
	}

	@Test
	void testWritingOnePerson() {
		UUID id = UUID.randomUUID();
		peopleList.add(new Criminal("Rachael", "Stokes", "criminal", id, "123-456-7890", "address", "email", "birth", "w", "f", "brown", "green", "not ", 0, "none", "none", "cola", "tall", "none", "3", "1"));
		DataWriter.savePeople();
		assertEquals("criminal", DataReader.readPeople().get(0).getType());
	}
   
	@Test
	void testWritingFivePeople() {
		UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();
        UUID id3 = UUID.randomUUID();
        UUID id4 = UUID.randomUUID();
		UUID id5 = UUID.randomUUID();
		peopleList.add(new Criminal("Rachael", "Stokes", "criminal", id1, "123-456-7890", "address", "email", "birth", "w", "f", "brown", "green", "not ", 0, "none", "none", "cola", "tall", "none", "3", "1"));
		peopleList.add(new Victim("Grace", "Andrews", "victim", id2, "phone", "address", "email", "birthDate", "w", "f", "familyContactInfo", "condition", "bloodType", "accountGiven", "5'10", "19"));
		peopleList.add(new Suspect("Chase", "Smith", "suspect", id3, "phone", "address", "email", "birthDate", "race", "gender", "accountGiven", "relationshipToVictim", "criminalRecord", "reasonWhySus", "height", "age"));
		peopleList.add(new PersonOfInterest("firstName", "lastName", "person of interest", id4, "phoneNumber", "address", "email", "birthDate", "race", "gender", "accountGiven", "relationshipToVictim", "height", "age"));
		peopleList.add(new Witness("firstName", "lastName", "witness", id5, "phoneNumber", "address", "email", "birthDate", "race", "gender", "accountGiven", "height", "age"));
		DataWriter.savePeople();
		assertEquals("suspect", DataReader.readPeople().get(2).getType());
	}

	
}
