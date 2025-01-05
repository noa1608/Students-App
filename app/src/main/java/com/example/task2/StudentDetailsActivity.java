package com.example.task2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class StudentDetailsActivity extends AppCompatActivity {

    private TextView studentName, studentId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        // Get references to TextViews
        studentName = findViewById(R.id.studentName);
        studentId = findViewById(R.id.studentId);

        // Retrieve student ID from Intent
        Intent intent = getIntent();
        String studentIdValue = intent.getStringExtra("studentId");

        // Find the student by ID (you can modify this part to fetch the actual student data)
        // For now, we'll just display a sample name and ID
        if (studentIdValue != null) {
            // Example: you can retrieve actual data from a database or model
            studentName.setText("John Doe"); // Example student name
            studentId.setText("ID: " + studentIdValue); // Display student ID
        }
    }
}
