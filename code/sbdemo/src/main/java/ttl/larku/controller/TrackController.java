package ttl.larku.controller;


import java.net.URI;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ttl.track.domain.Track;
import ttl.track.service.TrackService;

@RestController
@RequestMapping("/tracks")
public class TrackController {

   private final URICreator uriCreator;
   private TrackService trackService;

   //Constructor injection
   public TrackController(TrackService trackService, URICreator uriCreator) {
      this.trackService = trackService;
      this.uriCreator = uriCreator;
   }

   @GetMapping
   public List<Track> getAllTracks() {
      List<Track> tracks = trackService.getAllTracks();
      return tracks;
   }

   @GetMapping("/{id}")
   public ResponseEntity<?> getTrack(@PathVariable int id) {
      Track track = trackService.getTrackById(id);
      if (track == null) {
//         return ResponseEntity.notFound().build();
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No student with id: " + id);
      }
      return ResponseEntity.ok(track);
   }

   @PostMapping
   public ResponseEntity<?> addTrack(@RequestBody Track track) {
      Track newTrack = trackService.addTrack(track);
//
      URI newResource = uriCreator.getURIFor(newTrack.getId());

//      URI newResource = ServletUriComponentsBuilder
//            .fromCurrentRequest()
//            .path("/{id}")
//            .buildAndExpand(newTrack.getId())
//            .toUri();

//     return ResponseEntity.created(newResource).body(newTrack);
      return ResponseEntity.created(newResource).build();
   }

}
