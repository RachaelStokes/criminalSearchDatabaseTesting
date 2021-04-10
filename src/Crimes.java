import java.util.ArrayList;
import java.util.*;

public class Crimes {
  public static Crimes crimes = null;
  private static ArrayList<Crime> crimeList = new ArrayList<Crime>();

  
  private Crimes() {
    crimeList = DataReader.readCrime();
  }

  
  public static Crimes getInstance() { 
    if(crimes == null) 
    { 
      crimes = new Crimes(); 
    } 
    return crimes; 
  }
   

  public ArrayList<Crime> getCrime() {
    return crimeList;
  }

  public void addCrime(String crimeTitle, UUID crimeID, String description, ArrayList<Person> people, ArrayList<Evidence> evidence, ArrayList<RegisteredUser> users) {
    crimeList.add(new Crime(crimeTitle, crimeID, description, people, evidence, users));
    DataWriter.saveCrime();

  }
}