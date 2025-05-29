package com.tg.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/")
public class TgController {

    @GetMapping
    public String handleWebAppRequest(
            @RequestParam(name = "tgWebAppData", required = false) String tgWebAppData,
            Model model
    ) {
        if (tgWebAppData == null) {
            model.addAttribute("message", "Данные WebApp не найдены!");

            return "exception";
        }
        model.addAttribute("firstname", "Данные получены: ");
        model.addAttribute("lasttname", "Данные получены: ");
        model.addAttribute("username", "Данные получены: ");

        return "index";
    }


}