package hh.korona.kysely.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.korona.kysely.model.Query;
import hh.korona.kysely.model.Question;
import hh.korona.kysely.repository.QueryRepository;
import hh.korona.kysely.repository.QuestionRepository;

@Controller
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
	   
	    //@PreAuthorize("hasAuthority('ADMIN')")
		@RequestMapping(value = "/uusikysym", method = RequestMethod.GET)
		public String makeKysymys(Model model) {
			model.addAttribute("question", new Question()); // tyhjä kysymys + kysely dropdown
			model.addAttribute("querylist", queryRepository.findAll());
			return "kysymysform";
		}

		
		//@PreAuthorize("hasAuthority('ADMIN')")
		@RequestMapping(value = "/uusikysymys", method = RequestMethod.GET)
		public String uusiKysymys(Model model) {
			model.addAttribute("newQuery", new Query()); // tyhjä kysymys + kysely dropdown
			model.addAttribute("querylist", queryRepository.findAll());
			return "kyselyform";
		}

}
