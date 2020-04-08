package hh.korona.kysely;

import hh.korona.kysely.model.Query;
import hh.korona.kysely.repository.AnswerRepository;
import hh.korona.kysely.repository.QueryRepository;
import hh.korona.kysely.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.korona.kysely.model.Question;
import hh.korona.kysely.repository.QuestionRepository;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class KyselyApplication {

    private static final Logger log = LoggerFactory.getLogger(KyselyApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(KyselyApplication.class, args);
    }

    @Bean
    public CommandLineRunner insertData(QuestionRepository questionRepository, AnswerRepository answerRepository, QueryRepository queryRepository, UserRepository userRepository) {
        return (args) -> {
            //Saving some questions

            queryRepository.save(new Query(new Date(), null, "Esimerkki Kysely", null));




            questionRepository.save(new Question("Oletko ollut kiltti?", queryRepository.findByQueryId(1L).get(0), null));
            questionRepository.save(new Question("Minkä äänen tekee opettaja?", queryRepository.findByQueryId(1L).get(0), null));
            questionRepository.save(new Question("What is the airspeed velocity of an unladen swallow?", queryRepository.findByQueryId(1L).get(0), null));


        };
    }
}
