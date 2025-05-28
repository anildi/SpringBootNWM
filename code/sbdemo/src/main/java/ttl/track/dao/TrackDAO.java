package ttl.track.dao;

import java.util.List;
import ttl.track.domain.Track;

public interface TrackDAO {
   Track insert(Track track);

   boolean delete(int id);

   boolean update(Track track);

   Track findById(int id);

   List<Track> findAll();
}
