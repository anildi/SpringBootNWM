package ttl.track.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import ttl.track.dao.InMemoryTrackDAO;
import ttl.track.domain.Track;

public class TrackService {

   InMemoryTrackDAO dao = new InMemoryTrackDAO();

   public Track addTrack(Track track) {

      return dao.insert(track);
   }

   public boolean deleteTrack(int id) {
      return dao.delete(id);
   }

   public boolean updateTrack(Track track) {
      return dao.update(track);
   }

   public Track getTrackById(int id) {
      return dao.findById(id);
   }

   public List<Track> getAllTracks() {
      return dao.findAll();
   }
}
