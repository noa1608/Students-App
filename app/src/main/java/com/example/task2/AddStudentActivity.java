package com.example.task2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import androidx.appcompat.app.AppCompatActivity;

public class AddStudentActivity extends AppCompatActivity {

    private EditText nameInput, idInput, phoneInput, addressInput;
    private ImageView studentImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Students App");

        nameInput = findViewById(R.id.nameInput);
        idInput = findViewById(R.id.idInput);
        phoneInput = findViewById(R.id.phoneInput);
        addressInput = findViewById(R.id.addressInput);
        studentImage = findViewById(R.id.studentImage);
        Button saveButton = findViewById(R.id.saveButton);

        Glide.with(this)
                .load(R.drawable.student_pic)
                .apply(new RequestOptions().override(500, 600))
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(studentImage);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameInput.getText().toString();
                String id = idInput.getText().toString();
                String phone = phoneInput.getText().toString();
                String address = addressInput.getText().toString();

                if (!name.isEmpty() && !id.isEmpty() && !phone.isEmpty() && !address.isEmpty()) {
                    Student student = new Student(name, id, phone, address, false, R.drawable.student_pic);
                    Database.getInstance().addStudent(student);
                    finish();
                }
            }
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
}
