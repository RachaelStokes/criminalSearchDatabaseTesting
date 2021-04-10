
//package criminalSearchDatabase;
import java.util.*;
import org.json.simple.JSONObject;

/**
 * Person of Interest Class, extends the person class and is called when adding
 * a person of interest to the database
 */
public class PersonOfInterest extends Person { 
    private String accountGiven;
    private String relationshipToVictim;

    /**
     * Parameterized constructor, contains all information added about the person of
     * interest
     * 
     * @param firstName            First name
     * @param lastName             Last name
     * @param personId             Personal identification number
     * @param phoneNumber          Phone number
     * @param address              Home address
     * @param email                Email address
     * @param birthDate            Date of Birth
     * @param race                 Race
     * @param gender               Gender
     * @param accountGiven         Given accounts
     * @param relationshipToVictim Relationship to the victim
     */
    public PersonOfInterest(String firstName, String lastName, String type, UUID personId, String phoneNumber,
            String address, String email, String birthDate, String race, String gender, String accountGiven,
            String relationshipToVictim, String height, String age) {
        super(firstName, lastName, type, personId, phoneNumber, address, email, birthDate, race, gender, height, age);
        this.accountGiven = accountGiven;
        this.relationshipToVictim = relationshipToVictim;
    }

    /**
     * Returns the person of interest's relationship to the victim
     */
    public String getRelationshipToVictim() {
        return this.relationshipToVictim;
    }

    /**
     * Sets the person of interest's relationship to the victim
     */
    public void setRelationshipToVictim(String relationshipToVictim) {
        this.relationshipToVictim = relationshipToVictim;
    }

    /**
     * Returns the person of interest's given account of the crime
     */
    public String getAccountGiven() {
        return this.accountGiven;
    }

    /**
     * Sets the person of interest's given account of the crime
     */
    public void setAccountGiven(String accountGiven) {
        this.accountGiven = accountGiven;
    }

    /**
     * Outputs the POI specific information to the designated location
     */
    public String toString() {
        String ret = super.toString();
        ret += "\n*****************Person of Interest Information*****************\n*" + " Account Given: "
                + this.accountGiven + "\n* Relationship to Victim: " + this.relationshipToVictim;
        return ret;
    }

    public JSONObject getJSON() {
        JSONObject peopleDetails = super.getJSON();
        peopleDetails.put(PEOPLE_ACCOUNT_GIVEN, accountGiven);
        peopleDetails.put(PEOPLE_RELATIONSHIP_TO_VICTIM, relationshipToVictim);
        return peopleDetails;
    }
}
