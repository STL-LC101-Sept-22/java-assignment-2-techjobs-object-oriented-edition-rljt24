package org.launchcode.techjobs.oo;

import java.util.Objects;
import java.util.stream.Stream;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.
    public Job(){
        this.id = nextId;
        nextId++;
    }

    public Job(String aName, Employer aEmployer, Location aLocation, PositionType aPositionType, CoreCompetency aCoreCompetency){
        this();
        this.name = aName;
        this.employer = aEmployer;
        this.location = aLocation;
        this.positionType = aPositionType;
        this.coreCompetency = aCoreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.
//    public static void main(String[] args){
//        Job test = new Job();
//        boolean check = Stream.of(test.getName(), test.getEmployer(), test.getLocation(), test.getPositionType(), test.getCoreCompetency()).allMatch(Objects::isNull);
//        System.out.println(check);
//        System.out.println(test.getEmployer().getValue());
//    }

    @Override
    public String toString() {
        String output;
        boolean check = Stream.of(this.getName(), this.getEmployer(), this.getLocation(), this.getPositionType(), this.getCoreCompetency()).allMatch(Objects::isNull);
        if(check){
            output = "\nOOPS! This job does not seem to exist.\n";
        } else {
            String errorMessage = "Data not available";
            String part1 = String.format("ID: %s", this.getId());
            String part2;
            String part3;
            String part4;
            String part5;
            String part6;
            if (this.getName() != null) {
                part2 = String.format("Name: %s", this.getName());
            } else {
                part2 = String.format("Name: %s", errorMessage);
            }
            if (this.getEmployer().getValue() != null) {
                part3 = String.format("Employer: %s", this.getEmployer().getValue());
            } else {
                part3 = String.format("Employer: %s", errorMessage);
            }
            if (this.getLocation().getValue() != null) {
                part4 = String.format("Location: %s", this.getLocation().getValue());
            } else {
                part4 = String.format("Location: %s", errorMessage);
            }
            if (this.getPositionType().getValue() != null) {
                part5 = String.format("Position Type: %s", this.getPositionType().getValue());
            } else {
                part5 = String.format("Position Type: %s", errorMessage);
            }
            if (this.getCoreCompetency().getValue() != null) {
                part6 = String.format("Core Competency: %s", this.getCoreCompetency().getValue());
            } else {
                part6 = String.format("Core Competency: %s", errorMessage);
            }
            output = "\n" + part1 + "\n" + part2 + "\n" + part3 + "\n" + part4 + "\n" + part5 + "\n" + part6 + "\n";
        }
        return output;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public Location getLocation() {
        return location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}
