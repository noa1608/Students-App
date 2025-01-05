package com.example.task2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class StudentDetailsActivity extends AppCompatActivity {

    private TextView studentName, studentId, studentPhone, studentAddress;
    private ImageView studentImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        // Get references to TextViews and ImageView
        studentName = findViewById(R.id.studentName);
        studentId = findViewById(R.id.studentId);
        studentPhone = findViewById(R.id.studentPhone);
        studentAddress = findViewById(R.id.studentAddress);
        studentImage = findViewById(R.id.studentImage);

        // Retrieve student ID from Intent
        Intent intent = getIntent();
        String studentIdValue = intent.getStringExtra("studentId");

        // Find the student by ID
        Student student = Database.getInstance().getStudentById(studentIdValue);

        if (student != null) {
            studentName.setText(student.getName());
            studentId.setText("ID: " + student.getId());
            studentPhone.setText("Phone: " + student.getPhone());
            studentAddress.setText("Address: " + student.getAddress());
            studentImage.setImageResource(student.getPictureResId());
        }
    }
}
