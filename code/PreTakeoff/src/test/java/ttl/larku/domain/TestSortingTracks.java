package ttl.larku.domain;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Bean;
import ttl.track.dao.TrackDB;
import ttl.track.domain.Track;
import ttl.track.service.TrackService;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSortingTracks {

   TrackService trackService;

   @BeforeEach
   public void beforeEach() {
      trackService = new TrackService();
      TrackDB.initTrackService(trackService);
   }

   @Test
   public void testSortTracksByNaturalOder() {

      List<Track> tracks = trackService.getAllTracks();

      Collections.sort(tracks);

      assertEquals(4, tracks.get(3).getId());
   }

   @Test
   public void testSortTracksByDuration() {
      List<Track> tracks = trackService.getAllTracks();

      tracks.sort((t1, t2) -> t1.getDuration().compareTo(t2.getDuration()));

      tracks.forEach(out::println);

      assertEquals(100, tracks.get(0).getDuration().getSeconds());
   }


   @Test
   public void testFindTracksBy() {
      List<Track> tracks = trackService.getAllTracks();

      List<Track> result = findBy(tracks, t -> t.getReleaseDate().until(LocalDate.now(), ChronoUnit.YEARS) > 25);

      result.forEach(out::println);

      assertEquals(3, result.size());

      List<String> ls = List.of("a", "b", "cccccc");
      findBy(ls, s -> s.length() > 3);
   }


   public <T> List<T> findBy(List<T> tracks, Predicate<T> predicate) {
      List<T> result = new ArrayList<>();
      for(T track : tracks) {
         if(predicate.test(track)) {
            result.add(track);
         }
      }

      return result;
   }

   public List<Track> soSofindBy(List<Track> tracks, Predicate<Track> predicate) {
      List<Track> result = new ArrayList<>();
      for(Track track : tracks) {
         if(predicate.test(track)) {
            result.add(track);
         }
      }

      return result;
   }
}
