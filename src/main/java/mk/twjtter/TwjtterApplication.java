package mk.twjtter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("mk.twjtter.repository")
public class TwjtterApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwjtterApplication.class, args);
	}

}
