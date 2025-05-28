package ttl.larku.controller;


import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ttl.track.domain.Track;
import ttl.track.service.TrackService;

@RestController
@RequestMapping("/tracks")
public class TrackController {

   private TrackService trackService;

   //Constructor injection
   public TrackController(TrackService trackService) {
      this.trackService = trackService;
   }

   @GetMapping
   public List<Track> getAllTracks() {
      List<Track> tracks = trackService.getAllTracks();
      return tracks;
   }

   @GetMapping("/{id}")
   public Track getTrack(@PathVariable int id) {
      Track track = trackService.getTrackById(id);
      return track;
   }

   @PostMapping
   public Track addTrack(@RequestBody Track track) {
     Track newTrack = trackService.addTrack(track);
     return newTrack;
   }
}
