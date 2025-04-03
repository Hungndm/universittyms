package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Universitym.Student;

public class StudentDAO {
    private Connection connection;

    public StudentDAO(Connection connection) {
        this.connection = connection;
    }
    public void insertStudent(Student student) throws SQLException {
        String sql = "INSERT INTO Student (Name, Age, Email, GPA) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.setString(3, student.getEmail());
            preparedStatement.setFloat(4, student.getGpa());
            preparedStatement.executeUpdate();
        }
    }
    public Student selectStudent(int id) throws SQLException {
        String sql = "SELECT * FROM Student WHERE StudentID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return new Student(
                        rs.getInt("StudentID"),
                        rs.getString("Name"),
                        rs.getInt("Age"),
                        rs.getString("Email"),
                        rs.getFloat("GPA")
                );
            }
        }
        return null;
    }
    public List<Student> selectAllStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM Student";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery()) {
            while (rs.next()) {
                students.add(new Student(
                        rs.getInt("StudentID"),
                        rs.getString("Name"),
                        rs.getInt("Age"),
                        rs.getString("Email"),
                        rs.getFloat("GPA")
                ));
            }
        }
        return students;
    }
    public boolean deleteStudent(int id) throws SQLException {
        String sql = "DELETE FROM Student WHERE StudentID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        }
    }
    public boolean updateStudent(Student student) throws SQLException {
        String sql = "UPDATE Student SET Name = ?, Age = ?, Email = ?, GPA = ? WHERE StudentID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.setString(3, student.getEmail());
            preparedStatement.setFloat(4, student.getGpa());
            preparedStatement.setInt(5, student.getId());
            return preparedStatement.executeUpdate() > 0;
        }
    }
}