package nzh.dev.codeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableJpaAuditing
@EntityScan("nzh.domain")
public class CodeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodeServiceApplication.class, args);
	}
}
