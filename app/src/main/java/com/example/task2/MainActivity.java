package com.example.task2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private StudentAdapter studentAdapter;
    private static final int EDIT_STUDENT_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        Button addStudentButton = findViewById(R.id.addStudentButton);

        ArrayList<Student> students = Database.getInstance().getStudents();
        studentAdapter = new StudentAdapter(students, this);

        recyclerView.setAdapter(studentAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getSupportActionBar().setTitle("Students App");

        addStudentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddStudentActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        studentAdapter.notifyDataSetChanged();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == EDIT_STUDENT_REQUEST_CODE && resultCode == RESULT_OK) {
            Student updatedStudent = (Student) data.getSerializableExtra("updatedStudent");

            if (updatedStudent != null) {
                Database.getInstance().updateStudent(updatedStudent);
                studentAdapter.notifyDataSetChanged();
            }
        }
    }
}
