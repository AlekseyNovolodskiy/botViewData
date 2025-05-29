package com.tg.view.entity;//package com.tg.view.entity;
//

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@NoArgsConstructor
@Data
@Table(name = "users_info")
public class UserEntity {
    @Id
    @SequenceGenerator(name = "users_infoSequence", sequenceName = "users_info_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_infoSequence")
    @Column(name = "Id", nullable = false)

    private Long Id;
    private String firstName;
    private String lastName;
    private String userName;
    private String photoUrl;
    private Instant lastLogin;
    private Instant createdAt = Instant.now();

}
