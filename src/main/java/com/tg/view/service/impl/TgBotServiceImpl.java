package com.tg.view.service.impl;

import com.tg.view.entity.UsersEntity;
import com.tg.view.model.TelegramAuthDto;
import com.tg.view.repositories.UserRepository;
import com.tg.view.service.TgBotService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TgBotServiceImpl implements TgBotService {

    private final UserRepository userRepository;

    @Value("${telegram.bot.token}")
    String botToken;


    @Override
    public UsersEntity authenticate(TelegramAuthDto request) {
        return null;
    }
}

