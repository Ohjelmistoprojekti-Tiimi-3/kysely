package hh.korona.kysely.web;


import hh.korona.kysely.model.Answer;
import hh.korona.kysely.model.Query;
import hh.korona.kysely.model.Question;
import hh.korona.kysely.repository.AnswerRepository;
import hh.korona.kysely.repository.QueryRepository;
import hh.korona.kysely.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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

    @RequestMapping(value = "/api/kysymykset", method = RequestMethod.GET)
    public @ResponseBody
    List<Question> returnRestQuestionList() {
        return (List<Question>) questionRepository.findAll();
    }
    
    @RequestMapping(value = "/api/vastaukset", method = RequestMethod.GET)
    public @ResponseBody
    List<Answer> returnRestAnswerList() {
        return (List<Answer>) answerRepository.findAll();
    }


}
