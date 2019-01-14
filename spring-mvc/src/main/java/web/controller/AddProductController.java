package web.controller;

import domain.Product;
import db.dbInterface;
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
@RequestMapping(value = "/AddProductController")
public class AddProductController {

    private final dbInterface service;

    public AddProductController(@Autowired dbInterface service){
        this.service = service;
    }

    @RequestMapping( method = RequestMethod.GET)
    public ModelAndView addProduct() {
        return new ModelAndView("addProduct", "product", new Product());
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveProduct(Product product, BindingResult result){
        if(result.hasErrors()){
            return "addProduct";
        }
        System.out.print("ID = " + product.getProductId());
        service.addProduct(product);
        return "redirect:/ProductController.htm";
    }

    @RequestMapping(value = "/{productId}", method = RequestMethod.GET)
    public ModelAndView returnFomr(@PathVariable int productId){
        return new ModelAndView("updateProduct", "product", service.getProduct(productId));
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateProduct(Product product, BindingResult resutl){
        service.updateProduct(product);
        return "redirect:/ProductController.htm";
    }
    @RequestMapping(value = "/remove/{productId}", method = RequestMethod.GET)
    public String removeProduct(@PathVariable int productId){
        service.deleteProduct(productId);
        return "redirect:/ProductController.htm";
    }

}
