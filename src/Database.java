import java.util.Scanner;
import java.io.*;
import java.util.*;

public class Database {
    private static Scanner scan = new Scanner(System.in);
    private static String currMenu = "m";
    private static String nextMenu = "";
    private static String currFeature = "";
    private static String nextFeature = "";
    private static String attributes = "";
    private static boolean searchAgain = false;
    private static String username = "";
    private static Crimes crimes = Crimes.getInstance();

    public static void main(String[] args) {
        startup();
        while (!currMenu.equalsIgnoreCase("x")) {
            // while the user doesn't input x, the all-time program terminator
            if (currMenu.equals("m")) {
                main();
            } else if (currMenu.equals("c")) {
                caseSearch();
            } else if (currMenu.equals("p")) {
                personSearch();
            } else if (currMenu.equals("i")) {
                displaySaved();
            } else {
                // System.out.println("Invalid input. Try again!");
                main();
            }

            if (!nextMenu.equals("")) {
                goToNextMenu();
            }

        }
        System.out.println("Exiting... Goodbye");
    }

    private static void startup() {
        System.out.print("Welcome to the Criminal Search Database.\n Do you already have a login? Enter y or n: ");
        String ans = scan.nextLine();
        if (ans.equalsIgnoreCase("y")) {
            login();
        } else if (ans.equalsIgnoreCase("n")) {
            registerNewUser();
            login();
        }
        System.out.println("Success! Redirecting to the main menu...");
    }

    private static void login() {
        ArrayList<RegisteredUser> users = DataReader.readUser();
        boolean loginSuccessful = false;
        while (loginSuccessful == false) {
            System.out.print("Enter your username: ");
            username = scan.nextLine();
            System.out.print("Enter your password: ");
            String password = scan.nextLine();
            for (RegisteredUser r : users) {
                if (r.getUsername().equals(username) && r.getPassword().equals(password)) {
                    loginSuccessful = true;
                }
            }
            if (loginSuccessful == false) {
                System.out.println("Invalid login. Please try again.");
            }
        }
    }

    private static void registerNewUser() {
        RegisteredUsers registeredUsers = RegisteredUsers.getInstance();
        boolean passwordsMatch = false;
        System.out.print("Enter your first name: ");
        String firstName = scan.nextLine();
        System.out.print("Enter your last name: ");
        String lastName = scan.nextLine();
        System.out.print("Enter a username: ");
        String username = scan.nextLine();
        String password = "";
        String passwordAgain = "";
        while (passwordsMatch == false) {
            System.out.print("Enter a password: ");
            password = scan.nextLine();
            System.out.print("Enter your new password again: ");
            passwordAgain = scan.nextLine();
            if (password.equals(passwordAgain)) {
                passwordsMatch = true;
            } else {
                System.out.println("Passwords did not match.");
            }
        }
        UUID newId = UUID.randomUUID();
        registeredUsers.addRegisteredUser(newId, firstName, lastName, username, password, true);
        DataWriter.saveUsers();
        System.out.println("Login successfully created. Redirecting to login...");
    }

    private static void main() {
        System.out.println("*******************Main Menu*******************");
        System.out.println("* Enter [c] to search for or add a case\n" + "* Enter [p] to search for or add a person\n"
                + "* Enter [i] to view saved cases or people\n" + "* Enter [x] to exit");
        nextMenu = scan.next();
    }

    private static void caseSearch() {
        System.out.println("*****Case Search and Add Menu*****");
        System.out.println(
                "Enter [s] to search for a case\nEnter [a] to add a case\nEnter [m] to access the main menu\nEnter [x] to exit");
        scan.nextLine();
        nextFeature = scan.nextLine();
        while (currMenu.equals("c")) {
            if (nextFeature.equals("s")) {
                caseSearchSearch();
            } else if (nextFeature.equals("a")) {
                addCase();
            } else {
                nextMenu = nextFeature;
                break;
            }
            goToNextMenu();
        }
    }

    private static void addCase() {
        // Crimes crimes = Crimes.getInstance();
        System.out.print("********Add Case********\nEnter the case information:\nCrime Title: ");
        String newTitle = scan.nextLine();
        System.out.print("Crime Description: ");
        String newDesc = scan.nextLine();
        // entering people
        ArrayList<Person> crimePeople = enterPerson();

        ArrayList<Evidence> crimeEvidence = enterEvidence();
        // entering users
        ArrayList<RegisteredUser> crimeUsers = enterUser();
        // writing the crime and printing
        UUID crimeId = UUID.randomUUID();
        Crime thisCrime = new Crime(newTitle, crimeId, newDesc, crimePeople, crimeEvidence, crimeUsers);
        System.out.println("* YOUR NEW CRIME HAS BEEN ADDED *");
        System.out.println(thisCrime);
        crimes.addCrime(newTitle, crimeId, newDesc, crimePeople, crimeEvidence, crimeUsers);
        main();
    }

    public static ArrayList<RegisteredUser> enterUser() {
        boolean enterUsers = true;
        boolean found = false;
        RegisteredUsers users = RegisteredUsers.getInstance();
        ArrayList<RegisteredUser> crimeUsers = new ArrayList<RegisteredUser>();
        ArrayList<RegisteredUser> theUsers = users.getRegisteredUsers();
        for (RegisteredUser r : theUsers) {
            if (r.getUsername().equals(username)) {
                crimeUsers.add(r);
            }
        }
        while (enterUsers) {
            System.out.println("Would you like to add more users to this case? [y] or [n]");
            String more = scan.nextLine();
            if (more.equalsIgnoreCase("n")) {
                enterUsers = false;
                break;
            }
            System.out.println("User Information:\nFirst Name: ");
            String firstName = scan.nextLine();
            System.out.println("Last Name: ");
            String lastName = scan.nextLine();
            for (RegisteredUser u : theUsers) {
                if (u.getFirstName().equalsIgnoreCase(firstName) && u.getLastName().equalsIgnoreCase(lastName)) {
                    crimeUsers.add(u);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Sorry that user does not exist");
            }
        }
        return crimeUsers;
    }

    private static ArrayList<Evidence> enterEvidence() {
        boolean enterEvidence = true;
        Evidences evidences = Evidences.getInstance();
        ArrayList<Evidence> crimeEvidence = new ArrayList<Evidence>();
        while (enterEvidence) {
            System.out.print("Evidence Information:\nHit enter for unknown or unneeded information \nLocation: ");
            String location = scan.nextLine();
            System.out.print("Crime Type: ");
            String crimeType = scan.nextLine();
            System.out.print("Time: ");
            String time = scan.nextLine();
            System.out.print("Date: ");
            String date = scan.nextLine();
            System.out.print("Fingerprint Information: ");
            String fingerprintInfo = scan.nextLine();
            System.out.print("Blood Samples: ");
            String bloodSamples = scan.nextLine();
            System.out.print("DNA Information: ");
            String DNAInfo = scan.nextLine();
            System.out.print("Weapons: ");
            String weapon = scan.nextLine();
            System.out.print("Description of the Scene: ");
            String descriptionOfScene = scan.nextLine();
            System.out.print("Hair Samples: ");
            String hairSamples = scan.nextLine();

            UUID evidenceId = UUID.randomUUID();
            evidences.addEvidence(evidenceId, location, crimeType, time, date, fingerprintInfo, bloodSamples, DNAInfo,
                    weapon, descriptionOfScene, hairSamples);
            crimeEvidence.add(new Evidence(evidenceId, location, crimeType, time, date, fingerprintInfo, bloodSamples,
                    DNAInfo, weapon, descriptionOfScene, hairSamples));
            System.out.print("Enter another piece of evidence? Enter [y] for yes or [n] for no: ");
            String enter = scan.nextLine();
            if (enter.equalsIgnoreCase("n")) {
                enterEvidence = false;
            }
        }
        return crimeEvidence;
    }

    private static ArrayList<Person> enterPerson() {
        boolean enterPerson = true;
        People people = People.getInstance();
        ArrayList<Person> crimePeople = new ArrayList<Person>();
        while (enterPerson) {
            System.out.print("Person Information:\nHit enter for unknown or unneeded information \nFirst Name: ");
            String firstName = scan.nextLine();
            System.out.print("Last Name: ");
            String lastName = scan.nextLine();
            System.out.print("Type: ");
            String type = scan.nextLine();
            System.out.print("Phone Number: ");
            String phoneNumber = scan.nextLine();
            System.out.print("Address: ");
            String address = scan.nextLine();
            System.out.print("Email: ");
            String email = scan.nextLine();
            System.out.print("Birth Date: ");
            String birthDate = scan.nextLine();
            System.out.print("Race: ");
            String race = scan.nextLine();
            System.out.print("Gender: ");
            String gender = scan.nextLine();
            System.out.print("Height: ");
            String height = scan.nextLine();
            System.out.print("Age: ");
            String age = scan.nextLine();

            if (type.equalsIgnoreCase("witness")) {
                System.out.print("Account Given: ");
                String accountGiven = scan.nextLine();
                UUID personId = UUID.randomUUID();
                crimePeople.add(new Witness(firstName, lastName, type, personId, phoneNumber, address, email, birthDate,
                        race, gender, accountGiven, height, age));
                people.addPerson(firstName, lastName, type, personId, phoneNumber, address, email, birthDate, race,
                        gender, "", "", "", "", "", "", "", "", "", accountGiven, "", "", "", "", "", "", height, age);
            } else if (type.equalsIgnoreCase("victim")) {
                System.out.print("Account Given: ");
                String accountGiven = scan.nextLine();
                System.out.print("Family Contact Information: ");
                String familyContactInfo = scan.nextLine();
                System.out.print("Condition: ");
                String condition = scan.nextLine();
                System.out.print("Blood Type: ");
                String bloodType = scan.nextLine();
                UUID personId = UUID.randomUUID();
                crimePeople.add(new Victim(firstName, lastName, type, personId, phoneNumber, address, email, birthDate,
                        race, gender, familyContactInfo, condition, bloodType, accountGiven, height, age));
                people.addPerson(firstName, lastName, type, personId, phoneNumber, address, email, birthDate, race,
                        gender, "", "", "", "", "", "", "", "", "", accountGiven, "", "", "", familyContactInfo,
                        condition, bloodType, height, age);
            } else if (type.equalsIgnoreCase("suspect")) {
                System.out.print("Account Given: ");
                String accountGiven = scan.nextLine();
                System.out.print("Relationship to the Victim: ");
                String relationshipToVictim = scan.nextLine();
                System.out.print("Criminal Record: ");
                String criminalRecord = scan.nextLine();
                System.out.print("Reason Why They Are Suspicious: ");
                String reasonWhySus = scan.nextLine();
                UUID personId = UUID.randomUUID();
                crimePeople.add(new Suspect(firstName, lastName, type, personId, phoneNumber, address, email, birthDate,
                        race, gender, accountGiven, relationshipToVictim, criminalRecord, reasonWhySus, height, age));
                people.addPerson(firstName, lastName, type, personId, phoneNumber, address, email, birthDate, race,
                        gender, "", "", "", "", "", "", "", "", "", accountGiven, relationshipToVictim, criminalRecord,
                        reasonWhySus, "", "", "", height, age);
            } else if (type.equalsIgnoreCase("personOfInterest")) {
                System.out.print("Account Given: ");
                String accountGiven = scan.nextLine();
                System.out.print("Relationship to the Victim: ");
                String relationshipToVictim = scan.nextLine();
                UUID personId = UUID.randomUUID();
                crimePeople.add(new PersonOfInterest(firstName, lastName, type, personId, phoneNumber, address, email,
                        birthDate, race, gender, accountGiven, relationshipToVictim, height, age));
                people.addPerson(firstName, lastName, type, personId, phoneNumber, address, email, birthDate, race,
                        gender, "", "", "", "", "", "", "", "", "", accountGiven, relationshipToVictim, "", "", "", "",
                        "", height, age);
            } else if (type.equalsIgnoreCase("criminal")) {
                System.out.print("Hair Color: ");
                String hairColor = scan.nextLine();
                System.out.print("Eye Color: ");
                String eyeColor = scan.nextLine();
                System.out.print("Incarceration Status: ");
                String incarcerationStatus = scan.nextLine();
                System.out.print("Number of Offenses (As an Integer): ");
                String offenses = scan.nextLine();
                System.out.print("Severity of Crimes Committed: ");
                String severityOfCrime = scan.nextLine();
                System.out.print("Tattoos: ");
                String tattoos = scan.nextLine();
                System.out.print("Last Known Location: ");
                String knownLocation = scan.nextLine();
                System.out.print("Distinguishing Features: ");
                String distinguishingFeatures = scan.nextLine();
                System.out.print("Record Description: ");
                String recordDescription = scan.nextLine();
                UUID personId = UUID.randomUUID();
                int numOfOffenses = 0;
                if (!offenses.equals("")) {
                    numOfOffenses = Integer.parseInt(offenses);
                }
                crimePeople
                        .add(new Criminal(firstName, lastName, type, personId, phoneNumber, address, email, birthDate,
                                race, gender, hairColor, eyeColor, incarcerationStatus, numOfOffenses, severityOfCrime,
                                tattoos, knownLocation, distinguishingFeatures, recordDescription, height, age));
                people.addPerson(firstName, lastName, type, personId, phoneNumber, address, email, birthDate, race,
                        gender, hairColor, eyeColor, incarcerationStatus, offenses, severityOfCrime, tattoos,
                        knownLocation, distinguishingFeatures, recordDescription, "", "", "", "", "", "", "", height,
                        age);
            }

            System.out.print("Enter another person? Enter [y] for yes or [n] for no: ");
            String enter = scan.nextLine();
            if (enter.equalsIgnoreCase("n")) {
                enterPerson = false;
            }
        }
        return crimePeople;
    }

    private static void caseSearchSearch() {
        displayCaseSearchSearch();
        attributes = scan.nextLine();
        ArrayList<Crime> caseSearchResults = new ArrayList<Crime>();
        if (isID(attributes) == true) {
            UUID id = UUID.fromString(attributes);
            Crime result = searchCase(id);
            if (result != null) {
                System.out.println("*******************Matching Crime Found*******************");
                System.out.println(result.toString());
            } else {
                System.out.println("No matching ID found");
            }
        } else {
            caseSearchResults = searchCases(attributes);
            System.out.println("************************Search Results************************");
            for (Crime c : caseSearchResults) {
                System.out.println(c.toString());
            }
        }
        System.out.println(
                "* Enter [s] to search for another case\n* Enter [a] to add a case\n* Enter [m] to access the main menu\n* Enter [x] to exit");
        nextFeature = scan.nextLine();
        if (nextFeature.equals("m")) {
            nextMenu = "m";
            nextFeature = "";
        } else if (nextFeature.equals("x")) {
            nextMenu = "x";
            nextFeature = "";
        } else if (nextFeature.equals("s")) {
            nextMenu = "c";
        } else if (nextFeature.equals("a")) {
            nextMenu = "c";
        } else {
            nextMenu = "g";
        }
    }

    private static ArrayList<Crime> searchCases(String attributes) {
        ArrayList<Crime> caseSearchResults = crimes.getCrime();
        for (int i = 0; i < attributes.length(); i++) {
            char type = attributes.charAt(i);
            String val = " ";
            if (type == 't') {
                System.out.println("Enter the crime title: ");
            } else if (type == 'd') {
                System.out.println("Enter the crime description: ");
            } else {
                System.out.println("* \"" + type + "\"" + " is an invalid character. *");
            }
            val = scan.nextLine();
            caseSearchResults = filterCases(type, val, caseSearchResults);
        }
        return caseSearchResults;
    }

    private static ArrayList<Crime> filterCases(char type, String val, ArrayList<Crime> unfilteredResults) {
        ArrayList<Crime> filteredResults = new ArrayList<Crime>();
        for (Crime c : unfilteredResults) {
            if (type == 't') {
                if (c.getCrimeTitle().equalsIgnoreCase(val)) {
                    filteredResults.add(c);
                }
            } else if (type == 'd') {
                if (c.getDescription().equalsIgnoreCase(val)) {
                    filteredResults.add(c);
                }
            }
        }
        printCases(filteredResults);
        return filteredResults;
    }

    public static void printCases(ArrayList<Crime> results) {
        try {
            File myObj = new File("CaseSearchResults.txt");
            if (myObj.createNewFile()) {
                FileWriter myWriter = new FileWriter("CaseSearchResults.txt");
                System.out.println("File created: " + myObj.getName());
                for (Crime c : results) {
                    myWriter.write(c.toString());
                }
                myWriter.close();
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public static void reset() {
        currMenu = "m";
        nextMenu = "";
        attributes = "";
        searchAgain = false;
    }

    private static void displayCaseSearchSearch() {
        System.out.println("*******************Case Search Menu*******************");
        System.out.println("*\t   Enter the known case id number , or  \t*\n"
                + "*Enter all case attributes you would like to include\t*\n\tin your search; for example, fg"
                + "*\n*Input all letters with no spaces: {[t]itle}, {[d]escription}*");
    }

    private static void personSearch() {
        System.out.println("*****Person Search and Add Menu*****");
        System.out.println(
                "* Enter [s] to search for a person\n* Enter [a] to add a person\n* Enter [m] to access the main menu\n* Enter [x] to exit");
        scan.nextLine();
        nextFeature = scan.nextLine(); // the next feature that will be displayed
        while (currMenu.equals("p")) { // while we are still in person search
            if (nextFeature.equals("s")) { // if next feature is to search
                personSearchSearch();
            } else if (nextFeature.equals("a")) { // if next feature is to add
                // TODO implement add person
                ArrayList<Person> people = enterPerson();
                for (Person p : people) {
                    System.out.println(p);
                }
            } else {
                nextMenu = nextFeature;
                break;
            }
            goToNextMenu();
        }
    }

    private static void personSearchSearch() {
        displayPersonSearchSearch();
        attributes = scan.nextLine();
        ArrayList<Person> searchResults = new ArrayList<Person>();
        if (isID(attributes) == true) {
            UUID id = UUID.fromString(attributes);
            Person result = searchPerson(id);
            if (result != null) {
                System.out.println("*******************Matching Person Found*******************");
                System.out.println(result.toString());
            } else {
                System.out.println("No matching ID found");
            }
        } else {
            searchResults = searchPeople(attributes);
            System.out.println("************************Search Results************************");

            for (int i = 0; i < searchResults.size() + 0; i++) {
                int hi = i + 1;
                System.out.println("************************Result " + hi + "************************");
                System.out.println(searchResults.get(i).toString() + "\n");
            }
            System.out.println("Would you like to save the results? [y]es or [n]o");
            String ans = scan.nextLine();
            if (ans.equals("y")) {
                System.out.println("To save result(s), type the result numbers you would like to save");
                System.out.println("For results 1, 4, and 7, type: \n1\n4\n7\n0\n");
                int saveNums = scan.nextInt();
                ArrayList<Person> chosen = new ArrayList<Person>();
                while (saveNums != 0) {
                    chosen.add(searchResults.get(saveNums - 1));
                    saveNums = scan.nextInt();
                }
                /*
                 * String currNum = ""; int currNummy = 0;
                 * 
                 * 
                 * for (int i = 0; i < saveNums.length(); i++) { while (saveNums.charAt(i) != '
                 * ') { currNum += saveNums.substring(i, i + 1); } currNummy =
                 * Integer.valueOf(currNum); chosen.add(searchResults.get(currNummy));
                 * 
                 * }
                 */
                savePerson(chosen);
            }
        }

        System.out.println(
                "* Enter [s] to search for another person\n* Enter [a] to add a person\n* Enter [m] to access the main menu\n* Enter [x] to exit");
        nextFeature = scan.nextLine();
        if (nextFeature.equals("m")) {
            nextMenu = "m"; // will exit loop back into main method and will return to person search search
            nextFeature = "";
        } else if (nextFeature.equals("x")) {
            nextMenu = "x"; // will exit loop back into main method and will return to person search search
            nextFeature = "";
        } else if (nextFeature.equals("s")) {
            nextMenu = "p";
        } else if (nextFeature.equals("a")) {
            nextMenu = "p";
        } else {
            nextMenu = "g";
        }
    }

    public static void savePerson(ArrayList<Person> person) {
        try {
            File myObj = new File("PersonSearchResultsSaved.txt");
            if (myObj.createNewFile()) {
                FileWriter myWriter = new FileWriter("PersonSearchResultsSaved.txt");
                System.out.println("File created: " + myObj.getName());
                for (Person p : person) {
                    myWriter.write(p.toString());
                }
                myWriter.close();
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static boolean isID(String attr) {
        for (int i = 0; i < attr.length(); i++) {
            for (int j = 0; j < 10; j++) {
                if (Character.getNumericValue(attr.charAt(i)) == j) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void goToNextMenu() {
        currMenu = nextMenu;
        nextMenu = "";
    }

    private static void goToNextFeature() {
        currFeature = nextFeature;
        nextFeature = "";
    }

    private static void displayPersonSearchSearch() {
        System.out.println(" ***********************Person Search Menu************************");
        System.out.println("*\t\tEnter the known person id number , or \t\t  *\n"
                + "* Enter all attributes you would like to include in your search    "
                + "*\n* Input all letters with no spaces ({[f]irst name} {[l]ast name}   "
                + "*\n* {[g]ender} {[r]ace} {[a]ge} {[h]eight} {[H]air color}            "
                + "*\n* {[n]umber of Offenses} {[t]attoos} {[e]ye color}                 "
                + "*\n* {[A]ddress} {[E]mail} {[b]irth-date} {[d]istinguishing features} *");
        // + "*\n* {*");
    }

    private static Person searchPerson(UUID id) {
        ArrayList<Person> people = DataReader.readPeople();
        for (Person p : people) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    private static Crime searchCase(UUID id) {
        ArrayList<Crime> crimes = DataReader.readCrime();
        for (Crime c : crimes) {
            if (c.getCrimeId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    private static ArrayList<Person> searchPeople(String attributes) {
        ArrayList<Person> searchResults = DataReader.readPeople();
        for (int i = 0; i < attributes.length(); i++) {
            char type = attributes.charAt(i);
            String val = "";
            if (type == 'f') {
                System.out.print("* Enter the first name: ");
            } else if (type == 'l') {
                System.out.print("* Enter the last name: ");
            } else if (type == 'g') {
                System.out.println("* Enter specified gender: [m]ale, [f]emale *");
            } else if (type == 'r') {
                System.out.println(
                        "* Enter specified race: [a]sian, [b]lack/african american,  \t*\n* \t[c]aucasian/white, [n]ative, [o]ther \t\t\t*");
            } else if (type == 'H') {
                System.out.println(
                        "* Enter specified hair color:  black, blonde,\nbrunette/brown, ginger/red, white, gray, other *");
            } else if (type == 'n') {
                System.out.print("* Enter number of offenses: ");
            } else if (type == 'h') {
                System.out.println(
                        "* Enter height in feet followed by a tick and then inches (for 5 foot 9 inches, enter 5'9 *");
            } else if (type == 'A') {
                System.out.print("* Enter the specified address: ");
            } else if (type == 'E') {
                System.out.println("* Enter the specified email: ");
            } else if (type == 'd') {
                System.out.println("* Enter distinguishing features: ");
            } else if (type == 'a') {
                System.out.println("* Enter specified age: ");
            } else if (type == 'b') {
                System.out.println("* Enter birth-date: ");
            } else if (type == 't') {
                System.out.println("* Enter tattoos: ");
            } else {
                System.out.println("* \"" + type + "\"" + " is an invalid character. *");
            }
            val = scan.nextLine();
            searchResults = filterBy(type, val, searchResults);
        }
        return searchResults;
    }

    private static ArrayList<Person> filterBy(char type, String val, ArrayList<Person> unfilteredResults) {
        ArrayList<Person> filteredResults = new ArrayList<Person>();
        for (Person p : unfilteredResults) {
            if (type == 'f') {
                if (p.getFirstName().equalsIgnoreCase(val)) {
                    filteredResults.add(p);
                }
            } else if (type == 'l') {
                if (p.getLastName().equalsIgnoreCase(val)) {
                    filteredResults.add(p);
                }
            } else if (type == 'g') {
                if (p.getGender().equalsIgnoreCase(val)) {
                    filteredResults.add(p);
                }
            } else if (type == 'r') {
                if (p.getRace().equalsIgnoreCase(val)) {
                    filteredResults.add(p);
                }
            } else if (type == 'H') {
                if (p.getHairColor().equalsIgnoreCase(val)) {
                    filteredResults.add(p);
                }
            } else if (type == 'n') {
                if (p.getNumberOfOffenses().equalsIgnoreCase(val)) {
                    filteredResults.add(p);
                }
            } else if (type == 'h') {
                if (p.getHeight().equalsIgnoreCase(val)) {
                    filteredResults.add(p);
                }
            } else if (type == 'a') {
                if (p.getAge().equalsIgnoreCase(val)) {
                    filteredResults.add(p);
                }
            } else if (type == 'E') {
                if (p.getEmail().equalsIgnoreCase(val)) {
                    filteredResults.add(p);
                }
            } else if (type == 'A') {
                if (p.getAddress().equalsIgnoreCase(val)) {
                    filteredResults.add(p);
                }
            } else if (type == 'b') {
                if (p.getBirthDate().equalsIgnoreCase(val)) {
                    filteredResults.add(p);
                }
            } else if (type == 't') {
                if (p.getTattoos().equalsIgnoreCase(val)) {
                    filteredResults.add(p);
                }
            }
        }
        if (filteredResults.size() == 0) {
            System.out.println("Does not match any current people in the system");
        }
        return filteredResults;
    }

    private static void displaySaved() {
        System.out.println("*****Saved People and Cases Menu*****");
        System.out.println(
                "Enter [c] to view saved cases\nEnter [p] to view saved people\nEnter [m] to access the main menu\nEnter [x] to exit");
        nextMenu = scan.next();
        if (nextMenu.equals("p")) {
            People people = People.getInstance();
            ArrayList<Person> allPeople = people.getPeople();
            for (Person p : allPeople) {
                System.out.println(p);
            }
            System.out.println("");
            displaySaved();
        } else if (nextMenu.equals("c")) {
            // Crimes crimes = Crimes.getInstance();
            ArrayList<Crime> allCrimes = crimes.getCrime();
            for (Crime c : allCrimes) {
                System.out.println(c);
            }
            System.out.println("");
            displaySaved();
        } else if (nextMenu.equals("m")) {
            main();
        }
    }
}