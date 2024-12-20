package iuh.fit.se.controller;

import iuh.fit.se.entities.Category;
import iuh.fit.se.entities.Product;
import iuh.fit.se.servies.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private ProductService productService;
    @GetMapping("")
    public String home(Model model,@RequestParam(defaultValue = "0") int pageNumber, @RequestParam(defaultValue = "")String categoryid){
        Page<Product> products = null;
        List<Category> categories = productService.findAllCategory();
        if(!categoryid.isEmpty()) {
            products = productService.findWithSelect(Integer.valueOf(categoryid), PageRequest.of(pageNumber, 5));
        } else {
            products = productService.findAll(PageRequest.of(pageNumber, 5));
        }
        model.addAttribute("products", products.getContent());
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("totalPage", products.getTotalPages());

        model.addAttribute("categories", categories);
        return "home";
    }

    @GetMapping("/search")
    public String search(@RequestParam("key") String key, Model model) {
        List<Product> products = productService.findByKey(key);
        model.addAttribute("products", products);
        return "search";
    }
}
