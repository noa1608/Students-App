package com.example.task2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddStudentActivity extends AppCompatActivity {

    private EditText nameInput, idInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        nameInput = findViewById(R.id.nameInput);
        idInput = findViewById(R.id.idInput);
        Button saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameInput.getText().toString();
                String id = idInput.getText().toString();

                if (!name.isEmpty() && !id.isEmpty()) {
                    Database.getInstance().addStudent(new Student(name, id, false));
                    finish();
                }
            }
        });
    }
}