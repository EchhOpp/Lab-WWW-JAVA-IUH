package iuh.fit.se.controller;

import iuh.fit.se.entities.Category;
import iuh.fit.se.entities.Product;
import iuh.fit.se.repositories.CategoryRepository;
import iuh.fit.se.repositories.ProductRepository;
import iuh.fit.se.services.CategoryService;
import iuh.fit.se.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model, @RequestParam(defaultValue = "0") int page) {
        Page<Product> productPage = productService.getAllProductPagination(page, 2);
        model.addAttribute("pageHienTai", page);
        model.addAttribute("tongPage", productPage.getTotalPages());
        model.addAttribute("p", productPage.getContent());
        return "index";
    }

    @RequestMapping(value = "/searchID", method = RequestMethod.GET)
    public String searchID(Model model,@RequestParam int id) {
        Product product = productService.searchID(id);
        if(product == null) {
            return "home";
        }
        model.addAttribute("p", product);
        return "search";
    }

    @RequestMapping(value = "/searchName", method = RequestMethod.GET)
    public String searchName(Model model,@RequestParam String name) {
        List<Product> product = productService.searchName(name);
        model.addAttribute("p", product);
        return "search";
    }

    @RequestMapping(value = "/searchDate", method = RequestMethod.GET)
    public String searchDate(Model model,@RequestParam Date date) {
        List<Product> product = productService.searchDate(date);
        model.addAttribute("p", product);
        return "search";
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String showForm(Model model) {
        model.addAttribute("c", categoryService.getAllCategory());
        model.addAttribute("p", new Product());
        return "form";
    }

    @RequestMapping(value = "/addproduct", method = RequestMethod.POST)
    public String add(Model model, @Valid @ModelAttribute Product product, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            List<Category> categories = categoryService.getAllCategory();
            model.addAttribute("categories", categories);
            return "form";
        }
        productService.addProduct(product);
        return "form";
    }


}
