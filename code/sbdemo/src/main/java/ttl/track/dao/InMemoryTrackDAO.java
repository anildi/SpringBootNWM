package ttl.track.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import ttl.track.domain.Track;

@Repository
@Profile("dev")
public class InMemoryTrackDAO implements TrackDAO {

   private Map<Integer, Track> tracks = new HashMap<>();
   private int nextId = 1;

   @Override
   public Track insert(Track track) {
      int id = nextId++;

      track.setId(id);
      tracks.put(track.getId(), track);
      return track;
   }

   @Override
   public boolean delete(int id) {
      Track result = tracks.remove(id);
      return result != null;
   }

   @Override
   public boolean update(Track track) {
      return tracks.replace(track.getId(), track) != null;
   }

   @Override
   public Track findById(int id) {
      return tracks.get(id);
   }

   @Override
   public List<Track> findAll() {
      return new ArrayList<>(tracks.values());
   }
}
