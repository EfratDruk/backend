package com.example.demo.model;

import com.example.demo.model.enums.Sector;

import java.util.List;


public class Requirements {


   private int age;//?
   private List<Sector> sector;
   private double height;

   public Requirements() {
   }

   public Requirements(int age, List<Sector> sector, double hight) {
      this.age = age;
      this.sector = sector;
      this.height = hight;
   }

   public int getAge() {
      return age;
   }

   public void setAge(int age) {
      this.age = age;
   }

   public List<Sector> getSector() {
      return sector;
   }

   public void setSector(List<Sector> sector) {
      this.sector = sector;
   }

   public double getHight() {
      return height;
   }

   public void setHight(double hight) {
      this.height = hight;
   }
}
