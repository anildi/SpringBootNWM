package ttl.larku.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ttl.track.domain.Track;
import ttl.track.service.TrackService;

@RestController
public class StudentController {

   @Autowired
   private TrackService trackService;

   @GetMapping("/sayHello")
   public String sayHello() {
      return "Here we go with Controllers";
   }

   @GetMapping
   public List<Track> getTracks() {
     List<Track> tracks = trackService.getAllTracks();
     return tracks;
   }
}
