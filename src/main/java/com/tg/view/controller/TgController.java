package com.tg.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // Не @RestController!
@RequestMapping("/")
public class TgController {

    @GetMapping
    public String handleWebAppRequest(
            @RequestParam(name = "tgWebAppData", required = false) String webAppData,
            Model model
    ) {
        if (webAppData == null) {
            model.addAttribute("message", "Данные WebApp не найдены!");
            return "exception.html"; // Имя шаблона без .html
        }
        model.addAttribute("message", "Данные получены: " + webAppData);
        return "index.html"; // Аналогично создайте success.html
    }
}