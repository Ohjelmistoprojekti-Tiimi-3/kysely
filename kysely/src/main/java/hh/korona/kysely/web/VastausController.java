package hh.korona.kysely.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.korona.kysely.model.Answer;
import hh.korona.kysely.repository.AnswerRepository;

public class VastausController {
	
    @Autowired
    AnswerRepository answerRepository;
    
 // Tallennetaan kyselyn vastaukset
	
	  @RequestMapping(value = "/talvastaus", method = RequestMethod.POST)
	  @CrossOrigin(origins = "https://kyselyappi.herokuapp.com")
	  public String tallennaVastaus(@ModelAttribute Answer answer, Model model){
	        answerRepository.save(answer);
	        
	        return "null";
	    }  
 


}
