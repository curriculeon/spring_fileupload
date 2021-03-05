package com.github.perscholas;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by leon on 10/13/2020.
 */
@Service
public class ProductService {

    public String inputProduct(Model model) {
        model.addAttribute("product", new Product());
        return "view-product-form";
    }

    public String uploadFile(MultipartFile[] files, Model model, Product product, RedirectAttributes redirectAttributes) {
        try {
            String projectDirectory = System.getProperty("user.dir");
            String resourceDirectory = "/src/main/resources";
            String uploadDirectory = projectDirectory.concat(resourceDirectory);
            for (MultipartFile file : files) {
                String originalFileName = file.getOriginalFilename();
                if (originalFileName.isEmpty()) {
                    BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(new File(uploadDirectory, originalFileName)));
                    outputStream.write(file.getBytes());
                    outputStream.flush();
                    outputStream.close();
                } else {
                    redirectAttributes.addFlashAttribute("msg", "Please select at least one file.");
                    return "redirect:/view-product-form";
                }
            }
            model.addAttribute("msg", "Multiple files uploaded successfully.");
            model.addAttribute("product", product);
            return "view-product-detail";
        } catch(IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }
}
