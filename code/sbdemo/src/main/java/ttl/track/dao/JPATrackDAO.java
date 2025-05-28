package ttl.track.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import ttl.track.domain.Track;

@Repository
@Profile("prod")
public class JPATrackDAO implements TrackDAO{

   private Map<Integer, Track> tracks = new HashMap<>();
   private int nextId = 1;

   public Track insert(Track track) {
      int id = nextId++;

      track.setId(id);
      track.setAlbum("JPA: " + track.getAlbum());
      tracks.put(track.getId(), track);
      return track;
   }

   public boolean delete(int id) {
      Track result = tracks.remove(id);
      return result != null;
   }

   public boolean update(Track track) {
      return tracks.replace(track.getId(), track) != null;
   }

   public Track findById(int id) {
      return tracks.get(id);
   }

   public List<Track> findAll() {
      return new ArrayList<>(tracks.values());
   }
}
