package com.tg.view.mapper;

import com.tg.view.entity.UsersEntity;
import com.tg.view.model.TelegramAuthDto;
import com.tg.view.model.TelegramUser;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface TgBotMapper {

   UsersEntity telegramUserToUserEntity(TelegramUser telegramUser);
}
