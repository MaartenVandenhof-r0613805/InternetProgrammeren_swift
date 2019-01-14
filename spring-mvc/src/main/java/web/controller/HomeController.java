package web.controller;

import db.dbInterface;
import domain.Person;
import db.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ComponentScan
@RequestMapping(value = "/HomeController")
public class HomeController {

    private final dbInterface service;

    public HomeController(@Autowired dbInterface service){
        this.service = service;
    }

    @RequestMapping( method = RequestMethod.GET)
    public ModelAndView getHome() {
        return new ModelAndView("index", "index", new Person());
    }
}
