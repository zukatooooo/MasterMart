package com.example.demo.controller;

import com.example.demo.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Controller
public class AddProductController {

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
        System.out.println("Product Name: " + prod_name);
        System.out.println("Product Price: " + prod_price);
        System.out.println("Product Description: " +  prod_description);
        photoService.storePhoto(prod_photo, prod_name);

        return "redirect:/";
    }
}
