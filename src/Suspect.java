
//package criminalSearchDatabase;
import java.util.*;
import org.json.simple.JSONObject;

public class Suspect extends PersonOfInterest {
    private String criminalRecord;
    private String reasonWhySus;

    public Suspect(String firstName, String lastName, String type, UUID personId, String phoneNumber, String address,
            String email, String birthDate, String race, String gender, String accountGiven,
            String relationshipToVictim, String criminalRecord, String reasonWhySus, String height, String age) {
        super(firstName, lastName, type, personId, phoneNumber, address, email, birthDate, race, gender, accountGiven,
                relationshipToVictim, height, age);
        this.criminalRecord = criminalRecord;
        this.reasonWhySus = reasonWhySus;

    }

    public String getReasonWhySus() {
        return this.reasonWhySus;
    }

    public void setReasonWhySus(String reasonWhySus) {
        this.reasonWhySus = reasonWhySus;
    }

    public String getCriminalRecord() {
        return this.criminalRecord;
    }

    public void setCriminalRecord(String criminalRecord) {
        this.criminalRecord = criminalRecord;
    }

    public JSONObject getJSON() {
        JSONObject peopleDetails = super.getJSON();
        peopleDetails.put(PEOPLE_CRIMINAL_RECORD, criminalRecord);
        peopleDetails.put(PEOPLE_REASON_WHY_SUS, reasonWhySus);
        return peopleDetails;
    }
}
