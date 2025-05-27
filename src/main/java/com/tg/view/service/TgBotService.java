package com.tg.view.service;

import com.tg.view.entity.UsersEntity;
import com.tg.view.model.TelegramAuthDto;

public interface TgBotService {

    UsersEntity authenticate(TelegramAuthDto request);
}
