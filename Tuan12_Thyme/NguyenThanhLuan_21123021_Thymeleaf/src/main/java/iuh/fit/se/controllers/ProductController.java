package iuh.fit.se.controllers;

import iuh.fit.se.entities.Product;
import iuh.fit.se.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("")
    public String listProducts(Model model, @RequestParam(defaultValue = "0") int page) {
        Page<Product> products = productService.findAll(PageRequest.of(page, 2));
        model.addAttribute("products", products.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", products.getTotalPages());
        return "product/list";
    }

    @GetMapping("/search")
    public String searchProducts(@RequestParam String keyword, Model model, @RequestParam(defaultValue = "0") int page) {
        Page<Product> products = productService.search(keyword, PageRequest.of(page, 2));
        model.addAttribute("products", products.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", products.getTotalPages());
        return "product/list";
    }

    @GetMapping("/add")
    public String showAddProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "product/add";
    }

    @PostMapping("/add")
    public String addProduct(@Valid @ModelAttribute Product product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("product", product);
            return "product/add";
        }
        productService.save(product);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditProductForm(@PathVariable int id, Model model) {
        Product product = productService.findById(id);
        if (product != null) {
            model.addAttribute("product", product);
            return "product/edit";
        } else {
            return "redirect:/"; // Redirect to the list page if product not found
        }
    }

    @PostMapping("/edit")
    public String editProduct(@Valid @ModelAttribute Product product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("product", product);
            return "product/edit";
        }
        productService.save(product);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        productService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/view/{id}")
    public String viewProduct(@PathVariable int id, Model model) {
        Product product = productService.findById(id);
        if (product != null) {
            model.addAttribute("product", product);
            return "product/view";
        } else {
            return "redirect:/"; // Redirect to the list page if product not found
        }
    }
} 