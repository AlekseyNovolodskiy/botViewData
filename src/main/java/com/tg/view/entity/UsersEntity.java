package com.tg.view.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@Data
@Table(name="users_info")
public class UsersEntity {
    @Id
    @SequenceGenerator(name = "users_infoSequence", sequenceName = "users_info_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_infoSequence")
    @Column(name = "id", nullable = false)
    private Long id;

    private String firstName;
    private String userName;
    private String lastName;
    private String password;


}
