//Benjamin Williams
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.*;

public class EvidenceTester {
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

    @Test
    public void testEvidence() {
        Evidence e = new Evidence(id, location, crimeType, time, date, fingerprintInfo, bloodSampleInfo, DNAInfo, weapon, descriptionOfScene, hairSamples);
        assertEquals(id, e.getId());
        assertEquals(location, e.getLocation());
        assertEquals(crimeType, e.getCrimeType());
        assertEquals(time, e.getTime());
        assertEquals(date, e.getDate());
        assertEquals(fingerprintInfo, e.getFingerprintInfo());
        assertEquals(bloodSampleInfo, e.getBloodSampleInfo());
        assertEquals(DNAInfo, e.getDNAInfo());
        assertEquals(weapon, e.getWeapon());
        assertEquals(descriptionOfScene, e.getDescriptionOfScene());
        assertEquals(hairSamples, e.getHairSamples());
    }

    @Test
    public void testEvidenceToString() {
        Evidence e = new Evidence(id, location, crimeType, time, date, fingerprintInfo, bloodSampleInfo, DNAInfo, weapon, descriptionOfScene, hairSamples);
        Evidence a = new Evidence(id, location, crimeType, time, date, fingerprintInfo, bloodSampleInfo, DNAInfo, weapon, descriptionOfScene, hairSamples);
        assertEquals(a.toString(), e.toString());
    }
}
