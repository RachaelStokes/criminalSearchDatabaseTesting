
//package criminalSearchDatabase;
import java.util.*;
import org.json.simple.JSONObject;

/**
 * The criminal class is an extension of the person class that will contain all
 * of the information used to create a criminal in the database.
 */
public class Criminal extends Person {
    private String hairColor;
    private String height;
    private String eyeColor;
    private String incarcerationStatus;
    private int numOfOffenses;
    private String severityOfCrime;
    private String tattoos;
    private String knownLocation;
    private String distinguishingFeatures;
    private String recordDescription;

    /**
     * Parameterized constructor that will set all of the criminal attributes for
     * the specified criminal, preparing them to add to the database.
     * 
     * @param firstName              First name of the criminal
     * @param lastName               Last name of the criminal
     * @param personId               Personal ID number of the criminal
     * @param phoneNumber            Phone Number of the criminal
     * @param address                Address of the criminal
     * @param email                  Email address of the criminal
     * @param birthDate              Date of Birth of the criminal
     * @param race                   Race of the criminal
     * @param gender                 Gender of the criminal
     * @param hairColor              Hair color of the criminal
     * @param eyeColor               Eye color of the criminal
     * @param incarcerationStatus    Current Incarceration Status of the criminal
     * @param numOfOffenses          Number of previous offenses
     * @param severityOfCrime        Severerity of crime committed
     * @param tattoos                Tattoos or other notable bodily modifications
     *                               of the criminal
     * @param knownLocation          Current known location (if known) of the
     *                               criminal
     * @param distinguishingFeatures Other distinguishing features of the criminal
     * @param recordDescription      Criminal record overview of the criminal
     */
    public Criminal(String firstName, String lastName, String type, UUID personId, String phoneNumber, String address,
            String email, String birthDate, String race, String gender, String hairColor, String eyeColor,
            String incarcerationStatus, int numOfOffenses, String severityOfCrime, String tattoos, String knownLocation,
            String distinguishingFeatures, String recordDescription, String height, String age) {
        super(firstName, lastName, type, personId, phoneNumber, address, email, birthDate, race, gender, height, age);
        this.hairColor = hairColor;
        this.eyeColor = eyeColor;
        this.incarcerationStatus = incarcerationStatus;
        this.numOfOffenses = numOfOffenses;
        this.severityOfCrime = severityOfCrime;
        this.tattoos = tattoos;
        this.knownLocation = knownLocation;
        this.distinguishingFeatures = distinguishingFeatures;
        this.recordDescription = recordDescription;
        this.height = height;

    }

    /**
     * Returns hair color of the criminal
     */
    public String getHairColor() {
        return this.hairColor;
    }

    /**
     * Sets the hair color to the specified color in the database
     */
    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    /**
     * Returns eye color of the criminal
     */
    public String getEyeColor() {
        return this.eyeColor;
    }

    /**
     * Sets the eye color to the specified color in the database
     */
    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    /**
     * Returns incarceration status of the criminal
     */
    public String getIncarcerationStatus() {
        return this.incarcerationStatus;
    }

    /**
     * Sets the incarceration status to the specified status in the database
     */
    public void setIncarcerationStatus(String incarcerationStatus) {
        this.incarcerationStatus = incarcerationStatus;
    }

    /**
     * Returns the number of previous offenses of the criminal
     */
    public int getNumOfOffenses() {
        return this.numOfOffenses;
    }

    /**
     * Sets the number of previous offenses in the database
     */
    public void setNumOffenses(int numOfOffenses) {
        this.numOfOffenses = numOfOffenses;
    }

    /**
     * Returns severity of the criminal's crimes
     */
    public String getSeverityOfCrimes() {
        return this.severityOfCrime;
    }

    /**
     * Sets the severity of the criminal's crimes in the database
     */
    public void setSeverityOfCrimes(String severityOfCrime) {
        this.severityOfCrime = severityOfCrime;
    }

    /**
     * Returns tattoos or other notable bodily modifications of the criminal
     */
    public String getTattoos() {
        return this.tattoos;
    }

    /**
     * Sets tattoos or other notable bodily modifications of the criminal in the
     * database
     */
    public void setTattoos(String tattoos) {
        this.tattoos = tattoos;
    }

    /**
     * Returns known location of the criminal
     */
    public String getKnownLocation() {
        return this.knownLocation;
    }

    /**
     * Sets the known location in the database
     */
    public void setKnownLocation(String knownLocation) {
        this.knownLocation = knownLocation;
    }

    /**
     * Returns distinguishing features of the criminal
     */
    public String getDistinguishingFeatures() {
        return this.distinguishingFeatures;
    }

    /**
     * Sets distinguishing features in the database
     */
    public void setDistinguishingFeatures(String distinguishingFeatures) {
        this.distinguishingFeatures = distinguishingFeatures;
    }

    /**
     * Returns record description of the criminal
     */
    public String getRecordDescription() {
        return this.recordDescription;
    }

    /**
     * Sets the description of the criminal's record in the database
     */
    public void setRecordDescription(String recordDescription) {
        this.recordDescription = recordDescription;
    }

    public String getHeight() {
        return this.height;
    }

    public void setHeight(String h) {
        height = h;
    }

    public String toString() {
        String ret = super.toString();
        ret += "\n*****************Criminal Information*****************\n* Number of Offenses: " + this.numOfOffenses
                + "\n* Incarceration status: " + this.incarcerationStatus + "\tHeight: " + this.height
                + "\n* Hair Color: " + this.hairColor + "\tEye Color: " + this.eyeColor + "\n* Number of Offenses: "
                + this.numOfOffenses + "\n* Crime Severity: " + this.severityOfCrime + "\n* Tattoos: " + this.tattoos
                + "\n* Dist. Features: " + this.distinguishingFeatures + "\n* Last Known Location: "
                + this.knownLocation + "\n* Record Description: " + this.recordDescription;
        // TODO keep adding stuff specific to criminals
        return ret;
    }

    public JSONObject getJSON() {
        JSONObject peopleDetails = super.getJSON();
        peopleDetails.put(PEOPLE_HAIR_COLOR, hairColor);
        peopleDetails.put(PEOPLE_EYE_COLOR, eyeColor);
        peopleDetails.put(PEOPLE_INCARCERATION_STATUS, incarcerationStatus);
        peopleDetails.put(PEOPLE_NUM_OF_OFFENSES, String.valueOf(numOfOffenses));
        peopleDetails.put(PEOPLE_SEVERITY_OF_CRIME, severityOfCrime);
        peopleDetails.put(PEOPLE_TATTOOS, tattoos);
        peopleDetails.put(PEOPLE_KNOWN_LOCATION, knownLocation);
        peopleDetails.put(PEOPLE_DISTINGUISHING_FEATURES, distinguishingFeatures);
        peopleDetails.put(PEOPLE_RECORD_DESCRIPTION, recordDescription);
        return peopleDetails;
    }

}
