package hh.korona.kysely;

import hh.korona.kysely.model.Answer;
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
import hh.korona.kysely.model.QuestionType;
import hh.korona.kysely.repository.QuestionRepository;
import hh.korona.kysely.repository.QuestionTypeRepository;
import hh.korona.kysely.model.Option;
import hh.korona.kysely.repository.OptionRepository;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class KyselyApplication {

    private static final Logger log = LoggerFactory.getLogger(KyselyApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(KyselyApplication.class, args);
    }

    @Bean
    public CommandLineRunner insertData(QuestionRepository questionRepository, AnswerRepository answerRepository, QueryRepository queryRepository, UserRepository userRepository, OptionRepository optionRepository, QuestionTypeRepository questionTypeRepository) {
        return (args) -> {
            //Saving some questions date, user, title, questions<List>
            log.info("save a couple of queries");
            queryRepository.save(new Query(new Date(), null, "Kysely 1", null));
            queryRepository.save(new Query(new Date(), null, "Kysely 2", null));

            //queryRepository.save(new Query(new Date(), null, "Kurssipalautekysely", null));
            Query query3 = new Query(new Date(), null, "Kurssipalautekysely", null);
            queryRepository.save(query3);


            log.info("save a couple of questions");
            // questionRepository.save(new Question("Oletko ollut kiltti?", queryRepository.findByQueryId(1L).get(0), null));
            // questionRepository.save(new Question("Minkä äänen tekee opettaja?", queryRepository.findByQueryId(1L).get(0), null));
            // questionRepository.save(new Question("What is the airspeed velocity of an unladen swallow?", queryRepository.findByQueryId(1L).get(0), null));


            //String question, Query query, Answer answer
            Question question1 = new Question("Oletko tyytyväinen kurssilla tekemääsi työnlaatuun ja työmäärään?",null, null);
            Question question2 = new Question("Saavutitko tavoitteet, jotka asetit itsellesi kurssin alussa?",null, null);
            Question question3 = new Question("Saitko opettajalta tarpeeksi apua, kun sitä tarvitsit?",null, null);
            Question question4 = new Question("Minkälaisena koit opetuksen selkeyden ja ulosannin?",null, null);
            Question question5 = new Question("Miten kurssin sisältöä voisi kehittää?", null, null);



            //Asetetaan kysymykset kyselyyn

            question1.setQuery(query3);
            question2.setQuery(query3);
            question3.setQuery(query3);
            question4.setQuery(query3);
            question5.setQuery(query3);

            questionRepository.save(question1);
            questionRepository.save(question2);
            questionRepository.save(question3);
            questionRepository.save(question4);
            questionRepository.save(question5);
            
            // Asetetaan kysymystyypit kysymyksille
            //String name, List<Question> question
            
            QuestionType questionType1 = new QuestionType("Radio", null);
            question1.setQuestionType(questionType1);
            questionTypeRepository.save(questionType1);
            questionRepository.save(question1);
           
            		
            //String answer, Date date, Question question
            Answer answer1 = new Answer("Vastaus 1", new Date(),null);
            answer1.setQuestion(question1);
            answerRepository.save(answer1);


            //Oletko tyytyväinen kurssilla tekemääsi työnlaatuun ja työmäärään? (Moni valinta)
            
            Option q1o1 = new Option("Erittäin", question1);
  
            Option q1o2 = new Option("Kyllä", question1);
            Option q1o3 = new Option("En tiedä", question1);
            Option q1o4 = new Option("En", question1);
            Option q1o5 = new Option("En todellakaan", question1);
            
            optionRepository.save(q1o1);
            optionRepository.save(q1o2);
            optionRepository.save(q1o3);
            optionRepository.save(q1o4);
            optionRepository.save(q1o5);

            //Saavutitko tavoitteet, jotka asetit itsellesi kurssin alussa?
            Answer q2a1 = new Answer("Kyllä.", new Date(), null);
            Answer q2a2 = new Answer("Melkein.", new Date(), null);
            Answer q2a3 = new Answer("Jep, ja ylitin reilusti.", new Date(), null);
            Answer q2a4 = new Answer("En lähelläkään.", new Date(), null);
            Answer q2a5 = new Answer("¯\\_(ツ)_/¯", new Date(), null);

            q2a1.setQuestion(question2);
            q2a2.setQuestion(question2);
            q2a3.setQuestion(question2);
            q2a4.setQuestion(question2);
            q2a5.setQuestion(question2);

            answerRepository.save(q2a1);
            answerRepository.save(q2a2);
            answerRepository.save(q2a3);
            answerRepository.save(q2a4);
            answerRepository.save(q2a5);

            //Saitko opettajalta tarpeeksi apua, kun sitä tarvitsit?
            Answer q3a1 = new Answer("Enpä tarvinnut yhtään.", new Date(), null);
            Answer q3a2 = new Answer("Juu.", new Date(), null);
            Answer q3a3 = new Answer("Kyllä.", new Date(), null);
            Answer q3a4 = new Answer("En.", new Date(), null);
            Answer q3a5 = new Answer("¯\\_(ツ)_/¯", new Date(), null);

            q3a1.setQuestion(question3);
            q3a2.setQuestion(question3);
            q3a3.setQuestion(question3);
            q3a4.setQuestion(question3);
            q3a5.setQuestion(question3);

            answerRepository.save(q3a1);
            answerRepository.save(q3a2);
            answerRepository.save(q3a3);
            answerRepository.save(q3a4);
            answerRepository.save(q3a5);

            //Minkälaisena koit opetuksen selkeyden ja ulosannin?
            Answer q4a1 = new Answer("Helppo.", new Date(), null);
            Answer q4a2 = new Answer("Netti opiskelu teki asiasta hieman vaikeamman, muuten ok.", new Date(), null);
            Answer q4a3 = new Answer("Sopivana kurssin aiheeseen.", new Date(), null);
            Answer q4a4 = new Answer("Puutteellinen, ei anna tarpeeks oikeita esimerkkejä.", new Date(), null);
            Answer q4a5 = new Answer("¯\\_(ツ)_/¯", new Date(), null);

            q4a1.setQuestion(question4);
            q4a2.setQuestion(question4);
            q4a3.setQuestion(question4);
            q4a4.setQuestion(question4);
            q4a5.setQuestion(question4);

            answerRepository.save(q4a1);
            answerRepository.save(q4a2);
            answerRepository.save(q4a3);
            answerRepository.save(q4a4);
            answerRepository.save(q4a5);

            //Miten kurssin sisältöä voisi kehittää?
            Answer q5a1 = new Answer("Ihan ok nytten.", new Date(), null);
            Answer q5a2 = new Answer("Sopivammaks etä-opiskeluun.", new Date(), null);
            Answer q5a3 = new Answer("Eipä tarvitse paljoo kehityst.", new Date(), null);
            Answer q5a4 = new Answer("Enemmän esimerkkejä ja materiaalia.", new Date(), null);
            Answer q5a5 = new Answer("¯\\_(ツ)_/¯", new Date(), null);

            q5a1.setQuestion(question5);
            q5a2.setQuestion(question5);
            q5a3.setQuestion(question5);
            q5a4.setQuestion(question5);
            q5a5.setQuestion(question5);

            answerRepository.save(q5a1);
            answerRepository.save(q5a2);
            answerRepository.save(q5a3);
            answerRepository.save(q5a4);
            answerRepository.save(q5a5);

            log.info("fetch questions");
            for (Question question : questionRepository.findAll()) {
                log.info(question.toString());
            }

            log.info("fetch query by name");
            for (Query query : queryRepository.findByTitle("Kurssipalautekysely")) {
                log.info(query.toString());
            }

            // questionRepository.save(new Question("Oletko tyytyväinen kurssilla tekemääsi työnlaatuun ja työmäärään?", queryRepository.findByQueryId(2L).get(0),null));
            // questionRepository.save(new Question("Saavutitko tavoitteet, jotka asetit itsellesi kurssin alussa?", queryRepository.findByQueryId(2L).get(0),null));
            // questionRepository.save(new Question("Saitko opettajalta tarpeeksi apua, kun sitä tarvitsit?", queryRepository.findByQueryId(2L).get(0),null));
            // questionRepository.save(new Question("Minkälaisena koit opetuksen selkeyden ja ulosannin?", queryRepository.findByQueryId(2L).get(0),null));
            // questionRepository.save(new Question("Miten kurssin sisältöä voisi kehittää?", queryRepository.findByQueryId(2L).get(0),null));

            //  log.info("fetch questions by id");
            //   for (Question question : questionRepository. findByQuestionId(L2)) {
            //   	log.info(question.toString());
            //   }
        };
    }
}
