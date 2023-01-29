package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    @Test
    public void testSettingJobID(){
        Job test1 = new Job();
        Job test2 = new Job();
        assertNotEquals(test1.getId(), test2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job newJob = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        assertTrue(newJob.getName() instanceof String);
        assertEquals(newJob.getName(), "Product Tester");
        assertTrue(newJob.getEmployer() instanceof Employer);
        assertEquals(newJob.getEmployer().getValue(), "ACME");
        assertTrue(newJob.getLocation() instanceof Location);
        assertEquals(newJob.getLocation().getValue(), "Desert");
        assertTrue(newJob.getPositionType() instanceof PositionType);
        assertEquals(newJob.getPositionType().getValue(), "Quality Control");
        assertTrue(newJob.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(newJob.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality(){
        Job test1 = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        Job test2 = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        assertFalse(test1.equals(test2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job test = new Job();
        int lastChar = test.toString().length() - 1;
        assertEquals(test.toString().charAt(0), '\n');
        assertEquals(test.toString().charAt(lastChar), '\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job test1 = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        String part1 = String.format("ID: %s", test1.getId());
        String part2 = String.format("Name: %s", test1.getName());
        String part3 = String.format("Employer: %s", test1.getEmployer().getValue());
        String part4 = String.format("Location: %s", test1.getLocation().getValue());
        String part5 = String.format("Position Type: %s", test1.getPositionType().getValue());
        String part6 = String.format("Core Competency: %s", test1.getCoreCompetency().getValue());
        String expected = "\n"+part1+"\n"+part2+"\n"+part3+"\n"+part4+"\n"+part5+"\n"+part6+"\n";
        assertEquals(test1.toString(), expected);
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job test = new Job();
        test.setEmployer(new Employer("PortaFab"));
        test.setLocation(new Location("Chesterfield, MO"));
        test.setPositionType(new PositionType("Slave"));
        test.setCoreCompetency(new CoreCompetency("Obedience"));
        String part1 = "ID: 1";
        String part2 = "Name: Data not available";
        String part3 = "Employer: PortaFab";
        String part4 = "Location: Chesterfield, MO";
        String part5 = "Position Type: Slave";
        String part6 = "Core Competency: Obedience";
        String expected = "\n"+part1+"\n"+part2+"\n"+part3+"\n"+part4+"\n"+part5+"\n"+part6+"\n";
        assertEquals(test.toString(), expected);
    }

    @Test
    public void testToStringHandlesEmptyObject(){
        Job test555 = new Job();
        String error = "\nOOPS! This job does not seem to exist.\n";
        assertTrue(test555.toString() == error);
    }
}
