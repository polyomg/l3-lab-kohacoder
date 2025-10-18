package com.poly.controller;

import com.poly.dao.CategoryDAO;
import com.poly.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryDAO dao;

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("item", new Category());
        model.addAttribute("items", dao.findAll());
        return "category/index";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("item") Category item, Model model) {
        if (dao.existsById(item.getId())) {
            model.addAttribute("message", "Category ID đã tồn tại!");
        } else {
            dao.save(item);
            model.addAttribute("message", "Thêm mới thành công!");
        }
        model.addAttribute("items", dao.findAll());
        return "category/index";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("item") Category item, Model model) {
        if (!dao.existsById(item.getId())) {
            model.addAttribute("message", "Không tìm thấy Category để cập nhật!");
        } else {
            dao.save(item);
            model.addAttribute("message", "Cập nhật thành công!");
        }
        model.addAttribute("items", dao.findAll());
        return "category/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id, Model model) {
        if (dao.existsById(id)) {
            dao.deleteById(id);
            model.addAttribute("message", "Xóa thành công!");
        } else {
            model.addAttribute("message", "Không tìm thấy Category để xóa!");
        }
        model.addAttribute("item", new Category());
        model.addAttribute("items", dao.findAll());
        return "category/index";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, Model model) {
        Optional<Category> item = dao.findById(id);
        model.addAttribute("item", item.orElse(new Category()));
        model.addAttribute("items", dao.findAll());
        return "category/index";
    }
}
