package iuh.fit.se.controller;

import iuh.fit.se.entities.Product;
import iuh.fit.se.services.ProductService;
import jakarta.validation.Valid;
import org.hibernate.engine.jdbc.mutation.spi.BindingGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.model.IModel;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private ProductService productService;

    @GetMapping("")
    public String home(Model model, @RequestParam(defaultValue = "0") int pageNumber,@RequestParam(defaultValue = "")String categoryid) {
        Page<Product> page = null;
        if(categoryid.trim().isEmpty())
            page = productService.findALlWithPage(PageRequest.of(pageNumber, 5));
        else {
            page = productService.findProductByCate(Integer.valueOf(categoryid), PageRequest.of(pageNumber, 5 ));
        }
        model.addAttribute("items", page.getContent());
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("totalPage", page.getTotalPages());

        model.addAttribute("category", productService.findAllCategory());

        return "home";
    }

    @GetMapping("/search")
    public String search(Model model, @RequestParam("key") String key){
        List<Product> items = productService.findByKey(key);
        model.addAttribute("items", items);
        return "search";
    }

    @GetMapping("/add")
    public String addItem(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", productService.findAllCategory());
        return "add";
    }

    @PostMapping("/add")
    public String addItem(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("product", product);
            return "add";
        }
        productService.addProduct(product);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        productService.delete(id);
        return "redirect:/";  // Điều hướng lại trang chủ sau khi xóa
    }

    @GetMapping("/view/{id}")
    public String view(Model model,@PathVariable("id") Integer id) {
        model.addAttribute("items", productService.findById(id));
        return "view";
    }

}
