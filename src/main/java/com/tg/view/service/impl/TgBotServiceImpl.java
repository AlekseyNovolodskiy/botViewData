package com.tg.view.service.impl;

import com.tg.view.entity.UserEntity;
import com.tg.view.exception.InvalidTelegramAuthException;
import com.tg.view.mapper.TgBotMapper;
import com.tg.view.model.TelegramAuthRequest;
import com.tg.view.model.TelegramUser;
import com.tg.view.repositories.UserRepository;
import com.tg.view.service.TgBotService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class TgBotServiceImpl implements TgBotService {

    private final UserRepository userRepository;
    private final TgBotMapper mapper;

    @Value("${telegram.bot.token}")
    String botToken;


    @Override
    public UserEntity authenticate(TelegramAuthRequest request) {

        validateAuthData(request);
        TelegramUser telegramUser = request.getUser();

        UserEntity byUserName = userRepository.findByUserName(telegramUser.getUsername());
        if(isNull(byUserName)){
            registerUser(telegramUser);
        }



        return byUserName;
    }

    private UserEntity registerUser(TelegramUser telegramUser) {

        UserEntity usersEntity = new UserEntity();
        usersEntity.setUserName(telegramUser.getUsername());
        usersEntity.setFirstName(telegramUser.getFirstName());
        usersEntity.setLastName(telegramUser.getLastName());
        usersEntity.setPhotoUrl(telegramUser.getPhotoUrl());

        userRepository.save(usersEntity);

        return usersEntity;
    }

    //    private UsersEntity createNewUser(TelegramUser telegramUser) {
//        UsersEntity user = new UsersEntity();
//        user.setId(telegramUser.getId());
//        return user;
//    }
    private void validateAuthData(TelegramAuthRequest request) {

        String dataCheckString = buildDataCheckString(request);
        String secretKey = new HmacUtils(HmacAlgorithms.HMAC_SHA_256, "WebAppData".getBytes())
                .hmacHex(botToken);
        String calculatedHash = new HmacUtils(HmacAlgorithms.HMAC_SHA_256, secretKey.getBytes())
                .hmacHex(dataCheckString);

//        if (!calculatedHash.equals(request.getHash())) {
//            throw new InvalidTelegramAuthException("Invalid hash");
//        }


    }

    private String buildDataCheckString(TelegramAuthRequest request) {
        Map<String, String> fields = request.toMap();
        return fields.entrySet().stream()
                .filter(entry -> !entry.getKey().equals("hash"))
                .sorted(Map.Entry.comparingByKey())
                .map(entry -> entry.getKey() + "=" + entry.getValue())
                .collect(Collectors.joining("\n"));
    }


}

