package ttl.larku.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public record StudentRecord(int id, String name, String phoneNumber,
                            @JsonDeserialize(using = LocalDateDeserializer.class)
                            @JsonSerialize(using = LocalDateSerializer.class)
                            LocalDate dob,
                            Status status,
                            List<ScheduledClass> classes) {

    public enum Status {
        FULL_TIME,
        PART_TIME,
        HIBERNATING
    };
}
