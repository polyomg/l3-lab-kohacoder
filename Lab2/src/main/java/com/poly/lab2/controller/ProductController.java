package com.poly.lab2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import poly.edu.entity.Product;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {
    private List<Product> items = new ArrayList<>();
    private Product lastProduct;
    public ProductController() {
        items.add(new Product("A", 1.0));
        items.add(new Product("B", 12.0));
        items.add(new Product("C", 15.0));
        items.add(new Product("D", 20.0));
        items.add(new Product("E", 5.0));
        items.add(new Product("sdsf", 1.0));
        items.add(new Product("sfs", 12.0));
        items.add(new Product("12e", 15.0));
        items.add(new Product("dsgffnb", 20.0));
        items.add(new Product("dfnndb", 5.0));
        items.add(new Product("saa", 1.0));
        items.add(new Product("sfsbbb", 12.0));
        items.add(new Product("as", 15.0));
        items.add(new Product("sss", 20.0));
        items.add(new Product("aaw", 5.0));
        items.add(new Product("jggr", 1.0));
        items.add(new Product("yyyrrr", 12.0));
        items.add(new Product("nnnn", 15.0));
        items.add(new Product("ddd", 20.0));
        items.add(new Product("eew", 5.0));
    }

    @GetMapping("/product/form")
    public String form(Model model,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        Product p1 = new Product("iPhone 30", 5000.0);
        model.addAttribute("p1", p1);
        if (lastProduct != null) {
            model.addAttribute("p2", lastProduct);
        }
        // Phân trang
        int totalPages = (int) Math.ceil((double) items.size() / size);
        int start = page * size;
        int end = Math.min(start + size, items.size());

        List<Product> pageItems = items.subList(start, end);

        model.addAttribute("items", pageItems);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);

        return "views/form3";
    }


    @PostMapping("/product/save")
    public String save(@ModelAttribute("p2") Product p,
                       @RequestParam(defaultValue = "0") int page) {
        lastProduct = p;
        items.add(new Product(p.getName(), p.getPrice()));
        return "redirect:/product/form?page=" + page;

    }
}
