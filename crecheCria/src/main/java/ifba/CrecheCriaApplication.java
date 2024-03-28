package ifba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class CrecheCriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrecheCriaApplication.class, args);
		System.out.println("Criado ");
	}

}
