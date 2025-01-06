package com.example.task2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.bumptech.glide.Glide;

import androidx.appcompat.app.AppCompatActivity;

public class StudentDetailsActivity extends AppCompatActivity {

    private TextView studentName, studentId, studentPhone, studentAddress;
    private ImageView studentImage; // Add this if you're showing an image as well.
    private Button editStudentButton;
    private static final int EDIT_STUDENT_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Students App");

        // Get references to TextViews and ImageView
        studentName = findViewById(R.id.studentName);
        studentId = findViewById(R.id.studentId);
        studentPhone = findViewById(R.id.studentPhone);
        studentAddress = findViewById(R.id.studentAddress);
        studentImage = findViewById(R.id.studentImage); // This is for displaying the static image
        editStudentButton = findViewById(R.id.editStudentButton);

        Glide.with(this)
                .load(R.drawable.student_pic) // URL of the image
                .into(studentImage);

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
        editStudentButton.setOnClickListener(v -> {
            // Pass the student details to the EditStudentActivity
            Intent intent = new Intent(StudentDetailsActivity.this, EditStudentActivity.class);
            intent.putExtra("studentId", studentIdValue); // Pass the student ID to the Edit Activity
            startActivityForResult(intent, EDIT_STUDENT_REQUEST_CODE);
        });
    }
    @Override
    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        // Handle the back button click
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();  // This will take you back to the previous activity
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Check if the result is from EditStudentActivity
        if (requestCode == EDIT_STUDENT_REQUEST_CODE && resultCode == RESULT_OK) {
            // Retrieve the updated student object
            Student updatedStudent = (Student) data.getSerializableExtra("updatedStudent");

            if (updatedStudent != null) {
                // Update the UI with the new student details
                studentName.setText(updatedStudent.getName());
                studentId.setText(updatedStudent.getId());
                studentPhone.setText(updatedStudent.getPhone());
                studentAddress.setText(updatedStudent.getAddress());
                studentImage.setImageResource(updatedStudent.getPictureResId());  // Update the image
            }
        }
    }
}
