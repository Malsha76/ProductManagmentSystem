package com.example.demo.controller;

import com.example.demo.model.Contact;
import com.example.demo.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/")
    public String homePage(Model model) {
        return "index";
    }

    @GetMapping("/about")
    public String aboutPage(Model model) {
        model.addAttribute("pageTitle", "About Us");
        return "about";
    }

    @GetMapping("/contact")
    public String contactPage(Model model) {
        model.addAttribute("contact", new Contact());
        model.addAttribute("pageTitle", "Contact Us");
        return "contact";
    }

    @PostMapping("/contact")
    public String handleContactForm(@ModelAttribute Contact contact, Model model) {
        contactService.saveContact(contact);
        model.addAttribute("success", "Thank you for your message!");
        return "contact";
    }
}