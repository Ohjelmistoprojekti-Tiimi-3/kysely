package hh.korona.kysely.web;


import hh.korona.kysely.model.Query;
import hh.korona.kysely.model.Question;
import hh.korona.kysely.repository.QueryRepository;
import hh.korona.kysely.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class KyselyController {

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    QueryRepository queryRepository;


    @RequestMapping(value = "/testi")
    @ResponseBody
    public String getTestString(){
        return "Hello :)";
    }


    @RequestMapping(value = "/kyselyt")
    public String getQueries(Model model){
        List<Query> queries = (List<Query>) queryRepository.findAll();
        model.addAttribute("queries", queries);
        return "kyselylista";
    }
    
    @RequestMapping(value = "/kysymykset")
    public String getQuestions(Model model){
    	List<Question> questions = (List<Question>) questionRepository.findAll();
    	model.addAttribute("questions", questions);
        return "kysymyslista";
    }


}
