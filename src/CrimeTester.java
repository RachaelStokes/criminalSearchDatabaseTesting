import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import java.util.*;

class CrimeTester {
    private String crimeTitle;
    private UUID crimeID;
    private String description;
    private ArrayList<Person> people = new ArrayList<Person>();
    private ArrayList<Evidence> evidence = new ArrayList<Evidence>();
    private ArrayList<RegisteredUser> users = new ArrayList<RegisteredUser>();
  
    @Test
    public void testCrime(){
        Crime c = new Crime(crimeTitle, crimeID, description, people, evidence, users);
        assertEquals(crimeTitle, c.getCrimeTitle());
        assertEquals(crimeID, c.getCrimeId());
        assertEquals(description, c.getDescription());
        assertEquals(people, c.getPeople());
        assertEquals(evidence, c.getEvidence());
        assertEquals(users, c.getUser());
    }

    @Test
    public void testCrimeToString(){
        Crime c = new Crime(crimeTitle, crimeID, description, people, evidence, users);
        Crime a = new Crime(crimeTitle, crimeID, description, people, evidence, users);
        assertEquals(a.toString(), c.toString());
    }
}
