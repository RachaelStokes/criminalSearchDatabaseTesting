//package criminalSearchDatabase;
import java.util.*;

/**
 * Evidence class, called when user is adding new evidence to the database
 */
public class Evidence {
    
    private UUID id;
    private String location;
    private String crimeType;
    private String time;
    private String date;
    private String fingerprintInfo;
    private String bloodSampleInfo;
    private String DNAInfo;
    private String weapon;
    private String descriptionOfScene;
    private String hairSamples;
    

    /**
     * Parameterized constructor, takes in all information to be added to the specific evidence being added
     * @param evidenceId ID number for evidence being inputted
     * @param location Location of evidence
     * @param crimeType Type of crime the evidence was involved in
     * @param time Time of evidence collection
     * @param date Date of evidence collection
     * @param fingerprintInfo Fingerprint information of evidence (if applicable)
     * @param bloodSampleInfo Blood sample information of evidence (if applicable)
     * @param DNAInfo DNA information of evidence (if applicable)
     * @param weapon Weapon used (if applicable)
     * @param descriptionOfScene Description of crime scene evidence was collected at
     * @param hairSamples Hair sample information (if applicable)
     */
    public Evidence(UUID evidenceId, String location, String crimeType, String time, String date, String fingerprintInfo, String bloodSampleInfo,
        String DNAInfo, String weapon, String descriptionOfScene, String hairSamples) {
        this.id = evidenceId;
        this.location = location;
        this.crimeType = crimeType;
        this.time = time;
        this.date = date;
        this.fingerprintInfo = fingerprintInfo;
        this.bloodSampleInfo = bloodSampleInfo;
        this.DNAInfo = DNAInfo;
        this.weapon = weapon;
        this.descriptionOfScene = descriptionOfScene;
        this.hairSamples = hairSamples;
    }

    /**
     * Returns ID number of evidence
     */
    public UUID getId() {
        return this.id;
    }

    /**
     * Returns location of evidence collection
     */
    public String getLocation(){
        return this.location;
    }

    /**
     * Returns type of crime committed
     */
    public String getCrimeType(){
        return this.crimeType;
    }

    /**
     * Returns time of evidence collection
     */
    public String getTime(){
        return this.time;
    }

    /**
     * Returns date of evidence collection
     */
    public String getDate(){
        return this.date;
    }

    /**
     * Returns Fingerprint sample information (if applicable)
     */
    public String getFingerprintInfo(){
        return this.fingerprintInfo;
    }

    /**
     * Returns blood sample information (if applicable)
     */
    public String getBloodSampleInfo(){
        return this.bloodSampleInfo;
    }

    /**
     * Returns DNA information (if applicable)
     */
    public String getDNAInfo(){
        return this.DNAInfo;
    }

    /**
     * Returns information about the weapon used (if applicable)
     */
    public String getWeapon(){
        return this.weapon;
    }

    /**
     * Returns description of scene that evidence was collected at
     */
    public String getDescriptionOfScene(){
        return this.descriptionOfScene;
    }

    /**
     * Returns hair samples collected (if applicable)
     */
    public String getHairSamples(){
        return this.hairSamples;
    }

    /**
     * Sets the location of the evidence collected to be added to the database
     */
    public void SetLocation(String location){
        location = this.location;
    }

    /**
     * Sets the type of crime involved with the evidence collected to be added to the database
     */
    public void setCrimeType(String crimeType){
        crimeType = this.crimeType;
    }

    /**
     * Sets the time of the evidence collected to be added to the database
     */
    public void setTime(String time){
        time = this.time;
    }

    /**
     * Sets the date of the evidence collected to be added to the database
     */
    public void setDate(String date){
        date = this.date;
    }

    /**
     * Sets the fingerprint information of the evidence collected (if applicable) to be added to the database
     */
    public void setFingerprintInfo(String fingerprintInfo){
        fingerprintInfo = this.fingerprintInfo;
    }

    /**
     * Sets the blood sample information of the evidence collected (if applicable) to be added to the database
     */
    public void setBloodSampleInfo(String bloodSampleInfo){
        bloodSampleInfo = this.bloodSampleInfo;
    }

    /**
     * Sets the DNA information of the evidence collected (if applicable) to be added to the database
     */
    public void setDNAInfo(String DNAInfo){
        DNAInfo = this.DNAInfo;
    }

    /**
     * Sets the information about the weapon used (if applicable) to be added to the database
     */
    public void setWeapon(String weapon){
        weapon = this.weapon;
    }

    /**
     * Sets the scene description of the evidence collected to be added to the database
     */
    public void setDescriptionOfScene(String descriptionOfScene){
        descriptionOfScene = this.descriptionOfScene;
    }

    /**
     * Sets the hair sample information of the evidence collected (if applicable) to be added to the database
     */
    public void setHairSamples(String hairSamples){
        hairSamples = this.hairSamples;
    }

    /**
     * toString method, prints the evidence ID number, location, and type of crime committed to the user
     */
    public String toString() {
        return "* Evidence ID: " + id + "\n* Location: " + this.location + "\n* Type of Crime: " + this.crimeType + "\n* Time of Collection: " + this.time
        + "\n* Date of Collection: " + this.date + "\n* Fingerprint Information: " + this.fingerprintInfo + "\n* Blood Sample Information: " + this.bloodSampleInfo
        + "\n* DNA Information: " + this.DNAInfo + "\n* Weapon: " + this.weapon + "\n* Scene Description: " + this.descriptionOfScene
        + "\n* Hair Sample Information: " + this.hairSamples + "\n";
    }

}
