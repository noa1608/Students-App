package com.example.task2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EditStudentActivity extends AppCompatActivity {

    private EditText nameInput, idInput;
    private String studentId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);

        nameInput = findViewById(R.id.nameInput);
        idInput = findViewById(R.id.idInput);
        Button saveButton = findViewById(R.id.saveButton);

        studentId = getIntent().getStringExtra("studentId");
        Student student = Database.getInstance().getStudentById(studentId);

        if (student != null) {
            nameInput.setText(student.getName());
            idInput.setText(student.getId());
        }

        saveButton.setOnClickListener(v -> {
            if (student != null) {
                student.setName(nameInput.getText().toString());
                student.setId(idInput.getText().toString());
                finish();
            }
        });
    }
}