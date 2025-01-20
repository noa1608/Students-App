package com.example.task2;

import java.util.ArrayList;

public class Database {
    private static Database instance;
    private ArrayList<Student> students;

    private Database() {
        students = new ArrayList<>();
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void deleteStudent(String studentId) {
        // Iterate over the students list and find the student by ID
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (student.getId().equals(studentId)) {
                // Remove the student from the list
                students.remove(i);
                break;  // Exit the loop once the student is found and removed
            }
        }
    }
    public Student getStudentById(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }
    public void updateStudent(Student updatedStudent) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(updatedStudent.getId())) {
                students.set(i, updatedStudent);
                break;
            }
        }
    }
}