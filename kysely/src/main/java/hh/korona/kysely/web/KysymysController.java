package hh.korona.kysely.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.korona.kysely.model.Option;
import hh.korona.kysely.model.Query;
import hh.korona.kysely.model.Question;
import hh.korona.kysely.repository.OptionRepository;
import hh.korona.kysely.repository.QueryRepository;
import hh.korona.kysely.repository.QuestionRepository;
import hh.korona.kysely.repository.QuestionTypeRepository;

@Controller
public class KysymysController {
	
	   @Autowired
	    QueryRepository queryRepository;
	   
	   @Autowired
	    QuestionRepository questionRepository;
	   
	   @Autowired
	    QuestionTypeRepository QTRepository;
	   
	   @Autowired
	    OptionRepository optionRepository;
	   
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
			model.addAttribute("questiontypelist", QTRepository.findAll());
			return "kysymysform";
		}
		
		//@PreAuthorize("hasAuthority('ADMIN')")
		@RequestMapping(value = "/valintalisays/{questionid}", method = RequestMethod.GET)
		public String makeVaihtoehto(@PathVariable("questionid") Long questionid, Model model) {
			model.addAttribute("option", new Option());
			model.addAttribute("question", questionRepository.findById(questionid).get());
			return "vaihtoehtoform";
		}
		
		// vaihtoehdon talletus
		@RequestMapping(value = "/tallenvalinta/{questionId}", method = RequestMethod.POST)
		public String saveValinta(@ModelAttribute Option option, @PathVariable("questionId") Long questionid) {
			// talletetaan yhden kirjan tiedot tietokantaan
			option.setQuestion(questionRepository.findById(questionid).get());
			optionRepository.save(option);
			return "redirect:/valintalisays/{questionId}" ;
		}

		
		//@PreAuthorize("hasAuthority('ADMIN')")
		@RequestMapping(value = "/uusikysymys", method = RequestMethod.GET)
		public String uusiKysymys(Model model) {
			model.addAttribute("newQuery", new Query()); // tyhjä kysymys + kysely dropdown
			model.addAttribute("querylist", queryRepository.findAll());
			return "kyselyform";
		}

}
