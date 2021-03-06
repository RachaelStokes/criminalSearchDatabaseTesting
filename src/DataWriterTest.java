import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.json.simple.JSONObject;
import java.util.*;

class DataWriterTest {
	private RegisteredUsers users = RegisteredUsers.getInstance();
	private ArrayList<RegisteredUser> userList = users.getRegisteredUsers();

	private People people = People.getInstance();
	private ArrayList<Person> peopleList = people.getPeople();
	
	/*
	private Evidences evidences = Evidences.getInstance();
	private ArrayList<Evidence> evidenceList = evidences.getEvidence();

	private Crimes crimes = Crimes.getInstance();
	private ArrayList<Crime> crimesList = crimes.getCrime();*/
	
	 @BeforeEach public void setup() {
	 RegisteredUsers.getInstance().getRegisteredUsers().clear();
	 DataWriter.saveUsers(); People.getInstance().getPeople().clear();
	 DataWriter.savePeople(); }
	 
	
	 @AfterEach public void tearDown() {
	 RegisteredUsers.getInstance().getRegisteredUsers().clear();
	 DataWriter.saveUsers(); People.getInstance().getPeople().clear();
	 DataWriter.savePeople(); }
	 

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
		userList.add(new RegisteredUser(id6, "Rachael", "Stokes", "rachstokes6", "mypassword1", false));
		userList.add(new RegisteredUser(id7, "Rachael", "Stokes", "rachstokes7", "mypassword2", false));
		userList.add(new RegisteredUser(id8, "Rachael", "Stokes", "rachstokes8", "mypassword3", false));
		userList.add(new RegisteredUser(id9, "Rachael", "Stokes", "rachstokes9", "mypassword4", false));
		userList.add(new RegisteredUser(id10, "Rachael", "Stokes", "rachstokes10", "mypassword5", false));
		DataWriter.saveUsers();
		assertEquals("rachstokes10", DataReader.readUser().get(9).getUsername());
	}

	@Test
	void testWritingZeroPeople() {
		peopleList = DataReader.readPeople();
		assertEquals(0, peopleList.size());
	}

	@Test
	void testWritingOnePerson() {
		UUID id = UUID.randomUUID();
		peopleList.add(new Criminal("Rachael", "Stokes", "criminal", id, "123-456-7890", "address", "email", "birth",
				"w", "f", "brown", "green", "not ", 0, "none", "none", "cola", "tall", "none", "3", "1"));
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
		peopleList.add(new Criminal("Rachael", "Stokes", "criminal", id1, "123-456-7890", "address", "email", "birth",
				"w", "f", "brown", "green", "not ", 0, "none", "none", "cola", "tall", "none", "3", "1"));
		peopleList.add(new Victim("Grace", "Andrews", "victim", id2, "phone", "address", "email", "birthDate", "w", "f",
				"familyContactInfo", "condition", "bloodType", "accountGiven", "5'10", "19"));
		peopleList.add(new Suspect("Chase", "Smith", "suspect", id3, "phone", "address", "email", "birthDate", "race",
				"gender", "accountGiven", "relationshipToVictim", "criminalRecord", "reasonWhySus", "height", "age"));
		peopleList.add(new PersonOfInterest("firstName", "lastName", "person of interest", id4, "phoneNumber",
				"address", "email", "birthDate", "race", "gender", "accountGiven", "relationshipToVictim", "height",
				"age"));
		peopleList.add(new Witness("firstName", "lastName", "witness", id5, "phoneNumber", "address", "email",
				"birthDate", "race", "gender", "accountGiven", "height", "age"));
		DataWriter.savePeople();
		assertEquals("suspect", DataReader.readPeople().get(2).getType());
	}

	void testWritingTenPeople() {
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
		peopleList.add(new Criminal("Rachael", "Stokes", "criminal", id1, "123-456-7890", "address", "email", "birth",
				"w", "f", "brown", "green", "not ", 0, "none", "none", "cola", "tall", "none", "3", "1"));
		peopleList.add(new Criminal("Logan", "Moseley", "criminal", id2, "321-654-0987", "address", "email", "birth",
				"w", "m", "black", "green", "not ", 0, "none", "none", "cola", "tall", "none", "3", "1"));
		peopleList.add(new Victim("Grace", "Andrews", "victim", id3, "phone", "address", "email", "birthDate", "w", "f",
				"familyContactInfo", "condition", "bloodType", "accountGiven", "5'10", "19"));
		peopleList.add(new Victim("Abby", "Williams", "victim", id4, "phone", "address", "email", "birthDate", "w", "f",
				"familyContactInfo", "condition", "bloodType", "accountGiven", "5'10", "19"));
		peopleList.add(new Suspect("Chase", "Smith", "suspect", id5, "phone", "address", "email", "birthDate", "race",
				"gender", "accountGiven", "relationshipToVictim", "criminalRecord", "reasonWhySus", "height", "age"));
		peopleList.add(new Suspect("Alex", "Richardson", "suspect", id6, "phone", "address", "email", "birthDate",
				"race", "gender", "accountGiven", "relationshipToVictim", "criminalRecord", "reasonWhySus", "height",
				"age"));
		peopleList.add(new PersonOfInterest("firstName", "lastName", "person of interest", id7, "phoneNumber",
				"address", "email", "birthDate", "race", "gender", "accountGiven", "relationshipToVictim", "height",
				"age"));
		peopleList.add(new PersonOfInterest("firstName", "lastName", "person of interest", id8, "phoneNumber",
				"address", "email", "birthDate", "race", "gender", "accountGiven", "relationshipToVictim", "height",
				"age"));
		peopleList.add(new Witness("firstName", "lastName", "witness", id9, "phoneNumber", "address", "email",
				"birthDate", "race", "gender", "accountGiven", "height", "age"));
		peopleList.add(new Witness("firstName", "lastName", "witness", id10, "phoneNumber", "address", "email",
				"birthDate", "race", "gender", "accountGiven", "height", "age"));
		DataWriter.savePeople();
		assertEquals("victim", DataReader.readPeople().get(3).getType());

	}
	/*
	@Test
	void getUserThruJSON() {
		System.out.println(userList.size());
		int randIndex = (int) (Math.random() * 7);// random num 1-7
		RegisteredUser randUser = userList.get(randIndex);
		JSONObject randJSONObj = DataWriter.getUserJSON(randUser);
		String nameOne = randUser.getFirstName();
		String nameTwo = String.valueOf(randJSONObj.get("firstName"));
		assertEquals(nameOne, nameTwo);
	}
	
	@Test
	void getPersonThruJSON() {
		int randIndex = (int) (Math.random() * 18);// random num 1-18
		Person randPerson = peopleList.get(randIndex);
		JSONObject randJSONObj = DataWriter.getPeopleJSON(randPerson);
		String nameOne = randPerson.getFirstName();
		String nameTwo = String.valueOf(randJSONObj.get("firstName"));
		assertEquals(nameOne, nameTwo);
	}

	@Test
	void getEvidenceThruJSON() {
		int randIndex = (int) (Math.random() * 4);// random num 1-4
		Evidence randEvidence = evidenceList.get(randIndex);
		JSONObject randJSONObj = DataWriter.getEvidenceJSON(randEvidence);
		String weaponOne = randEvidence.getWeapon();
		String weaponTwo = String.valueOf(randJSONObj.get("weapon"));
		assertEquals(weaponOne, weaponTwo);
	}

	@Test
	void getCrimeThruJSON() {
		int randIndex = (int) (Math.random() * 5);// random num 1-5
		Crime randCrime = crimesList.get(randIndex);
		JSONObject randJSONObj = DataWriter.getCrimeJSON(randCrime);
		String crimeIdOne = randCrime.getCrimeId().toString();
		String crimeIdTwo = String.valueOf(randJSONObj.get("crimeId"));
		assertEquals(crimeIdOne, crimeIdTwo);

	}*/

}
