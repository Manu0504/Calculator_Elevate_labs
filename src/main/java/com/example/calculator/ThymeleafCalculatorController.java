package com.example.calculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ThymeleafCalculatorController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/calculator/calculate")
    public String calculate(@RequestParam double a, 
                            @RequestParam double b, 
                            @RequestParam String operation, 
                            Model model) {

        double result = 0;
        String message;

        switch (operation) {
            case "add":
                result = a + b;
                message = String.valueOf(result);
                break;
            case "subtract":
                result = a - b;
                message = String.valueOf(result);
                break;
            case "multiply":
                result = a * b;
                message = String.valueOf(result);
                break;
            case "divide":
                if (b == 0) {
                    message = "Error: Division by zero is not allowed!";
                } else {
                    result = a / b;
                    message = String.valueOf(result);
                }
                break;
            default:
                message = "Invalid operation!";
        }

        model.addAttribute("result", message);
        return "index";
    }
}
