DROP TABLE IF EXISTS Learn;
DROP TABLE IF EXISTS Class;
DROP TABLE IF EXISTS Student;

CREATE TABLE Student (
    StudentId INT PRIMARY KEY,
    Name VARCHAR(100),
    Age INT,
    Email VARCHAR(100),
    GPA DECIMAL(3,2)
);

CREATE TABLE Class (
    ClassId INT PRIMARY KEY,
    Description TEXT NOT NULL,
    NumberOfCredits FLOAT CHECK (NumberOfCredits > 0)
);

CREATE TABLE Learn (
    LearnID INT PRIMARY KEY AUTO_INCREMENT,
    StudentID INT,
    ClassID INT,
    FOREIGN KEY (StudentID) REFERENCES Student(StudentID) ON DELETE CASCADE,
    FOREIGN KEY (ClassID) REFERENCES Class(ClassID) ON DELETE CASCADE
);

INSERT INTO Student (StudentId, Name, Age, Email, GPA) 
VALUES (1, 'Nguyễn Văn An', 20, 'annv@vku.udn.vn', 3.5);

INSERT INTO Class (ClassId, Description, NumberOfCredits) 
VALUES (1, 'Lập trình Java cơ bản', 3);

INSERT INTO Learn (StudentID, ClassID) 
VALUES (1, 1);
