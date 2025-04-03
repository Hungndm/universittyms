package Universitym;

public class Learn {
    private int LearnId;
    private int StudentId;
    private int ClassId;


    public Learn() {

    }


    public Learn(int learnId, int studentId, int classId) {

        LearnId = learnId;
        StudentId = studentId;
        ClassId = classId;
    }


    public int getLearnId() {
        return LearnId;
    }


    public void setLearnId(int learnId) {
        LearnId = learnId;
    }


    public int getStudentId() {
        return StudentId;
    }


    public void setStudentId(int studentId) {
        StudentId = studentId;
    }


    public int getClassId() {
        return ClassId;
    }


    public void setClassId(int classId) {
        ClassId = classId;
    }

}