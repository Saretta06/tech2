package com.example;

import jakarta.mail.MessagingException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {


    private final EventiJDBCTemplate eventiJDBCTemp;

    @Autowired
    public MyController(EventiJDBCTemplate eventiJDBCTemp) {
        this.eventiJDBCTemp = eventiJDBCTemp;
    }

    //index
    @GetMapping("/")
    public String getStart() {
        return "index";
    }
    

   // contatti
    @GetMapping("/contact")
    public String getContact() {
        return "contact"; 
    }
    
    @GetMapping("/cart")
    public String getCart(Model model) {
       
        return "cart";
    }
}
