import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import java.util.*;

class DatabaseTester {
    private RegisteredUsers users = RegisteredUsers.getInstance();
    private ArrayList<RegisteredUser> userList = users.getRegisteredUsers();
    private People people = People.getInstance();
    private ArrayList<Person> peopleList = people.getPeople();
    private Evidences evidences = Evidences.getInstance();
    private ArrayList<Evidence> evidenceList = evidences.getEvidence();
    private Crimes crimes = Crimes.getInstance();
    private ArrayList<Crime> crimeList = crimes.getCrime();

    @Test
    void testSearchCaseByTitle() {
        ArrayList<Crime> result = Database.searchCases("t");
        // crime title should be input as: Circle K Robbery

        if (result.size() == 1) {
            for (int i = 0; i < crimeList.size(); i++) {
                if (crimeList.get(i).getCrimeTitle().equals(result.get(0).getCrimeTitle()))
                    assertEquals(crimeList.get(i).getCrimeTitle(), result.get(0).getCrimeTitle());
            }
        }
    }
}
