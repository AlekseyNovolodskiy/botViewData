package com.tg.view.model;

import lombok.Data;

@Data
public class TelegramAuthDto {

  private String userName;
  private String lastName;
  private String firstName;
  private String password;
}