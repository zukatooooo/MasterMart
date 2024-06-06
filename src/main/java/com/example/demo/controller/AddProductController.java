package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.PhotoService;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.time.Instant;
@Controller
public class AddProductController {

    @Autowired
    private ProductService productService;
    private final PhotoService photoService;

    @Autowired
    public AddProductController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping("/addProduct")
    public String addProduct(){
        return "addProduct";
    }

    @PostMapping("/addProduct")
    public String processProduct(@RequestParam String prod_name, @RequestParam Integer prod_price, @RequestParam String prod_description, @RequestParam MultipartFile prod_photo, Model model) {
        Product product = new Product();
        product.setName(prod_name);
        product.setPrice(prod_price);
        product.setDescription(prod_description);
        product.setSubmissionTime(Instant.now());
        product.setPhotoUrl("photos/" + prod_name);

        productService.saveProduct(product);

        photoService.storePhoto(prod_photo, prod_name);

        return "redirect:/";
    }
}
