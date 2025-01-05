package com.example.task2;

public class Student {
   private String name;
   private String id;
   private boolean isChecked;

   public Student(String name, String id, boolean isChecked) {
      this.name = name;
      this.id = id;
      this.isChecked = isChecked;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public boolean isChecked() {
      return isChecked;
   }

   public void setChecked(boolean checked) {
      isChecked = checked;
   }
}
