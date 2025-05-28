package ttl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import ttl.larku.domain.Student;
import ttl.larku.service.StudentService;
import ttl.track.domain.Track;
import ttl.track.service.TrackService;

@SpringBootApplication
public class SbdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbdemoApplication.class, args);
	}
//		ApplicationContext context = SpringApplication.run(SbdemoApplication.class, args);

//		int count = context.getBeanDefinitionCount();
//		System.out.println("Num Beans: " + count);
}

@Component
class MyRunner implements CommandLineRunner {

	@Autowired
	private StudentService studentService;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello from MyRunner");

		List<Student> students = studentService.getAllStudents();

		System.out.println("Students: " + students);
	}
}


@Component
class YourRunner implements CommandLineRunner {

	@Autowired
	private TrackService trackService;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello from YourRunner");

		List<Track> tracks = trackService.getAllTracks();

		System.out.println("Tracks: " + tracks);
	}
}

