package com.example.task2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddStudentActivity extends AppCompatActivity {

    private EditText nameInput, idInput, phoneInput, addressInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        nameInput = findViewById(R.id.nameInput);
        idInput = findViewById(R.id.idInput);
        phoneInput = findViewById(R.id.phoneInput);
        addressInput = findViewById(R.id.addressInput);
        Button saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameInput.getText().toString();
                String id = idInput.getText().toString();
                String phone = phoneInput.getText().toString();
                String address = addressInput.getText().toString();

                // Check if the fields are not empty
                if (!name.isEmpty() && !id.isEmpty() && !phone.isEmpty() && !address.isEmpty()) {
                    // Create a new Student object and add it to the temporary database
                    Student student = new Student(name, id, phone, address, false, R.drawable.student_pic);
                    Database.getInstance().addStudent(student);
                    finish();  // Close the activity and return to the main screen
                }
            }
        });
    }
}
