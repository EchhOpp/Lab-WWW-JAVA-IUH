package iuh.fit.controller;

//import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import iuh.fit.entites.Customer;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);
		return "customer-form";
	}

	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer,BindingResult theBindingResult) {
       if(theBindingResult.hasErrors()) {
    	   return "customer-form";
       }
		else {
			return "customer-confirmation";
		}
		
	}
}
