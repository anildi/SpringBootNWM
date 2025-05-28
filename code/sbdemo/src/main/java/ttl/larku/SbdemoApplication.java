package ttl.larku;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import ttl.larku.domain.Student;
import ttl.larku.service.StudentService;

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

		System.out.println(students);
	}
}


