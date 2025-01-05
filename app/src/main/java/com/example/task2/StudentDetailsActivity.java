package com.example.task2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

public class StudentDetailsActivity extends AppCompatActivity {

    private TextView studentName, studentId, studentPhone, studentAddress;
    private ImageView studentImage; // Add this if you're showing an image as well.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        // Get references to TextViews and ImageView
        studentName = findViewById(R.id.studentName);
        studentId = findViewById(R.id.studentId);
        studentPhone = findViewById(R.id.studentPhone);
        studentAddress = findViewById(R.id.studentAddress);
        studentImage = findViewById(R.id.studentImage); // This is for displaying the static image

        // Retrieve student ID from Intent
        String studentIdValue = getIntent().getStringExtra("studentId");

        // Find the student by ID
        Student student = Database.getInstance().getStudentById(studentIdValue);

        if (student != null) {
            // Set the details in the TextViews
            studentName.setText(student.getName());
            studentId.setText(student.getId());
            studentPhone.setText(student.getPhone());
            studentAddress.setText(student.getAddress());
            studentImage.setImageResource(student.getPictureResId()); // Set the student's image
        }
    }
    @Override
    public boolean onSupportNavigateUp() {
        // Handle back button click
        onBackPressed();
        return true;
    }
}
