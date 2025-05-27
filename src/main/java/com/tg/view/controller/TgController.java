package com.tg.view.controller;



import com.tg.view.entity.UsersEntity;
import com.tg.view.model.TelegramAuthDto;
import com.tg.view.service.TgBotService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

    @Controller
    @RequiredArgsConstructor
    public class TgController {

        private final TgBotService telegramAuthService;

        @PostMapping("/auth")
        public String authenticate(@RequestBody TelegramAuthDto request,HttpSession session) {

            UsersEntity user = telegramAuthService.authenticate(request);
            session.setAttribute("user", user);

            return "Authentication successful";
        }

        @GetMapping("/")
        public String home(Model model, HttpSession session) {
            UsersEntity user = (UsersEntity) session.getAttribute("user");
            if (user == null) {
                return "redirect:/login";
            }
            model.addAttribute("user", user);
            return "index";
        }

        @GetMapping("/login")
        public String login() {
            return "login";
        }
    }

