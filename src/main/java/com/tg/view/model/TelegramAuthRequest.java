package com.tg.view.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

@Data
public class TelegramAuthRequest {
    @JsonProperty("id")
    private Long Id;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("username")
    private String username;

    @JsonProperty("photo_url")
    private String photoUrl;

    @JsonProperty("auth_date")
    private Long authDate;

    @JsonProperty("hash")
    private String hash;

    public TelegramUser getUser() {
        TelegramUser user = new TelegramUser();
        user.setId(Id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUsername(username);
        user.setPhotoUrl(photoUrl);
        return user;
    }

    public Map<String, String> toMap() {
        Map<String, String> map = new LinkedHashMap<>();
        if (Id != null) map.put("id", Id.toString());
        if (firstName != null) map.put("first_name", firstName);
        if (lastName != null) map.put("last_name", lastName);
        if (username != null) map.put("username", username);
        if (photoUrl != null) map.put("photo_url", photoUrl);
        if (authDate != null) map.put("auth_date", authDate.toString());
        if (hash != null) map.put("hash", hash);
        return map;
    }
}