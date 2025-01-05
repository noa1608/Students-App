package com.example.task2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

   private ArrayList<Student> students;
   private Context context;

   public StudentAdapter(ArrayList<Student> students, Context context) {
      this.students = students;
      this.context = context;
   }

   @NonNull
   @Override
   public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view = LayoutInflater.from(context).inflate(R.layout.student_item, parent, false);
      return new ViewHolder(view);
   }

   @Override
   public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
      Student student = students.get(position);
      holder.name.setText(student.getName());
      holder.id.setText(student.getId());
      holder.checkBox.setChecked(student.isChecked());
      holder.picture.setImageResource(student.getPictureResId());  // Set student picture

      holder.checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> student.setChecked(isChecked));

      holder.itemView.setOnClickListener(v -> {
         Intent intent = new Intent(context, StudentDetailsActivity.class);
         intent.putExtra("studentId", student.getId());
         context.startActivity(intent);
      });
   }

   @Override
   public int getItemCount() {
      return students.size();
   }

   public static class ViewHolder extends RecyclerView.ViewHolder {
      TextView name, id;
      CheckBox checkBox;
      ImageView picture; // Added ImageView for picture

      public ViewHolder(@NonNull View itemView) {
         super(itemView);
         name = itemView.findViewById(R.id.studentName);
         id = itemView.findViewById(R.id.studentId);
         checkBox = itemView.findViewById(R.id.checkBox);
         picture = itemView.findViewById(R.id.studentPicture); // Initialize picture ImageView
      }
   }
}
