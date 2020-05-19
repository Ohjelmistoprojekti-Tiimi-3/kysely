package hh.korona.kysely.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.korona.kysely.model.Answer;
import hh.korona.kysely.model.Option;
import hh.korona.kysely.model.Query;
import hh.korona.kysely.model.Question;
import hh.korona.kysely.repository.AnswerRepository;
import hh.korona.kysely.repository.OptionRepository;
import hh.korona.kysely.repository.QueryRepository;
import hh.korona.kysely.repository.QuestionRepository;


@org.springframework.web.bind.annotation.RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RestController {

    @Autowired
    QueryRepository queryRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    AnswerRepository answerRepository;
    
    @Autowired
    OptionRepository optionRepository;

    // Palauttaa kyselyn kysymykset sekä kaikki vastaukset
    @RequestMapping(value = "/api/kyselyt", method = RequestMethod.GET)
    @CrossOrigin(origins = "https://kyselyappi.herokuapp.com")
    public @ResponseBody
    List<Query> returnRestQueryList() {
        return (List<Query>) queryRepository.findAll();
    }

    @RequestMapping(value = "/api/kyselyt/{id}", method = RequestMethod.GET)
    @CrossOrigin(origins = "https://kyselyappi.herokuapp.com")
    public @ResponseBody
    Query returnRestQueryById(@PathVariable("id") Long queryId) {
        return (Query) queryRepository.findById(queryId).get();
    }

    @RequestMapping(value = "/api/kysymykset", method = RequestMethod.GET)
    @CrossOrigin(origins = "https://kyselyappi.herokuapp.com")
    public @ResponseBody
    List<Question> returnRestQuestionList() {
        return (List<Question>) questionRepository.findAll();
    }
    
    @RequestMapping(value = "/api/valinnat", method = RequestMethod.GET)
    @CrossOrigin(origins = "https://kyselyappi.herokuapp.com")
    public @ResponseBody
    List<Option> returnRestOptionList() {
        return (List<Option>) optionRepository.findAll();
    }

    @RequestMapping(value = "/api/kysymys/{id}", method = RequestMethod.GET)
    @CrossOrigin(origins = "https://kyselyappi.herokuapp.com")
    public @ResponseBody
    Question returnOneRestQuestion(@PathVariable("id") Long questionId) {
        return (Question) questionRepository.findById(questionId).get();
    }

    @RequestMapping(value = "/api/tallennavastaus/{questionid}", method = RequestMethod.POST)
    @CrossOrigin(origins = "https://kyselyappi.herokuapp.com")
    public @ResponseBody
    Answer saveAnswerRest(@RequestBody Answer answer, @PathVariable("questionid") Long questionId) {

        System.out.println(questionId);
        Question question = questionRepository.findByQuestionId(questionId);

        answer.setQuestion(question);

        return answerRepository.save(answer);
    }
    
    @RequestMapping(value = "/api/tallennavaihtoehto/{optionId}", method = RequestMethod.POST)
    @CrossOrigin(origins = "https://kyselyappi.herokuapp.com")
    public @ResponseBody
    Option saveOptionRest( @PathVariable("optionId") Long optionId) {
    	System.out.println(optionId);
        Option option = optionRepository.findByOptionId(optionId);
        option.addCountOne();
    	return optionRepository.save(option);
    }
    
}
