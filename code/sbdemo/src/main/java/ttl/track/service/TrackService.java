package ttl.track.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ttl.track.dao.InMemoryTrackDAO;
import ttl.track.dao.TrackDAO;
import ttl.track.domain.Track;

@Service
public class TrackService {

   @Autowired
   private TrackDAO dao; // = new InMemoryTrackDAO();
//   private InMemoryTrackDAO dao; // = new InMemoryTrackDAO();

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
