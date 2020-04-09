package hh.korona.kysely.web;


import hh.korona.kysely.model.Query;
import hh.korona.kysely.model.Question;
import hh.korona.kysely.repository.QueryRepository;
import hh.korona.kysely.repository.QuestionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    
    // Tyhjä kysely lomake
    //@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/uusikysel", method = RequestMethod.GET)
	public String makeKysely(Model model) {
		model.addAttribute("query", new Query()); // tyhjä query
		return "kyselyform";
	}

	// kirja lomakkeen tietojen talletus
    //@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/talkysel", method = RequestMethod.POST)
	public String saveKysely(@ModelAttribute Query query) {
		// talletetaan yhden kirjan tiedot tietokantaan
		queryRepository.save(query);
		return "redirect:/kyselyt";
	}
	
    // Tyhjä kysely lomake
    //@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/uusikysym", method = RequestMethod.GET)
	public String makeKysymys(Model model) {
		model.addAttribute("question", new Question()); // tyhjä kysymys + kysely dropdown
		model.addAttribute("querylist", queryRepository.findAll());
		return "kysymysform";
	}

	// kirja lomakkeen tietojen talletus
    //@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/talkysym", method = RequestMethod.POST)
	public String saveKysymys(@ModelAttribute Question question) {
		// talletetaan yhden kirjan tiedot tietokantaan
		questionRepository.save(question);
		return "redirect:/kysymykset";
	}


}
