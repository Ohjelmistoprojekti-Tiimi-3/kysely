package hh.korona.kysely.web;


import java.util.List;

import hh.korona.kysely.model.Answer;
import hh.korona.kysely.model.Option;
import hh.korona.kysely.repository.AnswerRepository;
import hh.korona.kysely.repository.OptionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import hh.korona.kysely.model.Query;
import hh.korona.kysely.model.Question;
import hh.korona.kysely.repository.QueryRepository;
import hh.korona.kysely.repository.QuestionRepository;


@org.springframework.web.bind.annotation.RestController
@CrossOrigin(origins = "http://localhost:3000")
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
    public @ResponseBody
    List<Query> returnRestQueryList() {
        return (List<Query>) queryRepository.findAll();
    }

    @RequestMapping(value = "/api/kyselyt/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Query returnRestQueryById(@PathVariable("id") Long queryId) {
        return (Query) queryRepository.findById(queryId).get();
    }

    @RequestMapping(value = "/api/kysymykset", method = RequestMethod.GET)
    public @ResponseBody
    List<Question> returnRestQuestionList() {
        return (List<Question>) questionRepository.findAll();
    }

    @RequestMapping(value = "/api/kysymys/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Question returnOneRestQuestion(@PathVariable("id") Long questionId) {
        return (Question) questionRepository.findById(questionId).get();
    }

    @RequestMapping(value = "/api/tallennavastaus/{questionid}", method = RequestMethod.POST)
    public @ResponseBody
    Answer saveAnswerRest(@RequestBody Answer answer, @PathVariable("questionid") Long questionId) {

        System.out.println(questionId);
        Question question = questionRepository.findByQuestionId(questionId);

        answer.setQuestion(question);

        return answerRepository.save(answer);
    }
    
    @RequestMapping(value = "api/tallennavaihtoehto/{questionid}", method = RequestMethod.POST)
    public @ResponseBody
    Option saveOptionRest(@RequestBody Option option, @PathVariable("questionid") Long questionId) {
    	System.out.println(questionId);
    	Question question = questionRepository.findByQuestionId(questionId);
    	option.setQuestion(question);
    	return optionRepository.save(option);
    }
    
}
