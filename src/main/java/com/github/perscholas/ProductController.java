package com.github.perscholas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

/**
 * Created by leon on 10/13/2020.
 */
@Controller
@RequestMapping("/product-controller")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/input-form")
    public String inputProduct(Model model) {
        return productService.inputProduct(model);
    }

    @PostMapping(value = "/save-product")
    public String uploadFile(
            @RequestParam("images") MultipartFile[] files,
            Model model,
            Product product,
            RedirectAttributes redirectAttributes) throws IOException {
        return productService.uploadFile(files, model, product, redirectAttributes);
    }
}
