
//package criminalSearchDatabase;
import java.util.*;
import org.json.simple.JSONObject;

public class Victim extends Person {
    private String familyContactInfo;
    private String condition;
    private String bloodType;
    private String accountGiven;

    public Victim(String firstName, String lastName, String type, UUID personId, String phoneNumber, String address,
            String email, String birthDate, String race, String gender, String familyContactInfo, String condition,
            String bloodType, String accountGiven, String height, String age) {
        super(firstName, lastName, type, personId, phoneNumber, address, email, birthDate, race, gender, height, age);
        this.familyContactInfo = familyContactInfo;
        this.condition = condition;
        this.bloodType = bloodType;
        this.accountGiven = accountGiven;
    }

    public String getFamilyContactInfo() {
        return this.familyContactInfo;
    }

    public void setFamilyContactInfo(String familyContactInfo) {
        this.familyContactInfo = familyContactInfo;
    }

    public String getCondition() {
        return this.condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getBloodType() {
        return this.bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getAccountGiven() {
        return this.accountGiven;
    }

    public void setAccountGiven(String accountGiven) {
        this.accountGiven = accountGiven;
    }

    public String toString() {
        String ret = super.toString();
        ret += "\n*****************Victim Information*****************\n*" + " Condition: " + this.condition
                + "\n* Blood Type: " + this.bloodType + "\n* Emergency Contact Information: " + this.familyContactInfo
                + "\n* Account Given: " + this.accountGiven + "\n";
        return ret;
    }

    public JSONObject getJSON() {
        JSONObject peopleDetails = super.getJSON();
        peopleDetails.put(PEOPLE_ACCOUNT_GIVEN, accountGiven);
        peopleDetails.put(PEOPLE_FAMILY_CONTACT_INFO, familyContactInfo);
        peopleDetails.put(PEOPLE_CONDITION, condition);
        peopleDetails.put(PEOPLE_BLOOD_TYPE, bloodType);
        return peopleDetails;
    }
}
