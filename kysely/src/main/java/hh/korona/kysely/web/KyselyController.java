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
    
    @Autowired
    AnswerRepository answerRepository;


    @RequestMapping(value = "/testi")
    @ResponseBody
    public String getTestString() {
        return "Hello :)";
    }


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

    // Tyhjä kysely lomake
    //@PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/uusikysel", method = RequestMethod.GET)
    public String makeKysely(Model model) {
        model.addAttribute("query", new Query()); // tyhjä query
        return "kyselyform";
    }

    //@PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/talkysel", method = RequestMethod.POST)
    public String saveKysely(@ModelAttribute Query query) {
        // talletetaan yhden kirjan tiedot tietokantaan
        queryRepository.save(query);
        return "redirect:/kyselyt";
    }

	// lomakkeen tietojen talletus
	//@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/tallennauusikysely", method = RequestMethod.POST)
	public String tallennaKysely(@ModelAttribute Query query,Model model) {
		// talletetaan yhden kirjan tiedot tietokantaan
		queryRepository.save(query);
		model.addAttribute("query",query);
		System.out.println(query.toString());
		return "kyselykysymysform";
	}


    // kirja lomakkeen tietojen talletus
    //@PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/olemassaolevakysely", method = RequestMethod.POST)
    public String useExistingQuery(@ModelAttribute("query") Query query, Model model) {
        // talletetaan yhden kirjan tiedot tietokantaan


        Query query1 = queryRepository.findOneByQueryId(query.getQueryId());

        System.out.println(query1);
        model.addAttribute("returnQuery", query1);
        model.addAttribute("newQuestion", new Question(query1));

        System.out.println(model);

        return "kyselykysymysform";
    }

}
