package it.revo.first_spring_boot_backend2.controller;

import it.revo.first_spring_boot_backend2.pyload.ReqCategory;
import it.revo.first_spring_boot_backend2.pyload.ResCategory;
import it.revo.first_spring_boot_backend2.pyload.Result;
import it.revo.first_spring_boot_backend2.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping
    @ResponseBody
    public List<ResCategory> getCategories() {
        return categoryService.categoryList();
    }

    @PostMapping
    @ResponseBody
    public Result addCategory(@RequestBody ReqCategory reqCategory) {
        return categoryService.addCategory(reqCategory);
    }
}
