package it.revo.first_spring_boot_backend2.controller;

import it.revo.first_spring_boot_backend2.pyload.ReqProduct;
import it.revo.first_spring_boot_backend2.pyload.ResProduct;
import it.revo.first_spring_boot_backend2.pyload.Result;
import it.revo.first_spring_boot_backend2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    @ResponseBody
    public List<ResProduct> getproduct() {
        return productService.getProduct();


    }

    @PostMapping("/add")
    @ResponseBody
    public Result addProduct(@RequestBody ReqProduct reqProduct) {
        return productService.addProduct(reqProduct);
    }

}
