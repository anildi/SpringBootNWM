package ttl.larku.domain;

import java.time.LocalDate;

public record StudentRecord(int id, String name, String phoneNumber,
                            LocalDate dob, Status status) {

   public StudentRecord(String name, String phoneNumber,
                        LocalDate dob, Status status) {
      this(0, name, phoneNumber, dob, status);
   }


   public enum Status {
      FULL_TIME,
      PART_TIME,
      HIBERNATING
   }


   public StudentRecord withId(int id) {
      StudentRecord newStudent = new StudentRecord(id, this.name(), this.phoneNumber(),
            this.dob(), this.status());

      return newStudent;
   }

   public StudentRecord withName(String name) {
      StudentRecord newStudent = new StudentRecord(this.id(), name, this.phoneNumber(),
            this.dob(), this.status());

      return newStudent;
   }
}


