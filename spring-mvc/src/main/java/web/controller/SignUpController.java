package web.controller;

import domain.Person;
import db.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ComponentScan
@RequestMapping(value = "/SignUpController")
public class SignUpController {

//    private final ShopService service;
//
//    public SignUpController(@Autowired ShopService service){
//        this.service = service;
//    }
//
//    @RequestMapping( method = RequestMethod.GET)
//    public ModelAndView getSignUp() {
//        return new ModelAndView("signUp", "person", new Person());
//    }
//
//    @RequestMapping(method = RequestMethod.POST)
//    public String savePerson(Person person, BindingResult result){
//        if(result.hasErrors()){
//            return "signUp";
//        }
//        service.addPerson(person);
//        return "redirect:/PersonController.htm";
//    }
//
//    @RequestMapping(value = "/{userid}", method = RequestMethod.GET)
//    public ModelAndView editSignUp(@PathVariable String userid){
//        System.out.print("IN THE METHOD");
//        return new ModelAndView("update", "person", service.getPerson(userid));
//    }
//
//    @RequestMapping(value = "/update", method = RequestMethod.POST)
//    public String updatePerson(Person person, BindingResult result){
//        if(result.hasErrors()){
//            return "update";
//        }
//        service.updatePersons(person);
//        return "redirect:/PersonController.htm";
//    }
//
//    @RequestMapping(value = "/remove/{userid}", method = RequestMethod.GET)
//    public String removePerson(@PathVariable String userid){
//        service.deletePerson(userid);
//        return "redirect:/PersonController.htm";
//    }
}
