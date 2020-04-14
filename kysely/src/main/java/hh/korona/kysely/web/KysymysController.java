package hh.korona.kysely.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.korona.kysely.model.Query;
import hh.korona.kysely.model.Question;
import hh.korona.kysely.repository.QueryRepository;
import hh.korona.kysely.repository.QuestionRepository;

public class KysymysController {
	
	   @Autowired
	    QueryRepository queryRepository;
	   
	   @Autowired
	    QuestionRepository questionRepository;
	   
	   @RequestMapping(value = "/kysymykset")
	    public String getQuestions(Model model){
	    	List<Question> questions = (List<Question>) questionRepository.findAll();
	    	model.addAttribute("questions", questions);
	        return "kysymyslista";
	    }
	   
	    // Tyhjä kysely lomake
	    //@PreAuthorize("hasAuthority('ADMIN')")
		@RequestMapping(value = "/uusikysym", method = RequestMethod.GET)
		public String makeKysymys(Model model) {
			model.addAttribute("question", new Question()); // tyhjä kysymys + kysely dropdown
			model.addAttribute("querylist", queryRepository.findAll());
			return "kysymysform";
		}
		
		// lomakkeen tietojen talletus
	    //@PreAuthorize("hasAuthority('ADMIN')")
		@RequestMapping(value = "/talkysym", method = RequestMethod.POST)
		public String saveKysymys(@ModelAttribute Question question) {
			// talletetaan yhden kirjan tiedot tietokantaan
			questionRepository.save(question);
			return "redirect:/kysymykset";
		}
		
		// Tyhjä kysely lomake
		//@PreAuthorize("hasAuthority('ADMIN')")
		@RequestMapping(value = "/uusikysymys", method = RequestMethod.GET)
		public String uusiKysymys(Model model) {
			model.addAttribute("newQuery", new Query()); // tyhjä kysymys + kysely dropdown
			model.addAttribute("querylist", queryRepository.findAll());
			return "kyselyform";
		}

}
