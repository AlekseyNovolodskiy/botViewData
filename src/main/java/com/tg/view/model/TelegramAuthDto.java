package com.tg.view.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.LinkedHashMap;
import java.util.Map;

@Data
public class TelegramAuthDto {

  @JsonProperty("id")
  private Long telegramId;

  @JsonProperty("first_name")
  private String firstName;

  @JsonProperty("last_name")
  private String lastName;

  @JsonProperty("username")
  private String username;

  @JsonProperty("hash")
  private String hash;

  public TelegramUser getUser() {
    TelegramUser user = new TelegramUser();
    user.setFirstName(firstName);
    user.setLastName(lastName);
    user.setUsername(username);

    return user;
  }

  public Map<String, String> toMap() {

    Map<String, String> map = new LinkedHashMap<>();
    if (telegramId != null) map.put("id", telegramId.toString());
    if (firstName != null) map.put("first_name", firstName);
    if (lastName != null) map.put("last_name", lastName);
    if (username != null) map.put("username", username);
    if (hash != null) map.put("hash", hash);
    return map;
  }
}