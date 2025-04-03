package Universitym;

public class Class {
    private int ClassId;
    private String description;
    private float numberOfCreadits;

    public Class() {

    }

    public Class(int classId, String description, float numberOfCreadits) {
        ClassId = classId;
        this.description = description;
        this.numberOfCreadits = numberOfCreadits;
    }

    public int getClassId() {
        return ClassId;
    }

    public void setClassId(int classId) {
        ClassId = classId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getNumberOfCreadits() {
        return numberOfCreadits;
    }

    public void setNumberOfCreadits(float numberOfCreadits) {
        this.numberOfCreadits = numberOfCreadits;
    }



}