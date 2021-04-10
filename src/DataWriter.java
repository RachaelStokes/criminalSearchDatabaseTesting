//package criminalSearchDatabase;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.*;

public class DataWriter extends DataConstants{

    public static void saveUsers() {
        RegisteredUsers users = RegisteredUsers.getInstance();
        ArrayList<RegisteredUser> userList = users.getRegisteredUsers();
        JSONArray jsonUsers = new JSONArray();

        //creating all the json objects
        for(int i = 0; i < userList.size(); i++) {
            jsonUsers.add(getUserJSON(userList.get(i)));
        }

        //write JSON file
        try (FileWriter file = new FileWriter(USER_FILE_NAME)) {
            file.write(jsonUsers.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static JSONObject getUserJSON(RegisteredUser user) {
        JSONObject userDetails = new JSONObject();
        userDetails.put(USER_ID, user.getId().toString());
        userDetails.put(USER_FIRST_NAME, user.getFirstName());
        userDetails.put(USER_LAST_NAME, user.getLastName());
        userDetails.put(USER_USERNAME, user.getUsername());
        userDetails.put(USER_PASSWORD, user.getPassword());
        userDetails.put(USER_IS_LOGGED_IN, user.getLoggedIn());

        return userDetails;
    }

    public static void saveEvidence() {
        Evidences evidences = Evidences.getInstance();
        ArrayList<Evidence> evidenceList = evidences.getEvidence();
        JSONArray jsonEvidence = new JSONArray();

        for(int i = 0; i < evidenceList.size(); i++) {
            jsonEvidence.add(getEvidenceJSON(evidenceList.get(i)));
        }

        try (FileWriter file = new FileWriter(EVIDENCE_FILE_NAME)) {

            file.write(jsonEvidence.toJSONString());
            file.flush();
    
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getEvidenceJSON(Evidence evidence) {
        JSONObject evidenceDetails = new JSONObject();

        evidenceDetails.put(EVIDENCE_ID, evidence.getId().toString());
        evidenceDetails.put(EVIDENCE_LOCATION, evidence.getLocation());
        evidenceDetails.put(EVIDENCE_CRIME_TYPE, evidence.getCrimeType());
        evidenceDetails.put(EVIDENCE_TIME, evidence.getTime());
        evidenceDetails.put(EVIDENCE_DATE, evidence.getDate());
        evidenceDetails.put(EVIDENCE_FINGERPRINT_INFO, evidence.getFingerprintInfo());
        evidenceDetails.put(EVIDENCE_BLOOD_SAMPLE_INFO, evidence.getBloodSampleInfo());
        evidenceDetails.put(EVIDENCE_DNA_INFO, evidence.getDNAInfo());
        evidenceDetails.put(EVIDENCE_WEAPON, evidence.getWeapon());
        evidenceDetails.put(EVIDENCE_DESCRIPTION_OF_SCENE, evidence.getDescriptionOfScene());
        evidenceDetails.put(EVIDENCE_HAIR_SAMPLES, evidence.getHairSamples());

        return evidenceDetails;
    }


    public static void saveCrime() {
        Crimes crimes = Crimes.getInstance();
        ArrayList<Crime> crimeList = crimes.getCrime();
        JSONArray jsonCrime = new JSONArray();

        for(int i = 0; i < crimeList.size(); i++) {
            jsonCrime.add(getCrimeJSON(crimeList.get(i)));
        }

        try (FileWriter file = new FileWriter(CRIME_FILE_NAME)) {

            file.write(jsonCrime.toJSONString());
            file.flush();
    
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getCrimeJSON(Crime crime) {
        JSONObject crimeDetails = new JSONObject();
        ArrayList<Person> people = crime.getPeople();
        ArrayList<Evidence> evidence = crime.getEvidence();
        ArrayList<RegisteredUser> users = crime.getUser();
       
        JSONArray criminals  = new JSONArray();
        for(int i = 0; i < people.size(); i ++) {
            if(people.get(i).getType().equalsIgnoreCase("Criminal")) {
                criminals.add(people.get(i).getId().toString());
            }
        }

        JSONArray suspects  = new JSONArray();
        for(int i = 0; i < people.size(); i ++) {
            if(people.get(i).getType().equalsIgnoreCase("suspect")) {
                suspects.add(people.get(i).getId().toString());
            }
        }

        JSONArray personsOfInterest  = new JSONArray();
        for(int i = 0; i < people.size(); i ++) {
            if(people.get(i).getType().equalsIgnoreCase("personOfInterest")) {
                personsOfInterest.add(people.get(i).getId().toString());
            }
        }

        JSONArray witnesses  = new JSONArray();
        for(int i = 0; i < people.size(); i ++) {
            if(people.get(i).getType().equalsIgnoreCase("witness")) {
                witnesses.add(people.get(i).getId().toString());
            }
        }

        JSONArray victims  = new JSONArray();
        for(int i = 0; i < people.size(); i ++) {
            if(people.get(i).getType().equalsIgnoreCase("victim")) {
                victims.add(people.get(i).getId().toString());
            }
        }

        JSONArray evidenceIds  = new JSONArray();
        for(int i = 0; i < evidence.size(); i ++) {
            evidenceIds.add(evidence.get(i).getId().toString());
        }

        JSONArray userIds  = new JSONArray();
        for(int i = 0; i < users.size(); i ++) {
            userIds.add(users.get(i).getId().toString());
        }
        
        crimeDetails.put(CRIME_TITLE, crime.getCrimeTitle());
        crimeDetails.put(CRIME_ID, crime.getCrimeId().toString());
        crimeDetails.put(CRIME_DESCRIPTION, crime.getDescription());
        crimeDetails.put(CRIME_CRIMINALS, criminals);
        crimeDetails.put(CRIME_SUSPECTS, suspects);
        crimeDetails.put(CRIME_PERSONS_OF_INTEREST, personsOfInterest);
        crimeDetails.put(CRIME_WITNESSES, witnesses);
        crimeDetails.put(CRIME_VICTIMS, victims);
        crimeDetails.put(CRIME_EVIDENCE, evidenceIds);
        crimeDetails.put(CRIME_USERS, userIds);

        return crimeDetails;
    }

   
    
    public static void savePeople() {
        People people = People.getInstance();
        ArrayList<Person> peopleList = people.getPeople();
        JSONArray jsonPeople = new JSONArray();

        for(int i = 0; i < peopleList.size(); i++) {
           jsonPeople.add(getPeopleJSON(peopleList.get(i)));
        }

        try (FileWriter file = new FileWriter(PEOPLE_FILE_NAME)) {

            file.write(jsonPeople.toJSONString());
            file.flush();
    
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   public static JSONObject getPeopleJSON(Person person) {
        return person.getJSON();
    }
   

    public static void main(String[] args) {
        
        /*
        RegisteredUsers users = RegisteredUsers.getInstance();
        UUID userid = UUID.randomUUID();
        users.addRegisteredUser(userid, "Rachael", "Stokes", "alksjd", "kjsdhf", true);
        Evidences evidences = Evidences.getInstance();
        UUID evidenceid = UUID.randomUUID();
        evidences.addEvidence(evidenceid, "miami", "robbery", "midnight", "3/22/21", "no fingerprints", "blood", "DNA", "gun", "Scene descriptonsdf", "no hair"); 
        
        Crimes crimes = Crimes.getInstance();
        UUID crimeId = UUID.randomUUID();
        ArrayList<Person> person = new ArrayList<Person>();
        UUID personId = UUID.randomUUID();
        person.add(new Criminal("Rachael", "Stokes", "criminal", personId, "phone ", "address", "email", "birth", "w", "f", "brown", "green", "not ", 0, "none", "none", "cola", "tall", "none", "3", "1"));
        ArrayList<Evidence> evidence = new ArrayList<Evidence>();
        evidence.add(new Evidence(UUID.randomUUID(), "location", "crimeType", "time", "date", "finge", "blood sample", "dna", "weapon", "description of the scene", "hairsamples"));
        ArrayList<RegisteredUser> users2 = new ArrayList<RegisteredUser>();
        users2.add(new RegisteredUser(UUID.randomUUID(), "firstname", "lastname", "user", "password", false));
        crimes.addCrime("crime title", crimeId, "description", person, evidence, users2); 
        
        People people = People.getInstance();
        UUID personId = UUID.randomUUID();
        people.addPerson("firstName", "lastName", "witness", personId, "phoneNumber", "address", "email",
         "birthDate",  "race",  "gender",  "hairColor", "eyeColor",  "", 0,  "", 
         "",  "",  "",  "",  "accountGiven",  "", "",  "",  "",  "", "", "", "21");
         */
        //DataWriter.savePeople();
    }
}
