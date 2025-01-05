package com.example.task2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EditStudentActivity extends AppCompatActivity {

    private EditText nameInput, idInput, phoneInput, addressInput;
    private String studentId;
    private Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);

        nameInput = findViewById(R.id.nameInput);
        idInput = findViewById(R.id.idInput);
        phoneInput = findViewById(R.id.phoneInput);
        addressInput = findViewById(R.id.addressInput);
        Button saveButton = findViewById(R.id.saveButton);

        studentId = getIntent().getStringExtra("studentId");
        student = Database.getInstance().getStudentById(studentId);

        if (student != null) {
            nameInput.setText(student.getName());
            idInput.setText(student.getId());
            phoneInput.setText(student.getPhone());
            addressInput.setText(student.getAddress());
        }

        saveButton.setOnClickListener(v -> {
            if (student != null) {
                student.setName(nameInput.getText().toString());
                student.setId(idInput.getText().toString());
                student.setPhone(phoneInput.getText().toString());
                student.setAddress(addressInput.getText().toString());
                finish();
            }
        });
    }
}
