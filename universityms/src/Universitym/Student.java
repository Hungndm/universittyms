package Universitym;

public class Student {
    private int id;
    private String name;
    private int age;
    private String email;
    private float gpa;

    public Student(int id, String name, int age, String email, float gpa) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.gpa = gpa;
    }

    public Student(String name, int age, String email, float gpa) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.gpa = gpa;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public float getGpa() { return gpa; }
    public void setGpa(float gpa) { this.gpa = gpa; }
}