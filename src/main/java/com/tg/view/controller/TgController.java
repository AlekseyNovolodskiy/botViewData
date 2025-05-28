package com.tg.view.controller;


import com.tg.view.model.TelegramUser;
import com.tg.view.service.TgBotService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

    @Controller
    @RequiredArgsConstructor
    public class TgController {

        private final TgBotService telegramAuthService;


        @PostMapping("/")
        public String home(@RequestBody TelegramUser telegramUser,  Model model) {

            if (telegramUser == null) {
                return "exception";
            }
            model.addAttribute("user", telegramUser);
            return "index";
        }

//        @PostMapping("/exception")
//        public String exception() {
//            return "exception";
//        }
    }

