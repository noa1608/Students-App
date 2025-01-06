package com.example.task2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem;

public class EditStudentActivity extends AppCompatActivity {

    private EditText nameInput, idInput, phoneInput, addressInput;
    private Student student;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Students App");

        nameInput = findViewById(R.id.nameInput);
        idInput = findViewById(R.id.idInput);
        phoneInput = findViewById(R.id.phoneInput);
        addressInput = findViewById(R.id.addressInput);
        saveButton = findViewById(R.id.saveButton);

        String studentId = getIntent().getStringExtra("studentId");

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

                Intent resultIntent = new Intent();
                resultIntent.putExtra("updatedStudent", student);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
