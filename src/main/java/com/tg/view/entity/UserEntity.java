package com.tg.view.entity;//package com.tg.view.entity;
//
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@Table(name="users_info")
public class UserEntity {
    @Id
    @SequenceGenerator(name = "users_infoSequence", sequenceName = "users_info_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_infoSequence")
    @Column(name = "Id", nullable = false)

//    private Long Id;
//    private String firstName;
//    private String userName;
//    private String lastName;
//
    private Long Id;
    private String firstName;
    private String lastName;
    private String userName;
    private String photoUrl;
    private Instant lastLogin;
    private Instant createdAt = Instant.now();

}

//
//import jakarta.persistence.*;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.RequiredArgsConstructor;
//
//import java.time.Instant;
//
//@Data
//@Table(name="users_info")
//@RequiredArgsConstructor
//public class UserEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "telegram_id", unique = true, nullable = false)
//    private Long telegramId;
//
//    @Column(name = "first_name")
//    private String firstName;
//
//    @Column(name = "last_name")
//    private String lastName;
//
//    @Column(name = "username")
//    private String username;
//
//    @Column(name = "photo_url")
//    private String photoUrl;
//
//    @Column(name = "last_login")
//    private Instant lastLogin;
//
//    @Column(name = "created_at", updatable = false)
//    private Instant createdAt = Instant.now();
//}