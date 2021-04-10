import java.util.ArrayList;
import java.util.*;

public class Evidences {
  public static Evidences evidences = null;
  private static ArrayList<Evidence> evidenceList = new ArrayList<Evidence>();

  private Evidences() {
    evidenceList = DataReader.readEvidence();
  }

  
  public static Evidences getInstance() { 
    if(evidences == null) 
    { 
      evidences = new Evidences(); 
    } 
    return evidences; 
  }
   

  public ArrayList<Evidence> getEvidence() {
    return evidenceList;
  }

  public void addEvidence(UUID evidenceId, String location, String crimeType, String time, String date,
      String fingerprintInfo, String bloodSampleInfo, String DNAInfo, String weapon, String descriptionOfScene,
      String hairSamples) {
    evidenceList.add(new Evidence(evidenceId, location, crimeType, time, date, fingerprintInfo, bloodSampleInfo,
        DNAInfo, weapon, descriptionOfScene, hairSamples));
    DataWriter.saveEvidence();
  }
}