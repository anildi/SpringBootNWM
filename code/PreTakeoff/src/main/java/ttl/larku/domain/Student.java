package ttl.larku.domain;

import java.time.LocalDate;

//Fulltime
//Parttime
//Hibernating

public class Student implements Comparable<Student> {

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

   public Student(String name, LocalDate dob, Status status, String phoneNumber) {
      if(name == null || dob == null) {
         throw new IllegalArgumentException("Args must not be null");
      }

      this.name = name;
      this.status = status;
      this.dob = dob;
      this.phoneNumber = phoneNumber;

   }

   public Student(String name, LocalDate dob) {
      this(name, dob, Status.FULL_TIME, null);
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
            "id=" + id +
            ", dob=" + dob +
            ", name='" + name + '\'' +
            ", phoneNumber='" + phoneNumber + '\'' +
            ", status=" + status +
            '}';
   }

   @Override
   public int compareTo(Student other) {
//      if(this.id < other.id) {
//         return -1;
//      } else if(this.id > other.id) {
//         return 1;
//      }
//      return 0;
      return Integer.compare(this.id, other.id);
   }
}


