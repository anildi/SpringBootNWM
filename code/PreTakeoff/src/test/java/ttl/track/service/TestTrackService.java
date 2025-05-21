package ttl.track.service;

import java.time.Duration;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import ttl.track.domain.Track;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestTrackService {

   TrackService service = new TrackService();

   @Test
   public void testInsertTrack() {

      Track track = new Track("Here", "Jon", Track.Format.MP3,
            Duration.ofSeconds(122), LocalDate.of(1987, 4, 6));

      Track inserted = service.addTrack(track);
      assertNotNull(inserted);
      assertEquals(1, inserted.getId());
   }
}
