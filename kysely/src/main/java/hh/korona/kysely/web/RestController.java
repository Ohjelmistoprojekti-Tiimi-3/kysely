package hh.korona.kysely.web;


import java.util.List;

import hh.korona.kysely.model.Answer;
import hh.korona.kysely.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import hh.korona.kysely.model.Query;
import hh.korona.kysely.model.Question;
import hh.korona.kysely.repository.QueryRepository;
import hh.korona.kysely.repository.QuestionRepository;

@CrossOrigin
@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    QueryRepository queryRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    AnswerRepository answerRepository;


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

    @RequestMapping(value = "/api/tallennavastaus/{questionid}", method = RequestMethod.PUT)
    public @ResponseBody
    Answer saveAnswerRest(@RequestBody List<Answer> answer,@PathVariable ("questionid") Long questionId) {
        System.out.println(questionId);
        Question question = questionRepository.findByQuestionId(questionId);
        question.setAnswer(answer);
        questionRepository.save(question);
        return null;
    }

}
