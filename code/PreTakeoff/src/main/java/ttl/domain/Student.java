package ttl.domain;

import java.time.LocalDate;

//Fulltime
//Parttime
//Hibernating

public class Student {
   public enum Status {
      FULL_TIME,
      PART_TIME,
      HIBERNATING
   }

   private int id;
   private String name;
   private String phoneNumber;
   private LocalDate dob;
   private Status status;

   public Student(int id, String name, LocalDate dob, Status status, String phoneNumber) {
      if(name == null || dob == null) {
         throw new IllegalArgumentException("Args must not be null");
      }

      this.id = id;
      this.name = name;
      this.status = status;
      this.dob = dob;
      this.phoneNumber = phoneNumber;

   }

   public Student(int id, String name, LocalDate dob) {
      this(id, name, dob, Status.FULL_TIME, null);
   }


   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public LocalDate getDob() {
      return dob;
   }

   public void setDob(LocalDate dob) {
      this.dob = dob;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getPhoneNumber() {
      return phoneNumber;
   }

   public void setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
   }

   public Status getStatus() {
      return status;
   }

   public void setStatus(Status status) {
      this.status = status;
   }

   @Override
   public String toString() {
      return "Student{" +
            "dob=" + dob +
            ", id=" + id +
            ", name='" + name + '\'' +
            ", phoneNumber='" + phoneNumber + '\'' +
            ", status=" + status +
            '}';
   }

//   public String toString() {
//      return "id: " + id + ", name: " + name + ", phoneNumber: " + phoneNumber + ", dob: " + dob;
//   }
}


