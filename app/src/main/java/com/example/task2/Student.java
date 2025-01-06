package com.example.task2;

import java.io.Serializable;

public class Student implements Serializable {
   private String name;
   private String id;
   private boolean isChecked;
   private String phone;
   private String address;
   private int pictureResId;

   public Student(String name, String id, String phone, String address, boolean isChecked, int pictureResId) {
      this.name = name;
      this.id = id;
      this.phone = phone;
      this.address = address;
      this.isChecked = isChecked;
      this.pictureResId = pictureResId;
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

   public String getPhone() {
      return phone;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }

   public boolean isChecked() {
      return isChecked;
   }

   public void setChecked(boolean checked) {
      isChecked = checked;
   }

   public int getPictureResId() {
      return pictureResId;
   }

   public void setPictureResId(int pictureResId) {
      this.pictureResId = pictureResId;
   }
}