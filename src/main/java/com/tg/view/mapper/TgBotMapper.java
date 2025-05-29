package com.tg.view.mapper;

import com.tg.view.entity.UserEntity;
import com.tg.view.model.TelegramUser;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface TgBotMapper {

   UserEntity telegramUserToUserEntity(TelegramUser telegramUser);
}
