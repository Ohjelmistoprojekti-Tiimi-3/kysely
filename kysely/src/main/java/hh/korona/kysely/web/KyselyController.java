package hh.korona.kysely.web;


import hh.korona.kysely.model.Answer;
import hh.korona.kysely.model.Query;
import hh.korona.kysely.model.Question;
import hh.korona.kysely.repository.AnswerRepository;
import hh.korona.kysely.repository.QueryRepository;
import hh.korona.kysely.repository.QuestionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class KyselyController {

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    QueryRepository queryRepository;
    
    @Autowired
    AnswerRepository answerRepository;


    @ModelAttribute("query")
    public Query query() {
        return new Query();
    }


    @RequestMapping(value = "/kyselyt")
    public String getQueries(Model model) {
        List<Query> queries = (List<Query>) queryRepository.findAll();
        model.addAttribute("queries", queries);
        return "kyselylista";
    }
    
    // Hae yksi kysely Id:llä
    @RequestMapping(value="/kyselyt/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Query> findQueryRest(@PathVariable("id") Long queryId) {	
    	return queryRepository.findById(queryId);
    }

    // Tyhjä kysely lomake
    //@PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/uusikysel", method = RequestMethod.GET)
    public String makeKysely(Model model) {
        model.addAttribute("query", new Query()); // tyhjä query
        return "kyselynluontiform";
    }

    //@PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/talkysel", method = RequestMethod.POST)
    public String saveKysely(@ModelAttribute Query query) {
        // talletetaan yhden kirjan tiedot tietokantaan
        queryRepository.save(query);
        return "redirect:/kyselyt";
    }



    //@PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/talkysym", method = RequestMethod.POST)
    public String saveKysymys(@ModelAttribute ("newQuestion") Question question) {
        System.out.println(question.getQuery().getQueryId());
        Query query = queryRepository.findOneByQueryId(question.getQuery().getQueryId());
        question.setQuery(query);
        questionRepository.save(question);
        if (question.getQuestionType().getName() == "Radio" || question.getQuestionType().getName() == "Multi") {
        	return "redirect:/valintalisays/" + question.getQuestionId();
        } else {
        	return "redirect:/kysymykset";
        }
    }


    //kyselyform.html endpoit uuden kyselyn luontiin
    //tallennetaan uusi query ja palautetaan uusi tyhjä Question olio mihin on liitetty uusi Query olio

    //@PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/tallennauusikysely", method = RequestMethod.POST)
    public String tallennaKysely(@ModelAttribute Query query,Model model) {
        query.setDate(new Date());
        queryRepository.save(query);
        model.addAttribute("returnQuery", query);
        model.addAttribute("newQuestion", new Question(query));
        System.out.println(query.toString());
        return "kyselykysymysform";
    }


    //kyselyform.html form tulee tänne jos käytetään olemassa olevaa kyselyä
    //modelattribute palauttaa queryn jossa vain id mutta ei muuta tietoa, haetaan query1 oikea query query idn perusteella
    //@PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/olemassaolevakysely", method = RequestMethod.POST)
    public String useExistingQuery(@ModelAttribute("query") Query query, Model model) {
        Query query1 = queryRepository.findOneByQueryId(query.getQueryId());
        System.out.println(query1);
        model.addAttribute("returnQuery", query1);
        model.addAttribute("newQuestion", new Question(query1));
        return "kyselykysymysform";
    }

}
