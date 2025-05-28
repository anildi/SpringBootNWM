package ttl.track.dao;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import ttl.track.domain.Track;
import ttl.track.service.TrackService;

public class TrackDB {

   public static void initTrackService(TrackService trackService) {
      var tracks = List.of(
            new Track("Shiny Night", "Charlene", Track.Format.MP3, Duration.ofSeconds(220), LocalDate.of(2000, 10, 10)),
            new Track("Bright Night", "Frank", Track.Format.MP3, Duration.ofSeconds(100), LocalDate.of(1989, 6, 10)),
            new Track("Dueling Guitars", "Herb Ellis", Track.Format.OGG, Duration.ofSeconds(158), LocalDate.of(1958, 6, 5)),
            new Track("Kind of Blue", "Miles Davis", Track.Format.CD, Duration.ofSeconds(120), LocalDate.of(1965, 8, 20))
      );

      tracks.forEach(trackService::addTrack);
   }
}
