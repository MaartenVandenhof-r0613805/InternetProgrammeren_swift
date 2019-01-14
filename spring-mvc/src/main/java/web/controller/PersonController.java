package web.controller;

import db.ShopService;
import db.dbInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ComponentScan
@RequestMapping(value = "/PersonController")
public class PersonController {

    private final dbInterface service;

    public PersonController(@Autowired dbInterface service){
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getProductOverview() {
        return new ModelAndView("productoverview", "ProductDatabank", service.getProducts());
    }
}
