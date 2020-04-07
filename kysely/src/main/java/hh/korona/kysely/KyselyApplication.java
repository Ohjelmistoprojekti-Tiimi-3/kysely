package hh.korona.kysely;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.korona.kysely.model.Question;
import hh.korona.kysely.repository.QuestionRepository;

@SpringBootApplication
public class KyselyApplication {
	
	private static final Logger log = LoggerFactory.getLogger(KyselyApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(KyselyApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner insertData(QuestionRepository QtRepository) {
		return (args) -> {
			//Saving some questions
			
			QtRepository.save(new Question("Oletko ollut kiltti?", null, null));
			QtRepository.save(new Question("Minkä äänen tekee opettaja?", null, null));
			QtRepository.save(new Question("What is the airspeed velocity of an unladen swallow?", null, null));
			
		};
	}
}
