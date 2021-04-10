
//package criminalSearchDatabase;
import java.util.*;
import java.util.ArrayList;

public class Crime {

    private String crimeTitle;
    private UUID crimeID;
    private String description;
    private ArrayList<Person> people = new ArrayList<Person>();
    private ArrayList<Evidence> evidence = new ArrayList<Evidence>();
    private ArrayList<RegisteredUser> users = new ArrayList<RegisteredUser>();

    public Crime(String crimeTitle, UUID crimeID, String description, ArrayList<Person> people,
            ArrayList<Evidence> evidence, ArrayList<RegisteredUser> users) {
        this.crimeTitle = crimeTitle;
        this.crimeID = crimeID;
        this.description = description;
        this.people = people;
        this.evidence = evidence;
        this.users = users;

    }

    public String displayCrime() {
        return null;
    }

    public String getCrimeTitle() {
        return this.crimeTitle;
    }

    public void setCrimeTitle(String crimeTitle) {
        crimeTitle = this.crimeTitle;
    }

    public UUID getCrimeId() {
        return this.crimeID;
    }

    public String getDescription() {
        return this.description;
    }

    public ArrayList<Person> getPeople() {
        return this.people;
    }

    public ArrayList<Evidence> getEvidence() {
        return this.evidence;
    }

    public ArrayList<RegisteredUser> getUser() {
        return this.users;
    }

    public void setDescription(String description) {
        description = this.description;
    }

    public void addEvidence(Evidence evidence) {

    }

    public void addSuspects(Suspect suspect) {

    }

    public void addCriminal(Criminal criminal) {

    }

    public void addPersonsOfInterest(PersonOfInterest personOfInterest) {

    }

    public void addVictim(Victim victim) {

    }

    public void addWitnesses(Witness witness) {

    }

    public String toString() {
        String p = "";
        String e = "";
        String u = "";
        for (int i = 0; i < people.size(); i++) {
            
            p += people.get(i).toString() + " \n";
        }

        for (int i = 0; i < evidence.size(); i++) {
            e += evidence.get(i).toString() + " \n";
        }

        for (int i = 0; i < users.size(); i++) {
            u += users.get(i).toString() + " \n";
        }
        return "\n*****************Crime Information*****************" + "\n* Crime Title: " + this.crimeTitle + "\n* Crime ID Number: " + crimeID + "\n* Description: " + description
                + "\n*\n* PEOPLE:\n" + p + " \n* EVIDENCE:\n" + e + "\n* CASE USERS:\n" + u + "\n\n\n";
    }
}
