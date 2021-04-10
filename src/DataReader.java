import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.*;

public class DataReader extends DataConstants {

    public static ArrayList<Person> readPeople() {
        ArrayList<Person> people = new ArrayList<Person>();
        try {
            FileReader reader = new FileReader(PEOPLE_FILE_NAME);
            // JSONParser parser = new JSONParser();
            JSONArray peopleJSON = (JSONArray) new JSONParser().parse(reader);

            for (int i = 0; i < peopleJSON.size(); i++) {
                JSONObject personJSON = (JSONObject) peopleJSON.get(i);
                String firstName = (String) personJSON.get(PEOPLE_FIRST_NAME);
                String lastName = (String) personJSON.get(PEOPLE_LAST_NAME);
                String type = (String) personJSON.get(PEOPLE_TYPE);
                UUID personId = UUID.fromString((String) personJSON.get(PEOPLE_PERSON_ID));
                String phoneNumber = (String) personJSON.get(PEOPLE_PHONE_NUMBER);
                String address = (String) personJSON.get(PEOPLE_ADDRESS);
                String email = (String) personJSON.get(PEOPLE_EMAIL);
                String age = (String) personJSON.get(PEOPLE_AGE);
                String birthDate = (String) personJSON.get(PEOPLE_BIRTH_DATE);
                String race = (String) personJSON.get(PEOPLE_RACE);
                String gender = (String) personJSON.get(PEOPLE_GENDER);
                String height = (String) personJSON.get(PEOPLE_HEIGHT);
                String hairColor = (String) personJSON.get(PEOPLE_HAIR_COLOR);
                String eyeColor = (String) personJSON.get(PEOPLE_EYE_COLOR);
                String incarcerationStatus = (String) personJSON.get(PEOPLE_INCARCERATION_STATUS);
                String offenses = (String) personJSON.get(PEOPLE_NUM_OF_OFFENSES);
                
                int numOfOffenses = 0;
                if (!offenses.equals("")) {
                    numOfOffenses = Integer.parseInt(offenses);
                }

                String severityOfCrime = (String) personJSON.get(PEOPLE_SEVERITY_OF_CRIME);
                String tattoos = (String) personJSON.get(PEOPLE_TATTOOS);
                String knownLocation = (String) personJSON.get(PEOPLE_KNOWN_LOCATION);
                String distinguishingFeatures = (String) personJSON.get(PEOPLE_DISTINGUISHING_FEATURES);
                String recordDescription = (String) personJSON.get(PEOPLE_RECORD_DESCRIPTION);
                String accountGiven = (String) personJSON.get(PEOPLE_ACCOUNT_GIVEN);
                String familyContactInfo = (String) personJSON.get(PEOPLE_FAMILY_CONTACT_INFO);
                String condition = (String) personJSON.get(PEOPLE_CONDITION);
                String bloodType = (String) personJSON.get(PEOPLE_BLOOD_TYPE);
                String relationshipToVictim = (String) personJSON.get(PEOPLE_RELATIONSHIP_TO_VICTIM);
                String criminalRecord = (String) personJSON.get(PEOPLE_CRIMINAL_RECORD);
                String reasonWhySus = (String) personJSON.get(PEOPLE_REASON_WHY_SUS);

                if (type.equalsIgnoreCase("criminal")) {
                    people.add(new Criminal(firstName, lastName, type, personId, phoneNumber, address, email, birthDate,
                            race, gender, hairColor, eyeColor, incarcerationStatus, numOfOffenses, severityOfCrime,
                            tattoos, knownLocation, distinguishingFeatures, recordDescription, height, age));
                } else if (type.equalsIgnoreCase("suspect")) {
                    people.add(new Suspect(firstName, lastName, type, personId, phoneNumber, address, email, birthDate,
                            race, gender, accountGiven, relationshipToVictim, criminalRecord, reasonWhySus, height,
                            age));
                } else if (type.equalsIgnoreCase("victim")) {
                    people.add(new Victim(firstName, lastName, type, personId, phoneNumber, address, email, birthDate,
                            race, gender, familyContactInfo, condition, bloodType, accountGiven, height, age));
                } else if (type.equalsIgnoreCase("witness")) {
                    people.add(new Witness(firstName, lastName, type, personId, phoneNumber, address, email, birthDate,
                            race, gender, accountGiven, height, age));
                } else if (type.equalsIgnoreCase("personOfInterest")) {
                    people.add(new PersonOfInterest(firstName, lastName, type, personId, phoneNumber, address, email,
                            birthDate, race, gender, accountGiven, relationshipToVictim, height, age));
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return people;
    }

    public static ArrayList<Evidence> readEvidence() {
        ArrayList<Evidence> evidence = new ArrayList<Evidence>();
        try {
            FileReader reader = new FileReader(EVIDENCE_FILE_NAME);
            // JSONParser parser = new JSONParser();
            JSONArray evidencesJSON = (JSONArray) new JSONParser().parse(reader);

            for (int i = 0; i < evidencesJSON.size(); i++) {
                JSONObject evidenceJSON = (JSONObject) evidencesJSON.get(i);
                UUID evidenceId = UUID.fromString((String) evidenceJSON.get(EVIDENCE_ID));
                String location = (String) evidenceJSON.get(EVIDENCE_LOCATION);
                String crimeType = (String) evidenceJSON.get(EVIDENCE_CRIME_TYPE);
                String time = (String) evidenceJSON.get(EVIDENCE_TIME);
                String date = (String) evidenceJSON.get(EVIDENCE_DATE);
                String fingerprintInfo = (String) evidenceJSON.get(EVIDENCE_FINGERPRINT_INFO);
                String bloodSampleInfo = (String) evidenceJSON.get(EVIDENCE_BLOOD_SAMPLE_INFO);
                String DNAInfo = (String) evidenceJSON.get(EVIDENCE_DNA_INFO);
                String weapon = (String) evidenceJSON.get(EVIDENCE_WEAPON);
                String descriptionOfScene = (String) evidenceJSON.get(EVIDENCE_DESCRIPTION_OF_SCENE);
                String hairSamples = (String) evidenceJSON.get(EVIDENCE_HAIR_SAMPLES);
                evidence.add(new Evidence(evidenceId, location, crimeType, time, date, fingerprintInfo, bloodSampleInfo,
                        DNAInfo, weapon, descriptionOfScene, hairSamples));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return evidence;
    }

    public static ArrayList<RegisteredUser> readUser() {
        ArrayList<RegisteredUser> users = new ArrayList<RegisteredUser>();
        try {
            FileReader reader = new FileReader(USER_FILE_NAME);
            // JSONParser parser = new JSONParser();
            JSONArray usersJSON = (JSONArray) new JSONParser().parse(reader);

            for (int i = 0; i < usersJSON.size(); i++) {
                JSONObject userJSON = (JSONObject) usersJSON.get(i);
                UUID id = UUID.fromString((String) userJSON.get(USER_ID));
                String firstName = (String) userJSON.get(USER_FIRST_NAME);
                String lastName = (String) userJSON.get(USER_LAST_NAME);
                String userName = (String) userJSON.get(USER_USERNAME);
                String password = (String) userJSON.get(USER_PASSWORD);
                boolean isLoggedIn = (boolean) userJSON.get(USER_IS_LOGGED_IN);
                // add user
                users.add(new RegisteredUser(id, firstName, lastName, userName, password, isLoggedIn));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public static ArrayList<Crime> readCrime() {
        ArrayList<Crime> crime = new ArrayList<Crime>();
        try {
            FileReader reader = new FileReader(CRIME_FILE_NAME);
            JSONArray crimesJSON = (JSONArray) new JSONParser().parse(reader);
            for (int i = 0; i < crimesJSON.size(); i++) {
                JSONObject crimeJSON = (JSONObject) crimesJSON.get(i);
                String crimeTitle = (String) crimeJSON.get(CRIME_TITLE);
                UUID id = UUID.fromString((String) crimeJSON.get(CRIME_ID));
                String description = (String) crimeJSON.get(CRIME_DESCRIPTION);
                // people
                People peoples = People.getInstance();
                ArrayList<Person> allPeople = peoples.getPeople();
                ArrayList<Person> crimePeople = new ArrayList<Person>();
                // criminals
                JSONArray criminalIds = (JSONArray) crimeJSON.get(CRIME_CRIMINALS);
                for (int j = 0; j < criminalIds.size(); j++) {
                    UUID criminalId = UUID.fromString((String) criminalIds.get(j));
                    for (int k = 0; k < allPeople.size(); k++) {
                        if (allPeople.get(k).getId().equals(criminalId)) {
                            crimePeople.add(allPeople.get(k));
                        }
                    }
                }
                // witness
                JSONArray witnessIds = (JSONArray) crimeJSON.get(CRIME_WITNESSES);
                for (int j = 0; j < witnessIds.size(); j++) {
                    UUID witnessId = UUID.fromString((String) witnessIds.get(j));
                    for (int k = 0; k < allPeople.size(); k++) {
                        if (allPeople.get(k).getId().equals(witnessId)) {
                            crimePeople.add(allPeople.get(k));
                        }
                    }
                }
                // suspects
                JSONArray suspectIds = (JSONArray) crimeJSON.get(CRIME_SUSPECTS);
                for (int j = 0; j < suspectIds.size(); j++) {
                    UUID suspectId = UUID.fromString((String) suspectIds.get(j));
                    for (int k = 0; k < allPeople.size(); k++) {
                        if (allPeople.get(k).getId().equals(suspectId)) {
                            crimePeople.add(allPeople.get(k));
                        }
                    }
                }
                // victims
                JSONArray victims = (JSONArray) crimeJSON.get(CRIME_VICTIMS);
                for (int j = 0; j < victims.size(); j++) {
                    UUID victimId = UUID.fromString((String) victims.get(j));
                    for (int k = 0; k < allPeople.size(); k++) {
                        if (allPeople.get(k).getId().equals(victimId)) {
                            crimePeople.add(allPeople.get(k));
                        }
                    }
                }

                // persons of interest
                JSONArray personsOfInterest = (JSONArray) crimeJSON.get(CRIME_PERSONS_OF_INTEREST);
                for (int j = 0; j < personsOfInterest.size(); j++) {
                    UUID personOfInterestId = UUID.fromString((String) personsOfInterest.get(j));
                    for (int k = 0; k < allPeople.size(); k++) {
                        if (allPeople.get(k).getId().equals(personOfInterestId)) {
                            crimePeople.add(allPeople.get(k));
                        }
                    }
                }

                // evidence
                Evidences evidences = Evidences.getInstance();
                ArrayList<Evidence> allEvidence = evidences.getEvidence();
                ArrayList<Evidence> crimeEvidence = new ArrayList<Evidence>();

                JSONArray evidenceIds = (JSONArray) crimeJSON.get(CRIME_EVIDENCE);
                for (int j = 0; j < evidenceIds.size(); j++) {
                    UUID evidenceId = UUID.fromString((String) evidenceIds.get(j));
                    for (int k = 0; k < allEvidence.size(); k++) {
                        if (allEvidence.get(k).getId().equals(evidenceId)) {
                            crimeEvidence.add(allEvidence.get(k));
                        }
                    }
                }
                RegisteredUsers registeredUsers = RegisteredUsers.getInstance();
                ArrayList<RegisteredUser> allUsers = registeredUsers.getRegisteredUsers();
                ArrayList<RegisteredUser> crimeUsers = new ArrayList<RegisteredUser>();
                // users
                JSONArray userIds = (JSONArray) crimeJSON.get(CRIME_USERS);
                for (int j = 0; j < userIds.size(); j++) {
                    UUID userId = UUID.fromString((String) userIds.get(j));
                    for (int k = 0; k < allUsers.size(); k++) {
                        if (allUsers.get(k).getId().equals(userId)) {
                            crimeUsers.add(allUsers.get(k));
                        }
                    }
                }

                crime.add(new Crime(crimeTitle, id, description, crimePeople, crimeEvidence, crimeUsers));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return crime;
    }

    public static void main(String[] args) {
        ArrayList<Person> people = DataReader.readPeople();
        System.out.println("PEOPLE:");
        for (Person p : people) {
            System.out.println(p);
        }
        System.out.println(" ");
        System.out.println("EVIDENCE:");
        ArrayList<Evidence> evidence = DataReader.readEvidence();
        for (Evidence e : evidence) {
            System.out.println(e);
        }
        System.out.println(" ");
        System.out.println("USERS:");
        ArrayList<RegisteredUser> users = DataReader.readUser();
        for (RegisteredUser u : users) {
            System.out.println(u);
        }
        System.out.println(" ");
        System.out.println("CRIMES:");
        ArrayList<Crime> crimes = DataReader.readCrime();
        for (Crime c : crimes) {
            System.out.println(c);
        }
    }

}