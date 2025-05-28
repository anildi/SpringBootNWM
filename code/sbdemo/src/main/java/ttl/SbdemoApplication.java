package ttl;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import ttl.larku.domain.Student;
import ttl.larku.service.StudentService;
import ttl.track.dao.TrackDB;
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

		initService(studentService);

		List<Student> students = studentService.getAllStudents();

		System.out.println("Students: " + students);
	}

	public static void initService(StudentService service) {
		var students = List.of(
				new Student("Johnny", "383 93 39 20202",  LocalDate.of(1990, 10, 5), Student.Status.HIBERNATING),
				new Student("Rachna", "484 065 0606393", LocalDate.of(1960, 10, 8), Student.Status.FULL_TIME),
				new Student("Pheroze", "3483 9339 320", LocalDate.of(1947, 8, 16), Student.Status.FULL_TIME),
				new Student("Gunnar", "38 090-0-65", LocalDate.of(1980, 5, 5), Student.Status.PART_TIME),
				new Student("Isabella", "987-9876-3938", LocalDate.of(2000, 10, 5), Student.Status.HIBERNATING)
		);

		students.forEach(service::createStudent);
	}
}


@Component
class YourRunner implements CommandLineRunner {

	@Autowired
	private TrackService trackService;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello from YourRunner");

		TrackDB.initTrackService(trackService);

		List<Track> tracks = trackService.getAllTracks();

		System.out.println("Tracks: " + tracks);
	}
}

