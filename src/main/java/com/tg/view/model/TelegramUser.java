package com.tg.view.model;

import lombok.Data;

@Data
public class TelegramUser {
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String photoUrl;
}