package JDBCUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import DAO.StudentDAO;
import Universitym.Student;

public class Main {
    public static void main(String[] args) {
        // Sửa tên database cho đúng với tên đã tạo trên MySQL
        String url = "jdbc:mysql://localhost:3306/universityms?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String jdbcUsername = "root";
        String jdbcPassword = "11012006";

        try (Connection connection = DriverManager.getConnection(url, jdbcUsername, jdbcPassword)) {
            StudentDAO studentDAO = new StudentDAO(connection);

            Student newStudent = new Student("Nguyen Van A", 20, "annv@vku.udn.vn", 3.5f);
            studentDAO.insertStudent(newStudent);
            System.out.println("Đã thêm sinh viên mới!");

            System.out.println("Danh sách sinh viên:");
            for (Student student : studentDAO.selectAllStudents()) {
                System.out.println(student.getId() + " - " + student.getName());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
