import java.util.ArrayList;
import java.util.*;

public class People {
  public static People people = null;
  private static ArrayList<Person> personList = new ArrayList<Person>();

  private People() {
    personList = DataReader.readPeople();
  }

  public static People getInstance() {
    if (people == null) {
      people = new People();
    }
    return people;
  }

  public ArrayList<Person> getPeople() {
    return personList;
  }

  // get person based on id

  public void addPerson(String firstName, String lastName, String type, UUID personId, String phoneNumber,
      String address, String email, String birthDate, String race, String gender, String hairColor, String eyeColor,
      String incarcerationStatus, String offenses, String severityOfCrime, String tattoos, String knownLocation,
      String distinguishingFeatures, String recordDescription, String accountGiven, String relationshipToVictim,
      String criminalRecord, String reasonWhySus, String familyContactInfo, String condition, String bloodType,
      String height, String age) {
      if(type.equalsIgnoreCase("witness")) {
        personList.add(new Witness(firstName, lastName, type, personId, phoneNumber, address, email, birthDate, race,
        gender, accountGiven, height, age));
      } else if (type.equalsIgnoreCase("victim")) {
        personList.add(new Victim(firstName, lastName, type, personId, phoneNumber, address, email,  birthDate,  race, 
        gender, familyContactInfo, condition, bloodType, accountGiven, height, age));
      } else if (type.equalsIgnoreCase("suspect")) {
        personList.add(new Suspect(firstName, lastName, type, personId, phoneNumber, address,
        email, birthDate, race, gender, accountGiven, relationshipToVictim, criminalRecord, reasonWhySus, height, age));
      } else if (type.equalsIgnoreCase("personOfInterest")) {
        personList.add(new PersonOfInterest(firstName, lastName, type, personId, phoneNumber, address,
        email, birthDate, race, gender, accountGiven, relationshipToVictim, height, age));
      } else if (type.equalsIgnoreCase("criminal")) {
        int numOfOffenses = 0;
        if (!offenses.equals("")) {
          numOfOffenses = Integer.parseInt(offenses);
        }
        personList.add(new Criminal(firstName, lastName, type, personId, phoneNumber, address, email, birthDate, race,  
        gender, hairColor, eyeColor, incarcerationStatus, numOfOffenses, severityOfCrime, tattoos, knownLocation,
        distinguishingFeatures, recordDescription, height, age));
      }
      DataWriter.savePeople();
  }
}