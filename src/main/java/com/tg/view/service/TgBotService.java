package com.tg.view.service;

import com.tg.view.entity.UserEntity;
import com.tg.view.model.TelegramAuthRequest;

public interface TgBotService {

    UserEntity authenticate(TelegramAuthRequest request);
}
