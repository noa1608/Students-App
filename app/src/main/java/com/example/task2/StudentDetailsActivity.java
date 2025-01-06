package com.example.task2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import androidx.appcompat.app.AppCompatActivity;

public class StudentDetailsActivity extends AppCompatActivity {

    private TextView studentName, studentId, studentPhone, studentAddress;
    private ImageView studentImage;
    private Button editStudentButton;
    private static final int EDIT_STUDENT_REQUEST_CODE = 1;
    private CheckBox studentActiveCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Students App");

        studentName = findViewById(R.id.studentName);
        studentId = findViewById(R.id.studentId);
        studentPhone = findViewById(R.id.studentPhone);
        studentAddress = findViewById(R.id.studentAddress);
        studentImage = findViewById(R.id.studentImage);
        editStudentButton = findViewById(R.id.editStudentButton);
        studentActiveCheckBox = findViewById(R.id.studentActiveCheckBox);

        Glide.with(this)
                .load(R.drawable.student_pic)
                .into(studentImage);

        String studentIdValue = getIntent().getStringExtra("studentId");

        Student student = Database.getInstance().getStudentById(studentIdValue);


        if (student != null) {
            studentName.setText(student.getName());
            studentId.setText(student.getId());
            studentPhone.setText(student.getPhone());
            studentAddress.setText(student.getAddress());
            studentImage.setImageResource(student.getPictureResId());
            studentActiveCheckBox.setChecked(student.isChecked());
        }

        studentActiveCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (student != null) {
                student.setChecked(isChecked);
            }
        });
        editStudentButton.setOnClickListener(v -> {
            Intent intent = new Intent(StudentDetailsActivity.this, EditStudentActivity.class);
            intent.putExtra("studentId", studentIdValue); // Pass the student ID to the Edit Activity
            startActivityForResult(intent, EDIT_STUDENT_REQUEST_CODE);
        });
    }
    @Override
    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == EDIT_STUDENT_REQUEST_CODE && resultCode == RESULT_OK) {
            Student updatedStudent = (Student) data.getSerializableExtra("updatedStudent");

            if (updatedStudent != null) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("updatedStudent", updatedStudent);
                setResult(RESULT_OK, resultIntent);
                finish();

            }
        }
    }
}
