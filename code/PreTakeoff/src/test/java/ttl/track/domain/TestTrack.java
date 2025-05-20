package ttl.track.domain;

import java.time.Duration;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTrack {

   @Test
   public void testTrackConstruction() {
      Track track = new Track(10, "Silent Moon", "Franny Mcdonald", Track.Format.MP3,
            Duration.ofMinutes(2).plusSeconds(30), LocalDate.of(1975, 5, 5));

      assertEquals(10, track.getId());
   }
}
