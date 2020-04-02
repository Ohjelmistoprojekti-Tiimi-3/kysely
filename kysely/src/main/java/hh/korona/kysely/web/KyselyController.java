package hh.korona.kysely.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class KyselyController {


    @RequestMapping(value = "/testi")
    @ResponseBody
    public String getTestString(){
        return "Hello :)";
    }



}
