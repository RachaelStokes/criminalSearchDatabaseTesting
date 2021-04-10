
//package criminalSearchDatabase;
import java.util.*;
import org.json.simple.JSONObject;

public class Witness extends Person {
    private String accountGiven;

    public Witness(String firstName, String lastName, String type, UUID personId, String phoneNumber, String address,
            String email, String birthDate, String race, String gender, String accountGiven, String height,
            String age) {
        super(firstName, lastName, type, personId, phoneNumber, address, email, birthDate, race, gender, height, age);
        this.accountGiven = accountGiven;
    }

    public String getAccountGiven() {
        return this.accountGiven;
    }

    public void setAccountGiven(String accountGiven) {
        this.accountGiven = accountGiven;
    }

    public String toString() {
        String ret = super.toString();
        ret += "\n*****************Witness Information*****************\n*" + " Account Given: " + this.accountGiven;
        return ret;
    }

    public JSONObject getJSON() {
        JSONObject peopleDetails = super.getJSON();
        peopleDetails.put(PEOPLE_ACCOUNT_GIVEN, accountGiven);
        return peopleDetails;
    }
}
